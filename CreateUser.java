import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateUser
{
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	
	public void createNewRecord(UserEntity entity)
	{
		try
		{
			
			ConnectionTest test=new ConnectionTest();
			connection=test.getConnectionDetails();
			String query="insert into User_dtls(mobileno,password,uname,uaddress,ucity)values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setLong(1, entity.getMobileNo());
			preparedStatement.setString(2, entity.getPassword());
			preparedStatement.setString(3, entity.getuName());
			preparedStatement.setString(4, entity.getuAddress());
			preparedStatement.setString(5, entity.getuCity());
			
			preparedStatement.execute();
			System.out.println("Thanks For Registration...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
