package menu;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfacegame.Menu;

import java.awt.Color;
import java.util.LinkedList;

public class MenuAnimation<T> implements Menu<T> {
    private String string;
    private KeyboardSensor keyboardSensor;
    private LinkedList<String> key = new LinkedList<>();
    private LinkedList<String> message = new LinkedList<>();
    private LinkedList<T> returnval = new LinkedList<>();
    private T temp;

    public MenuAnimation(String stringMenu, KeyboardSensor keyboardSensor) {
        this.string = stringMenu;
        this.keyboardSensor = keyboardSensor;
    }


    @Override
    public void addSelection(String key, String message, T returnVal) {
        this.key.add(key);
        this.message.add(message);
        this.returnval.add(returnVal);
    }

    @Override
    public T getStatus() {
        return this.temp;
    }

   @Override
    public void doOneFrame(DrawSurface d) {
        Random rand=new Random();
        final int radius = 4;
        d.setColor(Color.cyan);
        d.fillRectangle(0, 0, 800, 600);
        for (int i = 0; i < 100; i++) {
            Color randomColor = new Color(rand.nextInt(0xFFFFFF));
            int x1 = rand.nextInt(GameLevel.WIDTH_OF_GUI);
            int y1 = rand.nextInt(GameLevel.HEIGHT_OF_GUI);
            Ball ball = new Ball(x1, y1, radius, randomColor);
            ball.drawOn(d);
            d.setColor(Color.black);
             d.drawText(40, 150, "Welcome to the Arkanoid Game:\n  ", 42);
            d.drawText(10, 350, "Press h to get height score ", 32);
            d.drawText(10, 400, "Press s to start a game", 32);
            d.drawText(10, 450, "Press q to quit", 32);
        }
    }
  

    @Override
    public boolean shouldStop() {
        for (String s : key) {
            if (keyboardSensor.isPressed(s)) {
                if (s.equals("h")) {
                    temp = returnval.get(0);
                } else if (s.equals("q")) {
                    temp = returnval.get(1);
                } else {
                    temp = returnval.get(2);
                }
                return true;
            }
        }
        return false;
    }
}
