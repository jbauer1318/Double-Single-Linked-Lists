 
public abstract class LinkedListIntClass implements LinkedListIntADT { 
  protected class LinkedListNode implements Cloneable { 
    public int info; 
    public LinkedListNode link; 
    //Default constructor 
    public LinkedListNode() { 
      info = 0; 
      link = null; 
    }
    
    //Alternate constructor 
    public LinkedListNode(int elem, LinkedListNode ptr) { 
      info = elem; 
      link = ptr; 
    }
    
    public Object clone() { 
      LinkedListNode copy = null; 
      try { 
        copy = (LinkedListNode) super.clone(); 
      } 
      catch (CloneNotSupportedException e) { 
        return null; 
      } 
      return copy; 
    }
    
    public String toString() { 
      return (info + ""); 
    } 
  } //end class LinkedListNode
  
    
  //Instance variables of the class LinkedListClass 
  protected LinkedListNode first;//address of the first node/list 
  protected LinkedListNode last; //address of the last node/list 
  protected int count;            //number of nodes in the list
  
  //Default constructor 
  public LinkedListIntClass() { 
    first = null; 
    last = null; 
    count = 0; 
  }
  
  public boolean isEmptyList() { 
    return (first == null); 
  }
  
  public void initializeList() { 
    first = null; 
    last = null; 
    count = 0; 
  }
  
  public void print()  { 
    LinkedListNode current; //variable to traverse the list 
    current = first; 
    while (current != null) {//while more data to print 
      System.out.print(current.info + " "); 
      current = current.link; 
    } 
  }
  
  public int length() { 
    return count; 
  }
  
  public int front()   { 
    return first.info; 
  }
  
  public int back()  { 
    return last.info; 
  }
  
  public Object clone() { 
    LinkedListIntClass copy = null; 
    try  { 
      copy = (LinkedListIntClass) super.clone(); 
    } 
    catch (CloneNotSupportedException e){ 
      return null; 
    }
    
    //If the list is not empty clone each node of the list. 
    if (first != null) { 
      //Clone the first node 
      copy.first = (LinkedListNode) first.clone(); 
      copy.last = copy.first; 
      LinkedListNode current; 
      if (first != null) 
        current = first.link; 
      else 
        current = null; 
      //Clone the remaining nodes of the list 
      while (current != null) { 
        copy.last.link = (LinkedListNode) current.clone(); 
        copy.last = copy.last.link; 
        current = current.link; 
      } 
    } 
    return copy; 
  }
  
  
  public abstract boolean search(int searchItem); 
  public abstract void insertFirst(int newItem); 
  public abstract void insertLast(int newItem); 
  public abstract void deleteNode(int deleteItem); 
}