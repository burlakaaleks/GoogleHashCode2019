public class Simulator {

    public static void main(String[] args) {
//        String[] inputs = {"a_example", "b_lovely_landscapes", "c_memorable_moments", "e_shiny_selfies", "d_pet_pictures"};
        String[] inputs = {"e_shiny_selfies"};

        for (String in: inputs) {
            Slideshow slideshow = new Slideshow();
            slideshow.parse(in + ".txt");
            slideshow.createSlide();
            slideshow.print(in + "_out.txt" );
        }
    }
}
