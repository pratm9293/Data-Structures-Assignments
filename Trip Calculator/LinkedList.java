

public class LinkedList {

	private Node1 head;
	
	public LinkedList() {
		head = null;
	}
	public LinkedList(int x){
		head = new Node1(x);
	}
	public LinkedList(Node1 n){
		head = n;
	}
	
	public void print(){
		Node1 current = head;
		while (current!=null){
			System.out.print(current.getData()+" ");
			current = current.getNext();
		}
	}
	
	public Node1 getHead()
	{
		return head;
	}
	
	public void insert(double x){
		x = x*100;
		if(head == null) {
			head = new Node1(x);
			return;
		}
		if(x>=head.getData()){
			head = new Node1(x, head); // case 1
			return;
		}
		Node1 current = head;
		Node1 previous = head;
		while(current!=null){
			if(x<current.getData()){
				previous = current;
				current = current.getNext();
			} else {
				previous.setNext(new Node1(x,current)); // case 2
				return;
			}
		}
		previous.setNext(new Node1(x)); // case 3
	}

	public boolean delete(int x){
		if(head.getData()==x){
			head = head.getNext(); // case 1
			return true;
		}
		Node1 current = head.getNext();
		Node1 previous = head;
		while(current!=null){
			if(current.getData()==x){
				previous.setNext(previous.getNext().getNext()); // cases 2 & 3
				return true;
			} else if(current.getData()>x){
				break;
			} else {
				previous = current;
				current = current.getNext();
			}
		} // while
		return false;
	}
	
	public void append(int x){
		Node1 current = head;
		while(current.getNext()!=null){
			current = current.getNext();
		}
		// Node temp = new Node(x);
		// current.setNext(temp);
		current.setNext(new Node1(x));
	}
	
	public int sum()
	{
		int sum = 0;
		Node1 current = head;
		
		while(current != null)
		{
			sum+= current.getData();
			current = current.getNext();
		}
		
		return sum;
		
	}

	
}
