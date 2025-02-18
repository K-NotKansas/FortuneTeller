import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel main, icon, scroll, control;
    JLabel title;
    JTextArea mainTxtArea;
    JScrollPane mainScrollPane;
    JButton quitOut, tellMyFortune;
    ImageIcon titleLabelImg;
    Random r = new Random();
    static ArrayList fortunes = new ArrayList<String>();
    int i, c;

    static {
        fortunes.add("You may spontaneously acquire a cat that is fond of lasagna and lazy on Mondays!");
        fortunes.add("Congrats! I would tell you what for, but it would ruin the surprise!");
        fortunes.add("Remember folks, the cookie made you to eat it!");
        fortunes.add("If you see a llama soon, avoid it!");
        fortunes.add("No worries, everyone has a second stomach for dessert!");
        fortunes.add("Let someone else go first on open mic night, you will sound like gold!");
        fortunes.add("Kick back and relax...But not for too long!");
        fortunes.add("You may find a rabbit in your hat!");
        fortunes.add("Have another!");
        fortunes.add("You know what? Me neither!");
        fortunes.add("It's the final countdown!");
    }

    //Make Main Frame... Figure out why it is being mean.
    public FortuneTellerFrame() {
        main = new JPanel();
        main.setLayout(new BorderLayout());

        plzMakeIconPane();
        main.add(icon, BorderLayout.NORTH);
        plzMakeScrollPane();
        main.add(scroll, BorderLayout.CENTER);
        plzMakeControlPane();
        main.add(control, BorderLayout.SOUTH);
        add(main);

        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //MakePanes
    public void plzMakeIconPane(){
        icon = new JPanel();
        titleLabelImg = new ImageIcon("src/CrystalBallFortuneTeller.png");
        title = new JLabel("Fortune Teller", titleLabelImg, JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setIcon(titleLabelImg);
        title.setFont(new Font("Times New Roman",Font.BOLD, 35));
        icon.add(title);
    }
    public void plzMakeScrollPane(){
        scroll = new JPanel();
        mainTxtArea = new JTextArea(10,51);
        mainTxtArea.setEditable(false);
        mainScrollPane = new JScrollPane(mainTxtArea);
        mainTxtArea.setFont(new Font("Arial",Font.PLAIN, 12));
        scroll.add(mainScrollPane);
    }
    public void plzMakeControlPane(){
        control = new JPanel();
        control.setLayout(new GridLayout(1, 2));
        quitOut = new JButton("Quit");
        tellMyFortune = new JButton("Read My Fortune!");

        //Action Listeners + logic on action
        quitOut.addActionListener((ActionEvent ae)->{
            System.exit(0);
        });
        tellMyFortune.addActionListener((ActionEvent ae)->{
            i = r.nextInt(0,11);


            if (i==c){
                if (c==11){
                    i--;
                    mainTxtArea.append((String) fortunes.get(i) + "\n");
                    c = i;
                }
                else {
                    i++;
                    mainTxtArea.append((String) fortunes.get(i) + "\n");
                    c = i;
                }
            }
            else {
                mainTxtArea.append((String) fortunes.get(i) + "\n");
                c = i;
            }
        });
        //add the buttons
        control.add(tellMyFortune);
        control.add(quitOut);
    }
}
