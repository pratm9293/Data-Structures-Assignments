import javax.swing.JOptionPane;

public class Node1 {
	
	private double data;
	private Node1 next;
	
	public Node1(double d){
		
		if(d/100 > 10000.0){
			   JOptionPane.showMessageDialog(null, "Too much spent by one student. Try Again!");
			  System.exit(0);
			}else if(d < 0)
			{
				JOptionPane.showMessageDialog(null, "Payment cannot be a negative number. Try Again!");
				System.exit(0);
			}else{
				data = d;
			}
	}
	
	public Node1(double d, Node1 n){
		if(d/100 > 10000.0){
			   JOptionPane.showMessageDialog(null, "Too much spent by one student. Try Again!");
			  System.exit(0);
			}else if(d < 0)
			{
				JOptionPane.showMessageDialog(null, "Payment cannot be a negative number. Try Again!");
				System.exit(0);
			}else{
					data = d;
					next = n;
			}
	}
	
	public double getData(){return data;}
	public Node1 getNext(){return next;}
	public void setNext(Node1 n){next = n;}
	

}
