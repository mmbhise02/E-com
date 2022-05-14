import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Product_Dtls
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	
	public void showProductDtls()
	{
		try 
		{
			int choice=0;
			
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="SELECT * FROM product_dtls";
			preparedStatement=connection.prepareStatement(query);
			ResultSet resultset=preparedStatement.executeQuery();
			
			HashMap<Integer, String>product =new HashMap<>();
			while(resultset.next())
			{
				String str="Product Name: "+resultset.getString(2)+", Description: "+resultset.getString(3)+", product_price :"+resultset.getLong(4)+", Quantity : "+resultset.getInt(5);
				
				product.put(resultset.getInt(1), str);		
			}
			
			Iterator <Integer> it = product.keySet().iterator();       //keyset is a method  
			while(it.hasNext())  
			{  
				int key=(int)it.next();  
				System.out.println(key+". -> "+product.get(key));  
			} 
						
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
