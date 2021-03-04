/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-26\5\2020
 * version-13.0.2
 */
package decorationgame;

/**
 * The type Counter.
 */
public class Counter {
    private int counter;

    /**
     * Instantiates a new Counter.
     *
     * @param counter the counter
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * Increase.dd number to current count.
     *
     * @param number the number
     */
    public void increase(int number) {
        int count = this.counter;
        count = count + number;
        this.counter = count;
    }

    /**
     * Decrease.subtract number from current count.
     *
     * @param number the number
     */
    public void decrease(int number) {
        int count = this.counter;
        count = count - number;
        this.counter = count;
    }

    /**
     * Gets value.
     *
     * @return the value counter.
     */
    public int getValue() {
        return this.counter;
    }
}
