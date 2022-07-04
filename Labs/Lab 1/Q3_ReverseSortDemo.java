public class Q3_ReverseSortDemo  {
    public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
		//your code here
		int i, j, argMin;
		char tmp;

		for (i = 0; i < values.length - 1; i++) {
			argMin = i;
			for (j = i + 1; j < values.length; j++) {
				if (values[j] > values[argMin]) {
					argMin = j;
				}
			}

			tmp = values[argMin];
			values[argMin] = values[i];
			values[i] = tmp;
		}
	}
}
