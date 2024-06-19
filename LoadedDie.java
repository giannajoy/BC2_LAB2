/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab2;

import java.util.Random;
/**
 * Represents a loaded six-sided die that has a higher probability of rolling a specific face.
 */
public class LoadedDie {
    private Random random;              //Instance of the random object
    private int loadedNumber;           //instance of the loaded Number object
    private int moreTimesPerHundred;    //Instance of times per 100 rolls

    /**
     * The constructor performs an initial roll of the die.
     * @param loadedNumber        which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     *                            the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadedNumber, int moreTimesPerHundred) {
        this.random = new Random();
        this.loadedNumber = loadedNumber;
        this.moreTimesPerHundred = moreTimesPerHundred;
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will basically set this die's value to a random value
     * with a uniform distribution between 1 and 6. The constructor's
     * moreTimesPerHundred argument determines the frequency with which it
     * returns the favorite value.
     * @return The result of the roll, which could be the preferred face or
     * a random value between 1 and 6.
     */
    public int roll() {
        int randomValue = random.nextInt(100);
        if (randomValue < moreTimesPerHundred) {
            // Loaded roll, return the favored face (6 in this case)
            return loadedNumber;
        } else {
            // Regular roll, return a random value between 1 and 6
            return random.nextInt(6) + 1;
        }
    }
}
