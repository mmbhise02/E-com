
public class Encryption
{
	public String encryptString(String str)
	{
		char arr[]=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			arr[i]=(char) (arr[i]+11);
		}
		String encryptString=String.valueOf(arr);
		// encryptString;
		return encryptString;
	}
	
	public String decryptionString(String str)
	{
		char arr[]=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			arr[i]=(char) (arr[i]-11);
		}
		String decryptedString=String.valueOf(arr);
		
		return decryptedString;
	}
	
}
