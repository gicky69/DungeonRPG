import javax.swing.*;

public class CoinPanel {
    JPanel CoinPanel;
    JLabel Coins;
    int CoinsCollected = 0;

    public CoinPanel(JFrame Frame) {
        CoinPanel = new JPanel();
        CoinPanel.setBounds(0,0,800,50);
        CoinPanel.setLayout(null);
        Frame.add(CoinPanel);

        Coins = new JLabel("Coins: " + CoinsCollected);
        Coins.setBounds(0,0,100,50);
        CoinPanel.add(Coins);
    }

    public void update() {
        Coins.setText("Coins: " + CoinsCollected);
    }
}
