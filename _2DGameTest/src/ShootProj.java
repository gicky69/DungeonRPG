import javax.swing.*;
import java.awt.*;

public class ShootProj {
    JLabel ShootProjectile;
    int x;
    int y;
    int width, height;
    int Xspeed = 0;
    int Yspeed = 0;

    public ShootProj(JFrame Frame) {
        ShootProjectile = new JLabel("o");
        ShootProjectile.setVisible(false);
        Frame.add(ShootProjectile);

        width = 10;
        height = 10;
    }

    public void update() {
        x = ShootProjectile.getX();
        y = ShootProjectile.getY();

        x += Xspeed;
        y += Yspeed;

        ShootProjectile.setBounds(x, y, width, height);
    }

    public void PlayerShoot(int playerX, int playerY, Player player) {
        ShootProjectile.setVisible(true);
        ShootProjectile.setBounds(playerX, playerY+18, width, height);

        Xspeed = player.directionX * 5;
        Yspeed = player.directionY * 5;

        if (Xspeed == 0 && Yspeed == 0) {
            Xspeed = 5;
        }
    }
}
