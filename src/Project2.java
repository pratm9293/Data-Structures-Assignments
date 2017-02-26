import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Project2 {
	/*
	 * @author Prateek Malli
	 * 
	 */
	public static void main(String[] args) throws IOException{
		/*
		 * Read the text file, process the read text, and create an instance of InfixToPostfix class each
		 * time we read one of the arithmetic expressions within project2.txt
		 * 
		 * @throws an IOException for any no-project file or null errors etc. 
		 */
		try(FileReader readFile = new FileReader("project2.txt")){
			
			String lineRead;
			BufferedReader fileLine = new BufferedReader(readFile);
			
			while((lineRead = fileLine.readLine()) != null){
				System.out.println(lineRead);
				InfixToPostfix readText = new InfixToPostfix(lineRead);
			}
		} catch (IOException e ){}
	}
}
