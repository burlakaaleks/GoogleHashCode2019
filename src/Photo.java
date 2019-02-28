import java.util.ArrayList;

public class Photo implements Comparable<Photo> {

    int id;
    String orientation;
    int numOfTags;
    ArrayList<String> tags = new ArrayList<>();

    public Photo(){}

    public Photo(int id, String orientation, int numOfTags, ArrayList<String> tags) {
        this.id = id;
        this.orientation = orientation;
        this.numOfTags = numOfTags;
        this.tags = tags;
    }

    @Override
    public int compareTo(Photo o) {
        return new Double(this.numOfTags).compareTo(new Double(o.numOfTags));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getNumOfTags() {
        return numOfTags;
    }

    public void setNumOfTags(int numOfTags) {
        this.numOfTags = numOfTags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
