/*check whether given number is prime*/

public class Prime
{
	public static void main(String...args)
	{
		int n = Integer.parseInt(args[0]);
		int count=0;
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)count++;
		}
		if(count==2)System.out.println(true);
		else System.out.println(false);
	}
}