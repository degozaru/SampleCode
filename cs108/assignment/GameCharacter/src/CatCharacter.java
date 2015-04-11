public class CatCharacter extends GameCharacter {

	//The constructors.
	public CatCharacter() {
		super();
	}
	public CatCharacter(int health, int happiness, int weight) {
		super(health, happiness, weight);
	} //End constructors.
	
	public void makeHappyNoise() {
		System.out.println("meow");
	} //End makeHappyNoise()

} //End CatCharacter()
