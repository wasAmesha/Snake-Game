package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameOverPage extends JPanel {

    private Image gameOverImage;
    private JButton tryAgainButton;
    private JButton exitButton;
    private SnakeGame snakeGame;
    private int score;

    public GameOverPage(SnakeGame snakeGame, int score) {
        this.snakeGame = snakeGame;
        this.score = score;
        setPreferredSize(new Dimension(500, 450));
        setBackground(Color.BLACK);

        // Load Game Over image
        loadGameOverImage();

        // Initialize and configure the Try Again button
        tryAgainButton = new JButton("Try Again");
        tryAgainButton.setFocusable(false);
        tryAgainButton.setBackground(Color.WHITE);
        tryAgainButton.setForeground(Color.BLACK);
        tryAgainButton.setFont(new Font("Arial", Font.BOLD, 16)); // Change font size
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.showGame();
            }
        });

        // Initialize and configure the Exit button
        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16)); // Change font size
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });

        // Set layout and position the components
        setLayout(new BorderLayout());

        // Add the Game Over image to the center
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(gameOverImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(500, 300));
        add(imagePanel, BorderLayout.CENTER);

        // Create a panel for the score
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.BLACK);
        JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Font size for the score
        scorePanel.add(scoreLabel);
        add(scorePanel, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2)); // Use GridLayout to fit buttons
        buttonPanel.setPreferredSize(new Dimension(500, 50)); // Adjust height as needed

        // Add buttons to the panel
        buttonPanel.add(tryAgainButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadGameOverImage() {
        ImageIcon gameOverIcon = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/over.jpeg"));
        if (gameOverIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            gameOverImage = gameOverIcon.getImage();
        } else {
            System.out.println("Game Over image not found or failed to load.");
            // Optionally set a default image if the actual image is missing
            gameOverImage = new BufferedImage(500, 300, BufferedImage.TYPE_INT_ARGB);
        }
    }
}
