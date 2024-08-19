package snakegame;

import javax.swing.*;

public class SnakeGame extends JFrame {
    private Board board;
    private StartPage startPage;

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize and add the StartPage
        startPage = new StartPage(this);
        add(startPage);

        // Initialize the board (but don't add it yet)
        board = new Board(this);

        // Display the StartPage initially
        setVisible(true);
    }

    public void showGame() {
        // Remove all components and add the game board
        getContentPane().removeAll();
        board = new Board(this);
        add(board);
        board.requestFocusInWindow(); // Request focus for key events
        revalidate();
        repaint();
    }

    public void showGameOver(int score) {
        getContentPane().removeAll();
        add(new GameOverPage(this, score)); // Pass the score to the GameOverPage constructor
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new SnakeGame().setVisible(true);
    }
}
