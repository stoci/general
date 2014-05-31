public class LongPalindrome
{
	// prints out longest palindrome in args array
	public static void main(String [] args)
	{
		System.out.println(getLongestPalindrome(args));
	}
	private static String getLongestPalindrome(String[] sentence)
	{
		//return string containing longest palindrome
		String longest="";
		//iterate through every word in the sentence array
		for(String s : sentence)
		{
			// StringBuilder used for reversing the String s 
			StringBuilder sb = new StringBuilder(s);
			if(s.length()>longest.length() && sb.reverse().toString().equals(s))
				//assign longest
				longest=s;
		}
		return longest;
	}
}