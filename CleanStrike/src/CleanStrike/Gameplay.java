package CleanStrike;

public class Gameplay {
	
	private boolean turn=true;
	private int bckCoin = 9;
	private int redCoin = 1;
	private boolean red=true;
	
	public boolean isTurn() {
		return turn;
	}
	
	Player p1 = new Player();
	Player p2 = new Player();
	
	public void strike() throws GameplayException{
		if(this.bckCoin<1) {
			throw new GameplayException("No Black Coins on the Board");
		}
		setUnsuccess();
		this.bckCoin--;
		updatePoints(1);
		printInfo();
		nextTurn();
	}

	public void multiStrike() throws GameplayException{
		// TODO Auto-generated method stub
		if(this.bckCoin<=1) {
			throw new GameplayException("No Black Coin on the Board");
		}
		setUnsuccess();
		this.bckCoin-=2;
		updatePoints(2);
		printInfo();
		nextTurn();
	}
	
	public void redStrike() throws GameplayException{
		if(this.redCoin<1) {
			throw new GameplayException("No Red Coins on the Board");
		}
		setUnsuccess();
		this.redCoin--;
		red=false;
		updatePoints(3);
		printInfo();
		nextTurn();
	}
	
	public void strikerStrike() {
		// TODO Auto-generated method stub
		updatePoints(-1);
		updateFouls();
		printInfo();
		nextTurn();
	}
	
	public void defuctCoin(String coin) throws GameplayException{
		// TODO Auto-generated method stub
		
		if(redCoin<1 && red) {
			throw new GameplayException("No Red Coins on the Board");
		}
		else if(bckCoin<1) throw new GameplayException("No Black Coins on the Board");
		else if(coin.equals("Red")) 
		{	
			red = false;
			redCoin--;
		}
		else bckCoin--;
		
		updatePoints(-2);
		updateFouls();
		printInfo();
		nextTurn();
	}
	
	
	public void noStrike() {
		addUnsuccess();
		printInfo();
		nextTurn();
	}
	
	public void nextTurn() {
		turn=!turn;
	}
	
	public boolean winCheck(){
		int point_diff=Math.abs(p1.getPoints()-p2.getPoints());
		if((p1.getPoints()>=5 || p2.getPoints()>=5) && point_diff>=3) {
			if(p1.getPoints()>=5) System.out.println("Player1 is winner by "+p1.getPoints()+":"+p2.getPoints());
			else System.out.println("Player2 is winner by "+p2.getPoints()+":"+p1.getPoints());
			return false;
		}
		else return true;
	}
	
	public boolean coinCheck() {
		if(redCoin<1 && bckCoin<1) {
			System.out.println("Match is a draw");
			return false;
		}
		else return true;
	}
	
	public void updatePoints(int points) {
		if(turn) p1.setPoints(p1.getPoints()+points);
		else p2.setPoints(p2.getPoints()+points);
	}
	
	private void updateFouls() {
		// TODO Auto-generated method stub
		if(turn) {
			p1.setFouls(p1.getFouls()+1);
			checkFoulCount(p1);
		}
			
		else {
			p2.setFouls(p2.getFouls()+1);
			checkFoulCount(p2);
		}
	}
	
	private void checkFoulCount(Player p) {
		if(p.getFouls()%3==0) {
			System.out.println("Extra point deducted for 3 Fouls");
			updatePoints(-1);
		}
	}
	
	private void addUnsuccess() {
		if(turn) 
			{
			p1.setMissCount((p1.getMissCount()+1));
			checkUnsuccessCount(p1);
		}
		else {
			p2.setMissCount(p2.getMissCount()+1);
			checkUnsuccessCount(p2);
		}
	}

	private void checkUnsuccessCount(Player p) {
		// TODO Auto-generated method stub
		if(p.getMissCount()==3) {
			System.out.println("Foul Not Scored for 3 Consecutive turns");
			updatePoints(-1);
			updateFouls();
			setUnsuccess();
		}
	}
	
	private void setUnsuccess() {
		// TODO Auto-generated method stub
		if(turn) p1.setMissCount(0);
		else p2.setMissCount(0);
	}
	
	private void printInfo() {
		System.out.println("\nPlayer 1 points are "+p1.getPoints()+" and fouls are "+p1.getFouls());
		System.out.println("Player 2 points are "+p2.getPoints()+" and fouls are "+p2.getFouls());
		System.out.println("Number of red coins left "+redCoin+" Number of black coins left "+bckCoin+"\n");
	}

	
}
