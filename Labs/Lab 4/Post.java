import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    public Post(String userName) {
      // Your code here
      this.likes = 0;
      this.userName = userName;
      this.timeStamp = Calendar.getInstance().getTime(); 
    }

    public String getUserName() {
	     return this.userName;
    }

    public Date getTimeStamp() {
	     return this.timeStamp;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.

    public void like() {
      this.likes++;
    }

    public int getLikes() {
      return this.likes;
    }


    public String toString() {
    	return getClass().getName() + ": " + this.timeStamp + ", " + this.userName + ", likes = " + this.likes;
    }


  	public int compareTo(Post other){
  		// Your code here.
      Calendar ourCalendar = Calendar.getInstance();
      ourCalendar.setTime(this.timeStamp);
      Calendar otherCalendar = Calendar.getInstance();
      otherCalendar.setTime(other.timeStamp);

      if(ourCalendar.getTimeInMillis() < otherCalendar.getTimeInMillis()) {
        return -1;
      } else if (ourCalendar.getTimeInMillis() > otherCalendar.getTimeInMillis()) {
        return 1;
      } else {
        return 0;
      }
    }

  	public boolean isPopular(){
  		// Your code here.
      return this.likes > 100;
  	}

}
