import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class ProductMain 
{
	public void productuserChoice(int user_id)
	{
		int choice=0;
		Scanner scanner=new Scanner(System.in);
		do
		{
			System.out.println("-----------------------------------------------------");
			System.out.println("1. Select Product and Add to Cart");
			System.out.println("2. Cart Details");
			System.out.println("3. Buy Product");
			System.out.println("4. exit");
			System.out.println("-----------------------------------------------------");
			
			System.out.println("Enter Your Choice...");
			choice=scanner.nextInt();
			
			if(choice==1)
			{
				Product_Dtls dtls=new Product_Dtls();
				dtls.showProductDtls();
				System.out.println("Enter Your Choice in Integer Format to Select product : ");
				int choice1=scanner.nextInt();
				ProductDtlsPerticularId dtlsId=new ProductDtlsPerticularId();
				dtlsId.showOneProductDtls(choice1, user_id);
			}
			else if(choice==2)
			{
				CartDtls cartDtls=new CartDtls();
				cartDtls.showCartDtls(user_id);
			}
			else if(choice==3)
			{
				CartDtls cartDtls=new CartDtls();
				cartDtls.showCartDtls(user_id);
				
				System.out.println("Select product to Buy in Integer Format : ");
				int cartId=scanner.nextInt();
				
				FinalBuy finalBuy=new FinalBuy();
				finalBuy.getPerticularRecord(cartId);
				
			}
			else if(choice==4)
			{
				System.out.println("Thanku...");
			}
			
			
		}while(choice!=4);
		
	}
}
