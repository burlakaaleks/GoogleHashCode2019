public class Simulator {
    public static void main(String[] args) {
        String[] inputs = {"a_example", "b_lovely_landscapes", "c_memorable_moments", "e_shiny_selfies", "d_pet_pictures"} ;

        for (String in: inputs) {
            Slideshow slideshow = new Slideshow();
            slideshow.parse(in + ".txt");

        }
    }
}
