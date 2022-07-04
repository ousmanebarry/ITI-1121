import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";
	private static final String SECTIONER = "###";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */

	/** 
	 * The variables to check if there are unparkable cars
	 * if so then list them and display them
	 * if not then display nothing 
	 */
	private static boolean canNotParkBool = false;
	private static String canNotParkText = "";


	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;
	
	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;


	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!
		// WRITE YOUR CODE HERE!
		lotDesign = new CarType[numRows][numSpotsPerRow];
		occupancy = new Car[numRows][numSpotsPerRow];


		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		occupancy[i][j] = c;
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		// WRITE YOUR CODE HERE!
		if(i > numRows - 1 || j > numSpotsPerRow || occupancy[i][j] == null) {
			return null;
		} else {
			Car removedCar = occupancy[i][j];
			occupancy[i][j] = null;
			return removedCar;
		}
	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
		CarType typeOfCar = c.getType();

		return i <= numRows - 1 && j <= numSpotsPerRow - 1 && lotDesign[i][j] != CarType.NA && occupancy[i][j] == null && typeOfCar.compareTo(lotDesign[i][j]) <= 0;
	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		// WRITE YOUR CODE HERE!
		int numberOfN = 0;

		for(int i = 0; i < lotDesign.length; i++) {
			for(int j = 0; j < lotDesign[i].length; j++) {
				if(lotDesign[i][j].equals(CarType.NA)) {
					numberOfN++;
				}
			} 
		}
		return (numRows * numSpotsPerRow) - numberOfN;
	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		// WRITE YOUR CODE HERE!
		int numberOfS = 0;
		
		for(int i = 0; i < occupancy.length; i++) {
			for(int j = 0; j < occupancy[i].length; j++) {
				if(occupancy[i][j] != null) {
					numberOfS++;
				}
			} 
		}
		return numberOfS;	
	}


	private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		int rowLength = 0;
		int rowSpotsLength = 0;
		boolean secondPart = false;

		while (scanner.hasNext()) {
			// WRITE YOUR CODE HERE!
		
			String str = scanner.nextLine();

			if (!str.equals("") && !str.equals(SECTIONER)) {
				str = str.replaceAll("\\s", "");
			} else if (str.equals("")) {
				continue;
			} else {
				secondPart = true;
				continue;
			}

			String[] splitArray = str.split(SEPARATOR);

			if (!secondPart) {
				rowLength++;
				for(int i = 0; i < splitArray.length; i++) {
					rowSpotsLength++;
				}
			} else {
				break;
			}
		}

		numRows = rowLength;
		numSpotsPerRow = rowSpotsLength/rowLength;

		scanner.close();
	}

	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));


		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		int rowLot = 0;
		boolean secondPart = false;

		// while loop for reading the lot design
		while (scanner.hasNext()) {
			// WRITE YOUR CODE HERE!
			String str = scanner.nextLine();

			if (!str.equals("")) {
				str = str.replaceAll("\\s", "");
			} else if (str.equals(SECTIONER)) {
				secondPart = true;
			} else {
				continue;
			}

			String[] splitLot = str.split(SEPARATOR);

			int columnLot = 0;

			if(!secondPart && !str.equals(SECTIONER)) {
				if(rowLot + 1 <= numRows) {
					for(String letter : splitLot) {
						CarType currentCar = Util.getCarTypeByLabel(letter);
						lotDesign[rowLot][columnLot] = currentCar;
						columnLot += 1;
					}
					rowLot += 1;
				}
			} else {
				break;
			}
		}

		// while loop for reading occupancy data
		while (scanner.hasNext()) {
			// WRITE YOUR CODE HERE!

			String str = scanner.nextLine();
			
			if (!str.equals("")) {
				str = str.replaceAll("\\s", "");
			} else {
				continue;
			}

			String[] splitLot = str.split(SEPARATOR);

			int i = Integer.parseInt(splitLot[0]);
			int j = Integer.parseInt(splitLot[1]);
			Car ourCar = new Car(Util.getCarTypeByLabel(splitLot[2]), splitLot[3]);


			if(canParkAt(i, j, ourCar)) {
				park(i, j, ourCar);
			} else {
				canNotParkBool = true;
				if(canNotParkText.isEmpty()) {
					canNotParkText += String.format("Car %s cannot be parked at (%s,%s)", ourCar.toString(), i, j);
				} else {
					canNotParkText += String.format("%nCar %s cannot be parked at (%s,%s)", ourCar.toString(), i, j);
				}
			}
		}
		scanner.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */


	

	public static void main(String[] args) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		if(canNotParkBool) {
			System.out.println(canNotParkText);
		}

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());
		
		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());
		
		System.out.print(lot);

		scanner.close();
	}
}