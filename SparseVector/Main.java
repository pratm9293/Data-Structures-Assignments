/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
/*import java.io.File;
import java.util.*;
*/
/**
 *
 * @author pratm
 */
public class Main {
    
    public static void main(String[] args){
       String line;
       Sparsevector sv1, sv2;
       FileReader fromFile;
       BufferedReader inFile;
       String path = "project1.txt";
        
        try{
            fromFile = new FileReader(path);
            inFile = new BufferedReader(fromFile);
            while( (line = inFile.readLine())!= null){
                sv1 = new Sparsevector();
                sv2 = new Sparsevector();
                
                String[] values = line.split(" ");
                sv1.addFromFile(values);
                
                line = inFile.readLine();
                values = line.split(" ");
                sv2.addFromFile(values);
                
                line = inFile.readLine();
                sv1.operation(line, sv2);
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }

        /*File myFile = new File("project1.txt");
        System.out.println("Attempting to read from file in: "+myFile.getCanonicalPath());

        Scanner input = new Scanner(myFile);
        String in = "";
        in = input.nextLine();
        */
    }
    
}
