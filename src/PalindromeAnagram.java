import java.util.Scanner;


public class PalindromeAnagram {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		String inputStr = scan.next(); //input string
		int inStrLength = inputStr.length(); //length of input string
		char uniqueChar;
		String list = "";
		boolean pairRemove = true;
		
		while(inStrLength > 0 && pairRemove)
		{
			for(int i = 0; i < inStrLength; i++)
			{
				//getChar at i
				System.out.println("inputStr length: " + inputStr.length() + " i: " + i);
				System.out.println("i < inStrLength? " + (i < inStrLength));
				
				uniqueChar = inputStr.charAt(i);
				if(!(i == inStrLength))
				{	
					if((inputStr.substring(i+1)).contains(uniqueChar + ""))
					{
						//add to list if not already in there
						if(!list.contains(uniqueChar + ""))
						{
							int index = inputStr.indexOf(uniqueChar);
							list += uniqueChar + ""; //add character
							pairRemove = true;
							inputStr = RemoveChar(inputStr, index);
							index = inputStr.indexOf(uniqueChar);
							inputStr = RemoveChar(inputStr, index);
						}
						else
						{
							System.out.println("Not list.contains");
						}
					}
					else
					{
						System.out.println("Not substring i + 1");
					}
				}
				else
				{
					System.out.println("inStrLength");
				}
				
				inStrLength = inputStr.length();
			}
			
			inStrLength = inputStr.length();
			pairRemove = false;
		}
		
		int charRemoved = 0;
		
		if(inputStr.length() == 0 || inputStr.length() == 1)
		{
			charRemoved = 0;
		}
		else
		{
			charRemoved = inputStr.length() - 1;
		}
		System.out.println(charRemoved + ", " + list.length());

	}
	
	public static String RemoveChar(String string, int index)
	{
		System.out.println("Removing " + index + " from '" + string + "'");
		String substring = "";
		substring = string.substring(0, index);
		
		if(string.length() > 1)
		{
			substring += string.substring(index+1, string.length());
		}
		
		System.out.println("Returning " + substring);
		return substring;
	}

}
