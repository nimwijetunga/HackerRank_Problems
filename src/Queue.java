
import java.io.*;
import java.util.*;

public class Queue {
	
	static class Node{
		Node next;
		Node prev;
		int val;
		public Node(Node next,Node prev, int val) {
			this.next = next;
			this.val = val;
			this.prev = prev;
		}
	}
	
	static Node first, last;

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int q = sc.nextInt();
    	for(int i = 0; i < q + 1; i++) {
    		String line = sc.nextLine();
    		String [] tokens = line.split("\\s+");
    		if(tokens[0].equals("1")) {
    			int val = Integer.valueOf(tokens[1]);
    			enque(val);
    		}else if(tokens[0].equals("2")) {
    			deque();
    		}else if(tokens[0].equals("3")) {
    			printf();
    		}
    	}
    }
    
    public static void enque(int val) {
    	if(first == null) {
    		first = new Node(null, null ,val);
    		last = first;
    	}else {
    		Node temp = new Node(null, last, val);
    		last.next = temp;
    		last = temp;
    	}
    }
    
    public static void deque() {
    	if(first == null) {
    		return;
    	}
    	first = first.next;
    }
    
    public static void printf() {
    	if(first == null) return;
    	System.out.println(first.val);
    }
    
    public static void printQ() {
    	Node temp = first;
    	while(temp != null) {
    		System.out.print(temp.val + "->");
    		temp = temp.next;
    	}
    	System.out.println("");
    }
}
