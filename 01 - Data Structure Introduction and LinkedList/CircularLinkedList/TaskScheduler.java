public class TaskScheduler {
    Node last;
    Node current=null;

    class Node {
        String taskID;
        String taskName;
        String priority;
        String dueDate;
        Node next;

        Node(String taskID, String taskName, String priority, String dueDate) {
            this.taskID = taskID;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            next = null;
        }
    }

    TaskScheduler() {
        last = null;
    }

    public void addAtBeginning(String taskID, String taskName, String priority, String dueDate) {
        Node newNode = new Node(taskID, taskName, priority, dueDate);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    public void addAtEnd(String taskID, String taskName, String priority, String dueDate) {
        Node newNode = new Node(taskID, taskName, priority, dueDate);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public void addAtPosition(int position, String taskID, String taskName, String priority, String dueDate) {
        Node newNode = new Node(taskID, taskName, priority, dueDate);
        if (position == 0) {
            addAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }
        Node temp = last.next;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
            if (temp == last.next) {
                throw new IndexOutOfBoundsException("Invalid position");
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == last) {
            last = newNode;
        }
    }

    public void removeByTaskID(String taskID) {
        Node temp = last.next;
        if (last == null) {
            throw new NullPointerException("Empty List");
        }
        if (last == last.next && last.next.taskID.equalsIgnoreCase(taskID)) {
            last = null;
            return;
        }
        if (last.next.taskID.equalsIgnoreCase(taskID)) {
            last.next = temp.next;
            return;
        }
        while (temp.next != last.next) {
            if(temp.next.taskID.equalsIgnoreCase(taskID)) {
                if (temp.next == last) {
                    last = temp;
                }
                temp.next=temp.next.next;
                return;
            }
            temp=temp.next;
        }
        System.out.println("Record not found");
    }
    public void viewAndMoveToNext(){
        if(last==null){
            throw new NullPointerException("Empty List");
        }
        if(current==null){
            current=last.next;
        }
        System.out.println("ID of the task is: "+ current.taskID+
                "\nName of the task is: "+current.taskName+
                "\npriority of the task: "+current.priority+
                "\nDue date of the task: "+current.dueDate);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        current=current.next;
    }
    public void display(){
        if(last== null){
            throw new NullPointerException("Empty list");
        }
        Node temp = last.next;
        do{
            System.out.println("ID of the task is: "+ temp.taskID+
                    "\nName of the task is: "+temp.taskName+
                    "\npriority of the task: "+temp.priority+
                    "\nDue date of the task: "+temp.dueDate);
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            temp=temp.next;
        }while(temp!=last.next);
    }
    public void searchByPriority(String priority){
        if(last== null){
            throw new NullPointerException("Empty list");
        }
        Node temp=last.next;
        do{
            if(temp.priority.equalsIgnoreCase(priority)){
                System.out.println("ID of the task is: "+ temp.taskID+
                        "\nName of the task is: "+temp.taskName+
                        "\npriority of the task: "+temp.priority+
                        "\nDue date of the task: "+temp.dueDate);
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
            }
            temp=temp.next;
        }while(temp!=last.next);
    }
}
class Task{
    public static void main(String[] args) {
        TaskScheduler taskScheduler=new TaskScheduler();
        taskScheduler.addAtBeginning("T01", "Task One", "low","27/09/25");
        taskScheduler.addAtEnd("T02", "Task Two", "high", "12/06/25");
        taskScheduler.addAtPosition(0, "T03", "Task Three", "high", "27/05/25");
        taskScheduler.addAtPosition(3, "T04", "Task Four", "high","21/6/25");
        taskScheduler.removeByTaskID("T03");
        taskScheduler.viewAndMoveToNext();
        taskScheduler.viewAndMoveToNext();
        taskScheduler.display();
        taskScheduler.searchByPriority("high");
    }
}

