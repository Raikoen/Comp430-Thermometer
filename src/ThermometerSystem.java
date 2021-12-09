import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ThermometerSystem {
  Scanner in = new Scanner(System.in);
  boolean isOn = false;
  double avgTemp;
  double feverTemp = 37.0;
  boolean feverDetected;
  int batteryStat = 80;
  char tempUnits = 'C';
  TimerTask task;
  Timer timer;

  public void mainMenu() {
    int input = 0;
    in = new Scanner(System.in);
    int timerRun = 0;
    while (input >= 0) {
      printScreen();
      if (isOn){
        if (timerRun == 0) {
          timerRun += 1;
        } else {
          timer.cancel();
        }
        setInactivityTimer();
      }
      System.out.println("==================");
      System.out.println("| 0 on/off       |");
      System.out.println("| 1 C/F          |");
      System.out.println("| 2 set fever    |");
      System.out.println("| 3 measure temp |");
      System.out.println("==================");
      System.out.print("Enter option: ");
      input = in.nextInt();
      clearConsole();
      switch (input) {
        case 0:
          turnOnOff();
          break;
        case 1:
          if(isOn) {
            convertTemp();
          }else{
            print_isOff_msg();
          }
          break;
        case 2:
          if(isOn) {
            int input2 = 0;
            while (input2 < 3) {
              printScreen();
              System.out.println("==========");
              System.out.println("| 1 up   |");
              System.out.println("| 2 down |");
              System.out.println("| 3 save |");
              System.out.println("==========");
              System.out.print("Enter option: ");
              input2 = in.nextInt();
              clearConsole();
              switch (input2) {
                case 1:
                  feverTemp = feverTemp + 0.5;
                case 2:
                  feverTemp = feverTemp - 0.5;
                default:
                  break;
              }
            }
          } else {
            print_isOff_msg();
          }
          break;
        case 3:
          if(isOn) {
            printScreen();
            measureTemp();
          }else{
            print_isOff_msg();
          }
          break;
        default:
          break;
      }
    }
  }

  public void setInactivityTimer() {
    task = new TimerTask() {
      public void run() {
        isOn = false;
        clearConsole();
        mainMenu();
        //in = new Scanner(System.in);
      }
    };
    timer = new Timer("Timer");
    int delay = 5000000; // msx1000=sec
    timer.schedule(task, delay);
  }

  public void turnOnOff() {
    if(isOn){
      isOn = false;
    } else{
      isOn = true;
    }
  }

  public void measureTemp(){
    Thermometer thermometer = new Thermometer();
    //random generated list of temp
    double []tempReadings = {203.9, 37.9, 36.3, 43.7, 35.7, 37, 38.8, 37.3, 44.9, 36.1};
    double sum = 0;
    for (double tempReading : tempReadings) {
      sum += tempReading;
    }
    avgTemp = sum/tempReadings.length;

      /*
      feverCalc() cannot be its own method, or the if statement using avgTemp and feverTemp does
      not yeild the correct results. It does result in the expecteed result when used this way,
      so that's what Nea and Kyle have decided to do

     */

    if(avgTemp >= feverTemp) {
      feverDetected = true;
    }
    if(feverDetected==true) {
      System.out.println("Fever Detected");
    }
    else {
      System.out.println("No Fever Detected");
    }

  }

  public void testFileReader() throws IOException {
    // File path is passed as parameter
    File file = new File(
            "TempReadingFiles/text_with_brackets.txt");

    // Note:  Double backquote is to avoid compiler
    // interpret words
    // like \test as \t (ie. as a escape sequence)

    // Creating an object of BufferedReader class
    BufferedReader br
            = new BufferedReader(new FileReader(file));

    // Declaring a string variable
    String st;
    // Consition holds true till
    // there is character in a string
    while ((st = br.readLine()) != null)

      // Print the string
      System.out.println(st);
  }

  public void convertTemp() {
    if(tempUnits == 'C') {
      tempUnits = 'F';
      avgTemp = (9.0/5.0) * avgTemp + 32;
      feverTemp = (9.0/5.0) * feverTemp + 32;
    } else {
      tempUnits = 'C';
      avgTemp = (5.0/9.0) * (avgTemp - 32);
      feverTemp = (5.0/9.0) * (feverTemp - 32);
    }
  }

  public void clearConsole(){
    int blanks = 30;
    int i = 0;
    while (i < blanks){
      System.out.println();
      i++;
    }
  }

  public void print_isOff_msg(){
    System.out.println("************************************");
    System.out.println("* Turn thermometer on before using *");
    System.out.println("************************************");
  }

  public void printScreen(){
    int screenWidth = 29;
    System.out.println("-----------------------------");
    String line0 = "| Thermometer is ";
    if(isOn){
      line0 = line0 + "On";
    } else {
      line0 = line0 + "Off";
    }
    DecimalFormat df = new DecimalFormat("#.#");
    String[] lines = {line0, "| Battery: " + batteryStat + "% ",
      "| fever: " + df.format(feverTemp) + " temp: " +
        df.format(avgTemp) + " " + tempUnits};
    int i;
    for (i = 0; i < lines.length; i++) {
      int len = lines[i].length();
      int dif = screenWidth - len - 1;
      int x;
      for (x = 0; x < dif; x++) {
        lines[i] = lines[i] + " ";
      }
      lines[i] = lines[i] + "|";
      System.out.println(lines[i]);
    }
    System.out.println("-----------------------------");
  }
}