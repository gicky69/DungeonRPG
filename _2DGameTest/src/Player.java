import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Random;

public class Player implements KeyListener {
    JLabel Player;
    int playerX = 400;
    int playerY = 300;
    int playerSpeed = 5;
    int directionX = 0;
    int directionY = 0;

    CoinPanel CoinPanel;

    Random random = new Random();

    CoinClass Coin;

    public Player(JFrame Frame) {
        CoinPanel = new CoinPanel(Frame);
        Coin = new CoinClass(Frame, this);
        Player = new JLabel("X");
        Player.setBounds(playerX,playerY,50,50);
        Frame.addKeyListener(this);
        Coin.Coin.setBounds(Coin.coinX, Coin.coinY, 50, 50);
    }

    public void update() {
        playerX += directionX;
        playerY += directionY;
        Player.setBounds(playerX, playerY, 50, 50);

        // If Player Touches Coin
        if (playerX >= Coin.coinX && playerX <= Coin.coinX + 15 && playerY >= Coin.coinY && playerY <= Coin.coinY + 15) {
            Coin.coinX = random.nextInt(500);
            Coin.coinY = random.nextInt(500);
            Coin.Coin.setBounds(Coin.coinX, Coin.coinY, 50, 50);
            CoinPanel.CoinsCollected++;
            CoinPanel.update();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if (KeyCode == KeyEvent.VK_UP) {
            directionY = -playerSpeed;
        } else if (KeyCode == KeyEvent.VK_DOWN) {
            directionY = playerSpeed;
        } else if (KeyCode == KeyEvent.VK_LEFT) {
            directionX = -playerSpeed;
        } else if (KeyCode == KeyEvent.VK_RIGHT) {
            directionX = playerSpeed;
        }

        if (KeyCode == KeyEvent.VK_W){
            directionY = -playerSpeed / 2;
        } else if (KeyCode == KeyEvent.VK_S) {
            directionY = playerSpeed / 2;
        } else if (KeyCode == KeyEvent.VK_A) {
            directionX = -playerSpeed / 2;
        } else if (KeyCode == KeyEvent.VK_D) {
            directionX = playerSpeed / 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if (KeyCode == KeyEvent.VK_UP || KeyCode == KeyEvent.VK_DOWN) {
            directionY = 0;
        } else if (KeyCode == KeyEvent.VK_LEFT || KeyCode == KeyEvent.VK_RIGHT) {
            directionX = 0;
        }

        // Slow Movement

        if (KeyCode == KeyEvent.VK_W || KeyCode == KeyEvent.VK_S) {
            directionY = 0;
        } else if (KeyCode == KeyEvent.VK_A || KeyCode == KeyEvent.VK_D) {
            directionX = 0;
        }
    }
}