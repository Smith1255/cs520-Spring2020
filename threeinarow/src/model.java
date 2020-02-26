
/**
 * Java implementation of the Model component of the ThreeInARowGame
 */
public class GameModel {

    private ThreeInARowBlock[][] blocksData;

    private int movesLeft;


    /**
     * Creates a new game model.
     */
    public GameModel() {
        public int movesLeft = 9;
        blocksData = new ThreeInARowBlock[3][3];

        // Initialize a block for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocksData[row][column] = new ThreeInARowBlock();
                // The last row contains the legal moves
                blocksData[row][column].setIsLegalMove(row == 2);
            }
        }
    }


    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                blocksData[row][column].reset();
                // Enable the bottom row
                blocksData[row][column].setIsLegalMove(row == 2);
            }
        }
        movesLeft = 9;
    }

    /**
     * Returns the blocksData object, which holds the current state of the game
     */
    public ThreeInARowBlock[][] getBlockData() {
        return blocksData;
    }

    /**
     * Returns the number of moves left in the game
     */
    public int getMovesLeft() {
        return movesLeft;
    }

    /**
     * Returns the number of moves left in the game
     */
    public void decrementMovesLeft() {
        movesLeft--;
    }


}
