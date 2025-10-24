import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * MazeGameGUI is responsible for rendering the game GUI, handling input from keyboard
 * and buttons, and coordinating interactions between the Board, Player, and game actions.
 */
public class MazeGameGUI {

    private final Board tester;
    private final Player testPlayer;
    private JFrame gameFrame;
    private JPanel mazePanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centralButtons;
    private JButton newGame;
    private JButton menu;
    private JButton[] buttons;
    private String[] buttonNames;
    private String[] positions;
    private String[] reversedPositions;
    private ActionListener[] actions;
    private GameActions gameActions;
    private TimerAndScore scores;

    /**
     * Constructs the MazeGameGUI with a given board size and difficulty parameters.
     */
    public MazeGameGUI(int size, int difficulty, int difficulty1, int difficulty2) {
        tester = new Board(size, size, difficulty, difficulty1, difficulty2);
        scores = new TimerAndScore(tester, this);
        scores.timerStart();

        testPlayer = new Player(this, tester, scores);

        // Initialize GUI components
        gameFrame = new JFrame();
        mazePanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        centralButtons = new JPanel();
        newGame = new JButton();
        menu = new JButton();
        gameActions = new GameActions(this, tester, scores);

        setupFrame();
        setupMazePanel();
        setupBottomPanel(size, difficulty, difficulty1, difficulty2);
        setupTopPanel();

        gameFrame.setVisible(true);
        mazePanel.requestFocusInWindow();
    }

    /** Sets up main game frame properties. */
    private void setupFrame() {
        gameFrame.setTitle("Maze Game");
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setSize(700, 700);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(true);
        gameFrame.setLocationRelativeTo(null);
    }

    /** Configures the maze panel and keyboard controls. */
    private void setupMazePanel() {
        mazePanel.setLayout(new BorderLayout());
        mazePanel.add(tester, BorderLayout.CENTER);
        mazePanel.setFocusable(true);

        mazePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        gameFrame.add(mazePanel, BorderLayout.CENTER);
    }

    /** Handles keyboard input for player movement and reversed controls. */
    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (gameActions.reversed()) {
            if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                testPlayer.move(tester, 0, +1);
            } else if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                testPlayer.move(tester, 0, -1);
            } else if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                testPlayer.move(tester, -1, 0);
            } else if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                testPlayer.move(tester, +1, 0);
            }
        } else {
            if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) {
                testPlayer.move(tester, 0, -1);
            } else if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) {
                testPlayer.move(tester, 0, +1);
            } else if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) {
                testPlayer.move(tester, +1, 0);
            } else if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) {
                testPlayer.move(tester, -1, 0);
            }
        }
    }

    /** Sets up bottom panel with movement buttons and control buttons. */
    private void setupBottomPanel(int size, int difficulty, int difficulty1, int difficulty2) {
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);

        // Initialize movement buttons
        buttons = new JButton[4];
        buttonNames = new String[]{"Up", "Down", "Right", "Left"};
        positions = new String[]{BorderLayout.NORTH,
            BorderLayout.SOUTH, 
            BorderLayout.EAST, 
            BorderLayout.WEST};
        reversedPositions = new String[]{BorderLayout.SOUTH, 
            BorderLayout.NORTH, 
            BorderLayout.WEST, 
            BorderLayout.EAST};
        actions = new ActionListener[]{
                e -> testPlayer.move(tester, 0, -1),
                e -> testPlayer.move(tester, 0, +1),
                e -> testPlayer.move(tester, +1, 0),
                e -> testPlayer.move(tester, -1, 0)
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(actions[i]);
            bottomPanel.add(buttons[i], positions[i]);
        }

        // Initialize central buttons
        centralButtons.setLayout(new FlowLayout());
        centralButtons.setBackground(Color.WHITE);
        newGame.setText("New Game");
        menu.setText("Menu");
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);

        newGame.addActionListener(e -> {
            gameFrame.dispose();
            new MazeGameGUI(size, difficulty, difficulty1, difficulty2);
        });

        menu.addActionListener(e -> {
            gameFrame.dispose();
            new GameMenu();
        });

        centralButtons.add(newGame);
        centralButtons.add(menu);

        bottomPanel.add(centralButtons, BorderLayout.CENTER);
        gameFrame.add(bottomPanel, BorderLayout.SOUTH);
    }

    /** Sets up the top panel with score and timer labels. */
    private void setupTopPanel() {
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(scores.getFakeFruits());
        topPanel.add(scores.getScoreLabel());
        topPanel.add(scores.getTimeLabel());

        gameFrame.add(topPanel, BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return gameFrame;
    }

    /**
 * Returns the corresponding JPanel based on the given character.
 *
 * @param panel a character representing which panel to retrieve:
 *              'm' - the main maze panel
 *              't' - the top panel (score and timer)
 *              'c' - the central buttons panel (New Game/Menu)
 *              any other value - the bottom panel (movement buttons)
 * @return the requested JPanel
 */
    public JPanel getPanel(char panel) {
        switch (panel) {
            case 'm':
                return mazePanel;
            case 't':
                return topPanel;
            case 'c':
                return centralButtons;
            default:
                return bottomPanel;
        }
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public String[] getPositions(char x) {
        return (x == 'o') ? positions : reversedPositions;
    }

    public String[] getNames() {
        return buttonNames;
    }
}
