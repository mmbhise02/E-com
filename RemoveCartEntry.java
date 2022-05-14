import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemoveCartEntry
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	
	public void removePerticularEntry(int cartId)
	{
		try
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="delete from cart where cartId=?";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1,cartId);
			preparedStatement.execute();
			
			System.out.println("Thank You For shopping with us...");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
