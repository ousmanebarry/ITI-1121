public class Arithmetic extends AbstractSeries {

  // instance variables
  double currentSum;
  double currentNum;

  public Arithmetic() {
    currentSum = 0.0;
    currentNum = 0.0;
  }

  public double next() {
    // implement the method
    currentNum = currentNum + 1;
    currentSum = currentSum + currentNum;
    return currentSum;
  }
}