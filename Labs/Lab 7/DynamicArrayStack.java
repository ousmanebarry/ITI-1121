import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

  // Instance variables

  private E[] elems; // Used to store the elements of this ArrayStack
  private int top; // Designates the first free cell
  private static final int DEFAULT_INC = 25; // Used to store default increment / decrement

  @SuppressWarnings("unchecked")
  // Constructor
  public DynamicArrayStack(int capacity) {
    // Your code here.
    this.elems = (E[]) new Object[DEFAULT_INC];
    this.top = 0;
  }

  // Gets current capacity of the array
  public int getCapacity() {
    return elems.length;
  }

  // Returns true if this DynamicArrayStack is empty
  public boolean isEmpty() {
    return (top == 0);
  }

  // Returns the top element of this ArrayStack without removing it
  public E peek() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException();

    return elems[top - 1];
  }

  @SuppressWarnings("unchecked")

  // Removes and returns the top element of this stack
  public E pop() throws EmptyStackException {
    // Your code here.
    if (isEmpty())
      throw new EmptyStackException();

    if (elems.length > DEFAULT_INC) {
      int occupiedIndices = 0;
      for (int i = 0; i < elems.length; i++) {
        if (elems[i] != null) {
          occupiedIndices++;
        }
      }
      if (occupiedIndices > DEFAULT_INC) {
        Object[] tmp = new Object[occupiedIndices];
        for (int i = 0; i < elems.length; i++) {
          if (elems[i] != null)
            tmp[i] = elems[i];
        }
        elems = (E[]) tmp;
      } else {
        Object[] tmp = new Object[DEFAULT_INC];
        for (int i = 0; i < elems.length; i++) {
          if (elems[i] != null)
            tmp[i] = elems[i];
        }
        elems = (E[]) tmp;
      }

    }
    E saved = elems[--top];

    elems[top] = null;

    return saved;
  }

  // Puts the element onto the top of this stack.
  @SuppressWarnings("unchecked")
  public void push(E element) {
    // Your code here.
    if (top == elems.length) {
      Object[] tmp = new Object[elems.length + DEFAULT_INC];
      for (int i = 0; i < elems.length; i++) {
        tmp[i] = elems[i];
      }
      elems = (E[]) tmp;
    }

    elems[top] = element;
    top++;
  }

  public void clear() {
    // Your code here.
    while (!isEmpty()) {
      pop();
    }
  }

}