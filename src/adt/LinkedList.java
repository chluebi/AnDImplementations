package adt;

public class LinkedList<T> implements Stack<T>, Queue<T>  {
	
	int size = 0;
	Node<T> first;
	Node<T> last;
	
	public LinkedList() {
		this.size = 0;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public void enqueue(T i) {
		size++;
		if (first == null) {
			first = new Node<T>(i);
			last = first;
			return;
		}
		Node<T> n = new Node<T>(i);
		last.setNext(n);
		last = n;
	}

	@Override
	public T dequeue() {
		T value = first.value();
		first = first.next();
		size--;
		return value;
	}

	@Override
	public void add(T i) {
		size ++;
		if (first == null) {
			first = new Node<T>(i);
			last = first;
			return;
		}
		Node<T> n = new Node<T>(i);
		n.setNext(first);
		first = n;
	}

	@Override
	public T peek() {
		return first.value();
	}

	@Override
	public T remove() {
		return dequeue();
	}
	
}

class Node<T> {
	
	private Node<T> next;
	private T value;
	
	public Node(T value) {
		this.value = value;
	}
	
	public T value() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public boolean hasNext() {
		return this.next != null;
	}
	
	public Node<T> next() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
