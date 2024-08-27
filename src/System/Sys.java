package System;
import java.util.Scanner;

import Animals.Alligator;
import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Dolphin;
import Animals.Eagle;
import Animals.Gender;
import Animals.Pigeon;
import Animals.Poisonous;
import Animals.Snake;
import Animals.WaterType;
import Animals.Whale;
import Mobility.Point;
import Olympics.Medal;
import Olympics.Type;



/**
 * @author Zohar Monsonego, I.D: 214067662
 * 
 * 
 * 
 * The Sys class represents a system for creating and interacting with various animals.
 * It allows the user to create different types of animals, view their information, hear their sounds,
 * and exit the program.
 */
public class Sys {
	
	
	/**
	 * The main method of the Sys class, which serves as the entry point of the program.
     * It prompts the user to create animals based on their type (air, water, terrestrial),
     * displays animal information or sounds based on user input, and allows the user to exit the program.
     * @param args The command line arguments (not used in this program).
     * @throws IllegalArgumentException if the user tried to create a water animal and entered dive depth which out of bound
     */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		// Prompt user to enter number of animals to create
		System.out.println("Please, enter how much animals you would like to create:");
		num = sc.nextInt();
		sc.nextLine();
		
		// Create an array to store the created animals
		Animal[] array = new Animal[num];
		
		// Loop to create each animal based on user input
		for(int i=0;i<num; i+=1) {
			int choice;
			System.out.println("What kind of animal would you like to create:");
			System.out.println("1. Air animal.");
			System.out.println("2. Water animal");
			System.out.println("3. Terrestrial animal.");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			String choice2;
			switch (choice) {
			case 1:
				System.out.println("How fun! You chose Air animals, which animal will you choose:");
				System.out.println("a. Eagle.");
				System.out.println("b. Pigeon.");
				
				choice2 = sc.nextLine().trim();
				
				if(choice2.equals("a")) {
					System.out.println("Come on, let's create the eagle:");
					array[i] = createEagle(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillWingspan(sc),fillAltitude(sc));
				}
				if(choice2.equals("b")) {
					System.out.println("Come on, let's create the pigeon:");
					array[i] = createPigeon(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillWingspan(sc),fillFamily(sc));
				}
				break;
			
			case 2:
				System.out.println("How fun! You chose Water animals, which animal will you choose:");
				System.out.println("a. Alligator.");
				System.out.println("b. Whale.");
				System.out.println("c. Dolphin.");
				
				choice2 = sc.nextLine().trim();
				
				if(choice2.equals("a")) {
					System.out.println("Come on, let's create the alligator:");
					try {
						array[i] = createAlligator(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillDiveDept(sc),fillAreaOfLiving(sc),fillNumOfLegs(sc));
					}catch(IllegalArgumentException e) {
						System.out.print(e.getMessage());
						System.exit(1);
					}
				}
				if(choice2.equals("b")) {
					System.out.println("Come on, let's create the whale:");
					try {
						array[i] = createWhale(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillDiveDept(sc),fillFoodType(sc));
					}catch(IllegalArgumentException e) {
						System.out.print(e.getMessage());
						System.exit(1);
					}
				}
				if(choice2.equals("c")) {
					System.out.println("Come on, let's create the dolphin:");
					try {
						array[i] = createDolphin(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillDiveDept(sc),fillWaterType(sc));
					}catch(IllegalArgumentException e) {
						System.out.print(e.getMessage());
						System.exit(1);
					}
				}
				break;
				
			case 3:
				System.out.println("How fun! You chose Terrestrial animals, which animal will you choose:");
				System.out.println("a. Dog.");
				System.out.println("b. Cat.");
				System.out.println("c. Snake.");
				
				choice2 = sc.nextLine().trim();
				
				if(choice2.equals("a")) {
					System.out.println("Come on, let's create the dog:");
					array[i] = createDog(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillBreed(sc));
				}
				if(choice2.equals("b")) {
					System.out.println("Come on, let's create the cat:");
					array[i] = createCat(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillCastrated(sc));
				}
				if(choice2.equals("c")) {
					System.out.println("Come on, let's create the snake:");
					array[i] = createSnake(fillName(sc),fillGender(sc),fillWeight(sc),fillSpeed(sc),fillMedals(sc),fillPosition(sc),fillPoisonous(sc),fillLength(sc));
				}
				break;
			}
		}
		
