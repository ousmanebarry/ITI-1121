import java.io.IOException;

public class Exercise1 {

  public static void throwException(int exceptionNumber) throws Exception {
    if (exceptionNumber == 1) {
      throw new Exception();
    } else if (exceptionNumber == 2) {
      throw new ArrayIndexOutOfBoundsException();
    } else if (exceptionNumber == 3) {
      throw new IOException();
    } else if (exceptionNumber == 4) {
      throw new IllegalArgumentException();
    } else if (exceptionNumber == 5) {
      throw new NullPointerException();
    }
  }

  /*
   * Returns the name of the exception thrown by the method throwException.
   * Method that handles the exceptions thrown by the throwException method.
   * 
   * @param exceptionNumber
   * 
   * @return The exception name or "NoException" if no exception was caught.
   */
  public static String catchException(int exceptionNumber) {
    String exceptionName = null;

    try {
      throwException(exceptionNumber);
    } catch (Exception e) {
      exceptionName = e.getClass().getSimpleName();
    } finally {
      if (exceptionName == null)
        exceptionName = "NoException";
      System.out.println("The exception type is: " + exceptionName + ", the exceptionNumber is: " + exceptionNumber);
    }

    return exceptionName;

  }

  public static void main(String[] args) {
    int exceptionNumber = (int) (Math.random() * 5) + 1;
    String exceptionName = catchException(exceptionNumber);
    System.out.println("Exception number: " + exceptionNumber);
    System.out.println("Exception name: " + exceptionName);
  }

}