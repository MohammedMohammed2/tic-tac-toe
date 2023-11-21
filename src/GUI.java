import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GUI {
    private JButton [] buttons = new JButton[9];
    boolean spelareX;
    Random random = new Random();
    GUI(){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        frame.add(TopPanel());
        frame.add(PlayingField());
        frame.setVisible(true);

    }

    /*shows if X or O is taking turn and the winner*/
    private JPanel TopPanel() {
        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(150,50));
        top.setBorder(BorderFactory.createLineBorder(Color.BLUE,10));

        return top;
    }

    private JPanel PlayingField(){
        JPanel Field = new JPanel(new BorderLayout(10,10));
        Field.setBorder(BorderFactory.createLineBorder(Color.black,2));
        Field.setPreferredSize(new Dimension(400,400));
        JPanel panel = new JPanel(new GridLayout(3, buttons.length,10,10));
        for(int i = 0; i<buttons.length;i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new EventListener());
            buttons[i].setActionCommand(i+"");
            panel.add(buttons[i]);
        }
        Field.add(panel);
        return Field;
    }

test

    //om det blir 0 är det spelare X som börjar om det blir 1 är det spelare O.
    //sen ska det läggas in text för X och O så det visas.
    public void startSpelare (){
        if (random.nextInt(2)==0){
            spelareX=true;
        } else {
            spelareX=false;
        }
    }

public class EventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("0")) {
            buttons[0].setText("x");
            buttons[0].setEnabled(false);
        }
        if (e.getActionCommand().equals("1")) {
            buttons[1].setText("x");
            buttons[1].setEnabled(false);
        }
        if (e.getActionCommand().equals("2")) {
            buttons[2].setText("x");
            buttons[2].setEnabled(false);
        }
        if (e.getActionCommand().equals("3")) {
            buttons[3].setText("x");
            buttons[3].setEnabled(false);
        }
        if (e.getActionCommand().equals("4")) {
            buttons[4].setText("O");
            buttons[4].setEnabled(false);
        }
        if (e.getActionCommand().equals("5")) {
            buttons[5].setText("x");
            buttons[5].setEnabled(false);
        }
        if (e.getActionCommand().equals("6")) {
            buttons[6].setText("O");
            buttons[6].setEnabled(false);
        }
        if (e.getActionCommand().equals("7")) {
            buttons[7].setText("O");
            buttons[7].setEnabled(false);
        }
        if (e.getActionCommand().equals("8")) {
            buttons[8].setText("O");
            buttons[8].setEnabled(false);
        }
    }
}
}
