import java.io.*;
import java.util.*;

public class Slideshow {

    LinkedHashSet<Photo> sortedSlideshow = new LinkedHashSet<>();
    ArrayList<Photo> photos = new ArrayList<>();
    HashSet<String> uniqueTags = new HashSet<>();
    int totalNumberOfPhotos;


    void parse(String filename){
        int bufferSize = 8 * 1024;

        int lineCount = 0;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);
            String firstLine = bufferedReader.readLine();

            totalNumberOfPhotos = Integer.parseInt(firstLine);

            for (int i = 0; i < totalNumberOfPhotos; i++) {

                String l = bufferedReader.readLine();
                String[] args = l.split(" ");

                Photo photo = new Photo();

                photo.id = i;
                photo.orientation = args[0];
                photo.numOfTags = Integer.parseInt(args[1]);

                for (int j = 2; j < args.length ; j++) {
                    photo.tags.add(args[j]);
                    uniqueTags.add(args[j]);
                }

                photos.add(photo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSlide() {
        System.out.println(uniqueTags.size());

        Iterator<String> iterator = uniqueTags.iterator();

        while (iterator.hasNext()){
            String tag = iterator.next();

            for (int i = 0; i < photos.size() ; i++) {
                for (int j = 0; j < photos.get(i).tags.size() ; j++) {
                    if(photos.get(i).tags.get(j).equals(tag)){
                        sortedSlideshow.add(photos.get(i));
                        System.out.println(photos.get(i).id + " added!");
                        break;
                    }
                }
            }
        }
    }

    public void print(String filename){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "ASCII");

            int slideshowSize = sortedSlideshow.size();
            writer.println(slideshowSize);

            String verticalSlide = "";

            for (Photo ph:sortedSlideshow) {
                if(ph.orientation.equals("H")) writer.println(ph.id);
                else {
                    verticalSlide += ph.id + " ";
                    int[] numArr = Arrays.stream(verticalSlide.split(" ")).mapToInt(Integer::parseInt).toArray();

                    if(numArr.length == 2){
                        writer.println(verticalSlide);
                        verticalSlide = "";
                    }
                }
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}

