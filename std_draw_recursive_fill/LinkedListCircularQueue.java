package lab3;
public class LinkedListCircularQueue {

    private int count;
    private Node front, rear;

    // Creates an empty queue
    public LinkedListCircularQueue(){

        /* YOUR CODE HERE */
    	front = null;
    	rear = null;
    	count = 0;
    }

    // Adds the specified element to the rear of the queue
    public void enqueue(String element) {

        /* YOUR CODE HERE */
    	Node n = new Node(element, null);
    	if(front == null) {
    		front = n;
    	}else {
    		rear.setLink(n);
    	}
    	
    	rear = n;
    	rear.setLink(front);
    	count++;
    }

    // Removes the element at the front of the queue and returns a reference to it
    public String dequeue()  {

        /* YOUR CODE HERE */
    	if(front == null) {
    		System.out.println("Queue is empty, can't remove any item");
    		return null;
    	}
    	
    	String data = front.getData();
    	if(front == rear) {
    		front = null;
        	rear = null;
    	}else {
    		Node tmp = front;
    		front = tmp.getLink();
    		rear.setLink(front);
    	}
    	
    	count--;
        return data; //temporary, change this later
    }

    // Returns the element at the front of the queue without removing it
    public String first() {

        /* YOUR CODE HERE */
    	if(front == null) {
    		return null;
    	}
    	
        return front.getData(); //temporary, change this later
    }

    // Returns true if the queue contains no elements, false otherwise
    public boolean isEmpty() {

        /* YOUR CODE HERE */
    	
        return count==0; //temporary, change this later
    }

    // Returns the number of elements in the queue
    public int size() {

        /* YOUR CODE HERE */

        return count; //temporary, change this later

    }

    // Returns a string representation of the queue
    public String toString() {
        String result = "";
        Node current = front;
        if (!isEmpty())
            do {
                result = result + (current.getData()).toString() + "\t";
                current = current.getLink();
            } while (current != front);
        return result;
    }


}
