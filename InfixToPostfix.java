import java.nio.charset.*;
import java.io.*;

public class InfixToPostfix {
	/*
	 * @author Prateek Malli
	 */
	private DynamicArrayStack<Character> newStack;
	private String printThis;
	
	public InfixToPostfix( ){
		newStack = new DynamicArrayStack<>();
		printThis = "";
	}
	/*
	 * As soon as an InfixToPostfix is initiated with a string passed in const., 
	 * it is processed, translated to postfix and printed via print() method
	 */
	public InfixToPostfix(String readLine) throws IOException {
		newStack = new DynamicArrayStack<>();
		printThis = "";
		
		if(getChar(readLine)) print();
		else System.out.println("\n\n" + "This is not a valid expression");
		
	}
	
	public void print(){ System.out.println(printThis + "\n"); }
	
	/*
	 * @params oper; incase stacks empty - this operator is the first to be pushed on.
	 * 		   intA; used for comparison in deciding whether an operator on stack is of 
	 * 				 lower precedence.
	 * We basically check to see what is on the top of stack - if it's '(' - we push whatever we popped back on.
	 * If it is '-' or '+', we have determined that whatever was on top of stack is of lowest precedence, and push back topOper.
	 * else, we determine that whatever was on top is ready to be put to output.
	 */
	public void operator(char oper, int intA){
		
		while(!newStack.isEmpty()){
			
			char topOper = newStack.pop();
			
			if(topOper == '('){
				newStack.push(topOper);
				break;
			}else{
				int intB;
				
				if(topOper == '-' || topOper == '+') intB = 0;
				else							    intB = 1;
				
				if(intB < intA) { 
					newStack.push(topOper);
					break;
				}else{
					printThis = printThis + topOper;
				}
			}
		}
		
		newStack.push(oper);
	}
	/*
	 * If the char processed within the read expression is a ')', this method is called.
	 * we immediately pop everything and add it to output until we hit '(' on stack to signal that the parenthesis () has ended. 
	 */
	public void parenthesis() { 
		
		while(!newStack.isEmpty()) {
			char y = newStack.pop();
			if(y == '(') break;
			else printThis = printThis + y;
		
		}
	}
	/*
	 * @param readLine; the String-type text that is read from project2.txt and processed within the main in Project2.java
	 * @return true - stack is empty.
	 * 
	 * We initiate a for loop to iterate and examine each character until the end of String (hence .length()). 
	 * Once the for loop as terminated, we pop everything off stack until stack is empty and add it to output.
	 * 
	 */
	public boolean getChar(String readLine){ 
		
		for(int i=0; i < readLine.length(); i++) { 
			
			char x = readLine.charAt(i);
			
			if(x == '-' || x == '+') operator(x, 0);
			else if(x == '/' || x == '*') operator(x, 1);
			else if(x == '(') newStack.push(x);
			else if(x == ')') parenthesis();
			else printThis = printThis + x;
		}
		
		while(!newStack.isEmpty()){
			printThis = printThis + newStack.pop();
		}
		
		
		return newStack.isEmpty(); 
	}

}
