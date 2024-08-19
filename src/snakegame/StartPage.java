package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JPanel {
    private Image logo;
    private JButton startButton;
    private SnakeGame snakeGame;

    public StartPage(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);

        // Load and resize logo image
        loadLogo();

        // Initialize and add the start button
        startButton = new JButton("Start Game");
        startButton.setFocusable(false);
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.setPreferredSize(new Dimension(150, 40));
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeGame.showGame();
            }
        });

        setLayout(new BorderLayout());

        // Create an ImageIcon with the scaled logo
        ImageIcon logoIcon = new ImageIcon(logo);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        add(logoLabel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    private void loadLogo() {
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/snake-game.png"));
        logo = logoIcon.getImage();

        // Resize the image to fit the panel or desired dimensions
        int width = getPreferredSize().width;
        int height = getPreferredSize().height;
        logo = logo.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
