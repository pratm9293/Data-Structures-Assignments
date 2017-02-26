import javax.swing.JOptionPane;

public class Assignment3 {

	
	
	public static void main(String[] args)
	{
	
	
		int continueOrno;
		int numOfStudents;
	do{
			int pplAmt = Integer.parseInt(
		    JOptionPane.showInputDialog("Enter the amount of people on the trip.")
		); 
		
		TripCalc trip1 = new TripCalc(pplAmt); //start a trip log with the amount of ppl passed through main and pass the node we created
		trip1.makeList();
		trip1.makeAverage();
		trip1.getPayment();
		numOfStudents = trip1.getNumOfStudents();
		continueOrno = Integer.parseInt(JOptionPane.showInputDialog("Enter 0 if you want to continue and make another trip."));
		
	}while(continueOrno==0 && 
			numOfStudents < 1000);
	
	
    }
}
//4.14434343 * 100 = 414.332/100.0 = 4.14

