import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductBuy
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;

	public void buyProductDetails(int product_id,int user_id,long price,String product_name) {
		try 
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="insert into user_history(product_id,productName,user_id,price)values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, product_id);
			preparedStatement.setString(2,product_name);
			preparedStatement.setInt(3, user_id);
			preparedStatement.setLong(4, price);
			
			preparedStatement.executeUpdate();
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
