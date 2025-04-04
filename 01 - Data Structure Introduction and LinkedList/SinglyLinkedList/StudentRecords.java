class StudentRecords{
    Node head;
    class Node{
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;
        Node(int rollNumber, String name, int age, String grade){
            this.rollNumber=rollNumber;
            this.name=name;
            this.age=age;
            this.grade=grade;
            next = null;
        }
    }
    StudentRecords(){
        head=null;
    }
    public void addAtBeginning(int rollNumber, String name,  int age,  String grade ){
        Node newNode= new Node( rollNumber,  name,  age,  grade);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    public void addAtEnd(int rollNumber, String name,  int age,  String grade){
        Node newNode=new Node(rollNumber,  name,  age,  grade);
        Node temp=head;
        if(head==null){
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next= newNode;
    }
    public void addAtPosition(int position, int rollNumber, String name,  int age,  String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        Node temp = head;
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        for (int i = 1; i < position; i++) {
            if (temp == null) {
                throw new IllegalArgumentException("Invalid position " + position);
            }
            temp=temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteByRollNumber(int rollNumber){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        if(head.rollNumber==rollNumber){
            head=head.next;
            return;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    public void searchByRollNumber(int rollNumber) {
        Node temp = head;
        if(temp==null){
            throw new NullPointerException("No records found");
        }
        if (head.rollNumber == rollNumber) {
            System.out.println("Roll number of the student \n" + head.rollNumber + "\nname of the Student\n" + head.name + "\nAge of the student\n" + head.age + "\nGrade of the Student\n" + head.grade);
            return;
        }
        while(temp!=null) {
            if(temp.rollNumber==rollNumber){
                System.out.println("Roll number of the student \n" + temp.rollNumber + "\nname of the Student\n" + temp.name + "\nAge of the student\n" + temp.age + "\nGrade of the Student\n" + temp.grade);
            }
            temp = temp.next;
        }
    }
    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No records to display");
            return;
        }
        while (temp != null) {
            System.out.println("Roll number of the student \n" + temp.rollNumber + "\nname of the Student\n" + temp.name + "\nAge of the student\n" + temp.age + "\nGrade of the Student\n" + temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrade(int rollNumber, String updatedGrade){
        Node temp=head;
        while(temp!=null){
            if(temp.rollNumber==rollNumber){
                temp.grade=updatedGrade;
                return;
            }
            temp=temp.next;
        }
        System.out.println("Record Not found");
    }
}
class Main{
    public static void main(String[] args) {
        StudentRecords studentRecord= new StudentRecords();
        studentRecord.addAtBeginning(1, "vijayaLakshmi", 22, "A+" );
        studentRecord.addAtBeginning(2, "lakshmi", 21, "A+" );
        studentRecord.addAtBeginning(3, "goutham", 21, "A+" );
        studentRecord.addAtEnd(4, "Surya",  22,  "B");
        studentRecord.addAtPosition(3, 5,  "Ganesh",   22, "O");
        studentRecord.deleteByRollNumber(5);
        studentRecord.searchByRollNumber(4);
        studentRecord.display();
        studentRecord.updateGrade(2, "B");
    }
}

