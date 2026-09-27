import java.util.Scanner;
class SingularMain{
      Node  head;  
      private int size;

      SingularMain(){
        this.size =0;
      }

      class Node{
        String data;
        Node next;

        Node(String data){
            this.data =data;
            this.next= null;
        }
      }

      // ADD FIRST
      public void addFirst(String data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = newNode;
            return;
        }
        newNode.next=head;
        head= newNode;

      }

      // ADD LAST
      public void addLast(String data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;

        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next= newNode;
      }



      // ADD at MID
      public void addMid(int index,String data){
        if(index<0 || index>size){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size){
            addLast(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node prevNode = head;
        for(int i=0;i<index-1;i++){
            prevNode= prevNode.next;
        }
        newNode.next= prevNode.next;
        prevNode.next = newNode;
        size++;

      }
      
      //DELETE FIRST
      public void deleteFirst(){
        if(head == null){
            System.out.println("List is Emty");
            return;
        }
        head=head.next;
        size--;
      }

      // DELETE LAST
      public void deleteLast(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        Node secondLastNode =head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode = null;
      }

      //DELETE MID
      public void deleteMid(int index){
        if(index < 0 || index>=size){
            System.out.println("List is Empty");
            return;
        }
        if(index==0){
            deleteFirst();
            return;
        }
        if(index==size){
            deleteLast();
            return;
        }

        Node prevNode = head;
        for(int i=0;i<index-1;i++){
            prevNode = prevNode.next;
        }
        prevNode.next = prevNode.next.next;
        size--;

      }


      // DISPLAY

      public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data +"->");
            currNode = currNode.next;
        }
           System.out.println("NULL");
      }

      //SIZE
      public void getSize(){
        System.out.println("Size of linked list:"+size);
    
      }
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      SingularMain list = new SingularMain();
      boolean running = true;
      while(running){
        System.out.println("-------Menu of Linked Operation--------");
        System.out.println("CHOOSE: 1.addFirst 2.addLast 3.addAtPosition 4.deleteFirst");
        System.out.println(" 5.deleteLast 6.deleteAtPosition 7.Display  8.getSize 9.Exit:");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1 -> {
                System.out.println("Enter your text:");
                String firstData = sc.nextLine();
                list.addFirst(firstData);
              }
            case 2 -> {
                System.out.println("Enter your text:");
                String lastData = sc.nextLine();
                list.addLast(lastData);
              }
            case 3 -> {
                System.out.println("Enter your position:");
                int position = sc.nextInt();
                System.out.println("Enter you text");
                String midData = sc.next();
                list.addMid(position,midData);
              }
            case 4 -> list.deleteFirst();
            case 5 -> list.deleteLast();
            case 6 -> {
                System.out.println("Enter position index:");
                int midIndex = sc.nextInt();
                list.deleteMid(midIndex);
              }
            case 7 -> list.display();
            case 8 -> list.getSize();
            case 9 -> {
                running = false;
                System.out.println("Exiting program .... GoodBye");
                sc.close();
              }
            default -> System.out.println("Wrong Input choose 1-9");
        }
      }
    }
}