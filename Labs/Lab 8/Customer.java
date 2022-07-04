// https://msabet.bitbucket.io/iti1121/labs/lab8.html

import java.util.Random;

public class Customer {

  private int arrivalTime;
  private int numberOfItems;
  private int initialNumberOfItems;
  private static final int MAX_NUM_ITEMS = 25;

  public Customer(int arrivalTime) {
    Random generator = new Random();
    this.arrivalTime = arrivalTime;
    this.numberOfItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1;
    this.initialNumberOfItems = this.numberOfItems;
  }

  public int getArrivalTime() {
    return this.arrivalTime;
  }

  public int getNumberOfItems() {
    return this.numberOfItems;
  }

  public int getNumberOfServedItems() {
    return this.initialNumberOfItems - this.numberOfItems;
  }

  public void serve() {
    this.numberOfItems--;
  }

}