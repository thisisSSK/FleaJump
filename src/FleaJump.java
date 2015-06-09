/**
 * Created by thisisSSK on 6/8/2015.
 */
public class FleaJump {
    public static void main (String args[]) {
        double numTrials = 20.0;
        double sumEmptySpaces = 0.0;

        for (int i = 0; i < numTrials; i ++) {
            Grid g = new Grid(50);
            g.ringBells();
            sumEmptySpaces += g.getNumEmptySpaces();
        }

        System.out.printf("After %.0f trials, there was an average of %6f empty spaces for each grid", numTrials, sumEmptySpaces/numTrials);

    }
}
