import java.util.Scanner;
import java.util.*;

public class help {
   
    public static void main(String[] args) {
        int menuChoice = 0;
        LinkedList myLinked = new LinkedList();
        while(menuChoice != 7) {
                System.out.println("\nlinked list and binary tree from scratch");
                System.out.println("1. Append a new number to linked list");
                System.out.println("2. Print linked list");
                System.out.println("3. Get node at index i");
                System.out.println("4. Remove node at index i");
                System.out.println("5. Reverse linked list");
                System.out.println("6. Insert into index");
                System.out.println("7. Type 7 to quit");
                Scanner myScanner = new Scanner(System.in);
                menuChoice = myScanner.nextInt();
                myScanner.nextLine();
                
                if(menuChoice == 1) {
                    System.out.println("Enter your number to append: ");
                    int dataItem = myScanner.nextInt();
                    myScanner.nextLine();
                    myLinked.add(dataItem);
                    myLinked.printAll();
                }
                else if(menuChoice == 2) {
                    myLinked.printAll();
                }
                else if(menuChoice == 3) {
                    System.out.println("Enter your index to get data: ");
                    int index = myScanner.nextInt();
                    myScanner.nextLine();
                    int info = myLinked.get(index);
                    System.out.println("index = " + index + " data = " + info);
                }
                else if(menuChoice == 4) {
                    System.out.println("Enter your index to remove node: ");
                    int index = myScanner.nextInt();
                    myLinked.remove(index);
                    myLinked.printAll();
                }
                else if(menuChoice == 5) {
                    myLinked.reverse();
                    myLinked.printAll();
                }
                else if(menuChoice == 6) {
                    System.out.println("Type the index to insert into");
                    int index = myScanner.nextInt();
                    myScanner.nextLine();
                    System.out.println("Type in data");
                    int data = myScanner.nextInt();
                    myLinked.insert(index, data);
                    myLinked.printAll();
                }
                else if(menuChoice == 7) {
                    System.exit(0);
                }
                else
                {
                    System.out.println("Not an option: Press 7 to quit.");
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
            Node finalNode = head;
            // While the variable that keeps track of the next node in the chain is not null
            while (finalNode.getNext() != null) {
                finalNode = finalNode.getNext();
            }
            // Found the last node in the chain because the nextNode.getNext() is null and the while loop ended
            // Now using the last node in the chain add a new node to the chain creating a new node from the user data
            finalNode.setNext(newNode);
            
        }
    }

    public void insert(int idx, int data) {
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) 
            temp = temp.getNext();
        Node insertedNode = new Node(data, temp.getNext());
        temp.setNext(insertedNode);
    }

    public int get(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void remove(int idx) {
        Node temp = head;
        if (idx == 0)
            head = head.getNext();
        else {
            //i = 0 to i = 10 ***** node at i = 10 contains data and next = null
            //remove i = 10
            //for loop goes to i = 9
            //temp = node at i = 9
            for (int i = 0; i < idx - 1; i++)
                temp = temp.getNext();
        }
        //10 is the last node in the linked list
        //set i=10   i=9 . i = 10 *************. i = 11 --> null
        //temp=4->6 5 is gone   temp=4, 5       6th
        temp.setNext(temp.getNext().getNext());
    }

    public int size() {
        int count = 0;
        Node finalNode = head;
        while (finalNode != null) {
            finalNode = finalNode.getNext();
            count++;
        }
        return count;
    }

    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void printAll() {
        Node finalNode = head;
        int count = 0;
        while(finalNode != null) {
            System.out.println("index = " + count + " data = " + finalNode.getData());
            finalNode = finalNode.getNext();
            count++;
        }
    }
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