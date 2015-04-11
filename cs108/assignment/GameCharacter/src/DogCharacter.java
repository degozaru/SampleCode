
public class DogCharacter extends GameCharacter {

	//The constructors
	public DogCharacter() {
		super();
	}
	public DogCharacter(int health, int happiness, int weight) {
		super(health, happiness, weight);
	} //End constructors
	
	public void makeHappyNoise() {
		System.out.println("woof");
	} //End makeHappyNoise()

} //End DogCharacter()
