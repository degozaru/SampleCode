public abstract class Character {

	private int score;
	
	public Character(int aScore){
		this.score = aScore;
	}
	
	public void setScore(int newScore){
		this.score = newScore;
	}
	
	public int getScore(){
		return this.score;
	}
	
	abstract void makeNoise();
	abstract void increaseScore(int amount);
	
}
