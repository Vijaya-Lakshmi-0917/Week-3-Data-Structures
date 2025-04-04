public class OnlineTicketReservationSystem {
    Node last;
    int count=0;

    class Node {
        String ticketID;
        String customerName;
        String movieName;
        int seatNumber;
        String bookingTime;
        Node next;

        Node(String ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
            this.ticketID = ticketID;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            next = null;
            count++;
        }
    }

    OnlineTicketReservationSystem() {
        last = null;
    }

    public void addAtEnd(String ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        Node newNode = new Node(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }
    public void removeByTicketID(String ticketID){
        Node temp=last.next;
        if(last==null){
            throw new NullPointerException("No records to remove");
        }
        if(last.next==last && last.next.ticketID.equalsIgnoreCase(ticketID)){
            last=null;
            count--;
            return;
        }
        if(last.next.ticketID.equalsIgnoreCase(ticketID)){
            last.next=temp.next;
            count--;
            return;
        }
        while(temp.next!=last.next){
            if(temp.next.ticketID.equalsIgnoreCase(ticketID)){
                if(temp.next==last){
                    last=temp;
                }
                temp.next=temp.next.next;
                count--;
                return;
            }
            temp=temp.next;
        }
        System.out.println(" No records found");
    }
    public void display() {
        if(last==null){
            throw new NullPointerException("No records to display");
        }
        Node temp = last.next;
        do {
            System.out.println("Ticket ID: "+temp.ticketID+
                    "\nCustomer name: "+temp.customerName+
                    "\nMovie name: "+temp.movieName+
                    "\nSeat number: "+temp.seatNumber+
                    "\nBooking time: "+temp.bookingTime);
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            temp = temp.next;
        } while (temp != last.next);
    }
    public void searchByCustomerNameOrMovieName(String customerName, String movieName){
        if(last==null){
            throw new NullPointerException("No records to display");
        }
        Node temp = last.next;
        do {
            if(temp.customerName.equalsIgnoreCase(customerName) || temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketID +
                        "\nCustomer name: " + temp.customerName +
                        "\nMovie name: " + temp.movieName +
                        "\nSeat number: " + temp.seatNumber +
                        "\nBooking time: " + temp.bookingTime);
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
            }
            temp = temp.next;
        } while (temp != last.next);
    }
    public void count(){
        System.out.println("The number of tickets booked is: "+count);
    }
}
class Ticket{
    public static void main(String[] args) {
        OnlineTicketReservationSystem onlineTicketReservationSystem=new OnlineTicketReservationSystem();
        onlineTicketReservationSystem.addAtEnd("M01", "A", "Xyz", 01, "15:30:24");
        onlineTicketReservationSystem.addAtEnd("M01", "A", "Xyz", 02, "15:30:24");
        onlineTicketReservationSystem.addAtEnd( "M02", "B", "Abc", 01, "17:59:36");
        onlineTicketReservationSystem.addAtEnd("M03", "C", "Asd", 01, "12:01:25");
        onlineTicketReservationSystem.removeByTicketID("M03");
        onlineTicketReservationSystem.display();
        onlineTicketReservationSystem.searchByCustomerNameOrMovieName("A", " ");
        onlineTicketReservationSystem.count();
    }
}
