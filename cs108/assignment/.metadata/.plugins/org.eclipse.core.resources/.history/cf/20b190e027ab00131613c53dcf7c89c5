public class GameCharacterTester2 {

	public static void main(String[] args) {
		//====Step 1: Create instances====
		System.out.println("Creating new characters");
		DogCharacter dixie = new DogCharacter();
		CatCharacter nyan = new CatCharacter();
		AlienCharacter et = new AlienCharacter();
		DogCharacter dixie2 = new DogCharacter(50, 50, 50);
		System.out.println("Create an alien having NO FUN :(");
		AlienCharacter et2 = new AlienCharacter(50, -100, 50);
		System.out.println("Creating an overweight cat");
		CatCharacter garfield = new CatCharacter(50, 50, 1000);
		System.out.println("=====");
		
		//====Step 2: Check values====
		System.out.println("Printing 5 default characters:");
		System.out.println("Health: " + dixie.getHealth() + 
							"| Happiness: " + dixie.getHappiness() + 
							" | Weight: " + dixie.getWeight() );
		System.out.println("Health: " + nyan.getHealth() + 
							" | Happiness: " + nyan.getHappiness() + 
							" | Weight: " + nyan.getWeight());
		System.out.println("Health: " + et.getHealth() + 
							" | Happiness: " + et.getHappiness() + 
							" | Weight: " + et.getWeight());
		System.out.println("Health: " + et2.getHealth() + 
							" | Happiness: " + et2.getHappiness() + 
							" | Weight: " + et2.getWeight());
		System.out.println("Health: " + garfield.getHealth() + 
							" | Happiness: " + garfield.getHappiness() + 
							" | Weight: " + garfield.getWeight());
		System.out.println("Printing a custom constructed character:");
		System.out.println("Health: " + dixie2.getHealth() + 
							" | Happiness: " + dixie2.getHappiness() +
							" | Weight: " + dixie2.getWeight());
		System.out.println("=====");
		
		//====Step 3: Changing values====
		System.out.println("Changing character's values to all 0");
		dixie.setHealth(0);
		dixie.setHappiness(0);
		dixie.setWeight(0);
		System.out.println("Health: " + dixie.getHealth() + 
							"| Happiness: " + dixie.getHappiness() + 
							" | Weight: " + dixie.getWeight() );
		System.out.println("Modifying to 100 and try to modify sadness");
		dixie.modifyCharacteristic(100, "HealTh");
		System.out.println("Health: " + dixie.getHealth());
		try {
			dixie.modifyCharacteristic(10, "sadNess");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Trying to set health to 1000 and -1");
		try {
			dixie.setHealth(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} try {
			dixie.setHealth(-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("=====");
		
		//====Step 4: Testing noises====
		System.out.println("Dogs:");
		dixie.makeSadNoise();
		dixie.makeHappyNoise();
		System.out.println("Cats: ");
		nyan.makeSadNoise();
		nyan.makeHappyNoise();
		System.out.println("Aliens: ");
		et.makeSadNoise();
		et.makeHappyNoise();
			
	} //End main()
} //End class GameCharacterTester
