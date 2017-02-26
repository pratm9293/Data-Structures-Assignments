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

public interface List<AnyType>
{
  void clear();
  
  int size();

  boolean isEmpty();

  AnyType get(int index);

  AnyType set(int index, AnyType newValue);

  boolean add(AnyType newValue);

  void add(int index, AnyType newValue);

  AnyType remove(int index);

  Iterator<AnyType> iterator();
}