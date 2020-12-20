import java.util.Scanner;
import java.util.*;

public class help {
   
    public static void main(String[] args) {
        String menuChoice = "boop";
        LinkedList myLinked = new LinkedList();
        while(!menuChoice.equals("q")) {
                System.out.println("linked list and binary tree from scratch");
                System.out.println("1. Append a new number to linked list");
                System.out.println("2. Print linked list");
                System.out.println("3. Get node at i");
                System.out.println("4. Remove last node");
                System.out.println("5. Reverse linked list");
                System.out.println("Type q to quit");
                Scanner myScanner = new Scanner(System.in);
                menuChoice = myScanner.next();
                if(menuChoice.equals("1")){
                    System.out.println("Enter");
                    int dataItem = myScanner.nextInt();
                    myLinked.add(dataItem);
                }
                else if(menuChoice.equals("2")) {
                    
                }
                else if(menuChoice.equals("3")) {

                }
                else if(menuChoice.equals("4")) {

                }
                else if(menuChoice.equals("5")) {

                }
                else {
                    System.out.println("Not an option: Press q to quit.")
                }
                
        }
    }
}
class LinkedList {
    //attributes
    Node head = null;

    //add method
    public void add(int userData) {
        Node newNode = new Node(userData, null);
        if (head == null)
            head = newNode;
        else {
            // Gets you the node after head
            Node finalNode = head.getNext();
            // While the variable that keeps track of the next node in the chain is not null
            while (!(finalNode.getNext() == null)) {
                finalNode = finalNode.getNext();
            }
            // Found the last node in the chain because the nextNode.getNext() is null and the while loop ended
            // Now using the last node in the chain add a new node to the chain creating a new node from the user data
            finalNode.setNext(newNode);
        }
    }
    public void insert(int idx, int data) {
        
    }
    public int get(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }
    public void remove(int idx) {}
    public int size() {}
    public void reverse() {}
    public void printAll() {}
}

class Node {

    //attributes
    int data;
    Node next;
    
    // Constructor
    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}