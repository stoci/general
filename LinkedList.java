/*singly linked list from scratch*/

public class LinkedList implements IList
{
	// head of list
	Node head = new Node(null);
	// points to next element of list used by next() method
	Node next = head;
	Node tail = head;
	
	// add to end of list
	public void insertTail(Object d)
	{
		// constructor automatically sets next to null
		Node newTail = new Node(d);
		tail = newTail;
	}
	public void insertHead(Object d)
	{
		// empty head node
		if(head.getData()==null){head.setData(d);return;}
		// insert at head of list
		Node newHead = new Node(d);
		newHead.setNext(head);
		tail = head;
		head = newHead;
	}
	public void insert(Object d, int index)
	{
		int length = length();
		// invalid index
		if(length<=index){throw new IndexOutOfBoundsException();}
		// index is Head
		else if(index==0){ insertHead(d);}
		// index is Tail
		else if(index==length-1){insertTail(d);}
		// index somewhere else
		else 
		{
			// find node prior to index O(n)
			for(int i =0; i<index; i++)
			{
				next();
			}
			// insert new Node
			Node insert = new Node(d);
			next.setNext(insert);
			// advance next pointer and set insert to point to it
			next(); insert.setNext(next);
			// reset next pointer
			next = head;
		}
	}
	
	// traverse LinkedList
	public Node next()
	{
		//get first element in the list
		if(next!=null){next = next.getNext(); return next;}
		// end of list.. reset next to head and return null
		else{next=head; return null;}
	}
		
	public int length()
	{
		int count=0;
		while(next()!=null)
		{
			count++;
		}
		return count;
	}
	public String toString()
	{
		return null;
	}
}

interface IList
{
	// insert at beginning of list
	void insertHead(Object n);
	// insert in middle somewhere
	void insert(Object n, int index);
	// insert at end of list
	void insertTail(Object d);
	// method to traverse list
	Node next();
	// number of nodes in list
	int length();
}

// represents node object in LinkedList
class Node
{
	//contains data
	private Object data;
	// points to next Node in list(default end of list)
	private Node pointer=null;
	
	// one arg constructor
	public Node(Object data)
	{
		this.data=data;
	}
	
	// get next element in list
	public Node getNext()
	{
		return pointer;
	}
	// set next element in list
	public void setNext(Node ptr)
	{
		pointer = ptr;
	}
	// set data in this node
	public void setData(Object d)
	{
		data=d;
	}
	public Object getData()
	{
		return data;
	}
}