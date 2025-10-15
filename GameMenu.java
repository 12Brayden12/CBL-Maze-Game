import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
public class GameMenu {
   public JFrame mainFrame;
   private JFrame tutorialFrame;
   private JPanel centraPanel;
   private JButton play;
   private JButton tutorial;
   private JTextArea rulesText;
   private Dimension buttonSize;

   public GameMenu() {
       mainFrame = new JFrame();
       mainFrame.setTitle("GameMenu");
       mainFrame.setLayout(new BorderLayout());
       mainFrame.setSize(500, 500);
       mainFrame.setResizable(true);
       mainFrame.setLocationRelativeTo(null);
       mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mainFrame.setVisible(true);

       buttonSize = new Dimension(250,50);

       centraPanel = new JPanel();
       BoxLayout boxLayout = new BoxLayout(centraPanel, BoxLayout.Y_AXIS);
       centraPanel.setBackground(Color.WHITE);
       centraPanel.setLayout(boxLayout);
       centraPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
       
       tutorial = new JButton();
       tutorial.setText("TUTORIAL");
       Font buttonsFont = new Font("Verdana", Font.BOLD, 40);
       tutorial.setFont(buttonsFont);
       tutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
       tutorial.setMaximumSize(buttonSize);
       tutorial.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
            openTutorial();
        }
        });
        play = new JButton();
        play.setFont(buttonsFont);
       play.setText("Play");
       play.setAlignmentX(Component.CENTER_ALIGNMENT);
       play.setMaximumSize(buttonSize);
       play.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
                /*
                Difficulty.GameSettings settings = Difficulty.chooseDifficulty();
                if (settings == null) return; 
                System.out.println("Fake Fruits: " + settings.fakeFruitCount);
                System.out.println("Traps: " + settings.trapCount);
                System.out.println("Time Limit: " + settings.timeLimit);

                JFrame gameFrame = new JFrame("Maze Game");
                gameFrame.setSize(500, 500);
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                Board gameBoard = new Board(10, 10, 10, settings.fakeFruitCount, settings.trapCount);
                gameFrame.add(gameBoard);

                gameFrame.setVisible(true);
                Difficulty.GameSettings settings = Difficulty.chooseDifficulty();
                if (settings == null) return; 
                System.out.println("Fake Fruits: " + settings.fakeFruitCount);
                System.out.println("Traps: " + settings.trapCount);
                System.out.println("Time Limit: " + settings.timeLimit);

                JFrame gameFrame = new JFrame("Maze Game");
                gameFrame.setSize(500, 500);
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                Board gameBoard = new Board(10, 10, 10, settings.fakeFruitCount, settings.trapCount);
                gameFrame.add(gameBoard);

                gameFrame.setVisible(true);
                 * 
                 */
                mainFrame.dispose();
                new Difficulty2();

        }
       });
       centraPanel.add(Box.createVerticalGlue());
       centraPanel.add(play);
       centraPanel.add(Box.createRigidArea(new Dimension(0,20)));
       centraPanel.add(tutorial);
       centraPanel.add(Box.createVerticalGlue());
       mainFrame.add(centraPanel,BorderLayout.CENTER);
       
    }
    public void openTutorial() {

    
    tutorialFrame = new JFrame("TUTORIAL");
    tutorialFrame.setLayout(new BorderLayout());
    tutorialFrame.setSize(250,250);
    tutorialFrame.setResizable(true);
    tutorialFrame.setLocationRelativeTo(null);
    tutorialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    rulesText = new JTextArea();
    Font highReadibility = new Font("Verdana", Font.PLAIN, 13);
    rulesText.setFont(highReadibility);
    rulesText.setLineWrap(true );
    rulesText.setWrapStyleWord(true);
    rulesText.setEditable(false);
    rulesText.setBackground(Color.WHITE);
    rulesText.setText(
    "Welcome to the Maze Java-based video game!\n" +
    "In these difficult ages of te prevalent obesity and unconcious eating disorders\n" +
    "helping others regain awareness about the importance of healthy eating. \n" +
    "The life of the x on this planet is limited.\n" +
    "Your main goal is to extend the life of x! Help him collect all of the fruits while escaping the viscious cycle of unhealthy food\n" +
    "Try to avoid all of the off fruits, and find the exit as soons as possible.\n"+
    "How to Play:\n" +
    "1. Choose your difficulty level:\n" +
    "   - Easy: Larger paths, more time\n" +
    "   - Medium: Standard maze complexity\n" +
    "   - Hard: Complex paths, less time\n\n" +       
    "2. Controls:\n" +
    "   ↑ Up arrow or Up button: Move up\n" +
    "   ↓ Down arrow or down button: Move down\n" +
    "   ← Left arrow or left button: Move left\n" +
    "   → Right arrow or right button: Move right\n" 
           );
           JScrollPane scrollPane = new JScrollPane(rulesText);
           scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
           scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
           tutorialFrame.add(scrollPane, BorderLayout.CENTER);
           tutorialFrame.setVisible(true);
    }
    
 
    





    
}