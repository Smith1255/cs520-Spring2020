import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private GameController game;
    private GameModel model;
    private GameView view;

    @Before
    public void setUp() {

        game = new GameController();
        model = new GameModel();
        view = new GameView();
    }

    @After
    public void tearDown() {
	game = null;
    }

    @Test
    public void testNewGame() {
        assertEquals ("1", game.getPlayer());
        assertEquals (9, game.getNumMovesLeft());
    }

    @Test
    public void testNoWin() {
        boolean[] moveResults;
        moveResults = game.chooseBlock(0, 0);
        assertEquals (moveResults[1], false);
        assertEquals (9, game.getNumMovesLeft());
    }

    @Test
    public void illegalMove() {
        boolean[] moveResults;
        moveResults = game.chooseBlock(0, 0);
        assertEquals (moveResults[0], false);
        assertEquals (9, game.getNumMovesLeft());
    }

    @Test
    public void legalMove() {
        boolean[] moveResults;
        moveResults = game.chooseBlock(2, 0);
        assertEquals (true, moveResults[0]);
        assertEquals (false, moveResults[1]);
        assertEquals (8, game.getNumMovesLeft());
    }

    @Test
    public void testDrawGame() {
        boolean[] moveResults;
        game.chooseBlock(2, 0); //Player 1
        game.chooseBlock(2,1); //Player 2
        game.chooseBlock(2,2); //Player 1
        game.chooseBlock(0, 2); //Player 2
        game.chooseBlock(2,2); //Player 1
        game.chooseBlock(1, 1); //Player 2
        game.chooseBlock(1, 0); //Player 1
        game.chooseBlock(1, 2); //Player 2
        game.chooseBlock(0, 1); //Player 1
        game.chooseBlock(0, 0); //Player 2
        moveResults = game.chooseBlock(0, 2); //Player 1

        assertEquals (true, moveResults[0]);
        assertEquals (true, moveResults[1]);
        assertEquals ("Draw", game.getWinner());
    }

    @Test
    public void testEndGameNoMoves() {
        boolean[] moveResults;
        game.chooseBlock(2, 0); //Player 1
        game.chooseBlock(2,1); //Player 2
        game.chooseBlock(2,2); //Player 1
        game.chooseBlock(0, 2); //Player 2
        game.chooseBlock(2,2); //Player 1
        game.chooseBlock(1, 1); //Player 2
        game.chooseBlock(1, 0); //Player 1
        game.chooseBlock(1, 2); //Player 2
        game.chooseBlock(0, 1); //Player 1
        game.chooseBlock(0, 0); //Player 2
        game.chooseBlock(0, 2); //Player 1

        assertEquals (0, game.getNumMovesLeft());

    }

    @Test
    public void testViewData() {
       assertEquals (false, view.getGuiVisibility());
       view.setGuiVisibility(true);
       assertEquals (true, view.getGuiVisibility());

       view.setPlayerturnText("Test");
       assertEquals ("Test", view.getPlayerturnText());
    }

    @Test
    public void testBlockData() {
        assertEquals (true, model.isBlockLegalMove(2,0));

        assertEquals (false, model.isBlockLegalMove(0,0));
        model.setBlockIsLegalMove(0,0, true);
        assertEquals (true, model.isBlockLegalMove(0,0));

        assertEquals (8, model.decrementMovesLeft());

        model.resetGame();
        assertEquals (true, model.isBlockLegalMove(2,0));
        assertEquals (false, model.isBlockLegalMove(0,0));
        assertEquals (9, model.getMovesLeft());

    }
}
