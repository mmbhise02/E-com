import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDtls
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	
	public void showCartDtls(int user_id)
	{
		long totalPrice=0;
		try
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			
			String query="select * from cart where uId=?";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, user_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			System.out.println("Cart Details.....");
			System.out.println("------------------------------------------------");
			System.out.println("id \t Product Name \t Price");
			System.out.println("------------------------------------------------");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getLong(3));
				totalPrice=totalPrice+resultSet.getLong(3);
			}
			System.out.println("\nTotal Price : "+totalPrice +" Rs.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
