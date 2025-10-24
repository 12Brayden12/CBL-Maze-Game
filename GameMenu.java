import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * GameMenu class creates the main menu for the maze game,
 * providing options to start the game or view the tutorial.
 */
public class GameMenu {
    public JFrame mainFrame;
    private JFrame tutorialFrame;
    private JPanel centraPanel;
    private JButton play;
    private JButton tutorial;
    private JTextArea rulesText;
    private Dimension buttonSize;

    /** Constructs the main game menu with Play and Tutorial options. */
    public GameMenu() {
        mainFrame = new JFrame();
        mainFrame.setTitle("GameMenu");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        buttonSize = new Dimension(350, 60);

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
                mainFrame.dispose();
                System.out.println('1');
                new Difficulty2();
            }
        });

        centraPanel.add(Box.createVerticalGlue());
        centraPanel.add(play);
        centraPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centraPanel.add(tutorial);
        centraPanel.add(Box.createVerticalGlue());
        mainFrame.add(centraPanel, BorderLayout.CENTER);
    }

    /** Opens the tutorial window with game instructions. */
    public void openTutorial() {
        tutorialFrame = new JFrame("TUTORIAL");
        tutorialFrame.setLayout(new BorderLayout());
        tutorialFrame.setSize(600, 500);
        tutorialFrame.setResizable(true);
        tutorialFrame.setLocationRelativeTo(null);
        tutorialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        rulesText = new JTextArea();
        Font highReadibility = new Font("Microsoft YaHei", Font.PLAIN, 16);
        rulesText.setFont(highReadibility);
        rulesText.setLineWrap(true);
        rulesText.setWrapStyleWord(true);
        rulesText.setEditable(false);
        rulesText.setBackground(Color.WHITE);
        rulesText.setMargin(new Insets(20, 25, 20, 25));
        rulesText.setText(
            "Welcome to the Maze Java-based video game!\n"
            + "In these difficult ages of the prevalent obesity and unconscious eating disorders\n"
            + "helping others regain awareness about the importance of healthy eating.\n"
            + "The life of the x on this planet is limited.\n"
            + "Your main goal is to extend the life of x! Help him collect all of the fruits"
            + " while escaping the vicious cycle of unhealthy food\n"
            + "Try to avoid all of the off fruits, and find the exit as soon as possible.\n"
            + "How to Play:\n"
            + "1. Choose your difficulty level:\n"
            + "   - Easy: Larger paths, more time\n"
            + "   - Medium: Standard maze complexity\n"
            + "   - Hard: Complex paths, less time\n\n"
            + "2. Controls:\n"
            + "   ↑ Up arrow or Up button: Move up\n"
            + "   ↓ Down arrow or Down button: Move down\n"
            + "   ← Left arrow or Left button: Move left\n"
            + "   → Right arrow or Right button: Move right\n"
            + "3. Fake Fruit:\n"
            + "   - Collect fake fruits (reverse control 10s)\n"
            + "   - There will be a fake fruit counter on the screen\n"
            + "4. Fruit:\n"
            + "   - Collect fruits to increase your score by 50\n"
            + "5. Traps:\n"
            + "   - Avoid traps to avoid losing game\n"
            + "6. Timer:\n"
            + "   - Complete the maze before time runs out\n"
            + "   - Remaining time will convert to your score multiplier\n"
        );

        JScrollPane scrollPane = new JScrollPane(rulesText);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        tutorialFrame.add(scrollPane, BorderLayout.CENTER);
        tutorialFrame.setVisible(true);
    }
}
