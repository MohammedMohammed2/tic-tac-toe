import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GUI {
    private JButton [] buttons = new JButton[9];
    private JPanel bot;
    boolean spelareX;
    Random random = new Random();
    private JLabel TurnStarter, scoreX, scoreO;
    int x;
    int o;


    GUI(){
        JFrame frame = new JFrame("Tic tac toe");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(TopPanel(),BorderLayout.NORTH);
        frame.add(PlayingField(),BorderLayout.CENTER);
        frame.add(bot, BorderLayout.SOUTH);
        frame.setVisible(true);
        startSpelare();
    }

    /*shows if X or O is taking turn and the winner*/
    private JPanel TopPanel() {
        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(150,50));
        top.setBorder(BorderFactory.createLineBorder(Color.darkGray,10));
        top.setBackground(Color.darkGray);

        //Panel som ska in i south med samma design som top.
        bot = new JPanel();
        bot.setPreferredSize(new Dimension(150,50));
        bot.setBorder(BorderFactory.createLineBorder(Color.darkGray,10));
        bot.setBackground(Color.darkGray);


        TurnStarter = new JLabel();
        TurnStarter.setFont(new Font(("Times New Roman"), Font.PLAIN,20));
        TurnStarter.setForeground(Color.orange);
        top.add(TurnStarter);

        //label för resultat X
        scoreX = new JLabel();
        scoreX.setFont(new Font(("Times New Roman"), Font.PLAIN,25));
        scoreX.setForeground(Color.blue);
        scoreX.setText("Spelare X:  0 ");

        //label för resultat O
        scoreO = new JLabel();
        scoreO.setFont(new Font(("Times New Roman"), Font.PLAIN,25));
        scoreO.setForeground(Color.red);
        scoreO.setText("       Spelare O: 0");

        bot.add(scoreX);
        bot.add(scoreO);

        return top;

    }

    private JPanel PlayingField(){
        JPanel Field = new JPanel(new BorderLayout(10,10));
        Field.setBorder(BorderFactory.createLineBorder(Color.black,2));
        Field.setPreferredSize(new Dimension(400,400));
        JPanel panel = new JPanel(new GridLayout(3, buttons.length,0,0));
        for(int i = 0; i<buttons.length;i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new ButtonListener());
            buttons[i].setBackground(Color.cyan);
            buttons[i].setFont(new Font(("Times New Roman"), Font.PLAIN,100));
            buttons[i].setActionCommand(i+"");
            panel.add(buttons[i]);
        }
        Field.add(panel);
        return Field;
    }

    //om det blir true är det spelare X som börjar om det blir false är det spelare O.
    public void startSpelare (){
        if (random.nextBoolean()){
            spelareX=true;
            TurnStarter.setText("SPELARE X BÖRJAR");
        } else {
            spelareX=false;
            TurnStarter.setText("SPELARE O BÖRJAR");
        }
    }
    private void spelStatus() { // kollar spelets status, vinnare, förlorare eller oavgjort
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) { //kollar varje vinnande rikning
                case 0:
                    // horisontell vinst
                    line = buttons[0].getText() + buttons[1].getText() + buttons[2].getText();
                    break;
                case 1:
                    line = buttons[3].getText() + buttons[4].getText() + buttons[5].getText();
                    break;
                case 2:
                    line = buttons[6].getText() + buttons[7].getText() + buttons[8].getText();
                    break;
                // vertical vinst
                case 3:
                    line = buttons[0].getText() + buttons[3].getText() + buttons[6].getText();
                    break;
                case 4:
                    line = buttons[1].getText() + buttons[4].getText() + buttons[7].getText();
                    break;
                case 5:
                    line = buttons[2].getText() + buttons[5].getText() + buttons[8].getText();
                    break;
                    //diagonal vinst
                case 6:
                    line = buttons[0].getText() + buttons[4].getText() + buttons[8].getText();
                    break;
                case 7:
                    line = buttons[2].getText() + buttons[4].getText() + buttons[6].getText();
                    break;
            }

            // kollar vem vinnaren är och visar det
            if (line.equals("XXX")) {
                JOptionPane.showMessageDialog(null, "Spelare X vann!");
                //uppdaterar counter och ändrar text i label.
                x++;
                scoreX.setText("Spelare X:  " + x);
                reset();
                return;
            } else if (line.equals("OOO")) {
                JOptionPane.showMessageDialog(null, "Spelare O vann!");
                //uppdaterar counter och ändrar text i label.
                o++;
                scoreO.setText("       Spelare O:  " + o);
                reset();
                return;
            }
        }
        // kollar ifall det är oavgjort
        if (fullt()) {
            JOptionPane.showMessageDialog(null, "Spelet blev oavgjort!");
            reset();
        }
    }

    // metod för att kolla ifall alla celler är fyllda
        private boolean fullt() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }



    //metod för att resetta spelet
    private void reset() {
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
        startSpelare();
    }

    
class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
         JButton buttonClicked = (JButton) e.getSource();
         //Om spelareX är true blir texten X annars O så det stämmer överens med Startspelare.
            if (spelareX){
                buttonClicked.setText("X");
            } else {
                buttonClicked.setText("O");
            }
            //så man inte kan ändra efter man klickat på knapp
            buttonClicked.setEnabled(false);

            //så det skiftar spelare.
           spelareX =! spelareX;

         spelStatus();

    }
}
}
