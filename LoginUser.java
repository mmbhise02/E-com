import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginUser
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	public boolean loginUser(UserEntity entity)
	{
		boolean flag=false;		
		try
		{
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
		
			String query="SELECT * FROM user_dtls";
			preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				if((resultSet.getLong(2)==entity.getMobileNo())&&(resultSet.getString(3).equals(entity.getPassword())))
				{
					entity.setuId(resultSet.getInt(1));
					entity.setMobileNo(resultSet.getLong(2));
					entity.setPassword(resultSet.getString(3));
					entity.setuName(resultSet.getString(4));
					entity.setuAddress(resultSet.getString(5));
					entity.setuCity(resultSet.getString(6));
					System.out.println("Login Succsessful...");
					
					ProductMain main=new ProductMain();
					main.productuserChoice(entity.getuId());
					
					flag=true;
				}
				
			}
			if(flag==false)
			{
				System.out.println("User Details Incorrect");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
}
