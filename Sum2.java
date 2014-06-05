/*Sum of 2. Basically, given an integer array 
and an integer as parameters to a method, return
true if any two sum to the given integer, false 
if not. So, for example, [1,3,5] and 8 returns 
true, [1,3,5] and 9 returns false.*/

public class Sum2
{
	public static void main(String[] args)
	{
		System.out.println(sumOf2(new int []{1,3,5},8));
	}
	
	private static boolean sumOf2(int[] arr,int sum)
	{
		// return value
		boolean b=false;
		//outer loop through array
		outer:for(int i=0;i<arr.length;i++)
		// inner loop through array starting at next index
			for(int j=1;j<arr.length;j++)
				if((arr[i]+arr[j])==sum){b=true; break outer;}
		return b;
	}
}