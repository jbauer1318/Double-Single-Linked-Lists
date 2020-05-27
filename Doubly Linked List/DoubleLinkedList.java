public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> { 

    public class DoubleLinkedListNode<T>  { 
    	
        T info; 
        DoubleLinkedListNode<T> next; 
        DoubleLinkedListNode<T> back;

        public DoubleLinkedListNode() { 
            info = null; 
            next = null; 
            back = null; 
        }

        public String toString() { 
            return info.toString(); 
        } 
    }

    protected int count; 
    protected DoubleLinkedListNode<T> first; 
    protected DoubleLinkedListNode<T> last; 
	
	public void initializeList() {
		first = null;
        last = null;
        count = 0;
	}
	
	
	public boolean isEmptyList() {
		return (first == null);
	}
	
	
	public T front() {
		return first.info;
	}
	
	
	public T back() {
		return last.info;
	}
	
	
	public int length() {
		return count;
	}
	
	
	public void print() { 
		DoubleLinkedListNode<T> current; 
	    current = first; 
	    while (current != null) {
	      System.out.print(current.info + " "); 
	      current = current.next; 
	    } 
		
	}
	
	
	public void reversePrint() { 
		DoubleLinkedListNode<T> current; 
	    current = last; 
	    while (current != null) { 
	      System.out.print(current.info + " "); 
	      current = current.back; 
	    }
	}

	
	public boolean search(T searchItem) { 
		 	DoubleLinkedListNode<T> current; 
	        current = first;
	        while(current != null){
	        	if(current.info.equals(searchItem))
	        		return true;
	        	else
	        		current = current.next;
	        }
	        
	        return false;
	}
	
	
	public void insertNode(T insertItem) {
		DoubleLinkedListNode<T> current; 
	    DoubleLinkedListNode<T> trailCurrent = null;  
	    DoubleLinkedListNode<T> newNode;
	    boolean found;
	    
	    newNode = new DoubleLinkedListNode();
	    
	    newNode.info = insertItem;
	    newNode.next = null;
	    newNode.back = null;
	    
	    if(first == null) {
	    	first = newNode;
	    	last = newNode;
	    	count++;
	    }
	    
	    else {
	    	found = false;
	    	current = first;
	    	
	    	while(current != null && found) {
	    		Comparable<T> temp = (Comparable<T>) current.info;
	    		if(temp.compareTo(insertItem) >= 0)
	    			found = true;
	    		else {
	    			trailCurrent = current;
	    			current = current.next;
	    		}
	    	}
	    	
	    	if (current == first) {
	    		first.back = newNode;
	    		newNode.next = first;
	    		first = newNode;
	    		count++;
	    	}
	    	else{
	    		if(current != null) {
	    			trailCurrent.next = newNode;
	    			newNode.back = trailCurrent;
	    			newNode.next = current;
	    			current.back = newNode;
	    		}
	    		
	    		else{
	    			trailCurrent.next = newNode;
	    			newNode.back = trailCurrent;
	    			last = newNode;
	    		}
	    		count++;
	    		}
	    			
	    	}
	}
	
	
	public void deleteNode(T deleteItem) {
	    DoubleLinkedListNode current;
	    DoubleLinkedListNode trailCurrent;  
	    boolean found; 
	    //the list is empty 
	    if (first == null) 
	      System.err.println("Cannot delete from an empty list."); 
	    else { 
	      //the node to be deleted is first 
	      if (first.info.equals(deleteItem)) { 
	    	current = first;  
	        first = first.next; 
	        if (first != null)  
	          first.back = null;
	        else
	        	last = null;
	        count--; 
	      } 
	      else {  
	        found = false; 
	        trailCurrent = first;
	        current = first.next; 
	        while (current != null && !found) { 
	          if (current.info == deleteItem) 
	            found = true; 
	          else { 
	            trailCurrent = current; 
	            current = current.next; 
	          } 
	        } 
	        //if found, delete the node 
	        if (found) { 
	          count--; 
	          trailCurrent.next = current.next; 
	          if (last == current) 
	            last = trailCurrent; 
	        } 
	        else 
	          System.out.println("Item to be deleted is not in the list."); 
	      } 
	    } 
		
	}
	
	
	public boolean equals(Object o){ 
	    if(o!= null &&  o instanceof DoubleLinkedList ){
	      DoubleLinkedList other = (DoubleLinkedList) o;
	      return (first == other.first && last == other.last && count == other.count);
	    }
	    else
	      return false;
	  }
  
	public String backwardsString() {
		String result="[head] - ";
	    DoubleLinkedListNode<T> current;  
	    current = last; 
	    while (current != null){
	    result += current.info + " - " ;
	    current = current.back;
	    }
	    result += "[tail]";
	    return result;
	}  

	public String toString() { 
	    String result="[head] - ";
	    DoubleLinkedListNode<T> current;  
	    current = first; 
	    while (current != null){
	    result += current.info + " - " ;
	    current= current.next;
	    }
	    result += "[tail]";
		    return result;
	}

	public String recursiveToString() { //helper
		return recursiveToString(first);
	}

	private String recursiveToString(DoubleLinkedListNode<T> node) {
		if (node == null)
			return "";
		String left = recursiveToString(node.next);
		if (left.isEmpty())
			return node.info.toString();
		
		return node.info.toString() + " - " + left;
	}




	public String recursiveBackwardsString() { //helper
		return recursiveBackwardsString(last);
	}

	private String recursiveBackwardsString(DoubleLinkedListNode<T> node) {
		if (node == null)
			return "";
		String left = recursiveBackwardsString(node.back);
		if (left.isEmpty())
			return node.info.toString();
		
		return node.info.toString() + " - " + left;
	}


	
	
	public void copy(DoubleLinkedList<T> otherList) {
       DoubleLinkedListNode<T> newNode;
       DoubleLinkedListNode<T> current;
     
       count = otherList.count;
       current = otherList.first;
       first = new DoubleLinkedListNode();
       first.info = current.info;
       first.next = null;
       last = first;
       current = current.next;

       while (current != null) {
           newNode = new DoubleLinkedListNode();
           newNode.info = current.info;
           newNode.next = null;
           last.next = newNode;
           last = newNode;
           current = current.next;
       }
       
   }


	public void reversedCopy(DoubleLinkedList<T> otherList) { 
       DoubleLinkedListNode<T> newNode;
       DoubleLinkedListNode<T> current;

       count = otherList.count;
       current = otherList.last;
       last.info = current.info;
       last.next = null;
       first = last;
       current = current.next;

       while (current != null) {
           newNode = new DoubleLinkedListNode();
           newNode.info = current.info;
           newNode.next = null;
           first.next = newNode;
           first = newNode;
           current = current.next;

       }

   }
		
}  

