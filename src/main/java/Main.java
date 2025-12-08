import java.util.*;
public class Main {	

	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
        
        int[] arr = {10, 20, 30, 40, 50, 60};
        int[] arr1 = {11, 21, 31, 41};
        Node<Integer> obj = buildNode(arr);
        Node<Integer> obj1 = buildNode(arr1);
        Node<Integer> objEx1 = ex1(obj, obj1);
        printNode(objEx1);
	}

	
	public static Node<Integer> buildNode(int[] a) {
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x;
		for (int i = 0; i < a.length; i++) {
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return h.getNext();
	}
	
	    public static void printNode(Node<Integer> h) {
        if (h == null){
            return;    
        } 
        printNode(h.getNext());
        System.out.println(h.getValue());
    }
	

    public static Node<Integer> ex1(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> h = new Node<Integer>(-1);
        Node<Integer> p = h;
        Node<Integer> x = list1;
        Node<Integer> y = list2;
    
        while (x != null && y != null) {
            if (x.getValue() <= y.getValue()) {
                p.setNext(new Node<Integer>(x.getValue()));
                p = p.getNext();
                x = x.getNext();
            } else {
                p.setNext(new Node<Integer>(y.getValue()));
                p = p.getNext();
                y = y.getNext();
            }
        }
    
        while (x != null) {
            p.setNext(new Node<Integer>(x.getValue()));
            p = p.getNext();
            x = x.getNext();
        }
    
        while (y != null) {
            p.setNext(new Node<Integer>(y.getValue()));
            p = p.getNext();
            y = y.getNext();
        }
    
        return h.getNext();
    }

}