		// Prompt user for further action after creating animals
		System.out.print("Amazing! After we have created all the animals, what would you like to do?" + "\n");
		System.out.print("1. See all information about the animals I selected." + "\n");
		System.out.print("2. To know what sound each animal I chose makes." + "\n");
		System.out.print("3. Exit." + "\n");
		
		int ans;
		ans = sc.nextInt();
		sc.nextLine();
		
		
		// Perform action based on user's choice
		if(ans == 1) {
			for(int i=0;i<num; i+=1) {
				System.out.printf(array[i].toString() + "\n" + "\n");
			}
		}
		else if(ans == 2) {
			for(int i=0;i<num;i+=1) {
				array[i].makeSound();
			}
		}
		else if(ans == 3) {
			System.out.print("Goodbye, it was nice to see you here!");
			System.exit(1);
		}
		else {
			System.out.print("There is no suitable option for your choice");
		}
		
		// Close the scanner
		sc.close();

	}
	
	
	
	
	// Helper methods to create specific types of animals
	
	static private String fillName(Scanner sc) {
		String n;
		System.out.print("What will the animal's name be?");
		n = sc.nextLine().trim();
		return n;
	}
	
	static private Gender fillGender(Scanner sc) {
		Gender gen = null;
		System.out.print("What is the animal's gender? (MALE, FEMALE, HERMAPHRODITE)");
		String g = sc.nextLine().trim().toUpperCase();
		
		try {
			gen = Gender.valueOf(g);
		} catch(IllegalArgumentException e) {
			System.out.println("You entered an invalid gender");
			System.exit(1);
		}
		return gen;
		
	}
	
	static private double fillWeight(Scanner sc) {
		double w;
		System.out.println("What is the animal's weight?");
		w = sc.nextDouble();
		sc.nextLine();
		return w;
	}

	static private int fillSpeed(Scanner sc) {
		int s;
		System.out.println("What is the animal's speed?");
		s = sc.nextInt();
		sc.nextLine();
		return s;
	}
	
	static private Medal[] fillMedals(Scanner sc) {
		int num_of_medals;
		System.out.println("How many medals the animal has?");
		num_of_medals = sc.nextInt();
		sc.nextLine();
		
		Medal[] m = new Medal[num_of_medals];
		for(int j=0;j<num_of_medals; j+=1) {
			Type type = null;
		    System.out.println("What the type of the medal? (BRONZE, SILVER, GOLD)");
		    String t = sc.next().trim().toUpperCase();
		    
		    try {
		    	type = Type.valueOf(t);
		    } catch(IllegalArgumentException e) {
		    	System.out.println("You entered an invalid type");
		    	System.exit(1);
		    }
		    sc.nextLine();
		    
		    String tournament;
		    System.out.println("Which tournament did the animal participate in?");
		    tournament = sc.next().trim();
		    sc.nextLine();
		    
		    int year;
		    System.out.println("In what year did the eagle participate in the tournament");
		    year = sc.nextInt();
		    sc.nextLine();
		    
		    m[j] = new Medal(type,tournament,year);
		}
		return m;
	}
	
	static private Point fillPosition(Scanner sc) {
		int x,y;
		System.out.println("What is the x coordinate of the animal's position");
		x = sc.nextInt();
		sc.nextLine();
		
		System.out.println("What is the y coordinate of the animal's position");
		y = sc.nextInt();
		sc.nextLine();
		
		Point p = new Point(x,y);
		return p;
	}
	
	static private double fillWingspan(Scanner sc) {
		double wing;
		System.out.println("What is the animal's wingspan?");
		wing = sc.nextDouble();
		sc.nextLine();
		return wing;
	}
	
	static private double fillAltitude(Scanner sc) {
		double alt_f;
		System.out.println("How high can the eagle fly?");
		alt_f = sc.nextDouble();
		sc.nextLine();
		return alt_f;
	}
	
	
	static private String fillFamily(Scanner sc) {
		String f;
		System.out.println("What family is the pigeon from?");
		f = sc.nextLine().trim();
		return f;
		
	}
	
	static private double fillDiveDept(Scanner sc) {
		double d_d;
		System.out.println("What is the diving depth that the animal is able to dive?");
		d_d = sc.nextDouble();
		sc.nextLine();
		return d_d;
	}
	
	static private String fillAreaOfLiving(Scanner sc) {
		String a_o_l;
		System.out.println("What is the area where the alligator lives?");
		a_o_l = sc.nextLine().trim();
		return a_o_l;
	}
	
	static private String fillFoodType(Scanner sc) {
		String ft;
		System.out.println("What is the type of food of the whale?");
		ft = sc.nextLine().trim();
		return ft;
	}
	
	static private WaterType fillWaterType(Scanner sc) {
		WaterType w_t = null;
	    System.out.println("What type of water is the dolphin in? (SEA,SWEET)");
	    String w = sc.nextLine().trim().toUpperCase();
	    
	    try {
	    	w_t = WaterType.valueOf(w);
	    } catch(IllegalArgumentException e) {
	    	System.out.println("You entered an invalid water type");
	    	System.exit(1);
	    }
	    sc.nextLine();
	   return w_t;
	}
	
	
	static private String fillBreed(Scanner sc) {
		String br;
		System.out.println("What breed is the dog from?");
		br = sc.nextLine().trim();
		return br;
	}
	
	static private boolean fillCastrated(Scanner sc) {
		boolean cas;
		String ans;
		System.out.println("Is the cat castrated? (yes/no)");
		ans = sc.nextLine().trim();
		if(ans.equals("yes")) {
			cas = true;
		}
		else {
			cas = false;
		}
		return cas;
	}
	
	static private Poisonous fillPoisonous(Scanner sc) {
		Poisonous po = null;
		System.out.println("What is the venom level of the snake? (NON_VENOMOUS, LOW, MID, HIGH, FATAL)");
        String p = sc.nextLine().trim().toUpperCase();
        
        try {
        	po = Poisonous.valueOf(p);
        } catch(IllegalArgumentException e) {
        	System.out.println("You entered an invalid venom level");
        	System.exit(1);
        }
        return po;
	}
	
	static private double fillLength(Scanner sc) {
		double l;
		System.out.println("what is the length of the snake?");
		l = sc.nextDouble();
		sc.nextLine();
		return l;
	}
	
	static private int fillNumOfLegs(Scanner sc) {
		int n;
		System.out.println("How many legs the alligator has?");
		n = sc.nextInt();
		sc.nextLine();
		return n;
	}
	
	
	
	static private Eagle createEagle(String n, Gender g, double w, int s, Medal[] m,Point po, double wing, double alt) {
		Eagle e = new Eagle(n,g,w,s,m,po,wing,alt);
		return e;
	}
	
	static private Pigeon createPigeon(String n, Gender g, double w, int s, Medal[] m,Point po, double wing, String fam) {
		Pigeon p = new Pigeon(n,g,w,s,m,po,wing,fam);
		return p;
	}
	
	static private Alligator createAlligator(String n, Gender g, double w, int sp, Medal[] m, Point p, double dive_d, String a_o_l, int num_l) {
		Alligator a = new Alligator(n,g,w,sp,m,p,dive_d,a_o_l,num_l);
		return a;
	}
	
	static private Whale createWhale(String n, Gender g, double weight, int sp, Medal[] m, Point p, double dive_d, String ft) {
		Whale wh = new Whale(n,g,weight,sp,m,p,dive_d,ft);
		return wh;
	}
	
	static private Dolphin createDolphin(String n, Gender g, double w, int sp, Medal[] m, Point p, double dive_d, WaterType wt) {
		Dolphin d = new Dolphin(n,g,w,sp,m,p,dive_d,wt);
		return d;
	}
	
	static private Dog createDog(String n, Gender g, double w, int sp, Medal[] m, Point p, String b) {
		Dog dog = new Dog(n,g,w,sp,m,p,b);
		return dog;
	}
	
	static private Cat createCat(String n, Gender g, double w, int sp, Medal[] m, Point p, boolean cas) {
		Cat cat = new Cat(n,g,w,sp,m,p,cas);
		return cat;
	}
	
	static private Snake createSnake(String n, Gender g, double w, int sp, Medal[] m, Point p, Poisonous po, double l) {
		Snake snake = new Snake(n,g,w,sp,m,p,po,l);
		return snake;
	}
	

	
	
	
	
	
	
	
	
	
	
}
