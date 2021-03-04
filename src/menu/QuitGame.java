package menu;

import biuoop.GUI;
import interfacegame.Task;

public class QuitGame implements Task<Void> {
    private GUI gui;

    public QuitGame(GUI gui) {
        this.gui = gui;
    }

    @Override
    public Void run() {
        this.gui.close();
        return null;
    }
}
