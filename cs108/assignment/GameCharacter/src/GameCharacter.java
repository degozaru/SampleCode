abstract public class GameCharacter {
	
	//Variable declarations
	private int health, weight, happiness;
  public static final int MAX_CHAR = 100;
  public static final int MIN_CHAR = 0;
	
	//Constructors
	public GameCharacter() {
		this.health = 100;
		this.happiness = 100;
		this.weight = 100;
	}
	public GameCharacter(int health, int happiness, int weight) {
		this.health = health;
		this.happiness = happiness;
		this.weight = weight;
		//This will check and set defaults if invalid
		if ((MIN_CHAR > health || health > MAX_CHAR) ||
			(0 > happiness || happiness > 100) ||
			(0 > weight || weight > 100)) {
				System.out.println("Invalid parameter, using defaults.");
				this.health = 100;
				this.happiness = 100;
				this.weight = 100;
		}
	} //End constructors
	
	//This will check and set the characteristic
	public void modifyCharacteristic(int changeAmount, String characteristic) {
		//This will check and modify the characteristics, if valid.
		switch(characteristic.toLowerCase()) {
		case "health": 
			setHealth(changeAmount + health);
			break;
		case "weight": 
			setWeight(changeAmount + weight);
			break;
		case "happiness":
			setHappiness(changeAmount + happiness);
			break;
		default:
			throw new IllegalArgumentException("Invalid char.");
		}
	} //End modifyCharacteristic()
	
	//These are the get functions
	public int getHealth() {
		return health;
	} //End getHealth()
	public int getWeight() {
		return weight;
	} //End getWeight()
	public int getHappiness() {
		return happiness;
	} //End getHappiness()
	
	//This are the set functions
	public void setHealth(int amount) {
		isValid(amount);
		this.health = amount;
	} //End setHealth()
	public void setWeight(int amount) {
		isValid(amount);
		this.weight = amount;
	} //End setWeight()
	public void setHappiness(int amount) {
		isValid(amount);
		this.happiness = amount;
	} //End setHappiness()
	
	//This will throw an exception if illegal change happens
	private boolean isValid(int amount) {
		if (0 <= (amount) && (amount) <= 100) {
			return true;
		} else {
			throw new IllegalArgumentException("Exceeds bounds.");
		}	
	} //End isValid()
	
	//This will make a sad noise.
	public void makeSadNoise() {
		System.out.println(":(");
	} //End makeSadNoise()
	
	//A signature for makeHappyNoise()
	abstract public void makeHappyNoise();
	
} //End class GameCharacter
