import java.lang.Math;

public class NotEnoughMoneyException extends IllegalStateException {
  private double amount;
  private double balance;

  public NotEnoughMoneyException(double amount, double balance) {
    super("you don't have enough money to witdraw " + amount + "$");
    this.amount = amount;
    this.balance = balance;
  }

  public double getAmount() {
    return this.amount;
  }

  public double getBalance() {
    return this.balance;
  }

  public double getMissingAmount() {
    return Math.abs(getBalance() - getAmount());
  }

}