/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-26\5\2020
 * version-13.0.2
 */
package interfacegame;

/**
 * The interface Hit notifier.
 */
public interface HitNotifier {
    /**
     * Add hit listener.Add hl as a listener to hit events.
     *
     * @param hl the hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener.Remove hl from the list of listeners to hit events.
     *
     * @param hl the hl
     */
    void removeHitListener(HitListener hl);
}
