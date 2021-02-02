package CleanStrike;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("This is a game called Clean Strike");
		System.out.println("Player1 Turn");
		String file = "/home/parth/Desktop/Sahaj/CleanStrike/src/CleanStrike/input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String testCase;
        while((testCase = bufferedReader.readLine()) != null){
            //process the line as required
        	try {
        	new UI().showMainScreen(testCase);
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	System.out.println("\nTest Case Ended\n");
        }
        bufferedReader.close();
	}

}
