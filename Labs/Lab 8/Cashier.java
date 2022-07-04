public class Cashier {
  private Queue<Customer> queue;
  private Customer currentCustomer;
  private int totalCustomerWaitTime;
  private int customersServed;
  private int totalItemsServed;

  public Cashier() {
    this.queue = new ArrayQueue<Customer>();
    this.currentCustomer = null;
    this.totalCustomerWaitTime = 0;
    this.customersServed = 0;
    this.totalItemsServed = 0;
  }

  public void addCustomer(Customer c) {
    this.queue.enqueue(c);
  }

  public int getQueueSize() {
    return this.queue.size();
  }

  public void serveCustomers(int currentTime) {
    if (this.currentCustomer == null && this.queue.isEmpty())
      return;

    if (this.currentCustomer == null) {
      this.currentCustomer = this.queue.dequeue();
      this.totalCustomerWaitTime += currentTime - this.currentCustomer.getArrivalTime();
    }

    this.currentCustomer.serve();

    if (currentCustomer.getNumberOfItems() == 0) {
      this.customersServed++;
      this.totalItemsServed += this.currentCustomer.getNumberOfServedItems();
      this.currentCustomer = null;
    }
  }

  public int getTotalCustomerWaitTime() {
    return this.totalCustomerWaitTime;
  }

  public int getTotalCustomersServed() {
    return this.customersServed;
  }

  public int getTotalItemsServed() {
    return this.totalItemsServed;
  }

  public String toString() {
    return "The total number of customers served is " + customersServed + "\n"
        + "The average number of items per customer was " + totalItemsServed / customersServed + "\n"
        + "The average waiting time (in seconds) was " + totalCustomerWaitTime / customersServed;
  }

}