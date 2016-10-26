import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Game extends JPanel {
  Ball ball = new Ball(this);//creates ball
  Racquet racquet = new Racquet(this, 650);//creates racquet
  Racquet racquet2 = new Racquet(this, 30);
  int speed = 1;//initial speed
  int p1Score;
  int p2Score;
  boolean state = true;
  
  private int getScoreP1() { //considering if this is still needed
    return p1Score;
  }
  private int getScoreP2() { //considering if this is still needed
    return p2Score;
  }
  
  public Game() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
        racquet.keyReleased(e);
        racquet2.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
        racquet.keyPressed(e);
        racquet2.keyPressed(e);
      }
    });
    setFocusable(true);
    Sound.BACK.loop();//i was the idiot all along
  }
  
  private void move() {
    ball.move();
    racquet.move();
    racquet2.move();
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(Color.GRAY);
    g2d.setFont(new Font("Verdana", Font.BOLD, 30));
    g2d.drawString("|", 330, 30);//NET
    g2d.drawString("|", 330, 60);
    g2d.drawString("|", 330, 90);
    g2d.drawString("|", 330, 120);
    g2d.drawString("|", 330, 150);
    g2d.drawString("|", 330, 180);
    g2d.drawString("|", 330, 210);
    g2d.drawString("|", 330, 240);
    g2d.drawString("|", 330, 270);
    g2d.drawString("|", 330, 300);
    g2d.drawString("|", 330, 330);
    g2d.drawString("|", 330, 360);
    g2d.drawString("|", 330, 390);
    g2d.setColor(Color.MAGENTA);//color of ball
    ball.paint(g2d);
    g2d.setColor(Color.BLUE);//player2
    racquet.paint(g2d);
    g2d.setColor(Color.RED);//player1
    racquet2.paint(g2d);
    g2d.setColor(Color.GREEN);
    g2d.setFont(new Font("Verdana", Font.BOLD, 30));
    g2d.drawString(String.valueOf(getScoreP2()), 630, 30);//scores
    g2d.drawString(String.valueOf(getScoreP1()), 10, 30);
  }
  
  public void gameOver(int i) {//need to modify for replay
    Sound.BACK.stop();
    Sound.GAMEOVER.play();
    int n = JOptionPane.showConfirmDialog(this,"Rematch?","Player" + String.valueOf(i) + " wins!", JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION){
    	reset();
    }
    else{
    	System.exit(ABORT);
    }
  }
  
  public void checkWinner(){ //checks who wins
    if (p1Score == 3){
      gameOver(1);
    }
    else if(p2Score == 3){
      gameOver(2);
    }
    else{
      //do nothing;
    }
  }
  
  public void reset(){
	  speed = 1;
	  ball = new Ball(this);
	  racquet = new Racquet(this, 650);
	  racquet2 = new Racquet(this, 30);
	  p1Score = 0;
	  p2Score = 0;
	  Sound.BACK.loop();
  }
  
  public void goal(){ //main purpose is to reset the game after a player scores;
    speed = 1;
    ball = new Ball(this);
    if(state == true){//for the new direction of the ball
      ball.xa = -ball.xa;
      state = false;
    }
    else if(state == false){
      ball.xa = ball.xa;
      state = true;
    }
  }
  
  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("All of the sound effects are recorded by me, PCTK");
    Game game = new Game();
    frame.add(game);
    frame.setSize(700, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    while (true) {
      game.move();
      game.repaint();
      game.checkWinner();
      Thread.sleep(10);
    }
  }
}