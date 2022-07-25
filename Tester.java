package doublylinkedlist;

public class Tester {

	public static void main(String[] args) {
		LinkedList dll=new LinkedList();
				dll.insert(10);
		        dll.display();
		        dll.insert(20);
		        dll.display();
		        dll.insert(30);
		        dll.display();
		        dll.insert(40);
		        dll.display();
		        dll.insert(5,70);
		        dll.display();
		        dll.insert(3,50);
		        dll.display();
		        dll.insert(1,5);
		        dll.display();
		        dll.deleteByposition(3);
		        dll.display();
	}

}
