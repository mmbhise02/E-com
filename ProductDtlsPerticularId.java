import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

//product_name,description,product_price,product_quantity
public class ProductDtlsPerticularId 
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	
	public void showOneProductDtls(int product_id,int user_id)
	{
		try 
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="SELECT * FROM product_dtls where product_id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, product_id);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next())
			{
				String str="Product Name: "+resultset.getString(2)+", Description: "+resultset.getString(3)+", product_price :"+resultset.getLong(4)+", Quantity : "+resultset.getInt(5);	
				AddToCart  addToCart=new  AddToCart();
				addToCart.addCart(resultset.getString(2), resultset.getLong(4), user_id, product_id);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
