import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;

//Has everything in ONE class
public class Thermometer
{
	boolean isOn=false;
	float avgTemp;
	float setTemp;
	int batteryStat;
	char tempUnits;
	float timer;
	boolean testPassed;
	boolean feverDetected;

	public static void main(String[] args) 
	{
		Thermometer thermometer = new Thermometer();

		thermometer.turnOnOff();
    	
 	}
	
	public void turnOnOff()
	{

		//Kyle & Nea
		if(isOn==false)
		{
			System.out.println("Press Enter");
			Scanner pressPower = new Scanner(System.in);
			pressPower.nextLine();

		}
		
		isOn = true;
		if(isOn==true)
		{
			selfTest();
		}

	}


	public void selfTest()
	{
		//Group effort

		System.out.println("Self-Test beginning now");
		//Just a placeholder to make sure we can get to this point
		testPassed=true;

		if(testPassed==true)
		{
			System.out.println("Test passed");
		}

		mainMenu();

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


	public float measureTemp()
	{
		//Max temp 120; Min temp 95
		//Kyle & Nea

	/*
        Nea and I (Kyle) wanted to generate an array of 10 random 
        float values and then have the program average those numbers.
        However, while trying to make this work, we ran into more issues
        than we feel we have time to solve given the time constraints.
        For now, we will use a pre-set array of 10 float values and the 
        program will average them instead. 

        float minTemp = 95.0f;
		float maxTemp = 120.0f;

		float []tempReadings = new float[10];
		Random randTemp = new Random();

        float sum = 0;
        for (int i=0; i<10; i++) 
        {
        	if(!(randTemp.nextFloat() < 95.0f) || !(randTemp.nextFloat() > 120.0f))
        	{
        		tempReadings[i] = randTemp.nextFloat();
 				sum += tempReadings[i];
        	}
 		
        }
    */

		float []tempReadings = {95.5f, 100.2f, 97.3f, 110.7f, 96.3f, 98.6f, 101.9f, 99.1f, 112.8f, 96.9f};
		
        float sum = 0;
        for (int i=0; i<tempReadings.length; i++) 
        {
        	
 			sum += tempReadings[i];
        }

         //Used for makng sure we can iterate through the array
        System.out.println("Array: " + Arrays.toString(tempReadings));
        float avgTemp = sum/tempReadings.length;
        //System.out.println("Your temperature is: " + avgTemp);
        DecimalFormat numFormat = new DecimalFormat("###.#");
        System.out.format(numFormat.format(avgTemp));
	
		return avgTemp;
	}

	public void mainMenu()
	{
		//Alvaro 
		measureTemp();
		
	}

	public void convertTemp()
	{
		//Kyle & Nea
	}

	public void inactivityTimer()
	{
		//Alvaro
	}



	public void feverCalc()
	{
		//Kyle & Nea
	}




	public void Log()
	{
		//Alvaro

		/*
		float[] logEntries;

		public addTemp(float entry);
		public deleteTemp(float entry);

		These aren't declared properly, they're placeholders
		*/
	}

}


