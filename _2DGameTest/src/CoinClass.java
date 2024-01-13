import javax.swing.*;
import java.util.Random;

public class CoinClass {
    JLabel Coin;
    int coinX = 0;
    int coinY = 0;
    Player Player;
    Random random = new Random();

    public CoinClass(JFrame Frame, Player player) {
        Coin = new JLabel("O");

        coinX = random.nextInt(500);
        coinY = random.nextInt(500);

        this.Player = player;
        Frame.add(Coin);
    }
}