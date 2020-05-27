public class UnorderedLinkedListInt extends LinkedListIntClass {
  
  public UnorderedLinkedListInt() {
    super();
  }
  
   public boolean search(int searchItem) {
    LinkedListNode current;
    current = first;
    while (current != null) {
      if (current.info == searchItem) {
        return true;
      } else {
        current = current.link;
      }      
    }
    return false;
  }
  
  public void insertFirst(int newItem) {
    LinkedListNode newNode;
    newNode = new LinkedListNode(newItem, first);
    first = newNode;
    if (last == null) {
      last = newNode;
    }
    count++;
  }
  
  public void insertLast(int newItem) {
    LinkedListNode newNode;
    newNode = new LinkedListNode(newItem, null);
    if (first == null) {
      first = newNode;
      last = newNode;
    } else {
      last.link = newNode;
      last = newNode;
    }
    count++;
  }
  
  public void deleteNode(int deleteItem) {
    LinkedListNode current; 
    LinkedListNode trailCurrent; 
    boolean found;
    if (first == null) {
      System.err.println("Cannot delete from an empty list.");
    } else {
      if (first.info == deleteItem) {
        first = first.link;
        if (first == null) {
          last = null;
        }
        count--;
      }
      else { 
        found = false;
        trailCurrent = first; 
        current = first.link; 
        while (current != null && !found) {
          if (current.info == deleteItem) {
            found = true;
          } else {
            trailCurrent = current;
            current = current.link;
          }
        }
        if (found) {
          count--;
          trailCurrent.link = current.link;
          if (last == current) {
            last = trailCurrent;
          } 
          else {
            System.out.println("Item to be deleted is not in the list.");
          }
        }
      }
    }
  }
  
  public UnorderedLinkedListInt merge1(UnorderedLinkedListInt list2) {
    LinkedListNode current = list2.first;
    while (!list2.isEmptyList() && current != null) {
      this.insertLast(current.info);
      current = current.link;
    }
    return this;
  }       
    
  public UnorderedLinkedListInt merge2(UnorderedLinkedListInt list2) {
    LinkedListNode current = first;
    UnorderedLinkedListInt merged = new UnorderedLinkedListInt();
    while (!this.isEmptyList() && current != null) {
      merged.insertLast(current.info);
      current = current.link;
    }
    current = list2.first;
    while (!list2.isEmptyList() && current != null) {
      merged.insertLast(current.info);
      current = current.link;
    }
    return merged;
  }
  
 public void split(UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, UnorderedLinkedListInt merged, int key) {
    LinkedListNode current = merged.first;
    while (!merged.isEmptyList() && current != null) {
      if (current.info <= key) {
        list1.insertLast(current.info);
      } else {
        list2.insertLast(current.info);
      }
      current = current.link;
    }
 }
 
 public int findSum() {
   LinkedListNode current;
   current = first;
   int sum = 0;
   while (current != null) {
     sum += current.info;
     current = current.link;
   }
   return sum;
 }
 
 public void massDelete(UnorderedLinkedListInt list) {
   LinkedListNode current = list.first;
   while (!list.isEmptyList() && current != null) {
     list.deleteNode(current.info);
     current = current.link;
   }
 } 
 
 public int findMin() {
   LinkedListNode current;
   current = first;
   int min = current.info;
   while (current != null) {
     if (min > current.info) {
       min = current.info;
     }
     current = current.link;
   }
   return min;
 }
  
 public String toString() {
   String result = "";
   LinkedListNode current = first;
   while (current.link != null) {
     result += current + ", ";
     current = current.link;
   }
   return ("[" + result + current + "]");
 }
 
}
