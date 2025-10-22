/*import javax.swing.JOptionPane;

public class Difficulty {


    public static class GameSettings {
        public int fakeFruitCount;
        public int trapCount;
        public int timeLimit;

        public GameSettings(int fakeFruitCount, int trapCount, int timeLimit) {
            this.fakeFruitCount = fakeFruitCount;
            this.trapCount = trapCount;
            this.timeLimit = timeLimit;
        }
    }

    public static GameSettings chooseDifficulty() {
        String[] options = {"Easy", "Medium", "Hard"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "Choose your difficulty level:",
            "Select Difficulty",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == -1) {
            return null;
        }

        switch (choice) {
            case 0: return new GameSettings(5, 2, 300);  // Easy
            case 1: return new GameSettings(10, 5, 180); // Medium
            case 2: return new GameSettings(15, 8, 120); // Hard
            default: return new GameSettings(10, 5, 180);
        }
    }
}
