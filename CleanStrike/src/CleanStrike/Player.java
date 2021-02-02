package CleanStrike;

public class Player {
	private int points;
	private int fouls;
	private int missCount;
	
	public Player() {
		this.points=0;
		this.fouls=0;
		this.missCount=0;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getFouls() {
		return fouls;
	}
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	public int getMissCount() {
		return missCount;
	}

	public void setMissCount(int missCount) {
		this.missCount = missCount;
	}

	@Override
	public String toString() {
		return "Player [points=" + points + ", fouls=" + fouls + ", unsuccess=" + missCount + "]";
	}	
}
