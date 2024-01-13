import javax.swing.*;
import java.util.Random;

public class Enemy {
    JLabel Enemy;
    int x;
    int y;
    int width, height;
    int Xspeed = 0;
    int Yspeed = 0;

    Random random = new Random();

    public Enemy(JFrame Frame) {
        Enemy = new JLabel("X");
        Frame.add(Enemy);

        SpawnEnemy();

        width = 20;
        height = 20;
    }

    public void update() {
        x = Enemy.getX();
        y = Enemy.getY();

        x += Xspeed;
        y += Yspeed;

        Enemy.setBounds(x, y, width, height);
    }

    public void SpawnEnemy() {
        Enemy.setVisible(true);

        int randomX = random.nextInt(2);
        int randomY = random.nextInt(2);

        Xspeed = 2;
        Yspeed = 2;
    }
}
