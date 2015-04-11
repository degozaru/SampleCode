
public class Starship extends Character{
	
	private int score;
	
	public Starship(int aScore) {
		super(aScore);
	}

	@Override
	void makeNoise() {
		System.out.println("Meow");
		
	}

	@Override
	void increaseScore(int amount) {
		setScore(this.score + amount);
		
	}
}
