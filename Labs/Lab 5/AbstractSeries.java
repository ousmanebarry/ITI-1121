public abstract class AbstractSeries implements Series {

  public double[] take(int k) {
    // implement the method
    double[] nthTerms = new double[k];

    for(int i = 0; i < k; i++) {
      nthTerms[i] = this.next();
    }
  
    return nthTerms;
  }

}