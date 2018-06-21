package ga.raindrop.projectperitah.configs;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class customText {

    public static void errText(String error) {
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.RED).build();   //setting format
        cp.println(error);
        cp.clear();

    }

    public static void typeWriter(String typeWriter){
        for (int i = 0; i < typeWriter.length(); i++) {
            System.out.print(typeWriter.charAt(i));

            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void textDelay(int delay){

    }

    public static void clearScreen(){
        for (int i = 0; i < 150; ++i) System.out.println();
    }
    public static void badEnding(){

    }

}
