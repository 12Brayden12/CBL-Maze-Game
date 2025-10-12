import javax.swing.*;

public class TimerManager {
    private int timeRemaining;
    private Timer timer;
    private TimerListener listener;

    public TimerManager(int startTime, TimerListener listener) {
        this.timeRemaining = startTime;
        this.listener = listener;
        timer = new Timer(1000, e -> tick());
    }

    private void tick() {
        timeRemaining--;
        listener.onTimerUpdate(timeRemaining);
        if (timeRemaining <= 0) {
            timer.stop();
            listener.onTimeUp();
        }
    }

    public void start() { timer.start(); }
    public void stop() { timer.stop(); }

    public interface TimerListener {
        void onTimerUpdate(int secondsLeft);
        void onTimeUp();
    }
}
