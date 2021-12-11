package src;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Thermometer
{
  public void selfTest() throws InterruptedException {
    ThermometerSystem thermometer = new ThermometerSystem();
    beep();
  }
  public void beep() throws InterruptedException {
    Toolkit play = Toolkit.getDefaultToolkit();
    play.beep();
    Thread.sleep(300);
    play.beep();
  }
}