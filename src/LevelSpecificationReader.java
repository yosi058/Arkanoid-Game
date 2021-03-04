/*
import baselevel.Block;
import biuoop.DrawSurface;
import decorationgame.Velocity;
import interfacegame.LevelInformation;
import interfacegame.Sprite;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LevelSpecificationReader implements LevelInformation {
    private LinkedList<Velocity> velocities = new LinkedList<>();
    private LinkedList<Block> blocks = new LinkedList<>();
    private int numOfBalls = 1;
    private int paddleSpeed = 0;
    private int paddleWidth = 0;
    private int numOfBlocksLeft = 0;
    private String levelName = null;
    private Sprite backRound = null;

    public List<LevelInformation> fromReader(java.io.Reader reader) {
        LinkedList<LevelInformation> levelInformationLinkedList = new LinkedList<>();
        try {
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            while (line != null) {
                if (!line.contains(":")) {
                    continue;
                } else {
                    String[] words = line.split(":");
                    switch (words[0]) {
                        case "level_name":
                            this.levelName = words[1];
                            break;
                        case "ball_velocities":
                            String[] parts = words[1].split(" ");
                            for (String s : parts) {
                                String[] speedAndAngle = s.split(",");
                                Velocity v = new Velocity(Integer.parseInt(speedAndAngle[0]),
                                        Integer.parseInt(speedAndAngle[1]));
                                this.velocities.add(v);
                            }
                            break;
                        case "background":
                            this.backRound = new Sprite() {
                                @Override
                                public void drawOn(DrawSurface d) {
                                    d.setColor(Color.decode(words[1]));
                                    d.fillRectangle(0, 0, 800, 600);
                                }

                                @Override
                                public void timePassed() {
                                }
                            };
                            break;
                        case "paddle_speed":
                            this.paddleSpeed = Integer.parseInt(words[1]);
                            break;
                        case "paddle_width":
                            this.paddleWidth = Integer.parseInt(words[1]);
                            break;
                        case "block_definitions":
                            String[] textFile = words[1].split("/");
                            File file = new File(textFile[1]);
                            FileReader fileReader = new FileReader(file);
                            BlocksDefinitionReader.fromReader(fileReader);
                            break;
                        case "num_blocks":
                            this.numOfBlocksLeft = Integer.parseInt(words[1]);
                            break;
                        case "END_LEVEL":
                            levelInformationLinkedList.add(this);
                            break;
                    }
                }
                line = buffer.readLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Override
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.backRound;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numOfBlocksLeft;
    }
}

 */

