/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

		public NewsFeed(Post[] messages) {
			this.messages = new Post[MAX_SIZE];
			for(int i = 0; i < messages.length; i++) {
				this.messages[i] = messages[i];
				size++;
			}
			this.sort();
		}

    public NewsFeed() {
    	// Your code here.
			messages = new Post[MAX_SIZE];
			size = 0;
    }

    public void add(Post message) {
      // Your code here.
			if(this.size < MAX_SIZE) {
				this.messages[size] = message;
				this.size++;
				this.sort();
			} 
    }

		private Post[] getPosts() {
			return messages;
		}

    public Post get(int index) {
	    return messages[index];
    }

    public int size() {
	    return this.size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		// Your code here
			int arraySize = 0;
			
			for(Post i : messages) {
				if(i instanceof PhotoPost) {
					arraySize++;
				}
			}

			Post[] newNewsFeed = new Post[arraySize];
			int counter = 0;

			for(Post i : messages) {
				if(i instanceof PhotoPost) {
					newNewsFeed[counter] = i;
					counter++;
				}
			}

			return new NewsFeed(newNewsFeed);
  	}

  	public NewsFeed plus(NewsFeed other){
  	  // Your code here
			int counter = 0;
			Post[] newNewsFeed = new Post[this.size() + other.size()];

			for(Post i : this.getPosts()) {
				if(i != null) {
					newNewsFeed[counter] = i;
					counter++;
				}
			}

			for(Post i : other.getPosts()) {
				if(i != null) {
					newNewsFeed[counter] = i;
					counter++;
				}
			}
			NewsFeed nFeed = new NewsFeed(newNewsFeed);
			nFeed.sort();
			return nFeed;
  	}

		public String toString() {
			return getClass().getName() + ": " + this.size;
		}

}
