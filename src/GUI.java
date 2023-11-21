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
    private JLabel TurnStarter;
    GUI(){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(TopPanel(),BorderLayout.NORTH);
        frame.add(PlayingField(),BorderLayout.CENTER);
        frame.setVisible(true);
        startSpelare();
    }

    /*shows if X or O is taking turn and the winner*/
    private JPanel TopPanel() {
        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(150,50));
        top.setBorder(BorderFactory.createLineBorder(Color.BLUE,10));
        top.setBackground(Color.blue);

        TurnStarter = new JLabel("it is X's turn");
        TurnStarter.setFont(new Font(("Times New Roman"), Font.PLAIN,20));
        TurnStarter.setForeground(Color.orange);
        top.add(TurnStarter);

        return top;
    }

    private JPanel PlayingField(){
        JPanel Field = new JPanel(new BorderLayout(10,10));
        Field.setBorder(BorderFactory.createLineBorder(Color.black,2));
        Field.setPreferredSize(new Dimension(400,400));
        JPanel panel = new JPanel(new GridLayout(3, buttons.length,10,10));
        for(int i = 0; i<buttons.length;i++) {
            buttons[i] = new JButton();
           buttons[i].addActionListener(new ButtonListener());
            buttons[i].setActionCommand(i+"");
            panel.add(buttons[i]);
        }
        Field.add(panel);
        return Field;
    }

    //om det blir 0 är det spelare X som börjar om det blir 1 är det spelare O.
    //sen ska det läggas in text för X och O så det visas.
    public void startSpelare (){
        if (random.nextBoolean()){
            spelareX=true;
            TurnStarter.setText("SPELARE X");
        } else {
            spelareX=false;
            TurnStarter.setText("SPELARE O");
        }
    }
class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        buttonClicked.setText(spelareX ? "X" : "O");
        buttonClicked.setEnabled(false);

        spelareX = !spelareX;
    }
}
}
