public class Geometric extends AbstractSeries {

  // instance variables
  double currentSum;
  double currentNum;
  double nth;

  public Geometric() {
    currentSum = 0.0;
    currentNum = -1.0;
    nth = 0.0;
  }

  public double next() {
    // implement the method
    currentNum = currentNum + 1.0;
    nth = 1/Math.pow(2, currentNum);
    currentSum = currentSum + nth;
    return currentSum;
  }
}