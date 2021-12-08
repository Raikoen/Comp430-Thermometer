import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;



//Has THREE classes
public class ThermometerSystem
{
	boolean isOn=false;
	double avgTemp;
	float setTemp;
	int batteryStat;
	char tempUnits='C';
	float timer;
	
	public static void main(String[] args) 
	{

		ThermometerSystem thermometer = new ThermometerSystem();

		thermometer.turnOnOff();
    	
 	}
	

	public void turnOnOff()
	{
		Thermometer thermometer = new Thermometer();

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
			thermometer.selfTest();
		}

	}

	 public void mainMenu()
	{
		//Alvaro 
		
		measureTemp();
		convertTemp();
		
		
	}


	public void measureTemp()
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

        
		double []tempReadings = {95.5, 100.2, 97.3, 110.7, 96.3, 98.6, 101.9, 99.1, 112.8, 96.9};
		
        double sum = 0;
        for (int i=0; i<tempReadings.length; i++) 
        {
        	
 			sum += tempReadings[i];
        }

         //Used for makng sure we can iterate through the array
        System.out.println("Array: " + Arrays.toString(tempReadings));
        avgTemp = sum/tempReadings.length;
        //System.out.println("Your temperature is: " + avgTemp);
        DecimalFormat numFormat = new DecimalFormat("###.#");
        System.out.format(numFormat.format(avgTemp));

	}

	public void convertTemp()
	{
		//Kyle & Nea
		
	    if(tempUnits=='C')
	    {
	    	double celcius = ((avgTemp-32) * 5.0/9.0);

	  
	   	 	System.out.println();
	    	DecimalFormat numFormat = new DecimalFormat("###.#");
        	System.out.format(numFormat.format(celcius));
	    }	
	}

	public void inactivityTimer()
	{
		//Alvaro
	}


}

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

public class Main
{
	public static void main(String[] args) 
	{

		ThermometerSystem thermometer = new ThermometerSystem();
		Thermometer getTempInfo = new Thermometer();

		thermometer.turnOnOff();
		getTempInfo.selfTest();
    	
 	}
}

