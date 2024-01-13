import javax.swing.*;

public class Main implements Runnable {
    JFrame Frame;
    Player player;
    CoinClass Coin;
    Enemy enemy;

    Thread GameThread;

    public Main() {
        Frame = new JFrame();
        Frame.setSize(800,600);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(null);

        player = new Player(Frame);
        Frame.add(player.Player);

        Coin = new CoinClass(Frame, player);
        Frame.add(Coin.Coin);

        enemy = new Enemy(Frame);
        Frame.add(enemy.Enemy);

        Frame.setFocusable(true);
        Frame.requestFocusInWindow();

        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);

        start();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void start() {
        GameThread = new Thread(this);
        GameThread.start();
    }

    public void run() {
        while(GameThread != null) {
            player.update();
            player.Shoot.update();
            enemy.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}