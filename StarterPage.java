import java.util.Scanner;

public class StarterPage {

	public static void main(String[] args)
	{
		int choice=0;
		boolean flag=false;
		Scanner scanner=new Scanner(System.in);
		Encryption encryption=new Encryption();
		do
		{
			System.out.println("-------------------------------------------------------------");
			System.out.println("1. Login");
			System.out.println("2. Create Account");
			System.out.println("3. Exit");
			System.out.println("-------------------------------------------------------------");
			
			System.out.println("\n Enter Your Choice in Integer Format");
			choice=scanner.nextInt();
			
			if(choice==1)
			{
				System.out.println("Enter Mobile Number : ");
				long mobileNo=scanner.nextLong();
				String regex = "(0/91)?[7-9][0-9]{9}";
				String temp=""+mobileNo;
				if(temp.matches(regex))
				{
					System.out.println("Enter Password : ");
					scanner.nextLine();
					String password=scanner.nextLine();
					password=encryption.encryptString(password);
					
					UserEntity entity=new UserEntity();
					entity.setMobileNo(mobileNo);
					entity.setPassword(password);
					LoginUser loginUser=new LoginUser();
					flag=loginUser.loginUser(entity);
				}
				else
				{
					System.out.println("Please Enter Valid Mobile Number\n");
				}
				
			}
			else if(choice==2)
			{
				System.out.println("Enter Mobile Number : ");
				long mobileNo=scanner.nextLong();
				
				String regex = "(0/91)?[7-9][0-9]{9}";
				String temp=""+mobileNo;
				if(temp.matches(regex))
				{
					System.out.println("Enter Name : ");
					scanner.nextLine();
					String uName=scanner.nextLine();
					
					System.out.println("Enter Password : ");
					String password=scanner.nextLine();
					password=encryption.encryptString(password);
							
					System.out.println("Enter Address : ");
					String uAddress=scanner.nextLine();
					
					System.out.println("Enter City : ");
					String uCity=scanner.nextLine();
					
					UserEntity entity=new UserEntity(mobileNo,password,uName,uAddress,uCity);
					CreateUser createUser=new CreateUser();
					createUser.createNewRecord(entity);
				}
				else
				{
					System.out.println("Please Enter Valid Mobile Number\n");
				}
				
			}
			else if(choice==3)
			{
				System.out.println("Thanku....");
			}
			else
			{
				System.out.println("Please Enter Valid Choice");
			}
		}while((choice!=3)&&(flag!=true));
	}

}
