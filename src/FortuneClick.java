import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneClick implements ActionListener {

    public void actionPerformed(ActionEvent ae) {
        ArrayList fortunes = new ArrayList();
        Random r = new Random();
        fortunes.add("You may find a shiny coin soon!");
        int i = 0;
        int c = 0;

        if (c == i){
            if (c==11){
                i=c-1;
            }
            else {
                i = c+1;
            }
        }
        else {
            i = r.nextInt(0,11);
            c = i;
            System.out.println(fortunes.get(i));
        }

    }
}
