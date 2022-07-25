package doublylinkedlist;

public class LinkedList {
	private Node head;

	public LinkedList() {
		head = null;
	}

	@SuppressWarnings("unused")
	public boolean insert(int data) {
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}
		// if list is empty
		if (head == null) {
			head = newNode;
			return true;
		}
		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		newNode.setPrev(temp);
		temp.setNext(newNode);
		return true;

	}

	public void display() {
		if (head == null) {
			System.out.println("list is empty");
		}
		Node show = head;
		while (show != null) {
			System.out.print(show.getData() + " ");
			show = show.getNext();
		}
		System.out.println();
	}

	@SuppressWarnings("unused")
	public boolean insert(int position, int data) {
		if (position <= 0) {
			return false;
		}
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}
		if (position == 1) {
			if (head != null) {
				newNode.setNext(head);
				head.setPrev(newNode);
			}
			head = newNode;
			return true;
		}
		Node prev = head;

		for (int i = 1; i < position - 1; i++) {
			prev = prev.getNext();
			if (prev == null) {
				return false;
			}
		}
		Node next = prev.getNext();
		if (next != null) {
			newNode.setNext(next);
			next.setPrev(newNode);
		}

		newNode.setPrev(prev);
		prev.setNext(newNode);
		return true;
	}

	public boolean deleteByposition(int position) {
		if (position <= 0 || head == null) {
			return false;
		}
		if (position == 1) {
			// if list have only one node
			if (head.getNext() == null) {
				head = null;
			}
			head = head.getNext();
			head.setPrev(null);
			return true;
		}

		Node del = head;
		for (int i = 1; i < position; i++) {
			del = del.getNext();
			if (del == null) {
				return false;
			}
		}
		del.getPrev().setNext(del.getNext());
        if(del.getNext() != null) {
            del.getNext().setPrev(del.getPrev());
        }
		return true;
	}

}
