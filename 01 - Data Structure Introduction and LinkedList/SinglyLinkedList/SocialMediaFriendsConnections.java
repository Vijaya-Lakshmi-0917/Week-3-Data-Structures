import java.util.ArrayList;
import java.util.List;
public class SocialMediaFriendsConnections {
    Node head;

    class Node {
        String userId;
        String name;
        int age;
        List<String> listOfFriendsIds;
        Node next;

        Node(String userId, String name, int age, List<String> listOfFriendsIds) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.listOfFriendsIds = listOfFriendsIds != null ? listOfFriendsIds : new ArrayList<>();
            this.next = null;
        }
    }
    SocialMediaFriendsConnections() {
        head = null;
    }
    public void addAtBeginning(String userId, String name, int age, List<String> listOfFriendsIds){
        Node newNode=new Node(userId,  name,  age,  listOfFriendsIds);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    public void addAtEnd(String userId, String name, int age, List<String> listOfFriendsIds) {
        Node newNode = new Node(userId, name, age, listOfFriendsIds);
        Node temp = head;
        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void addAtPosition(int position, String userId, String name, int age, List<String> listOfFriendsIds){
        Node newNode = new Node(userId, name, age, listOfFriendsIds);
        Node temp= head;
        if(position==0){
            addAtBeginning(userId, name, age,listOfFriendsIds);
            return;
        }
        for(int i=1; i< position; i++){
            if(temp==null){
                throw new NullPointerException("Invalid Position");
            }
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public Node findUserByUserId(String userId) {
        Node temp = head;
        while (temp != null) {
            if (temp.userId.equals(userId)) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public void AddFriendConnection(String userId1, String userId2) {
        Node user1 = findUserByUserId(userId1);
        Node user2 = findUserByUserId(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.listOfFriendsIds.contains(userId2)) {
                user1.listOfFriendsIds.add(userId2);
            }
            if (!user2.listOfFriendsIds.contains(userId1)) {
                user2.listOfFriendsIds.add(userId1);
            }
        } else {
            System.out.println("User Not Found");
        }
    }

    public void removeAFriendConnection(String userIdToBeRemovedFrom, String userIdToBeRemoved) {
        Node user1 = findUserByUserId(userIdToBeRemovedFrom);
        Node user2 = findUserByUserId(userIdToBeRemoved);
        if (user1 != null && user2 != null) {
            if (user1.listOfFriendsIds.contains(userIdToBeRemoved)) {
                user1.listOfFriendsIds.remove(userIdToBeRemoved);
            } else {
                System.out.println("User Not Found");
            }
        }
    }
    public void display(String userId){
        Node temp=head;
        while(temp!=null) {
            if (temp.userId.equals(userId)) {
                for (int i = 0; i < temp.listOfFriendsIds.size(); i++) {
                    System.out.println(temp.listOfFriendsIds.get(i));
                }
                break;
            }
            temp=temp.next;
        }
    }
    public void searchByNameOrUserId(String userId, String name){
        Node temp=head;
        while(temp!=null){
            if(temp.name.equals(name)|| temp.userId.equals(userId)){
                System.out.println("user id of the person is "+temp.userId);
                System.out.println("Name of the person is "+temp.name);
                System.out.println("Age of the person is "+temp.age);
                System.out.println("list of Connections of "+temp.name);
                for(int i=0; i<temp.listOfFriendsIds.size(); i++){
                    System.out.println(temp.listOfFriendsIds.get(i));
                }
            }
            temp=temp.next;
        }
    }
    public void countNumberOfFriendsForEachUser(){
        Node temp=head;
        if(head==null){
            throw new NullPointerException("List is Empty");
        }
        while(temp!=null){
            int count=temp.listOfFriendsIds.size();
            System.out.println(temp.userId+ " has "+count +" number of connections");
            temp=temp.next;
        }
    }

}
class SocialMedia {
    public static void main(String[] args) {
        SocialMediaFriendsConnections socialMedia = new SocialMediaFriendsConnections();
        socialMedia.addAtBeginning("sl8573", "Vijaya Lakshmi", 22, new ArrayList<>(List.of("gs9573", "sr0167", "sl9017")));
        socialMedia.addAtBeginning("gs9573", "Gowtham", 19, new ArrayList<>(List.of("sl8573", "sr0167", "sl9017")));
        socialMedia.addAtEnd("ga0679", "Ganesh",21,new ArrayList<>(List.of("sl8573","js8745", "jm0917")) );
        socialMedia.addAtPosition(1, "ab1794", "abi", 24, new ArrayList<>(List.of( "gd9017", "cs0967")));
        socialMedia.AddFriendConnection("sl8573", "ab1794");
        socialMedia.removeAFriendConnection("sl8573", "ab1794");
        socialMedia.display("sl8573");
        socialMedia.searchByNameOrUserId("sl8573", null);
        socialMedia.countNumberOfFriendsForEachUser();
    }
}

