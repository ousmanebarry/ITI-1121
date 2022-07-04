import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        int lengthGrades = 10;
        double[] grades = new double[lengthGrades];
        Scanner getDouble = new Scanner(System.in);

        System.out.println("Enter 10 grades between 0-100: ");
        for(int i = 0; i < lengthGrades; i++) {
            double currentDouble = getDouble.nextDouble();
            grades[i] = currentDouble;
        }

        System.out.println("Average of grades: " + calculateAverage(grades));
        System.out.println("Median of grades: " + calculateMedian(grades));
        System.out.println("Number of failures: " + calculateNumberFailed(grades));
        System.out.println("Number of success: " + calculateNumberPassed(grades));

        getDouble.close();
    }

    public static double calculateAverage(double[] notes){
		double average = 0;
        for(double i : notes) {
            average += i;
        }
        return average/notes.length;
	}

    public static double calculateMedian(double[] notes) {
        int i, j, argMin;
        double tmp;

		for (i = 0; i < notes.length - 1; i++) {
			argMin = i;
			for (j = i + 1; j < notes.length; j++) {
				if (notes[j] < notes[argMin]) {
					argMin = j;
				}
			}

			tmp = notes[argMin];
			notes[argMin] = notes[i];
			notes[i] = tmp;
		}
        int index = notes.length / 2;
        if(notes.length % 2 == 0) {
            return (notes[index] + notes[index - 1])/2;
        } else {
            return notes[index];
        }
    }

    public static int calculateNumberFailed(double[] notes){
		int numberFailed = 0;
        for(double i : notes) {
            if(i < 50) {
                numberFailed++;
            }
        }
        return numberFailed;
	}

    public static int calculateNumberPassed(double[] notes){
		int numberPassed = 0;
        for(double i : notes) {
            if(i >= 50) {
                numberPassed++;
            }
        }
        return numberPassed;
	}
}
