import java.util.Scanner;

class SingularMain {

    Node head;
    private int size;

    SingularMain() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;
        
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    // add first
    public void addFirst(String data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
          head = newNode;
          return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add last
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
        currNode.next = newNode;
    }

    // Add at specific position
    public void add(int index, String data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = head;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
    }

    // Delete first
    public void deleteFirst(){
        if(head == null){
            System.out.println("The list is Empty");
            return;
        }
        head = head.next;
        size--;
    }

    // Delete last
    public void deleteLast(){
        if(head == null){
            System.out.println("This list is Empty");
            return;
        }
        
        size--;
        
        if(head.next == null){
            head = null;
            return;
        }
        
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // Delete at specific position
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index or list is empty!");
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node prevNode = head;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }
        prevNode.next = prevNode.next.next;
        size--;
    }

    // print
    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    // size
    public void getSize(){
        System.out.println("Size of linked list: " + size);
    }

    public static void main(String[] args) {
        SingularMain list = new SingularMain();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Linked List Operations Menu ---");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Position");
            System.out.println("7. Print List");
            System.out.println("8. Get Size");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the trailing newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter string to add first: ");
                    String firstData = scanner.nextLine();
                    list.addFirst(firstData);
                    break;
                case 2:
                    System.out.print("Enter string to add last: ");
                    String lastData = scanner.nextLine();
                    list.addLast(lastData);
                    break;
                case 3:
                    System.out.print("Enter position/index: ");
                    int addIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter string to add: ");
                    String posData = scanner.nextLine();
                    list.add(addIndex, posData);
                    break;
                case 4:
                    list.deleteFirst();
                    break;
                case 5:
                    list.deleteLast();
                    break;
                case 6:
                    System.out.print("Enter position/index to delete: ");
                    int delIndex = scanner.nextInt();
                    list.deleteAt(delIndex);
                    break;
                case 7:
                    list.printList();
                    break;
                case 8:
                    list.getSize();
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 9.");
            }
        }
        scanner.close();
    } 
}
