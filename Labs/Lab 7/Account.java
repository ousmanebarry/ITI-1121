public class Account {
  private double balance;

  public Account() {
    this.balance = 0;
  }

  public double getBalance() {
    return this.balance;
  }

  public void deposit(double amount) {
    this.balance += amount;
    System.out.println("new balance=" + getBalance() + "$");
  }

  public void withdraw(double amount) throws NotEnoughMoneyException {
    if (getBalance() > amount) {
      this.balance -= amount;
      System.out.println("new balance=" + getBalance() + "$");
    } else {
      throw new NotEnoughMoneyException(amount, this.balance);
    }
  }

}