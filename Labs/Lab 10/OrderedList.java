import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

  // Implementation of the doubly linked nodes (nested-class)

  private static class Node {

    private Comparable value;
    private Node previous;
    private Node next;

    private Node(Comparable value, Node previous, Node next) {
      this.value = value;
      this.previous = previous;
      this.next = next;
    }
  }

  // Instance variables

  private Node head;
  private int size;

  // Representation of the empty list.

  public OrderedList() {
    // Your code here.
    size = 0;
    head = new Node(null, null, null);
    head.next = head.previous = head;
  }

  // Calculates the size of the list

  public int size() {
    // Remove line below and add your implementation.
    return size;
  }

  public Object get(int pos) {
    // Remove line below and add your implementation.
    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = head.next;
    for (int i = 0; i < pos; i++) {
      current = current.next;
    }
    return current.value;
  }

  // Adding an element while preserving the order
  @SuppressWarnings("unchecked")
  public boolean add(Comparable o) {
    // Remove line below and add your implementation.
    if (o == null) {
      throw new IllegalArgumentException();
    }
    Node current = head;
    while (current.next != head && current.next.value.compareTo(o) < 0) {
      current = current.next;
    }
    Node newNode = new Node(o, current, current.next);
    current.next.previous = newNode;
    current.next = newNode;
    size++;
    return true;
  }

  // Removes one item from the position pos.

  public void remove(int pos) {
    // Remove line below and add your implementation.
    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node current = head.next;
    for (int i = 0; i < pos; i++) {
      current = current.next;
    }
    current.previous.next = current.next;
    current.next.previous = current.previous;
    size--;
  }

  // Knowing that both lists store their elements in increasing
  // order, both lists can be traversed simultaneously.

  public void merge(OrderedList other) {
    // Remove line below and add your implementation.
    Node current = other.head.next;

    while (current != other.head) {
      add(current.value);
      current = current.next;
    }

  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    Node current = head.next;
    while (current != head) {
      sb.append(current.value);
      current = current.next;
      if (current != head) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
