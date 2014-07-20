// given N integers as command line arguments determine how many triples sum to zero
// brute-force O(N^3)

public class ThreeSum
{
	public static void main(String...nums)
	{
		int [] args = new int[nums.length];
		
		for(int i = 0;i<nums.length;i++){
			args[i]=Integer.parseInt(nums[i]);
		}
		// check if <3 arguments
		if(args.length<3)System.out.println("nice try.");
		
		// 3+ args triple nested for loop
		else
		{
			int count = 0;
			
			for(int i=0;i<args.length;i++)
				for(int j=i+1;j<args.length;j++)
					for(int k=j+1;k<args.length;k++)
						{if((args[i]+args[j]+args[k])==0)count++;}
			
			System.out.println(count);
		}
	}
}