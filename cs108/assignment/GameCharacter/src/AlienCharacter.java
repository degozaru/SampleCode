
public class AlienCharacter extends GameCharacter {

	//The constructors
	public AlienCharacter() {
		super();
	}
	public AlienCharacter(int health, int happiness, int weight) {
		super(health, happiness, weight);
	} //End constructors

	public void makeHappyNoise() {
		System.out.println("bzzrp");
	} //End makeHappyNoise()
}
