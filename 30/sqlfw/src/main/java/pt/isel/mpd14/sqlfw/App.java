package src.main.java.pt.isel.mpd14.sqlfw;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws SQLException
	{
		/* final String connectionUrl = 
			"jdbc:sqlserver://localhost:1433;" +
			"databaseName=Product;" + 
			"user=JACKY-PC;password=123456";
		 */
		// Connection c = DriverManager.getConnection(connectionUrl);

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setInstanceName("SQLEXPRESS");
		ds.setUser("lsuser");
		ds.setPassword("123456");
		ds.setServerName("JACKY-PC\\SQLEXPRESS");
		ds.setPortNumber(1433);
		ds.setDatabaseName("Product");
		Connection c = ds.getConnection();
		//System.out.println("Entrou");
		PreparedStatement cmd = c.prepareStatement(
				"SELECT ProductID, ProductName, UnitPrice, UnitsInStock "
						+ "FROM Products WHERE UnitPrice > ? AND UnitsInStock > ?");
		cmd.setDouble(1, 0.10);
		cmd.setInt(2, 20);
		ResultSet rs = cmd.executeQuery();

		TransformResultset aux=new TransformResultset(rs);
		Iterable<Product> list=aux.getListData();
		Iterator<Product> it=list.iterator();
	
		while(it.hasNext()){
			Product p=it.next();
			System.out.println(" \n Id: "+p.getProductID()+" \n Name: "+p.getProductName()+"\n Price: "+p.getUnitPrice()+"\n UnitsInStock: "+p.getUnitsInStock());
			
		}
	}

}
