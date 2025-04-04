public class LibraryManagementSystem {
    Node head;
    Node tail;

    class Node {
        String bookName;
        String author;
        String genre;
        String bookID;
        boolean availabilityStatus;
        Node prev;
        Node next;

        Node(String bookName, String author, String genre, String bookID, boolean availabilityStatus) {
            this.bookName = bookName;
            this.author = author;
            this.genre = genre;
            this.bookID = bookID;
            this.availabilityStatus = availabilityStatus;
            prev = null;
            next = null;
        }
    }

    LibraryManagementSystem() {
        head = null;
        tail = null;
    }

    public void addAtBeginning(String bookName, String author, String genre, String bookID, boolean availabilityStatus) {
        Node newNode = new Node(bookName, author, genre, bookID, availabilityStatus);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void addAtEnd(String bookName, String author, String genre, String bookID, boolean availabilityStatus){
        Node newNode = new Node(bookName, author, genre, bookID, availabilityStatus);
        if(head==null){
            head= newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev= tail;
            tail=newNode;
        }
    }
    public void addAtPosition(int position,String bookName, String author, String genre, String bookID, boolean availabilityStatus){
        Node newNode = new Node(bookName, author, genre, bookID, availabilityStatus);
        if(position==0){
            addAtBeginning(bookName, author, genre, bookID, availabilityStatus);
            return;
        }
        Node temp=head;
        for(int i=1; i<position;i++){
            if(temp==null){
                throw new NullPointerException("Invalid Position");
            }
            temp=temp.next;
        }
        newNode.next=temp.next;
        newNode.prev=temp;
        if(temp.next!=null){
            temp.next.prev=newNode;
        }
        else{
            tail=newNode;
        }
        temp.next=newNode;
    }
    public void RemoveABookByID(String bookID){
        if(head==null){
            throw new NullPointerException("Empty List");
        }
        Node temp=head;
        while(temp!=null){
            if(temp.bookID.equalsIgnoreCase(bookID)){
                if(temp==head){
                    head=head.next;
                    if(head!=null){
                        head.prev=null;
                    }
                    else {
                        tail = null;
                    }
                }
                else if(temp==tail){
                    tail=temp.prev;
                    tail.next=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                return;
                }
            temp=temp.next;
        }
        System.out.println("No Records found");
    }
    public void searchABookByTitleOrAuthor(String bookName, String author){
        Node temp=head;
        while(temp!=null) {
            if (temp.bookName.equals(bookName) ||temp.author.equals(author)){
                System.out.println("Title of the book is: " + temp.bookName +
                        "\nAuthor of the book is: " + temp.author +
                        "\nGenre of the book is: " + temp.genre +
                        "\nId of the book is: " + temp.bookID +
                        "\nIs the book available? " + temp.availabilityStatus);
                System.out.println("------------------------------------------------------------------------------");
                return;
            }
            temp = temp.next;
        }
        System.out.println("No records found");
    }
    public void updateAvailabilityStatus(String bookName, Boolean status){
        Node temp= head;
        while(temp!=null){
            if(temp.bookName.trim().equalsIgnoreCase(bookName)){
                temp.availabilityStatus=status;
                return;
            }
            temp=temp.next;
        }
        System.out.println("Record not found");
    }
    public void display(){
        Node temp=head;
        if(head==null){
            System.out.println("No records to display");
            return;
        }
        while(temp!=null){
            System.out.println("Title of the book is: " + temp.bookName +
                    "\nAuthor of the book is: " + temp.author +
                    "\nGenre of the book is: " + temp.genre +
                    "\nId of the book is: " + temp.bookID +
                    "\nIs the book available? " + temp.availabilityStatus);
            System.out.println("------------------------------------------------------------------------------");
            temp=temp.next;
        }
    }
    public void displayReverse(){
        Node temp=tail;
        if(head==null){
            System.out.println("No records to display");
            return;
        }
        while(temp!=null){
            System.out.println("Title of the book is: " + temp.bookName +
                    "\nAuthor of the book is: " + temp.author +
                    "\nGenre of the book is: " + temp.genre +
                    "\nId of the book is: " + temp.bookID +
                    "\nIs the book available? " + temp.availabilityStatus);
            System.out.println("------------------------------------------------------------------------------");
            temp=temp.prev;
        }
    }
    public void count(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("The count of books is: "+count);
    }
}
class Library{
    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem=new LibraryManagementSystem();
        libraryManagementSystem.addAtBeginning("book1", "author1", "fiction", "bookF01", true);
        libraryManagementSystem.addAtBeginning("book2", "author2", "non-fiction", "bookNF01", true);
        libraryManagementSystem.addAtEnd("book3", "author3", "Magazine", "bookM01", true);
        libraryManagementSystem.addAtPosition(2,"book4", "author4", "Magazine", "bookM02", true);
        libraryManagementSystem.RemoveABookByID("bookM02");
        libraryManagementSystem.searchABookByTitleOrAuthor("book3"," ");
        libraryManagementSystem.updateAvailabilityStatus("book3",  false);
        libraryManagementSystem.display();
        libraryManagementSystem.displayReverse();
        libraryManagementSystem.count();
    }
}