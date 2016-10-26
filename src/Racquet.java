import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class Racquet {
  private int x;
  private static final int WITH = 10;
  private static final int HEIGHT = 60;
  int y = 150;
  int ya = 0;
  private Game game;
  public Racquet(Game game, int x) {
    this.game = game;
    this.x = x;
  }
  public void move() {
    if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT)
      y = y + ya;
  }
  public void paint(Graphics2D g) {
    g.fillRect(x, y, WITH, HEIGHT);
  }
  public void keyReleased(KeyEvent e) {
    ya = 0;
  }
  public void keyPressed(KeyEvent e) {
    if (x == 650){
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
      ya = game.speed;
    if (e.getKeyCode() == KeyEvent.VK_UP)
      ya = -game.speed;
    }
    else{
    if (e.getKeyCode() == KeyEvent.VK_S)
      ya = game.speed;
    if (e.getKeyCode() == KeyEvent.VK_W)
      ya = -game.speed;
    }
  }
  public Rectangle getBounds() {
    return new Rectangle(x, y, WITH, HEIGHT);
  }
  public int getTopX() {
    return x - WITH;
  }
  public int getBotX() {
    return WITH;
  }
}