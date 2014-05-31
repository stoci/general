/*only one instance of class exists and only accessible via getter method
asked by Red Hat
*/

public class Singleton
{
	// static field containing only instance of the class accessible via getter
	private static Singleton s = new Singleton();
	
	// cannot be instanced from outside class
	private Singleton()
	{
		super();
	}
	// static method to retrieve only instance available
	public static Singleton getInstance()
	{
		return s;
	}
}