public class PhotoPost extends Post {

    private String fileName;
    private String caption;

    public PhotoPost(String userName, String fileName, String caption) {
      // Your code here.
      super(userName);
      this.fileName = fileName;
      this.caption = caption;
    }

    public String getCaption() {
	     return this.caption;
    }

    public String getFileName() {
      return this.fileName;
    }

    public String toString() {
    	return super.toString() + ", " + this.fileName + ", " + this.caption;
    }

}
