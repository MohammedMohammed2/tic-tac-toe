import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI {
    private JButton [] buttons = new JButton[9];
    boolean spelareX;
    Random random = new Random();
    GUI(){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.add(TopPanel());
        panel.add(PlayingField());

        startSpelare();

    }

    /*shows if X or O is taking turn and the winner*/
    private JPanel TopPanel() {
        JPanel top = new JPanel();

        return top;
    }

    private JPanel PlayingField(){
        JPanel Field = new JPanel(new BorderLayout(10,10));
        Field.setBorder(BorderFactory.createLineBorder(Color.black,2));
        Field.setPreferredSize(new Dimension(400,400));

        JPanel panel = new JPanel(new GridLayout(3, 3,10,10));
        for(int i = 0; i<buttons.length;i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new ButtonListener());
            panel.add(buttons[i]);
        }
        Field.add(panel);
        return Field;
    }


    //om det blir 0 är det spelare X som börjar om det blir 1 är det spelare O.
    //sen ska det läggas in text för X och O så det visas.
    public void startSpelare (){
        spelareX = random.nextBoolean();
    }


    private void checkGameStatus() {

    }
class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        buttonClicked.setText(spelareX ? "X" : "O");
        buttonClicked.setEnabled(false);

        checkGameStatus();
        spelareX = !spelareX;
    }
}

}

