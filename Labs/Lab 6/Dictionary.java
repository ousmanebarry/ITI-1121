public class Dictionary implements Map<String, Integer> {

  private final static int INITIAL_CAPACITY = 10;
  private final static int INCREMENT = 5;
  private int count;

  private Pair[] elems;

  public int getCount() {
    return count;
  }

  public int getCapacity() {
    return elems.length;
  }

  public Dictionary() {
    /* Your code here */
    this.count = 0;
    this.elems = new Pair[INITIAL_CAPACITY];
  }

  @Override
  public void put(String key, Integer value) {
    /* Your code here */
    if (count == elems.length)
      increaseCapacity();

    elems[count] = new Pair(key, value);
    count++;
  }

  private void increaseCapacity() {
    /* Your code here. Use this in put() where necessary. */
    Pair[] tmp = new Pair[elems.length + INCREMENT];
    for (int i = 0; i < elems.length; i++) {
      tmp[i] = elems[i];
    }
    elems = tmp;
  }

  @Override
  public boolean contains(String key) {
    /* Your code here. */
    for (int i = count - 1; i >= 0; i--) {
      if (elems[i].getKey().equals(key))
        return true;
    }
    return false;
  }

  @Override
  public Integer get(String key) {
    /* Your code here. */
    for (int i = count - 1; i >= 0; i--) {
      if (elems[i].getKey().equals(key))
        return elems[i].getValue();
    }
    return null;
  }

  @Override
  public void replace(String key, Integer value) {
    /* Your code here. */
    for (int i = count - 1; i >= 0; i--) {
      if (elems[i].getKey().equals(key)) {
        elems[i] = new Pair(key, value);
        break;
      }
    }
  }

  @Override
  public Integer remove(String key) {
    /* Your code here. */
    Integer removedKey = null;
    for (int i = count - 1; i >= 0; i--) {
      if (elems[i].getKey().equals(key)) {
        removedKey = elems[i].getValue();
        elems[i] = null;
        break;
      }
      ;
    }
    count--;
    return removedKey;
  }

  @Override
  public String toString() {
    String res;
    res = "Dictionary: {elems = [";
    for (int i = count - 1; i >= 0; i--) {
      res += elems[i];
      if (i > 0) {
        res += ", ";
      }
    }
    return res + "]}";
  }

}