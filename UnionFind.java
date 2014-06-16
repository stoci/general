// given N integer objects, determine if there is a path between p and q
// quick-find algorithm O(N^2)


interface IUnionF
{
	void union(int p, int q);
	boolean connected(int p, int q);	
	void Q-union(int p, int q);
	boolean Q-connected(int p, int q);
}

public class UnionFind implements IUnionF
{
	// array of size N containing connected components
	int [] objects;
	
	public UnionFind(int N)
	{
		this.objects = new int[N];
		
		// initialize unconnected components
		for(int i=0;i<N;i++)
			objects[i]=i;
	}
	
	public void union(int p, int q)
	{
		// get what p is currently connected to
		int objP = objects[p];
		int objQ = objects[q];
		// change any index that had old value to q
		for(int i=0; i<objects.length; i++)
			if(objects[i]==objP)objects[i]=objQ;
		
		for(int x:objects)
			System.out.print(x);
		System.out.println();
	}
	
	public boolean connected(int p, int q)
	{
		if(objects[p]==objects[q])return true;
		else return false;
	}
	
	public void Q-union(int p, int q)
	{
	}
	
	public boolean Q-connected(int p, int q)
	{
		while()
	}
	
	private int root(int i)
	{
		return 0;
	}
	public static void main(String [] args)
	{
		int N = 10;
		
		UnionFind uf = new UnionFind(N);
		// quick-find
		/*uf.union(4,3);
		uf.union(3,8);
		uf.union(6,5);
		uf.union(9,4);
		uf.union(2,1);
		System.out.println(uf.connected(8,9));
		System.out.println(uf.connected(5,0));
		uf.union(5,0);uf.union(7,2);uf.union(6,1);*/
		
		//quick-union
	}
}