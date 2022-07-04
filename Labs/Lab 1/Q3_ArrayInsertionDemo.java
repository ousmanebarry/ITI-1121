public class Q3_ArrayInsertionDemo {
    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int[] newArray = new int[beforeArray.length + 1];
        newArray[indexToInsert] = valueToInsert;
        int beforeArrayIndex = 0;
        for(int i = 0; i < newArray.length; i++) {
            if(i != indexToInsert) {
                newArray[i] = beforeArray[beforeArrayIndex];
                beforeArrayIndex++;
            } 
        }
        return newArray;
	}

	public static void main(String[] args){
        int[] myArray = new int[] {1, 5, 4, 7, 9, 6};
        int myIndex = 3;
        int myValue = 15;

		int [] myNewArray = insertIntoArray(myArray, myIndex, myValue);

        System.out.println("Array before insertion:");
        for(int i : myArray) {
            System.out.println(i);
        }
        
        System.out.println("Array after insertion of " + myValue + " at position " + myIndex + ":");
        for(int j : myNewArray) {
            System.out.println(j);
        }
	}
}
