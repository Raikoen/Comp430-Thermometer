package src;

import java.io.IOException;

public class Main
{
  public static void main(String[] args) throws IOException, InterruptedException {
    TempLog tempLog = new TempLog();
    tempLog.createLogFile();
    ThermometerSystem thermometer = new ThermometerSystem();
    thermometer.clearConsole();
    thermometer.mainMenu();

  }
}
