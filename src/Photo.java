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
        return this.tags.get(0).compareTo(tags.get(0));
    }
}
