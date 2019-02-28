import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Slideshow {

    ArrayList<String> orderedSlideshow = new ArrayList<>();
    ArrayList<Photo> photosH = new ArrayList<>();
    ArrayList<Photo> photosV = new ArrayList<>();

    void parse(String filename){
        int bufferSize = 8 * 1024;

        int lineCount = 0;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);
            String firstLine = bufferedReader.readLine();

            int totalNumberOfPhotos = Integer.parseInt(firstLine);

            for (int i = 0; i < totalNumberOfPhotos; i++) {

                String l = bufferedReader.readLine();
                String[] arr = l.split(" ");

                Photo photo = new Photo();

                photo.id = i;
                photo.orientation = arr[0];
                photo.numOfTags = Integer.parseInt(arr[1]);

                for (int j = 2; j < arr.length ; j++) {
                    photo.tags.add(arr[j]);
                }
                if(photo.orientation.equals("V")){
                    photosV.add(photo);
                }
                else photosH.add(photo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSlide() {
        Collections.sort(photosV, Collections.reverseOrder());
        Collections.sort(photosH, Collections.reverseOrder());

        for (int i = 0; i < photosV.size() ; i++) {
            if(photosV.get(i).orientation.equals("V") && photosV.get(i+1).orientation.equals("V")){
                orderedSlideshow.add(photosV.get(i).id + " " + photosV.get(i+1).id);
                i += 1;
            }
            else if(photosV.get(i).orientation.equals("V") && !photosV.get(i+1).orientation.equals("V")){
                continue;
            }
        }

        for (int i = 0; i < photosH.size() ; i++) {
            if(photosH.get(i).orientation.equals("H")){
                orderedSlideshow.add(String.valueOf(photosH.get(i).id));
            }
        }

    }

    public void print(String filename){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "ASCII");

            int slideshowSize = orderedSlideshow.size();
            writer.println(slideshowSize);

            for (int i = 0; i < slideshowSize ; i++) {
                writer.println(orderedSlideshow.get(i));
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}

