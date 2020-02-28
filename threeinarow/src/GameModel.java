
/**
 * Java implementation of the Model component of the ThreeInARowGame
 */
public class GameModel {

    private ThreeInARowBlock[][] blocksData = new ThreeInARowBlock[3][3];

    private int movesLeft;



    /**
     * Creates a new game model.
     */
    public GameModel() {
        movesLeft = 9;

        // Initialize a block for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int col = 0; col<3 ;col++) {
                blocksData[row][col] = new ThreeInARowBlock();
                // The last row contains the legal moves
                blocksData[row][col].setIsLegalMove(row == 2);
            }
        }
    }


    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int col = 0;col<3;col++) {
                blocksData[row][col].reset();
                // Enable the bottom row
                blocksData[row][col].setIsLegalMove(row == 2);
            }
        }
        movesLeft = 9;
    }

    /**
     * Returns the blocksData object, which holds the current state of the game
     *
     * @return ThreeInARowBlock Returns the blocksData object
     */
    public ThreeInARowBlock[][] getBlockData() {
        return blocksData;
    }

    /**
     * Returns a block at the given row/col
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @return ThreeInARowBlock Returns the specific block object
     */
    public ThreeInARowBlock getBlock(int row, int col) {
        return blocksData[row][col];
    }

    /**
     * Returns the number of moves left in the game
     *
     * @return int Number of moves left
     */
    public int getMovesLeft() {
        return movesLeft;
    }

    /**
     * Decrements the number of moves left in the game and returns the new value
     *
     * @return int Number of moves left minus one
     */
    public int decrementMovesLeft() {
        if (movesLeft == 0) return 0;

        return --movesLeft;
    }

    /**
     * Returns whether move is valid on the given block
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @return boolean The legality of moving into the block
     */
    public boolean isBlockLegalMove(int row, int col) {
        return blocksData[row][col].getIsLegalMove();
    }

    /**
     * Sets the isValid property in the specified block
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @param isLegal Whether or not this block is allowing moves into it
     */
    public void setBlockIsLegalMove(int row, int col, boolean isLegal) {
        blocksData[row][col].setIsLegalMove(isLegal);
    }

    /**
     * Returns the contents in the given block
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @return String The contents of the block
     */
    public String getBlockContents(int row, int col) {
        return blocksData[row][col].getContents();
    }

    /**
     * Sets the contents in the specified block
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @param contents The contents to update the block with
     */
    public void setBlockContents(int row, int col, String contents) {
        blocksData[row][col].setContents(contents);
    }




}
