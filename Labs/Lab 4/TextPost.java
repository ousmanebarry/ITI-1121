public class TextPost extends Post {

    private String message;

    public TextPost(String userName, String message) {
      // Your code here.
      super(userName);
      this.message = message;
    }

    public String getMessage() {
	     return message;
    }

    public String toString() {
    	return super.toString() + ", " + message;
    }

  	public boolean isPopular() {
  		// Your code here.
      return this.likes > 50;
  	}

}
