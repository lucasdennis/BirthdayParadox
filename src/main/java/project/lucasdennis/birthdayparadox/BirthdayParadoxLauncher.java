package project.lucasdennis.birthdayparadox;

/**
 * Created by lucas on 10/8/17.
 */
public class BirthdayParadoxLauncher {
    private static final int TESTS_TO_RUN = 100;
    private static final int PEOPLE_IN_ROOM = 23;

    public static void main(String[] args) {
        BirthdayParadox tester = new BirthdayParadox(TESTS_TO_RUN, PEOPLE_IN_ROOM);
        System.out.println(tester.runSimulation());
    }
}
