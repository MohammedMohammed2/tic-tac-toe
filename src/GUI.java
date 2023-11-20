import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private JButton [] buttons = new JButton[9];
    GUI(){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.add(TopPanel());
        panel.add(PlayingField());
    }

    /*shows if X or O is taking turn and the winner*/
    private JPanel TopPanel() {
        JPanel top = new JPanel();

        return top;
    }

    private JPanel PlayingField(){
        JPanel Field = new JPanel(new BorderLayout(10,10));
        Field.setBorder(BorderFactory.createLineBorder(Color.black,2));
        Field.setPreferredSize(new Dimension(300,300));
        JPanel panel = new JPanel(new GridLayout(3, buttons.length,10,10));
        for(int i = 0; i<buttons.length;i++) {
            buttons[i] = new JButton();
            panel.add(buttons[i]);
        }
        Field.add(panel);
        return Field;
        hejhejhej

    }

}
