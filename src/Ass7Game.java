/*
 * Id:208486365.
 * email-Yosefnatanb@gmail.com
 * date-16\6\2020
 * version-13.0.2
 */


import baselevel.GameLevel;
import biuoop.GUI;
import decorationgame.Counter;
import interfacegame.LevelInformation;
import interfacegame.Menu;
import interfacegame.Task;
import levels.DirectHit;
import levels.FinalFour;
import levels.Green3;
import levels.WideEasy;
import menu.HighScoresAnimation;
import menu.MenuAnimation;
import menu.QuitGame;
import menu.RunGame;
import menu.ShowHiScoresTask;
import rungame.AnimationRunner;
import rungame.GameFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Ass 5 game.
 */
public class Ass7Game {
    /**
     * The constant EQUAL.
     */
    private static final String[] EQUAL = {"1", "2", "3", "4"};
    /**
     * The constant PER_SECOND.
     */
    private static final int PER_SECOND = 60;

    /**
     * The entry point of application. create a new game and run it.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Counter counter = new Counter(0);
        GUI gui = new GUI(" Arkanoid", GameLevel.WIDTH_OF_GUI, GameLevel.HEIGHT_OF_GUI);
        AnimationRunner runner = new AnimationRunner(gui, PER_SECOND);
        List<LevelInformation> levelInf = new ArrayList<>();
        GameFlow game = new GameFlow(runner, gui.getKeyboardSensor(), counter);
        LevelInformation[] level = getLevelInf();
        for (String arg : args) {
            if (Arrays.asList(EQUAL).contains(arg)) {
                LevelInformation l = level[Integer.parseInt(arg) - 1];
                levelInf.add(l);
            }
        }
        if (levelInf.isEmpty()) {
            levelInf.addAll(Arrays.asList(level));
        }
        Menu<Task<Void>> menu = new MenuAnimation<>("Menu Title", gui.getKeyboardSensor());
        menu.addSelection("h", "Height scores",
                new ShowHiScoresTask(runner, new HighScoresAnimation(counter), gui.getKeyboardSensor()));
        menu.addSelection("q", "Quit", new QuitGame(gui));
        menu.addSelection("s", "Start - Game",
                new RunGame(levelInf, game, runner, gui.getKeyboardSensor(), counter));
        while (true) {
            runner.run(menu);
            Task<Void> task = menu.getStatus();
            task.run();
        }
    }

    /**
     * @return LevelInformation[]
     */

    private static LevelInformation[] getLevelInf() {
        LevelInformation[] level = new LevelInformation[4];
        level[0] = new DirectHit();
        level[1] = new WideEasy();
        level[2] = new Green3();
        level[3] = new FinalFour();
        return level;
    }

}