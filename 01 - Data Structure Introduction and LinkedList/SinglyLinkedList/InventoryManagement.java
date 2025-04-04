public class InventoryManagement {
    Node head;
    class Node {
        String itemName;
        String itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, String itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }
    }
    InventoryManagement(){

        head=null;
    }
    public void addAtBeginning(String itemName, String itemId,int quantity,double price){
        Node newNode= new Node(itemName, itemId, quantity, price);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    public void addAtEnd(String itemName, String itemId,int quantity,double price){
        Node newNode= new Node(itemName, itemId, quantity, price);
        Node temp=head;
        if(head==null){
            addAtBeginning(itemName,  itemId, quantity, price);
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void addAtPosition(int position, String itemName, String itemId,int quantity,double price){
        Node newNode= new Node(itemName, itemId, quantity, price);
        Node temp=head;
        if(position == 0){
            newNode.next=head;
            head=newNode;
            return;
        }
        for(int i=1; i<position;i++){
            if(temp==null){
                throw new NullPointerException("Invalid Position "+ position);
            }
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void removeAnItem(String itemId){
        Node temp= head;
        if(head==null){
            System.out.println("List is Empty");
            return;
            }
        if(head.itemId.equals(itemId)){
            head=head.next;
            return;
        }
        while(temp!=null && !temp.itemId.equals(itemId)){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    public void updateQuantity(String itemId, int quantityToBeUpdated){
        Node temp=head;
        if(head==null){
            throw new NullPointerException("No records found");
        }
        while(temp!=null){
            if(temp.itemId.equals(itemId)){
                temp.quantity=quantityToBeUpdated;
                return;
            }
            temp=temp.next;
        }
        System.out.println("Record not found");
    }
    public void searchByItemIdOrItemName(String itemId, String itemName){
        Node temp=head;
        if (head==null){
            throw new NullPointerException("No records found");
        }
        while(temp!=null){
            if (itemId!=null && temp.itemId.equals(itemId) || itemId!=null && temp.itemName.equals(itemName)) {
                System.out.println("Item name is: " + temp.itemName + "\nItemId is: " + temp.itemId + "\nQuantity of the items is: " + temp.quantity + "\nprice of item per quantity is: " + temp.price);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Record not found");
    }
    public void calculateTotalValue(){
        Node temp=head;
        double totalValue=0;
        while(temp!=null){
            totalValue+=temp.price* temp.quantity;
            temp=temp.next;
        }
        System.out.println("The total value of the inventory is: "+totalValue);
    }
    public void Sort(String criteria, String order) {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node temp = head;

            while (temp.next != null) {
                boolean shouldSwap = false;

                if (criteria.equalsIgnoreCase("name")) {
                    int cmp = temp.itemName.compareToIgnoreCase(temp.next.itemName);
                    shouldSwap = (order.equalsIgnoreCase("asc")) ? cmp > 0 : cmp < 0;
                } else if (criteria.equalsIgnoreCase("price")) {
                    shouldSwap = (order.equalsIgnoreCase("asc")) ? temp.price > temp.next.price : temp.price < temp.next.price;
                }

                if (shouldSwap) {
                    String tempName = temp.itemName;
                    String tempId = temp.itemId;
                    int tempQty = temp.quantity;
                    double tempPrice = temp.price;

                    temp.itemName = temp.next.itemName;
                    temp.itemId = temp.next.itemId;
                    temp.quantity = temp.next.quantity;
                    temp.price = temp.next.price;

                    temp.next.itemName = tempName;
                    temp.next.itemId = tempId;
                    temp.next.quantity = tempQty;
                    temp.next.price = tempPrice;

                    swapped = true;
                }

                temp = temp.next;
            }
        } while (swapped);
    }
    public void displaySortedInventory() {
        Node temp = head;
        System.out.println("\nSorted Inventory List:");
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}
class inventory{
    public static void main(String[] args) {
        InventoryManagement inventoryManagement=new InventoryManagement();
        inventoryManagement.addAtBeginning("One Plus Nord 2","OnePlus01",2,30000);
        inventoryManagement.addAtBeginning("One plus Z2 earbuds", "OnePlus03",1,5000);
        inventoryManagement.addAtEnd("Laptop HP"," HP01",1,52000);
        inventoryManagement.addAtPosition(1,"Laptop Dell", "Dell01",4,48000);
        inventoryManagement.addAtPosition( 2, "One plus Nord CE", "OnePlus02",1,23000);
        inventoryManagement.removeAnItem("OnePlus01");
        inventoryManagement.updateQuantity("OnePlus03", 3);
        inventoryManagement.searchByItemIdOrItemName("OnePlus03", null);
        inventoryManagement.calculateTotalValue();
        inventoryManagement.Sort("price", "asc");
        inventoryManagement.displaySortedInventory();

    }
}