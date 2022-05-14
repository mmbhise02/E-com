import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest 
{
	private Connection connection=null;
	
	public Connection getConnectionDetails()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/ecommerce","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;
	}
}
