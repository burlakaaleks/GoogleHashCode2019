import java.io.*;
import java.util.ArrayList;

public class Slideshow {

    ArrayList<Photo> orderedSlideshow = new ArrayList<>();

    void parse(String filename){
        int bufferSize = 8 * 1024;

        int lineCount = 0;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);
            String firstLine = bufferedReader.readLine();

            int totalNumberOfPhotos = Integer.parseInt(firstLine);
            ArrayList<Photo> photosV = new ArrayList<>();
            ArrayList<Photo> photosH = new ArrayList<>();

            for (int i = 0; i < totalNumberOfPhotos; i++) {

                String l = bufferedReader.readLine();
                String[] arr = l.split(" ");

                Photo photo = new Photo();

                photo.id = i;
                photo.orientation = arr[0];
                photo.numOfTags = Integer.parseInt(arr[1]);

                for (int j = 2; j < arr.length ; j++) {
                    photo.tags.add(arr[i]);
                }

                if(photo.orientation == "V") {
                    photosV.add(photo);
                }
                else{
                    photosH.add(photo);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSlide(){

    }

    public void print(String filename){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");

            int slideshowSize = orderedSlideshow.size();
            writer.println(slideshowSize);

            for (int i = 0; i < slideshowSize ; i++) {
                if(orderedSlideshow.get(i).orientation == "V"){
                    writer.print(orderedSlideshow.get(i).id + " " + orderedSlideshow.get(i+1));
                    i += 1;
                }else{
                    writer.print(orderedSlideshow.get(i).id + " ");
                }
                writer.println();
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
