public class Problem8_1
{
	public static void main(String[] args)
	{
		System.out.println(isPalindrome("otto"));
		System.out.println(isPalindrome("asdf"));
	}
	
	public static boolean isPalindrome(String s)
	{
		if (s.length() <= 1)
			return true;

		else
		{
			return (s.charAt(0) == s.charAt(s.length()-1)) && 
			(isPalindrome(s.substring(1, s.length() - 1)));
		}
	}
}