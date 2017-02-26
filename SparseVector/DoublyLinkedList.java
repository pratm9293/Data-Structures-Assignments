/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pratm
 */
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class DoublyLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> prev;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> p, Node<AnyType> n)
    {
      setData(d);
      setPrev(p);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getPrev() { return prev; }

    public void setPrev(Node<AnyType> p) { prev = p; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private int modCount;
  private Node<AnyType> header;
  private Node<AnyType> trailer;

  public DoublyLinkedList()
  {
    header = new Node<AnyType>(null, null, null);
    trailer = new Node<AnyType>(null, null, null);
    modCount = 0;
    clear();
  }

  public void clear()
  {
    header.setNext(trailer);
    trailer.setPrev(header);
    theSize = 0;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return (size() == 0);
  }

  public AnyType get(int index)
  {
    
      return getNode(index).getData();
  }

  public AnyType set(int index, AnyType newValue)
  {
    
      Node<AnyType> modNode = getNode(index);
      AnyType oldVal = modNode.getData();
      modNode.setData(newValue);
      return oldVal;
  }

  public boolean add(AnyType newValue)
  {
    add(size(), newValue);
    return true;
  }

  public void add(int index, AnyType newValue)
  {
      
      if(isEmpty()){
    	  Node<AnyType> newNode = new Node<AnyType>(newValue, header, trailer);
    	  header.setNext(newNode);
    	  trailer.setPrev(newNode);
    	  modCount++;
    	  theSize++;
      }else{
    	  Node<AnyType> ind = getNode(index, 0, size());
    	  Node<AnyType> newNode = new Node<AnyType>(newValue, ind.getPrev(), ind);
    	  ind.prev.next = newNode;
    	  ind.prev = newNode;
    	  theSize++;
    	  modCount++;
      }
      
  }

  public AnyType remove(int index)
  {
    return remove(getNode(index));
  }

  public Iterator<AnyType> iterator()
  {
    return new LinkedListIterator();    
  }

  private Node<AnyType> getNode(int index)
  {
    return (getNode(index, 0, size()-1));
  }

  private Node<AnyType> getNode(int index, int lower, int upper)
  {
      Node<AnyType> indNode;
      if(index < lower || index > upper){
          throw new IndexOutOfBoundsException();
      }
      if(index < size() / 2){
              indNode = header.next;
          for(int i = 0; i< index; i++){
              indNode = indNode.getNext();
          }
      }else{
              indNode= trailer.prev;
           for(int i = size(); i > index; i--){
              indNode = indNode.getPrev();    
           }
        }
      
      return indNode;
  }

  private AnyType remove(Node<AnyType> currNode)
  {
    
      currNode.next.prev = currNode.prev;
      currNode.prev.next = currNode.next;
      theSize--;
      modCount++;
      
      return currNode.getData();
  }

  private class LinkedListIterator implements Iterator<AnyType>
  {
    private Node<AnyType> current;
    private int expectedModCount;
    private boolean okToRemove;

    LinkedListIterator()
    {
      current = header.getNext();
      expectedModCount = modCount;
      okToRemove = false;
    }

    public boolean hasNext()
    {
      return (current != trailer);
    }

    public AnyType next()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!hasNext())
        throw new NoSuchElementException();

      AnyType nextValue = current.getData();
      current = current.getNext();
      okToRemove = true;
      return nextValue;
    }

    public void remove()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!okToRemove)
        throw new IllegalStateException();

      DoublyLinkedList.this.remove(current.getPrev());
      expectedModCount++;
      okToRemove = false;
    }
  }
}
