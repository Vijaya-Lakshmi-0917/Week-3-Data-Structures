public class UndoRedoFunctionalityForTextEditor {
    Node head;
    Node tail;
    Node temp;
    int size;
    final int historyLimit=10;
    class Node{
        String text;
        Node prev;
        Node next;
        Node (String text){
            this.text=text;
        }
    }
    public void trimToSizeFromHead(){
        while (size>historyLimit){
            if(head==null){
                break;
            }
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            size--;
        }
    }
    UndoRedoFunctionalityForTextEditor(){
        head=null;
        tail=null;
        temp=null;
        size=0;
    }
    public void type(String text){
        Node newNode= new Node(text);
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.prev = temp;
            } else {
                tail = temp;
            }
            size--;
        }
        if (temp == null) {
            head = tail = temp = newNode;
        } else {
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
            tail = temp;
        }

        size++;
        trimToSizeFromHead();
    }
    public void undo(){
        if(temp!=null && temp.prev!=null){
            temp=temp.prev;
        }
        else{
            System.out.println("Nothing to Undo");
        }
    }
    public void redo(){
        if(temp!=null && temp.next!=null){
            temp=temp.next;
        }
        else{
            System.out.println("Nothing to redo");
        }
    }
    public void  display(){
        if(temp!=null){
            System.out.println("Current text: "+temp.text);
        }
        else{
            System.out.println("Editor is Empty");
        }
    }
}
class Main{
    public static void main(String[] args) {
        UndoRedoFunctionalityForTextEditor editor=new UndoRedoFunctionalityForTextEditor();
        editor.type("This");
        editor.type("is");
        editor.type("a");
        editor.type("java");
        editor.type("program");
        editor.undo();
        editor.display();
        editor.undo();
        editor.display();
        editor.redo();
        editor.display();
        editor.type("Hello World");
        editor.redo();
    }
}
