package circularlinkedlist;

public class CircularLinkedList {
	private Node head;

	public CircularLinkedList() {
		this.head = null;
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
			newNode.setNext(newNode);
			return true;
		}
		Node last = head;
		while (last.getNext() != head) {
			last = last.getNext();
		}
		last.setNext(newNode);
		newNode.setNext(head);
		return true;
	}

	public void display() {
		 if (head == null) {
	            return;
	        }

	        Node temp = head;
	        do {
	            System.out.print(temp.getData() + " ");
	            temp = temp.getNext();
	        } while (temp != head);
	        System.out.println();

		
	}

	@SuppressWarnings("unused")
	public boolean insert(int position, int data) {
		 if(position <= 0 || (head == null && position > 1)) {
	            return false;
	        }

	        Node newNode = new Node(data);
	        if(newNode == null) {
	            return false;
	        }
	        if(position == 1) {

	            //list is empty
	            if(head == null) {
	                head = newNode;
	                newNode.setNext(newNode);
	                return true;
	            }

	            //position is 1 and the list is not empty
	            newNode.setNext(head);

	            Node last = head;
	            while (last.getNext() != head) {
	                last = last.getNext();
	            }
	            last.setNext(newNode);

	            head = newNode;

	            return true;
	        }
          
	        //position is other than 1
	        Node prev = head;
	        for(int i = 1; i < position - 1; i++) {
	            prev = prev.getNext();
	            if(prev == head) {
	                return false;
	            }
	        }

	        newNode.setNext(prev.getNext());
	        prev.setNext(newNode);
	        
			return true;
		
	}
	
	
	public boolean deleteByPosition(int position) {
        if(head == null || position <= 0) {
            return false;
        }

        if(position == 1) {

            if(head.getNext() == head) {
                head = null;
                return true;
            }

            //locate last node
            Node last = head;
            while(last.getNext() != head) {
                last = last.getNext();
            }

            last.setNext(head.getNext());
            head = head.getNext();

            return true;
        }

        Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev.getNext() == head) {
                return false;
            }
        }

        Node del = prev.getNext();
        prev.setNext(del.getNext());

        return true;
    }
}
