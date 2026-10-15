class LL{
     Node head;
	class Node {
        String data;
        Node next;
        
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
	
	// Add First
	public void addFirst(String data){
	    Node newNode = new Node(data);
		if(head== null){
		   head=newNode;
		   return;
		}
		newNode.next=head;
		head = newNode;
		
	}
	
	//Add Last
	public void addLast(String data){
		Node newNode = new Node(data);
		if(head== null){
			head=newNode;
			return;
		}
		  Node currNode = head;
	     while(currNode.next != null){
		  currNode= currNode.next;
	   }
	   currNode.next = newNode;
		
	}
	
	//Delete First
	
	public void deleteFirst(){
		if(head==null){
			System.out.println("List is Empty");
		}
		head = head.next;
	}
	
	//Delete Last
	
	public void deleteLast(){
		if(head == null){
			System.out.println("Lis is Empty");
		}
		if(head.next==null){
			head= null;
			return;
		}
	    Node secondeLast = head;
		Node lastNode = head.next;
	     while(lastNode.next != null){
			 lastNode = lastNode.next;
			 secondeLast = secondeLast.next;
		  
	   }
	   secondeLast.next=null;
		
	}
	
	//Display
	
	public void printList(){
	   if(head==null){
            System.out.println("Linked list is Empty");	   
	   }
	   Node currNode = head;
	   while(currNode != null){
	      System.out.print(currNode.data+"->");
		  currNode= currNode.next;
	   }
	   System.out.println("NULL");
	}
	
	
	public static void main(String[] args){
	    LL list = new LL();
		
		list.addFirst("a");
		list.addFirst("is");
		list.addLast("list");
		
		list.deleteFirst();
		list.deleteLast();
		list.printList();
		
	}
}