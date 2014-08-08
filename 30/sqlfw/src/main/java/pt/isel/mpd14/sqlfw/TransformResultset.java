package src.main.java.pt.isel.mpd14.sqlfw;

import static java.lang.String.format;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransformResultset {
	
	private ResultSet rs;
	
	public TransformResultset(ResultSet rs){
		this.rs=rs;
	}
	
	public   Iterable<Product> getListData() throws SQLException{
		
		ArrayList<Product> list=new ArrayList<Product>();
		
        //int count = 0;
        
        
        while(rs.next()) {
        
        	Product aux=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getInt(4));
            list.add(aux);
           // count++;
        }
     //   System.out.println("Fetched " + count + " rows");
    
		return list;
		
		
	}
	
	
}
