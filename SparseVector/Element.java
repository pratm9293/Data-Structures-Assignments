/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pratm
 */
public class Element implements Comparable<Element>{
   
   private int index;
   private double data;
   
    public Element() { }
    public Element(int i, double d) {
        setInd(i);
        setData(d);
    } 
    
    public Element(Element x) {
        this(x.getInd(), x.getData());
    }
   
    public void setInd(int index) { 
        this.index = index; 
    }
   
    public int getInd() { 
        return index; 
    }
    
    public void setData(double data) {
        this.data = data;
    }
    
    public double getData() { 
        return data; 
    }
    
    public int compareTo(Element x) {
        
    	/*if (x == null){
            throw new NullPointerException();
    	}
        
        if (!(x instanceof Element)){
            throw new ClassCastException();
        }
        
        if(x.getInd() > index) return 1; 
        else if(x.getInd() < index) return -1;
        else*/ return 0; 
    }
  
    
    public String toString() { 
        return "[" + getInd() + "," + getData() + "]"; 
    }
 }
    
    

