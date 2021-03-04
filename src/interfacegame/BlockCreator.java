package interfacegame;

import baselevel.Block;

public interface BlockCreator {
    // Create a block at the specified location.
    Block create(int xpos, int ypos);
}
