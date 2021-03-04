/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-29\4\2020
 * version-13.0.2
 */
package decorationgame;


import biuoop.DrawSurface;
import interfacegame.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Instantiates a new Sprite collection.created a new ArrayList of sprites.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * Add sprite.add a sprite to the list.
     *
     * @param s the s Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Notify all time passed.call all the sprites and tall them the timePass.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprite = new ArrayList<>(this.sprites);
        for (Sprite c : sprite) {
            c.timePassed();
        }
    }

    /**
     * Draw all on.call of the sprites and draw them on the screen.
     *
     * @param d the d DrawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> sprite = new ArrayList<>(this.sprites);
        for (Sprite c : sprite) {
            c.drawOn(d);
        }
    }

    /**
     * Gets sprites.return the list of the SpriteCollection.
     *
     * @return the sprites list.
     */
    public List<Sprite> getSprites() {
        return sprites;
    }
}
