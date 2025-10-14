import javax.swing.Timer;

public class ControlReversal {
    private static boolean reversed = false;
    private static Timer timer;


    public static void activate() {
        if (reversed) return; 
        reversed = true;
        System.out.println("Controls reversed for 10 seconds!");


        timer = new Timer(10000, e -> {
            reversed = false;
            System.out.println("Controls back to normal!");
        });
        timer.setRepeats(false);
        timer.start();
    }


    public static boolean isReversed() {
        return reversed;
    }
}
