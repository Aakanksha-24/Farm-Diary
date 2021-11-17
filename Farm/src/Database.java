import java.sql.Connection;
import java.sql.DriverManager;
 public class Database
{
	public static Connection con;
	public static Connection getconnect()
	{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/farm","root","");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args)
	{
		System.out.println("Connection");
	}
	
}