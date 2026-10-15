import java.util.Scanner;

public class DoublyMain {
    private int size;
    Node head;
    Node tail;

    DoublyMain() {
      size=0;
    }
    
        class Node{
            String data;
            Node prev;
            Node next;

            Node(String data){
                this.data=data;
                this.prev=null;
                this.next=null;
            }
        }
    
    //add first
    public void addFirst(String data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
           head=newNode;
           tail=newNode;
           return;    
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    
    

    public void addLast(String data){
        Node newNode = new Node(data);
        size++;

        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    
    public void addMid(String data,int index){
        if(index<0|| index>size){
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
            prevNode = prevNode.next;
        }
        
        Node nextNode = prevNode.next;

        newNode.next=nextNode;
        newNode.prev =prevNode;
        prevNode.next = newNode;

        if(nextNode!=null){
            nextNode.prev = newNode;
        }
        size++;
    }


    public void deleteFirst(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        size--;
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        head = head.next;
        head.prev =null;

    }

    public void deleteLast(){
        if(head== null){
            System.out.println("List is Empty");
            return;
        }
        size--;
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        tail=tail.prev;
        tail.next=null;
    }
    public void deleteMid(int index){
        if(head==null||index<0||index>=size){
           System.out.println("Invalid Index or List is Empty");
           return;
        }
        if(index==0){
            deleteFirst();
            return;
        }
        if(index==size-1){
            deleteLast();
            return;
        }

        Node currNode =head;

        for(int i =0;i<index;i++){
            currNode = currNode.next;
        }
      currNode.prev.next= currNode.next;
      currNode.next.prev = currNode.prev;
      size--;
    }
    //Display

    public void display(){
        if(head==null){
            System.out.println("NULL");
            return;
        }
        Node currNode =head;
        while(currNode!=null){
            System.out.print(currNode.data +"<->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DoublyMain list = new DoublyMain();

    int choice;
        System.out.println("\n===== DOUBLY LINKED LIST =====");
        System.out.println("1. Add First 2.Add Last 3.Add at Index 4.Delete First "); 
        System.out.println("5. Delete Last 6.Delete at Index 7.Display 8.Exit ");
    do {

        System.out.print("Enter your choice: ");

        choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter data: ");
                String first = sc.nextLine();
                list.addFirst(first);
                break;

            case 2:
                System.out.print("Enter data: ");
                String last = sc.nextLine();
                list.addLast(last);
                break;

            case 3:
                System.out.print("Enter data: ");
                String data = sc.nextLine();

                System.out.print("Enter index: ");
                int index = sc.nextInt();

                list.addMid(data, index);
                break;

            case 4:
                list.deleteFirst();
                break;

            case 5:
                list.deleteLast();
                break;

            case 6:
                System.out.print("Enter index: ");
                int delIndex = sc.nextInt();

                list.deleteMid(delIndex);
                break;

            case 7:
                list.display();
                break;

            case 8:
                System.out.println("Program exited.");
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 8);

    sc.close();
}


}
