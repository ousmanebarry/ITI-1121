import java.util.Arrays;
import java.io.*;

public class PlayList {

    // Instance variables

    private Song[] songs;
    private int count;
    private int capacityIncrement;

    // Constructor
    // See below for a new usage of the reserved keyword this.

    public PlayList(int initialCapacity, int capacityIncrement) {

        if (initialCapacity < 1)
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);

        if (capacityIncrement < 1)
            throw new IllegalArgumentException("Illegal increment: " + capacityIncrement);

        songs = new Song[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public PlayList(int initialCapacity) {
        this(initialCapacity, 10);
    }

    public PlayList() {
        this(10, 10);
    }

    // Returns the number of elements currently stored in the PlayList

    public int getSize() {
        return count;
    }

    public boolean addSong(Song song) {

        if (song == null)
            throw new IllegalArgumentException("null is not a valid argument");

        for (int i = 0; i < count; i++)
            if (songs[i].equals(song)) // songs[ i ] cannot be null
                return false;

        if (count == songs.length) {

            Song[] tmp = songs;
            songs = new Song[tmp.length + capacityIncrement];
            for (int i = 0; i < tmp.length; i++)
                songs[i] = tmp[i];
        }

        songs[count++] = song;
        return true;
    }

    public Song getSongAt(int index) {

        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("" + index);

        return songs[index];
    }

    // Arrays already has a sort method.

    public void sort(java.util.Comparator<Song> c) {
        Arrays.sort(songs, c);
    }

    // Implementing our own sort method.

    public void sort2(java.util.Comparator<Song> c) {

        for (int i = 0; i < count; i++) {

            int min = i;

            // Find the smallest element in the unsorted region of the
            // array.

            for (int j = i + 1; j < count; j++)
                if (c.compare(songs[j], songs[min]) < 0)
                    min = j;

            // Swap the smallest unsorted element with the element
            // found a position i.

            Song tmp = songs[min];
            songs[min] = songs[i];
            songs[i] = tmp;
        }
    }

    public static PlayList getSongsFromFile(String fileName) throws IOException {
        // YOUR CODE HERE (remove the exception)
        PlayList p = new PlayList();

        // Read in the file line by line.
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = br.readLine();

        while (line != null) {
            // Split the line into the artist and the title.
            String[] parts = line.split(":");
            p.addSong(new Song(parts[0], parts[1], parts[2]));
            line = br.readLine();
        }
        br.close();
        return p;
    }

    public void writeSongsToFile(String fileName) throws IOException {
        // YOUR CODE HERE (remove the exception)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

        for (int i = 0; i < getSize(); i++) {
            bw.write(getSongAt(i).toString());
            bw.newLine();
        }
        bw.close();

    }

    public boolean equals(PlayList other) {
        if (other == null) {
            return false;
        }
        if (count != other.count || capacityIncrement != other.capacityIncrement) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (!songs[i].equals(other.songs[i])) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String result = "PlayList:\n";
        for (int i = 0; i < count; i++) {
            result += "\t" + songs[i].toString() + "\n";
        }
        result += "Count: " + count + "\nCapacityIncrement: " + capacityIncrement;
        return result;
    }
}
