public class MovieManagementSystem {
    Node head;
    Node tail;

    class Node {
        String movieTitle;
        String director;
        int yearOfRelease;
        double rating;
        Node prev;
        Node next;

        Node(String movieTitle, String director, int yearOfRelease, double rating) {
            this.movieTitle = movieTitle;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            prev = null;
            next = null;
        }
    }

    MovieManagementSystem() {
        head = null;
        tail = null;
    }

    public void addAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head=newNode;
            tail = newNode;
        } else {
            newNode.next=head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        Node temp = head;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void addAtPosition(int position, String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (position == 0) {
            addAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid position");
            }
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev=newNode;
        } else {
            tail=newNode;
        }
        temp.next=newNode;
    }
    public void removeMovieRecordByMovieTitle(String movieTitle) {
        if (head == null) {
            throw new NullPointerException("No records to remove");
        }
        Node temp = head;
        while (temp != null) {
            if (temp.movieTitle.equals(movieTitle)) {
                if (temp==head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                }
                else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie record not found");
    }
    public void searchByDirectorOrRating(String director, double rating){
        Node temp= head;
        if(head==null){
            throw new NullPointerException("Empty List");
        }
        while(temp!=null){
            if(temp.director.equalsIgnoreCase(director) || temp.rating==rating) {
                System.out.println("Title of the movie is: "+temp.movieTitle+"\nYear of release: "+temp.yearOfRelease+"\nDirector of the movie is: "+temp.director+"\nRating of the movie is: "+temp.rating);
                System.out.println("---------------------------------------------------------------------------");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie Record Not Found");
    }
    public void display(){
        if(head==null){
            throw new NullPointerException("Empty List");
        }
        Node temp=head;
        while(temp!=null){
            System.out.println("Title of the movie is: "+temp.movieTitle+"\nYear of release: "+temp.yearOfRelease+"\nDirector of the movie is: "+temp.director+"\nRating of the movie is: "+temp.rating);
            System.out.println("---------------------------------------------------------------------------");
            temp=temp.next;
        }
    }
    public void reverseDisplay(){
        if(head==null){
            throw new NullPointerException("Empty List");
        }
        Node temp= tail;
        while(temp!=null){
            System.out.println("Title of the movie is: "+temp.movieTitle+"\nYear of release: "+temp.yearOfRelease+"\nDirector of the movie is: "+temp.director+"\nRating of the movie is: "+temp.rating);
            System.out.println("---------------------------------------------------------------------------");
            temp=temp.prev;
        }
    }
    public void UpdateMovieRatingByMovieTitle(String movieTitle, double updatedRating){
        Node temp=head;
        while(temp!=null){
            if(temp.movieTitle.equals(movieTitle)){
                temp.rating=updatedRating;
                return;
            }
            temp=temp.next;
        }
        System.out.println("Record not found");
    }
}
class Movie{
    public static void main(String[] args) {
        MovieManagementSystem movieManagementSystem=new MovieManagementSystem();
        movieManagementSystem.addAtBeginning("movie1", "Abx", 2025, 5);
        movieManagementSystem.addAtBeginning("movie2", "xyg", 2023, 4.4);
        movieManagementSystem.addAtEnd("movie3", "xyz", 2019, 4.3);
        movieManagementSystem.addAtPosition(2, "movie4", "abg", 2024, 2.9);
        movieManagementSystem.removeMovieRecordByMovieTitle("movie2");
        movieManagementSystem.searchByDirectorOrRating("abx", 0.0);
        movieManagementSystem.display();
        movieManagementSystem.reverseDisplay();
        movieManagementSystem.UpdateMovieRatingByMovieTitle("movie1", 4.7);
    }
}



