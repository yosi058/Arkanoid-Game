package menu;

import biuoop.DrawSurface;
import decorationgame.Counter;
import interfacegame.Animation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HighScoresAnimation implements Animation {
    private Counter counter;

    public HighScoresAnimation(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Height scores:" + checkHeightScore(), 32);
    }

    public int checkHeightScore() {
        Path path = Paths.get("hightscores.txt");
        try {
            File file = new File(String.valueOf(path));
            if (!file.exists()) {
                FileWriter myWriter = new FileWriter(file);
                myWriter.write("The height score so far is:" + counter.getValue());
                myWriter.close();
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                String[] lines = line.split(":");
                String part2 = lines[1];
                int score = Integer.parseInt(part2);
                if (counter.getValue() > score) {
                    FileWriter myWriter = new FileWriter(file);
                    myWriter.write("The height score so far is:" + counter.getValue());
                    myWriter.close();
                }else{
                    return score;
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return counter.getValue();
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}