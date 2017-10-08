package project.lucasdennis.birthdayparadox;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucas on 10/8/17.
 */
public class BirthdayParadoxTest {

    @Test
    public void testBirthdayParadox() {
        int testsToRun = 10000;
        int peopleInRoom = 23;
        BirthdayParadox test = new BirthdayParadox(testsToRun, peopleInRoom);
        String output = test.runSimulation();
        System.out.println(output);
        int endOfSubstring = output.indexOf("<-");
        String result = output.substring(endOfSubstring - 5, endOfSubstring - 1);
        int matches = Integer.parseInt(result);
        boolean isInExpectedRange = matches > 4750 && matches < 5250;
        Assert.assertTrue(isInExpectedRange);
    }
}
