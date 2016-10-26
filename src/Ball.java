import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Ball {
  private static final int DIAMETER = 30;
  private int x;
  int y = 0;
  int xa = 1;
  int ya = 1;
  private Game game;
  public Ball(Game game) {
    this.game = game;
    this.x = 327;
  }
  void move() {
    boolean changeDirection = true;
    if (x + xa < 0){
      Sound.SCORE.play();
      ++game.p2Score;
      game.goal();
    }
    else if (x + xa > game.getWidth() - DIAMETER){
      Sound.SCORE.play();
      ++game.p1Score;
      game.goal();
    }
    else if (y + ya < 0)
      ya = game.speed;
    else if (y + ya > game.getHeight() - DIAMETER){
      ya = -game.speed;
    }
    else if (collision()){
      xa = -game.speed;
      x = game.racquet.getTopX() - DIAMETER;
      game.speed++;
    }
    else if (collision2()){
      xa = game.speed;
      x = game.racquet.getBotX() + DIAMETER;
      game.speed++;
    }
    else
      changeDirection = false;
    if (changeDirection){
      Sound.BALL.play();
    }
    y = y + ya;
    x = x + xa;
  }
  private boolean collision() {
    return game.racquet.getBounds().intersects(getBounds());
  }
  private boolean collision2() {
    return game.racquet2.getBounds().intersects(getBounds());
  }
  public void paint(Graphics2D g) {
    g.fillOval(x, y, DIAMETER, DIAMETER);
  }
  public Rectangle getBounds() {
    return new Rectangle(x, y, DIAMETER, DIAMETER);
  }
}
