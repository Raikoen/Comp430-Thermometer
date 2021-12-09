import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {

        ThermometerSystem thermometerSystem = new ThermometerSystem();
        thermometerSystem.testFileReader();
        thermometerSystem.clearConsole();
        thermometerSystem.mainMenu();
    }
}
