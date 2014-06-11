/*singly linked list from scratch*/

public class LinkedList implements IList
{
	// head of list
	Node head = new Node(null);
	// points to next element of list used by next() method
	Node next = head;
	Node tail = head;
	
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
	
	public void deleteHead()
	{
		head = head.getNext();
	}
	public void deleteTail()
	{
		Node current = head;
		Node prev = null;
		// find end of list and previous element
		while(true)
		{
			//head==tail
			if(current.getNext()==null){deleteHead();break;}
			else 
			{
				prev = current;
				current = current.getNext();
				
				//reached end of list
				if(current==null)break;
			}
		}
		tail=prev;
		tail.setNext(null);
	}
	
	public void delete(int index)
	{
		Node current = head;
		Node prev = null;
		// find end of list and previous element
		while(true)
		{
			//head
			if(index==0){deleteHead();break;}
			//tail
			else if(index == this.length()-1){deleteTail(); break;}
			else 
			{
				prev = current;
				current = current.getNext();
				
				//reached end of list
				if(current==null)break;
			}
		}
		tail=prev;
		tail.setNext(null);
		
		
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
	// delete from head
	void deleteHead();
	// delete from specific location
	void delete(int index);
	// delete from tail
	void deleteTail();
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