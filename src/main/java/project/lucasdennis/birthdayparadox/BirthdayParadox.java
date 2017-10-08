package project.lucasdennis.birthdayparadox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lucas on 10/8/17.
 */
public class BirthdayParadox {

    private static final int DAYS_IN_YEAR = 365;
    private static final int MAX_YEARS_WITHOUT_LEAP = 3;
    private static final int LEAP_YEAR_ODDS = 4;
    private static final int STARTING_VAL = 1;
    private int testsToRun;
    private int peopleInRoom;

    public BirthdayParadox(int testsToRun, int peopleInRoom) {
        this.peopleInRoom = peopleInRoom;
        this.testsToRun = testsToRun;
    }

    public String runSimulation() {
        int matchCount = 0;
        for (int i = 0; i < testsToRun; i++) {
            List<Integer> birthdayList = new ArrayList<>();
            Set<Integer> birthdaySet = new HashSet<>();
            for (int j = 0; j < peopleInRoom; j++) {
                int randomBday = randomBirthday();
                birthdayList.add(randomBday);
                birthdaySet.add(randomBday);
            }
            if (birthdayList.size() != birthdaySet.size()) {
                matchCount++;
            }
        }

        StringBuilder output = new StringBuilder("");
        output.append(testsToRun + " tests were run. \n");
        output.append("Each time the room had " + peopleInRoom + " people. \n");
        output.append(matchCount + " <- is the number of times at least 2 people in the room shared a birthday.");
        return output.toString();
    }

    /**
     * @return Will return random int in the range of 1:366. Odds of 366 will be adjusted to simulate leap years.
     */
    private int randomBirthday() {
        int randomOutOf4 = ThreadLocalRandom.current().nextInt(STARTING_VAL, LEAP_YEAR_ODDS + 1);
        boolean leapYear = randomOutOf4 > MAX_YEARS_WITHOUT_LEAP;
        int daysInYear = DAYS_IN_YEAR;
        if (leapYear) {
            daysInYear++;
        }
        return ThreadLocalRandom.current().nextInt(STARTING_VAL, daysInYear + 1);
    }
}
