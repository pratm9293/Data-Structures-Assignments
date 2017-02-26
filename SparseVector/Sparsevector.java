/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
/**
 *
 * @author pratm
 */
public class Sparsevector {

    private DoublyLinkedList<Element> sv;
    public Sparsevector() {
        sv = new DoublyLinkedList<Element>();
    }
    public Sparsevector(DoublyLinkedList<Element> e){
        setList(e);
        this.sortList();
    }
    public void addFromFile(String[] x){
        for(int i = 0; i < x.length; i++){
            Element newElement = new Element();
            
            newElement.setInd(Integer.parseInt(x[i]));
            newElement.setData(Double.parseDouble(x[++i]));
            
            sv.add(newElement);
            this.sortList();   
        }
        
    }
    public void operation(String s, Sparsevector x){
        if(s.equals("add")){
           //this.add(x);
        }
        
    }
    public void setList(DoublyLinkedList<Element> e){ 
        sv = e; 
    }
    public void sortList(){
        DoublyLinkedList<Element> sortedList = new DoublyLinkedList<>();
        while(!sv.isEmpty()){
            int min = 0;
            
            for(int i = 1; i<sv.size(); i++){
                if(sv.get(i).getInd() < sv.get(min).getInd()){
                    min = i;
                }
            }
            System.out.println(min);
            sortedList.add(sv.getNode(min));
           // sv.remove(min);
        }
        //sv = sortedList;
    }
    public void tostring(){
        for(int i = 0; i<sv.size(); i++){
            System.out.print(sv.get(i) + " ");
        }
        System.out.println("");
        //return null;
    }
   /* public Sparsevector add(Sparsevector x){
        
        int tempVal;
        Iterator itrList = this.iterator();
        Iterator itrX = x.iterator();
        DoublyLinkedList<Element> newList = new DoublyLinkedList<>();
        int x1 = 0, x2 = 0;
        
        Element e1 = this.getElement(x1);
        Element e2 = x.getElement(x2);
        
        while(itrList.hasNext() && itrX.hasNext()) {
            if((x1!= this.size()) || (x2 != x.size())){
                e1 = this.getElement(x1);
                e2 = x.getElement(x2);    
            }else{
                break;
            }
            
            tempVal = e1.compareTo(e2);
            if(tempVal != 0){
                if(tempVal != 1){
                    newList.add(new Element(e1));
                    itrList.next();
                    x1++;
                }else{
                    newList.add(new Element(e2));
                    itrX.next();
                    x2++;
                }
            }else{
                int index = e1.getInd();
                double sumVal = e1.getData() + e2.getData();
                if(sumVal != 0){
                    newList.add(new Element(index, sumVal));
                }
                itrList.next();
                itrX.next();
                x1++;
                x2++;
            }
        }
        while((itrX.hasNext())){
            e2 = this.getElement(x2);
            newList.add(new Element(e2));
            x2++;
            itrX.next();
        }
        while((itrList.hasNext())){
            e1 = this.getElement(x1);
            newList.add(new Element(e1));
            x1++;
            itrList.next();
        }
        
        Sparsevector sumSv = new Sparsevector(newList);
        
        return sumSv;
    }*/
    private Iterator iterator() { 
        return this.getList().iterator();
    }
    public DoublyLinkedList<Element> getList(){
        return sv;
    }
    public Element getElement(int index) {
        return this.getList().get(index);
    }
    public int size() { 
        return sv.size();
    }
    public void print(String x, Sparsevector list1, Sparsevector list2){
        char dotCharacter = (char) 183;
        this.toString();
        if(x.equals("add")){
            System.out.println("+");
        }else if(x.equals("subtract")){
            System.out.println("-");
        }else if(x.equals("dot")){
            System.out.println(dotCharacter);
        }
        list1.toString();
        System.out.println("=");
        list2.toString();
    }
}
