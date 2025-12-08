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
	

    public static Node<Integer> ex1(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> h = new Node<Integer>(-1);
        Node<Integer> p = h;
        int min;
    
        while (n1 != null && n1 != null) {
            if (n1.getValue() <= n2.getValue()) {
                min = n1.getValue());
				n1 = n1.getNext();
            } else {				
                min = n2.getValue());
				n2 = n2.getNext();
			}
			p.setNext(new Node<Integer>(min));
			p = p.getNext();
        }
        while (n1 != null) {
            p.setNext(new Node<Integer>(n1.getValue()));
            p = p.getNext();
            n1 = n1.getNext();
        }
        while (n2 != null) {
            p.setNext(new Node<Integer>(n2.getValue()));
            p = p.getNext();
            n2 = n2.getNext();
        }    
        return h.getNext();
    }
}
