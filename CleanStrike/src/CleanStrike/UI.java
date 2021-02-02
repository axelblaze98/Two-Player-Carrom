package CleanStrike;

//import java.util.Scanner;

public class UI {
	
	//Scanner sc = new Scanner(System.in);
	Gameplay gp = new Gameplay();
	int i =0;
	char choice=' ';
	
	public void showMainScreen(String curline) throws Exception{
		System.out.println(
				"1. Strike\n"+
				"2. Multi-Strike\n"+
				"3. Red Strike\n"+
				"4. Striker Strike\n"+
				"5. Defunct Coin\n"+
				"6. None"
				);
		
		if(i<curline.length()) {
            System.out.println(curline.charAt(i));
            choice = curline.charAt(i);
        	i+=2;
        	}
		else throw new Exception("Input test case not valid");
		
		switch(choice) {
		case '1':
			Strike();
			break;
		case '2':
			MultiStrike();
			break;
		case '3':
			RedStrike();
			break;
		case '4':
			StrikerStrike();
			break;
		case '5':
			i=DefuctCoin(curline,i);
			break;
		case '6':
			None();
			break;
		}
		
		if(gp.winCheck() && gp.coinCheck()) {
			if(gp.isTurn()) System.out.println("Player1 turn");
			else System.out.println("Player2 turn");
			showMainScreen(curline);
		}
		
	}

	private void Strike() {
		// TODO Auto-generated method stub
		try {
		gp.strike();
		}
		catch(GameplayException err) {
			System.out.println(err.getMessage());
		}
		
	}
	
	private void MultiStrike() {
		// TODO Auto-generated method stub
		try {
		gp.multiStrike();
		}
		catch(GameplayException err) {
			System.out.println(err.getMessage());
		}
	}
	
	private void RedStrike() {
		// TODO Auto-generated method stub
		try {
			gp.redStrike();
		}
		catch(GameplayException err) {
			System.out.println(err.getMessage());
		}
	}
	
	private void StrikerStrike() {
		// TODO Auto-generated method stub
		gp.strikerStrike();
	}
	

	

	private int DefuctCoin(String curline,int i) {
		// TODO Auto-generated method stub
		System.out.println(
				"1. Red\n"+
				"2. Black\n"
		);
		if(i<curline.length()) {
            System.out.println(curline.charAt(i));
            choice = curline.charAt(i);
        	i+=2;
        	}
		try {
		switch(choice) {
		case '1':
			gp.defuctCoin("Red");
			break;
		case '2':
			gp.defuctCoin("Black");
			break;
		}
		}
		catch(GameplayException err) {
			System.out.println(err.getMessage());
		}
		return i;
	}
	
	private void None() {
		// TODO Auto-generated method stub
		gp.noStrike();
	}

}
