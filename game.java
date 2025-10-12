package CBL_Maze_Game;

import utils.TimerManager;

public class Game implements TimerManager.TimerListener {

    private TimerManager timer;
    private Difficulty difficulty;

    public Game(Difficulty difficulty) {
        this.difficulty = difficulty;
        int startTime = timeForDifficulty(difficulty);
        timer = new TimerManager(startTime, this);
        timer.start();
    }

    private int timeForDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return 300;
            case MEDIUM:
                return 180;
            case HARD:
                return 120;
            default:
                return 180;
        }
    }

    @Override
    public void onTimerUpdate(int secondsLeft) {
        System.out.println("Time remaining: " + secondsLeft + "s");
    }

    @Override
    public void onTimeUp() {
        System.out.println("Time's up! Game over.");
    }
}
