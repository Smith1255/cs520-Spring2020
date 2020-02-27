import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

/**
 * Java implementation of the 3 in a row game, using the Swing framework.
 *
 * This quick-and-dirty implementation violates a number of software engineering
 * principles and needs a thorough overhaul to improve readability,
 * extensibility, and testability.
 */
public class GameController {
    public static final String GAME_END_NOWINNER = "Game ends in a draw";


    private GameModel gameData;
    private GameView gameView;

    /**
     * The current player taking their turn
     */
    public String player = "1";


    /**
     * Creates a new game initializing the GUI.
     */
    public GameController() {
        gameData = new GameModel();
        gameView = new GameView();

        for(int row = 0; row<3; row++) {
            for(int col = 0; col<3 ;col++) {
                gameView.updateBlock(row,col, gameData.getBlockContents(row, col), gameData.isBlockLegalMove(row, col));
                //game.add(blocks[row][col]);
            }
        }

        gameView.getResetButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int col = 0; col<3 ;col++) {
                gameView.getGuiBlock(row,col).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        move((JButton)e.getSource());
                    }
                });
            }
        }
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    protected void move(JButton block) {
        int movesLeft = gameData.decrementMovesLeft();
        if(gameData.getMovesLeft() % 2 == 1) {
            gameView.setPlayerturnText("'X': Player 1");
        } else{
            gameView.setPlayerturnText("'O': Player 2");
        }

        if(player.equals("1")) {
            // Check whether player 1 won
            if(block==gameView.getGuiBlock(0,0)) {
                gameData.setBlockContents(0, 0, "X");
                gameData.setBlockIsLegalMove(0, 0, false);
                updateViewBlock(0, 0);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(0,1)) {
                gameData.setBlockContents(0, 1, "X");
                gameData.setBlockIsLegalMove(0,1,false);
                updateViewBlock(0, 1);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(0,2)) {
                gameData.setBlockContents(0, 2, "X");
                gameData.setBlockIsLegalMove(0,2,false);
                updateViewBlock(0, 2);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(1,0)) {
                gameData.setBlockContents(1, 0, "X");
                gameData.setBlockIsLegalMove(1,0,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(0,0,true);
                updateViewBlock(1, 0);
                updateViewBlock(0, 0);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(1,1)) {
                gameData.setBlockContents(1, 1, "X");
                gameData.setBlockIsLegalMove(1,1,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(0,1,true);
                updateViewBlock(1, 1);
                updateViewBlock(0, 1);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(1,2)) {
                gameData.setBlockContents(1, 2, "X");
                gameData.setBlockIsLegalMove(1,2,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(0,2,true);
                updateViewBlock(1, 2);
                updateViewBlock(0, 2);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(2, 0)) {
                gameData.setBlockContents(2, 0, "X");
                gameData.setBlockIsLegalMove(2,0,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(1,0,true);
                updateViewBlock(2, 0);
                updateViewBlock(1, 0);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(2, 1)) {
                gameData.setBlockContents(2, 1, "X");
                gameData.setBlockIsLegalMove(2,1,false);
                // Enabled the space on top of this one
                gameData.setBlockIsLegalMove(1,1,true);
                updateViewBlock(2, 1);
                updateViewBlock(1, 1);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(2, 2)) {
                gameData.setBlockContents(2, 2, "X");
                gameData.setBlockIsLegalMove(2,2,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(1,2,true);
                updateViewBlock(2, 2);
                updateViewBlock(1, 2);
                player = "2";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 1 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            }
        } else {
            // Check whether player 2 won
            if(block==gameView.getGuiBlock(0,0)) {
                gameData.setBlockContents(0, 0, "O");
                gameData.setBlockIsLegalMove(0,0,false);
                updateViewBlock(0, 0);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(0,1)) {
                gameData.setBlockContents(0, 1, "O");
                gameData.setBlockIsLegalMove(0,1,false);
                updateViewBlock(0, 1);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(0,2)) {
                gameData.setBlockContents(0, 2, "O");
                gameData.setBlockIsLegalMove(0,2,false);
                updateViewBlock(0, 2);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(1,0)) {
                gameData.setBlockContents(1, 0, "O");
                gameData.setBlockIsLegalMove(1,0,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(0,0,true);
                updateViewBlock(1, 0);
                updateViewBlock(0, 0);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(1,1)) {
                gameData.setBlockContents(1, 1, "O");
                gameData.setBlockIsLegalMove(1,1,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(0,1,true);
                updateViewBlock(1, 1);
                updateViewBlock(0, 1);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(1,2)) {
                gameData.setBlockContents(1, 2, "O");
                gameData.setBlockIsLegalMove(1,2,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(0,2,true);
                updateViewBlock(1, 2);
                updateViewBlock(0, 2);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(2, 0)) {
                gameData.setBlockContents(2, 0, "O");
                gameData.setBlockIsLegalMove(2,0,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(1,0,true);
                updateViewBlock(2, 0);
                updateViewBlock(1, 0);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(2, 1)) {
                gameData.setBlockContents(2, 1, "O");
                gameData.setBlockIsLegalMove(2,1,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(1,1,true);
                updateViewBlock(2, 1);
                updateViewBlock(1, 1);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            } else if(block==gameView.getGuiBlock(2, 2)) {
                gameData.setBlockContents(2, 2, "O");
                gameData.setBlockIsLegalMove(2,2,false);
                // Enable the space on top of this one
                gameData.setBlockIsLegalMove(1,2,true);
                updateViewBlock(2, 2);
                updateViewBlock(1, 2);
                player = "1";
                if(movesLeft<7) {
                    if(checkWin(block)) {
                        gameView.setPlayerturnText("Player 2 wins!");
                        gameView.endGame();
                    } else if(movesLeft==0) {
                        gameView.setPlayerturnText(GAME_END_NOWINNER);
                    }
                }
            }
        }
    }

    /**
     * Checks to see if the game has been won and
     * reports which player has won if the game is over
     *
     * @param block The JButton object that corresponds to the block in blocksData
     * @return boolean Returns whether a player has won or not
     */
    protected boolean checkWin(JButton block) {
        if (block==gameView.getGuiBlock(0,0)) {
            if ((gameData.getBlockContents(0,0).equals(gameData.getBlockContents(0,1)) &&
                    gameData.getBlockContents(0,1).equals(gameData.getBlockContents(0,2))) ||
                    (gameData.getBlockContents(0,0).equals(gameData.getBlockContents(1,0)) &&
                            gameData.getBlockContents(1,0).equals(gameData.getBlockContents(2,0))) ||
                    (gameData.getBlockContents(0,0).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(2,2)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(0,1)) {
            if ((gameData.getBlockContents(0,1).equals(gameData.getBlockContents(0,0)) &&
                    gameData.getBlockContents(0,0).equals(gameData.getBlockContents(0,2))) ||
                    (gameData.getBlockContents(0,1).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(2,1)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(0,2)) {
            if ((gameData.getBlockContents(0,2).equals(gameData.getBlockContents(0,1)) &&
                    gameData.getBlockContents(0,1).equals(gameData.getBlockContents(0,0))) ||
                    (gameData.getBlockContents(0,2).equals(gameData.getBlockContents(1,2)) &&
                            gameData.getBlockContents(1,2).equals(gameData.getBlockContents(2,2))) ||
                    (gameData.getBlockContents(0,2).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(2,0)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(1,0)) {
            if ((gameData.getBlockContents(1,0).equals(gameData.getBlockContents(1,1)) &&
                    gameData.getBlockContents(1,1).equals(gameData.getBlockContents(1,2))) ||
                    (gameData.getBlockContents(1,0).equals(gameData.getBlockContents(0,0)) &&
                            gameData.getBlockContents(0,0).equals(gameData.getBlockContents(2,0)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(1,1)) {
            if ((gameData.getBlockContents(1,1).equals(gameData.getBlockContents(1,0)) &&
                    gameData.getBlockContents(1,0).equals(gameData.getBlockContents(1,2))) ||
                    (gameData.getBlockContents(1,1).equals(gameData.getBlockContents(0,1)) &&
                            gameData.getBlockContents(0,1).equals(gameData.getBlockContents(2,1))) ||
                    (gameData.getBlockContents(1,1).equals(gameData.getBlockContents(0,0)) &&
                            gameData.getBlockContents(0,0).equals(gameData.getBlockContents(2,2))) ||
                    (gameData.getBlockContents(1,1).equals(gameData.getBlockContents(0,2)) &&
                            gameData.getBlockContents(0,2).equals(gameData.getBlockContents(2,0)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(1,2)) {
            if ((gameData.getBlockContents(1,2).equals(gameData.getBlockContents(0,2)) &&
                    gameData.getBlockContents(0,2).equals(gameData.getBlockContents(2,2))) ||
                    (gameData.getBlockContents(1,2).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(1,0)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(2, 0)) {
            if ((gameData.getBlockContents(2,0).equals(gameData.getBlockContents(2,1)) &&
                    gameData.getBlockContents(2,1).equals(gameData.getBlockContents(2,2))) ||
                    (gameData.getBlockContents(2,0).equals(gameData.getBlockContents(1,0)) &&
                            gameData.getBlockContents(1,0).equals(gameData.getBlockContents(0,0))) ||
                    (gameData.getBlockContents(2,0).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(0,2)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(2, 1)) {
            if ((gameData.getBlockContents(2,1).equals(gameData.getBlockContents(2,0)) &&
                    gameData.getBlockContents(2,0).equals(gameData.getBlockContents(2,2))) ||
                    (gameData.getBlockContents(2,1).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(0,1)))) {
                return true;
            }
        }
        else if (block==gameView.getGuiBlock(2, 2)) {
            if ((gameData.getBlockContents(2,2).equals(gameData.getBlockContents(2,1)) &&
                    gameData.getBlockContents(2,1).equals(gameData.getBlockContents(2,0))) ||
                    (gameData.getBlockContents(2,2).equals(gameData.getBlockContents(1,2)) &&
                            gameData.getBlockContents(1,2).equals(gameData.getBlockContents(0,2))) ||
                    (gameData.getBlockContents(2,2).equals(gameData.getBlockContents(1,1)) &&
                            gameData.getBlockContents(1,1).equals(gameData.getBlockContents(0,0)))) {
                return true;
            }
        }
        return false; //No win found
    }

    /**
     * Updates the block at the given row and col
     * after one of the player's moves.
     *
     * @param row The row that contains the block
     * @param col The col that contains the block
     */
    protected void updateViewBlock(int row, int col) {
        gameView.updateBlock(row,col, gameData.getBlockContents(row, col), gameData.isBlockLegalMove(row, col));
        gameView.updateBlock(row,col, gameData.getBlockContents(row, col), gameData.isBlockLegalMove(row, col));
    }

    

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        gameData.resetGame();
        for(int row = 0;row<3;row++) {
            for(int col = 0;col<3;col++) {
                updateViewBlock(row,col);
            }
        }
        player = "1";
        gameView.setPlayerturnText("Player 1 to play 'X'");
    }

    /**
     * Sets game visibility
     *
     * @param isVisible Sets the visibility of the view
     */
    public void setGuiVisibility(boolean isVisible) {
        gameView.setGuiVisibility(isVisible);
    }
}
