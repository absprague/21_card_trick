import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JFrame{
    
    private Toolkit tools = Toolkit.getDefaultToolkit();
    private int width = tools.getScreenSize().width - 50;
    private int height = tools.getScreenSize().height - 50;
    private Dimension screenSize = new Dimension(width, height);
    private Column[] columns = new Column[3];//only columns are on the board in the class diagram.
        
    public Board(){
        setTitle("21 Card Trick");
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent event){
                close();
            }
        });
        setSize(screenSize);
        setVisible(true);
        
        JButton startTrick = new JButton("Start");
        startTrick.setBounds((width/2)-50, (height/2)-25, 100, 50);
        startTrick.setToolTipText("Shuffles and deals 21 cards to choose from");
        startTrick.setVisible(true);
        startTrick.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
                startTrick.setVisible(false);
                repaint();
            }
        });
        this.add(startTrick);
        
    }
    
    public void addToColumn(int columnId, Card card){
        Column c = columns[columnId];
        c.addCard(card);
    }
    
    private void start(){
        //goes to deck and shuffles it
        //deals the 21 cards
        
    }
    
    private void close(){
        if(JOptionPane.showConfirmDialog(this, (Object)"Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
				== JOptionPane.OK_OPTION)
			System.exit(0);
    }
}
