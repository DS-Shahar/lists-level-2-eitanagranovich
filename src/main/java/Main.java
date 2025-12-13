import java.util.*;
public class Main {	

	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
        
        int[] arr = {10, 20, 30, 40, 50, 60, 60};
        int[] arr1 = {11, 21, 31, 41};
        int[] arrUnsorted = {5, 6, 2, 7, 7, 1};
        Node<Integer> obj = buildNode(arr);
        Node<Integer> obj1 = buildNode(arr1);
        Node<Integer> objEx1 = ex1(obj, obj1);
        Node<Integer> objUnsorted = buildNode(arrUnsorted);
        System.out.println("ex1:");
        printNode(objEx1);
        System.out.println("ex2:");
        printNode(ex2(objUnsorted));
        System.out.println("ex3:");
        System.out.println(ex3(7, objUnsorted));
	    System.out.println("ex4:");
        System.out.println(ex4(objUnsorted));
	    System.out.println("ex5:");
	    printNode(ex5(obj));
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
    
    public static Node<Integer> ex2(Node<Integer> list) {
        Node<Integer> hNew = new Node<>(null); // רשימה חדשה (dummy head)
        Node<Integer> t = hNew;
    
        while (list != null) {
            // מציאת מינימום
            Node<Integer> min = list;
            Node<Integer> minPrev = null;
            Node<Integer> p = list;
    
            while (p.getNext() != null) {
                if (p.getNext().getValue() < min.getValue()) {
                    min = p.getNext();
                    minPrev = p;
                }
                p = p.getNext();
            }
    
            
            if (minPrev == null) { 
                list = list.getNext();
            } else {
                minPrev.setNext(min.getNext());
            }
    
            
            min.setNext(null);
            t.setNext(min);
            t = min;
        }
    
        return hNew.getNext();
    }
    
    public static int ex3(int x, Node<Integer> l){
        Node<Integer> p  = l;
        Node<Integer> h = l;
        int countBegin = 0;
        int countEnd = 0;
        boolean exist = false;
        while(!exist){
            if (p.getValue() == x){
                exist = true;
            }
            countBegin++;
            
            p = p.getNext();
        }
        exist = true;
        while(exist){
            if (p.getValue() == x){
                countEnd = 0;
            }
            countEnd++;
            if (p.getNext() == null){
                exist = false;
            } 
            p = p.getNext();
        }
        return countEnd + countBegin;
        
    }
    public static boolean ex4(Node<Integer> list) {
        Node<Integer> p1 = list;
    
        while (p1 != null) {
            Node<Integer> p2 = p1.getNext();
            while (p2 != null) {
                if (p1.getValue().equals(p2.getValue())) {
                    return false;
                }
                p2 = p2.getNext();
            }
            p1 = p1.getNext();
        }
        return true;
    }
    
    public static Node<Integer> ex5(Node<Integer> list) {
        Node<Integer> hNew = new Node<>(null); // dummy head
        Node<Integer> t = hNew;
    
        Node<Integer> p = list;
        while (p != null) {
            
            Node<Integer> q = hNew.getNext();
            boolean found = false;
    
            while (q != null && !found) {
                if (q.getValue().equals(p.getValue())) {
                    found = true;
                }
                q = q.getNext();
            }
    
            
            if (!found) {
                t.setNext(new Node<>(p.getValue()));
                t = t.getNext();
            }
    
            p = p.getNext();
        }
    
        return hNew.getNext();
    }
    
    
}	
