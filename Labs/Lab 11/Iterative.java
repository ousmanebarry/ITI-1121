public class Iterative {

  public static BitList complement(BitList in) {

    // Your code here

    BitList newBitList = new BitList();

    Iterator it = in.iterator();
    Iterator itIn = newBitList.iterator();

    while (it.hasNext()) {
      itIn.add(it.next() == 0 ? 1 : 0);
    }

    return newBitList;
  }

  public static BitList or(BitList a, BitList b) throws IllegalArgumentException {

    // Your code here

    BitList newBitList = new BitList();

    if (checkIllegalArgument(a, b)) {
      throw new IllegalArgumentException();
    }

    Iterator it = newBitList.iterator();
    Iterator itA = a.iterator();
    Iterator itB = b.iterator();

    while (itA.hasNext() && itB.hasNext()) {
      it.add(itA.next() | itB.next());
    }

    return newBitList;
  }

  public static BitList and(BitList a, BitList b) throws IllegalArgumentException {

    // Your code here

    BitList newBitList = new BitList();

    if (checkIllegalArgument(a, b)) {
      throw new IllegalArgumentException();
    }

    Iterator it = newBitList.iterator();
    Iterator itA = a.iterator();
    Iterator itB = b.iterator();

    while (itA.hasNext() && itB.hasNext()) {
      it.add(itA.next() & itB.next());
    }

    return newBitList;
  }

  public static BitList xor(BitList a, BitList b) throws IllegalArgumentException {

    // Your code here

    BitList newBitList = new BitList();

    if (checkIllegalArgument(a, b)) {
      throw new IllegalArgumentException();
    }

    Iterator it = newBitList.iterator();
    Iterator itA = a.iterator();
    Iterator itB = b.iterator();

    while (itA.hasNext() && itB.hasNext()) {
      it.add(itA.next() ^ itB.next());
    }

    return newBitList;
  }

  private static boolean checkIllegalArgument(BitList a, BitList b) {
    boolean flag = false;

    if (a.toString().length() != b.toString().length())
      flag = true;

    if (a.toString().equals("0") || b.toString().equals("0"))
      flag = true;

    return flag;
  }

  public static void main(String[] args) {

    BitList list0 = new BitList("");
    BitList list1 = new BitList("");

    try {
      xor(list0, list1);
      System.out.println("good");
    } catch (IllegalArgumentException e) {
      System.out.println("caught");
    }

  }
}