import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Java implementation of the View component of the ThreeInARowGame
 */
public class GameView {

    private JFrame gui = new JFrame("Three in a Row");
    private JButton[][] blocks = new JButton[3][3];
    private JButton reset = new JButton("Reset");
    private JTextArea playerturn = new JTextArea();

    /**
     * Creates a new game initializing the GUI.
     */
    public GameView() {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int col = 0; col<3 ;col++) {
                blocks[row][col] = new JButton();
                blocks[row][col].setPreferredSize(new Dimension(75,75));
                game.add(blocks[row][col]);
            }
        }
    }

    /**
     * Updates the block at the given row and col
     * after one of the player's moves.
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @param newText The text to update the gameView block object with
     * @param isLegalMove Whether or not this block is allowing moves into it
     */
    protected void updateBlock(int row, int col, String newText, boolean isLegalMove) {
        blocks[row][col].setText(newText);
        blocks[row][col].setEnabled(isLegalMove);
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
        for(int row = 0;row<3;row++) {
            for(int col = 0;col<3;col++) {
                blocks[row][col].setEnabled(false);
            }
        }
    }

    /**
     * Returns the GUI block data
     *
     * @return JButton[][]
     */
    public JButton[][] getGuiBlocks() {
        return blocks;
    }

    /**
     * Returns a JButton block at the given row/col
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     * @return JButton
     */
    public JButton getGuiBlock(int row, int col) {
        return blocks[row][col];
    }

    /**
     * Returns the reset JButton
     * @return JButton The Reset JButton
     */
    public JButton getResetButton() {
        return reset;
    }

    /**
     * Set the Jtextarea playerturn string contents
     *
     * @param newText The new text to update the playerturn label with
     */
    public void setPlayerturnText(String newText) {
        playerturn.setText(newText);
    }

    /**
     * Get the Jtextarea playerturn string contents
     *
     * @return String The text in the playerturn property
     */
    public String getPlayerturnText() {
        return playerturn.getText();
    }

    /**
     * Sets the visibility of the GUI
     *
     * @param isVisible Sets the visibility of the view
     */
    public void setGuiVisibility(boolean isVisible) {
        gui.setVisible(isVisible);
    }

    /**
     * Gets the visibility of the GUI
     *
     * @return boolean Whether or not the GUI is visible
     */
    public boolean getGuiVisibility() {
        return gui.isDisplayable();
    }

}
