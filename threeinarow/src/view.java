import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;

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

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
            }
        }
    }

    /**
     * Updates the block at the given row and column
     * after one of the player's moves.
     *
     * @param row The row that contains the block
     * @param column The column that contains the block
     */
    protected void updateBlock(int row, int column, String newText, boolean isLegalMove) {
        blocks[row][column].setText(newText);
        blocks[row][column].setEnabled(isLegalMove);
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                blocks[row][column].setEnabled(false);
            }
        }
    }

    /**
     * Returns the GUI block data
     */
    public JButton[][] getGuiBlocks() {
        return blocks;
    }

    /**
     * Returns the JButton reset
     */
    public JButton getResetButton() {
        return reset;
    }

    /**
     * Set the Jtextarea playerturn string contents
     */
    public void setPlayerturnText(String newText) {
        playerturn = newText;
    }

    /**
     * Set the Jtextarea playerturn string contents
     */
    public void setGuiVisibility(boolean isVisible) {
        game.gui.setVisible(isVisible);
    }

}
