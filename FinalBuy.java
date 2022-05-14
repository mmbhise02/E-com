import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FinalBuy 
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	
	public void getPerticularRecord(int cartId)
	{
		try
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="select * from cart where cartid=?";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, cartId);
			ResultSet resultSet=preparedStatement.executeQuery();
			//userid ,product id,price,product name
			
			int productId=0,userId=0;
			long price=0;
			String product_name=null;
			
			while(resultSet.next())
			{
				product_name=resultSet.getString(2);
				price=resultSet.getLong(3);
				userId=resultSet.getInt(4);
				productId=resultSet.getInt(5);
			}
			ProductBuy buy=new ProductBuy();
			buy.buyProductDetails(productId, userId, price, product_name);
			
			RemoveCartEntry cartEntry=new RemoveCartEntry();
			cartEntry.removePerticularEntry(cartId);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
