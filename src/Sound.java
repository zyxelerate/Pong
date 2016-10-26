import java.applet.Applet;
import java.applet.AudioClip;
public class Sound {
  public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("Click.wav"));
  public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("Yamete.wav"));
  public static final AudioClip SCORE = Applet.newAudioClip(Sound.class.getResource("Ping.wav"));
  public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("InTheJungle.wav"));//Background sound
}