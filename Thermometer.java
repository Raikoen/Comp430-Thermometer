import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;


public class Thermometer
{
  boolean testPassed;
  boolean feverDetected;

  public void selfTest()
  {
    //Group effort

    System.out.println("Self-Test beginning now");
    //Just a placeholder to make sure we can get to this point
    testPassed=true;

    if(testPassed==true)
    {
      System.out.println("Test passed");
      ThermometerSystem thermometer = new ThermometerSystem();

      thermometer.mainMenu();
    }

		/*
			For simulating the battery life test, we could make
			a random number generator that just spits out a
			random number that can be tested in an if-else.
			If the number generated is beneath a certain number,
			then the system will have the "Low Battery" meassage
			and will keep that message up for a few seconds before
			calling the mainMenu() method

			This is more to get brownie pts, neither Nea nor
			myself (Kyle) think it is absolutely pertinent to
			implement this
		*/



  }


  public void feverCalc()
  {
    //Kyle & Nea
  }


}

/*public class Log
{
	//Alvaro

		/*
		float[] logEntries;

		public addTemp(float entry);
		public deleteTemp(float entry);

		These aren't declared properly, they're placeholders

}
*/



