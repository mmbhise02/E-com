import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddToCart
{
	private Connection connection;
	private PreparedStatement preparedStatement=null;
	
	public void addCart(String product_name,long price,int uId,int product_id)
	{
		try 
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="insert into cart(product_name,price,uId,product_id)values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,product_name);
			preparedStatement.setLong(2,price);
			preparedStatement.setInt(3, uId);
			preparedStatement.setInt(4, product_id);
			
			preparedStatement.executeUpdate();
			System.out.println("Saved to cart");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
