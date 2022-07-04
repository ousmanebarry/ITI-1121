public class ITIStringBuffer {

    private SinglyLinkedList<String> listString;
    private String result;

    public ITIStringBuffer() {
        listString = new SinglyLinkedList<>();
        result = null;
    }

    public ITIStringBuffer(String firstString) {
        listString = new SinglyLinkedList<>();
        listString.addFirst(firstString);
        result = null;
    }

    public void append(String nextString) {
        listString.add(nextString);
        result = null;
    }

    public String toString() {
        String outputString;
        if (result == null) {

            int count = 0;

            for (String i : listString) {
                count += i.length();
            }

            char[] charArray = new char[count];

            int countTwo = 0;

            for (String i : listString) {
                char[] nextArray = i.toCharArray();
                for (char j : nextArray) {
                    charArray[countTwo] = j;
                    countTwo++;
                }
            }

            outputString = new String(charArray);
            result = outputString;
        }
        return result;
    }

}
