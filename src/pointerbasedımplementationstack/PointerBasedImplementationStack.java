
package pointerbasedımplementationstack;

import java.util.*;
import java.lang.Iterable;

public class PointerBasedImplementationStack <Item> implements Stack <Item>{
  private Node head; //the first node
  private int size; // number of items
 
  //Nested class to define node
  private class Node
  {
    Item item;
    Node next;
  }
 
  //Zero argument constructor
  public PointerBasedImplementationStack()
  {
    head = null;
    size = 0;
  }
 
  //Check if stack is empty	
  @Override
  public boolean isEmpty()
  {
    return (size == 0);
  }
 
  //Remove item from the beginning of the list.
  @Override
  public Item pop()
  {
    Item item = head.item;
    head = head.next;
    size--;
    return item;
  }
 
  //Add item to the beginning of the list.
  @Override
  public void push(Item item)
  {
    Node oldHead = head;
    head = new Node();
    head.item = item;
    head.next = oldHead;
    size++;
  }
 
  //Return number of items present in the stack
  @Override
  public int size()
  {
    return size;
  }
 
  //Iterator for traversing stack items
  public Iterator<Item> iterator()
  {
    return new LinkedStackIterator();
  }
 
  //inner class to implement iterator interface
  private class LinkedStackIterator implements Iterator <Item>
  {
    private int i = size;
    private Node first = head; //the first node
 
    @Override
    public boolean hasNext()
    {
      return (i > 0);
    }
 
    @Override
    public Item next()
    {
      Item item = first.item;
      first = first.next;
      i--;
      return item;
    }
 
    @Override
    public void remove()
    {
      // not needed
    }
    
  }
    
    public static void main(String[] args) {
    Stack <Integer> s = new PointerBasedImplementationStack<>();
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    s.push(60);
    s.push(70);
 
    System.out.println("Size of the stack: " + s.size());
 
    // iterate through stack
//    System.out.println("Following items pushed to Stack as of now:");
//    for (Integer i: s)
//      System.out.println(i);	

    }
}
