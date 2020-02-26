/**
 * The ThreeInARowBlock class represents a given block in the game.
 */
public class ThreeInARowBlock
{

    /**
     * The current value of the contents of this block
     */
    private String contents;

    /**
     * Whether or not it is currently legal to move into this block
     */
    private boolean isLegalMove;

    /**
     * Creates a new block
     *
     * @throws IllegalArgumentException When the given game is null
     */
    public ThreeInARowBlock() {
        contents = "";
        isLegalMove = false;
        this.reset();
    }


    /**
     * Sets the contents of this block to the given value.
     *
     * @param value The new value for the contents of this block
     * @throws IllegalArgumentException When the given value is null
     */
    public void setContents(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Contents must be non-null.");
        }
        this.contents = value;
    }

    /**
     * Returns the non-null String value of the contents of this block.
     *
     * @return The non-null String value
     */
    public String getContents() {
        return this.contents;
    }

    public void setIsLegalMove(boolean isLegalMove) {
        this.isLegalMove = isLegalMove;
    }

    public boolean getIsLegalMove() {
        return this.isLegalMove;
    }

    /**
     * Resets this block before starting a new game.
     */
    public void reset() {
        this.contents = "";
        this.isLegalMove = false;
    }
}
