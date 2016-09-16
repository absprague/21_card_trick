import java.awt.BasicStroke;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.StrokeBorder;

public class Board extends JFrame{
    
    private Toolkit tools = Toolkit.getDefaultToolkit();
    private int width = tools.getScreenSize().width - 50;
    private int height = tools.getScreenSize().height - 50;
    private Dimension screenSize = new Dimension(width, height);
    private Column[] columns = new Column[3];
    
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
        if(columns[0] == null){
            for(int i = 0; i < columns.length; i++){
                columns[i] = new Column();
                int cWidth = columns[i].getWidth();
                columns[i].setLocation((i*cWidth)+(i+1)*width/8, 50);
                //border only a placeholder
                columns[i].setBorder(new StrokeBorder(new BasicStroke(1)));
                this.add(columns[i]);
            }
            int i = 0;
            for(int r = 0; r < 7; r++){
                for(int c = 0; c < 3; c++){
                    addToColumn(i%3, new Card());//new Card just placeholder
                    System.out.println(i);
                    i++;
                }
            }
            JButton cardChosen = new JButton("I have chosen a card");
            cardChosen.setBounds(width/2-90, height-120, 180, 25);
            cardChosen.setVisible(true);
            cardChosen.addActionListener((ActionEvent e) -> {
                next();
                cardChosen.setVisible(false);
                repaint();
            });
            this.add(cardChosen);
            repaint();
            System.out.println(this);
        }
    }
    
    private void close(){
        if(JOptionPane.showConfirmDialog(this, (Object)"Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
				== JOptionPane.OK_OPTION)
			System.exit(0);
    }
    
    private void next(){
        //go on to next part of the deal
    }
    
    @Override
    public String toString(){
        return "The Board Contains: \n" + columns[0] + columns[1] + columns[2];
    }
}
