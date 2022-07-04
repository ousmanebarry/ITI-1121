public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {

		int n = 1;
		ParkingLot parkingLot = new ParkingLot(n);

		while (true) {
			double averageIncomingQueue = 0.0d;

			System.out.println("====Setting lot capacity to: " + n + "====");

			for (int i = 0; i < NUM_RUNS; i++) {
				Simulator simulator = new Simulator(parkingLot, hourlyRate, 24 * 3600);
				parkingLot = new ParkingLot(n);

				long end, start;

				start = System.currentTimeMillis();
				simulator.simulate();
				end = System.currentTimeMillis();

				long runtime = end - start;

				int queueSize = simulator.getIncomingQueueSize();
				averageIncomingQueue += queueSize;

				System.out.println("Simulation run " + (i + 1) + " (" + runtime + "ms)"
						+ "; Queue length at the end of simulation run: " + queueSize);
			}

			averageIncomingQueue /= NUM_RUNS;

			if (averageIncomingQueue <= THRESHOLD) {
				break;
			} else {
				n += 1;
				parkingLot = new ParkingLot(n);
			}

			System.out.println("");

		}
		return n;
	}

	public static void main(String args[]) {

		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}