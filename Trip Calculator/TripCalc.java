import javax.swing.JOptionPane;
public class TripCalc {

	private int amtOfPpl;
	private  int sum;
	private  int sumaverage;
	private  int remainder;
	private  double average;
	private LinkedList list1;
	private static int numOfStudents;
	
	
	public TripCalc()
	{
		
	}
	
	
	
	public TripCalc(int pplAmt)
	{
		if(pplAmt<0){
			JOptionPane.showMessageDialog(null, "Negative Amount entered for Students! Try Again.");
			return;
		}else{
			amtOfPpl = pplAmt;
			numOfStudents += amtOfPpl;
		}
	}
	
	public  static int getNumOfStudents()
	{
		return numOfStudents;
		
	}
	
	public boolean addMoreTrip(int x)
	{
		boolean addMoreTrip = true;
		
		if(numOfStudents>1000)
		{
			JOptionPane.showMessageDialog(null,"You have exceeded your limit of tallying 1000 students. No more trips can be made." );
			addMoreTrip = false;
			return addMoreTrip;
		}else if(x==0){
			addMoreTrip = false;
			return addMoreTrip;
		}
		
		return addMoreTrip;
	}
	
	
	public double makeAverage()
	{
		
		remainder = sum%amtOfPpl;
		average = sum/amtOfPpl;
		if(remainder > 0)
		{
			average  = remainder+average;
		}
		
		return average;
		//average = average/100;

	}
	
	public void makeList()
	{
	    LinkedList moneyInput = new LinkedList();
		
	    for (int i = 0; i < amtOfPpl; i++){ //because first is already accounted for, minus 1 from pplAmt
				moneyInput.insert(                //calls insert method and inserts the nodes into LinkedList
				Double.parseDouble(
					JOptionPane.showInputDialog("How much did the person spend?") 
				)
			);		
		} 
	   //moneyInput.print();
	   sum = moneyInput.sum();
	  list1 = moneyInput;
	  //  list1.print();
	   
	}
	
	
	public void getPayment()
	{
		double temp;
		double temp2 = 0;
		
	/*	if(current.getNext()== null)
		{
			System.out.print("yes");
		}else{
			System.out.print("no");
		}
		System.out.println(x.getData());
		System.out.println(current.getData());*/
		Node1 current = list1.getHead();
		while(current != null)
		{
			//System.out.println("IMhere");
			//System.out.println("Old: " + current.getData());
			if(current.getData() > average)
			{
				//System.out.println("This node " + current.getData() + " is larger than avg: " + sumAvg);
				temp = current.getData() - average;
				//System.out.println("answer: " + temp);
				//break;
				temp2 += temp;
				//System.out.println(temp2);
				
			}
			
			
			
			current = current.getNext();
			//System.out.println("New: " + current.getData());
			
		}
		System.out.println("$" + temp2/100);
		
	}
}