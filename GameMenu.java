import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The GameMenu class provides the main menu interface for the Maze Game,
 * including options to play the game or view the tutorial.
 */

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

       buttonSize = new Dimension(350,60);

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
                System.out.println('1');
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
    tutorialFrame.setSize(600,500);
    tutorialFrame.setResizable(true);
    tutorialFrame.setLocationRelativeTo(null);
    tutorialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    rulesText = new JTextArea();
    Font highReadibility = new Font("Microsoft YaHei", Font.PLAIN, 16);
    rulesText.setFont(highReadibility);
    rulesText.setLineWrap(true );
    rulesText.setWrapStyleWord(true);
    rulesText.setEditable(false);
    rulesText.setBackground(Color.WHITE);
    rulesText.setMargin(new Insets(20, 25, 20, 25));
    rulesText.setText(
    "Welcome to the Maze Java-based video game!\n" +
    "In a world overwhelmed by fast food, sugar, and endless temptation,\n" +
    "a small spark of hope remains — you, the guardian of X.\n" +
    "X’s life energy is fading as unhealthy habits consume the planet.\n" +
    "Your mission is to guide X through the maze of choices,\n" +
    "collecting fruits to restore vitality,\n" +
    "while avoiding the traps of contaminated food and distraction.\n" +
    "Only by staying focused and finding the exit can X reclaim balance and survive!\n\n" +
    "How to Play:\n" +
    "1. Choose your difficulty level:\n" +
    "   - Easy: Larger paths, more time\n" +
    "   - Medium: Standard maze complexity\n" +
    "   - Hard: Complex paths, less time\n\n" +       
    "2. Controls:\n" +
    "   ↑ Up arrow or Up button: Move up\n" +
    "   ↓ Down arrow or down button: Move down\n" +
    "   ← Left arrow or left button: Move left\n" +
    "   → Right arrow or right button: Move right\n" +
    "3. Fruits:\n" +
    "   - Collect fruits to gain points" +
    "   - Each fruit worths 50 points\n" +
    "4. Fake Fruits:\n" +
    "   - Avoid fake fruits that reverse your key bind\n" +
    "5. Traps:\n" +
    "   - Stepping on traps ends the game immediately\n" +
    "6. Exit:\n" +
    "   - Find the exit to win the game and secure X's survival!\n" +
    "7. Time Limit:\n" +
    "   - Complete the maze within 100 second.\n" +
    "   - Try to be as quick as possible to get a high score multiplier!\n" 

           );
           JScrollPane scrollPane = new JScrollPane(rulesText);
           scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
           scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
           tutorialFrame.add(scrollPane, BorderLayout.CENTER);
           tutorialFrame.setVisible(true);
    }
    
 
    





    
}