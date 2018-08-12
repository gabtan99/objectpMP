
/**
* The class <b>Random</b> is imported to be used for generating a number the number of rocks, and tile positions containing the rocks.
*/
import java.util.*;

/**
* public class <b>Farmer</B>
*
*
* The class Farmer is the main model file that interacts with the controller or view.
*
* <p>
* This Farmer class represents the player itself interacting with the application.
* This contains necessary information about the farmer, including: <br>
* Statistics: <i>name</i>, <i>level</i>, <i>currentExp</i>, <i>maxExp</i>, <i>rank</i>, <i>rankName</i> <br>
* Register Information: <i>canRegister</i>, <i>coins</i>, <i>regPrice</i> <br>
* Farm Related Information and Components: <i>fertilizer</i>, <i>seedBag</i>, <i>farmLot</i>.
* <p>
* The farmer basically enacts all funcions that a farmer does with respect to commands initiating action to the tiles.
* A farmer has a <i>seedBag</i> which contains all the seeds possible in-game.
* The farmer also has a <i>farmLot</i> which contains his array of tiles that he can interact with his seeds and tools.
* <p>
* This farmer also has a feature of registering, which allows the farmer to gain bonuses based on their current rank.
* The rank, in order, starts from Unregistered, to Registered, to Distinguished, and lastly to Honourable.
* These ranks can only be accessed at a certain level, from which the farmer has to pay a sum to rank up.
*
* @author  Gabriel T. Tan and Adrian Paule D. Ty
* @version 1.0
* @since   2018-08-15
* @see         Seed
* @see         Vegetable
* @see         Flower
* @see         FruitTree
* @see         Tile
*/
public class Farmer {
	private String name;
	private int level;
	private int currentExp;
	private int maxExp;
	private int rank;
	private String rankName;
	private int nHarvested;

	private boolean canRegister;
	private double regPrice;
	private double coins;

	private int fertilizer;
	private ArrayList<Seed> seedBag;
	private ArrayList<Tile> farmLot;

	/**
	*  A constructor for objects of Farmer class
	* <p>
	* This costructor for this class intializes the starting stats of the farmer;
	* setting the starting level, the base coins, and the number of fertilizer.
	*
	* <p>
	* Additionally, this contructor instantiates the seedBag of the farm which is an <i>ArrayList</i> of <b>Seed</b>.
	* All kinds of existing seeds are also created in this constructor:
	* <i>Turnip</i> (<b>Vegetable</b> class),
	* <i>Carrot</i> (<b>Vegetable</b> class),
	* <i>Tomato</i> (<b>Vegetable</b> class),
	* <i>Potato</i> (<b>Vegetable</b> class),
	* <i>Rose</i> (<b>Flower</b> class),
	* <i>Tulip</i> (<b>Flower</b> class),
	* <i>Stargazer</i> (<b>Flower</b> class),
	* <i>Sunflower</i> (<b>Flower</b> class),
	* <i>Mango</i> (<b>FruitTree</b> class),
	* <i>Apple</i> (<b>FruitTree</b> class),
	* <i>Banana</i> (<b>FruitTree</b> class),
	* <i>Orange</i> (<b>FruitTree</b> class).
	* <p>
	* Also, farmLot of this Farmer is also instantiated. The count is set to 50 tiles.
	* A random number generator generates both the number of tiles with rocks and
	* the position of the tiles which have rocks.
	*/
	public Farmer() {
		currentExp = 0;
		maxExp = 125;
		rank = 0;
		rankName = "Unregistered Farmer";
		level = 0;
		nHarvested = 0;
		regPrice = 200.0;
		coins = 200.0;

		fertilizer = 5;

		seedBag = new ArrayList<Seed>();
		Vegetable turnip = new Vegetable("Turnip", 1, 1, 2, 0, 1, 1, 5, 6, 1, 1);
		seedBag.add(turnip);
		Vegetable carrot = new Vegetable("Carrot", 1.5, 1, 2, 0, 1, 1, 10, 9, 1, 2);
		seedBag.add(carrot);
		Vegetable tomato = new Vegetable("Tomato", 2.5, 3, 4, 1, 2, 1, 20, 15, 1, 3);
		seedBag.add(tomato);
		Vegetable potato = new Vegetable("Potato", 5, 4, 5, 2, 3, 1, 25, 13, 1, 6);
		seedBag.add(potato);
		Flower rose = new Flower("Rose", 1, 1, 2, 0, 1, 2, 5, 5);
		seedBag.add(rose);
		Flower tulip = new Flower("Tulip", 1.5, 2, 3, 0, 1, 2, 7, 7);
		seedBag.add(tulip);
		Flower stargazer = new Flower("Stargazer", 2.5, 2, 3, 0, 1, 2, 10, 9);
		seedBag.add(stargazer);
		Flower sunflower = new Flower("Sunflower", 3.5, 2, 3, 1, 2, 2, 20, 19);
		seedBag.add(sunflower);
		FruitTree mango = new FruitTree("Mango", 7, 7, 7, 4, 4, 3, 50, 4, 5, 10);
		seedBag.add(mango);
		FruitTree apple = new FruitTree("Apple", 7, 7, 7, 5, 5, 3, 55, 3.5, 7, 10);
		seedBag.add(apple);
		FruitTree banana = new FruitTree("Banana", 8, 8, 8, 5, 5, 3, 60, 3.5, 10, 15);
		seedBag.add(banana);
		FruitTree orange = new FruitTree("Orange", 8, 8, 8, 6, 6, 3, 65, 4.5, 13, 15);
		seedBag.add(orange);

		farmLot = new ArrayList<Tile>();

		Random generate = new Random();

		// Generates the random rock tiles.
		int n = generate.nextInt(4) + 4;
		int[] p = new int[n];

		for (int i = 0; i < n; i++)
			p[i] = generate.nextInt(50);

		for (int i = 0; i < 50; i++) {
			boolean found = false;
			Tile t = new Tile(i);

			for (int k = 0; k < n && !found; k++) {
				if (p[k] == i) {
					t.setRocks(true);
					t.setAvailable(false);
					found = true;
				} else {
					t.setAvailable(true);
				}
			}

			farmLot.add(t);
		}
	}

	/**
	* Automatically increments the <i>currentExp</i> of the farmer.
	* <p>
	* This private method automatically adds 5 to the farmer's experience points, the standard gain per action.
	* Other methods/actions which calls for an experience gain calls this method to do it for them.
	* <p>
	* Additionally, this also checks if the <i>currentExp</i> matches the <i>maxExp</i>,
	* which will trigger the player to level up, adding 1 to the current level.
	* <p>
	* One feature to note is that this also checks the eligibility of the farmer to register, specified by <i>canRegister</i>;
	* @see #register()
	*/
	private void addExp() {
		currentExp += 5;

		if (currentExp == maxExp) {
			currentExp = 0;
			level++;

			if (rank == 3) {
				canRegister = false;
				return;
			}

			if (rank == 0) {
				if (level >= 5)
					canRegister = true;
				else
					canRegister = false;
			} else if (rank == 1) {
				if (level >= 10)
					canRegister = true;
				else
					canRegister = false;
			} else if (rank == 2) {
				if (level >= 15)
					canRegister = true;
				else
					canRegister = false;
			}
		}
	}

	/**
	*  Sets the availability of the surrounding tiles of the given position
	* <p>
	* This method is generally used for seeds of <b>FruitTree</b> instance.
	* Whevever the seed is planted, it sets the availability of the tiles around it in the four basic directions
	* to the given boolean value.
	* <p>
	*
	*
	* @param  pos  an integer which represents the position of the tile
	* @param  bool  a boolean value to set the tiles' availability to
	*/
	private void setRoots(int pos, boolean bool) {
		// If position is in a corner
		if (pos == 0 || pos == 9 || pos == 40 || pos == 49) {
			switch (pos) {
			case 0:
				farmLot.get(pos + 1).setAvailable(bool);
				farmLot.get(pos + 10).setAvailable(bool);
				break;

			case 9:
				farmLot.get(pos - 1).setAvailable(bool);
				farmLot.get(pos + 10).setAvailable(bool);
				break;

			case 40:
				farmLot.get(pos + 1).setAvailable(bool);
				farmLot.get(pos - 10).setAvailable(bool);
				break;

			case 49:
				farmLot.get(pos - 1).setAvailable(bool);
				farmLot.get(pos - 10).setAvailable(bool);
				break;

			}
		}
		// If position is on left edge
		else if (pos % 10 == 0) {
			farmLot.get(pos - 10).setAvailable(bool);
			farmLot.get(pos + 1).setAvailable(bool);
			farmLot.get(pos + 10).setAvailable(bool);

		}
		// If position is on right edge
		else if (pos % 10 == 9) {
			farmLot.get(pos - 10).setAvailable(bool);
			farmLot.get(pos - 1).setAvailable(bool);
			farmLot.get(pos + 10).setAvailable(bool);

		}
		// If position is on top edge
		else if (pos < 10) {
			farmLot.get(pos - 1).setAvailable(bool);
			farmLot.get(pos + 10).setAvailable(bool);
			farmLot.get(pos + 1).setAvailable(bool);

		}
		// If position is on bottom edge
		else if (pos > 39) {
			farmLot.get(pos - 1).setAvailable(bool);
			farmLot.get(pos - 10).setAvailable(bool);
			farmLot.get(pos + 1).setAvailable(bool);

		}
		// If position is within borders
		else {
			farmLot.get(pos - 1).setAvailable(bool);
			farmLot.get(pos + 1).setAvailable(bool);
			farmLot.get(pos + 10).setAvailable(bool);
			farmLot.get(pos - 10).setAvailable(bool);
		}
	}

	/*
		This is the isAvailableForTree method.
		+ This method checks the surround tiles of a given tile in index -pos if they are all available for a tree to be planted.
		+ This method returns true if no unavailable tile is encountered, and false otherwise.
	*/
	private boolean isAvailableForTree(int pos) {
		// If position is in a corner
		if (pos == 0 || pos == 9 || pos == 40 || pos == 49) {
			switch (pos) {
			case 0:
				if (!farmLot.get(pos + 1).getAvailable())
					return false;
				if (!farmLot.get(pos + 10).getAvailable())
					return false;
				break;

			case 9:
				if (!farmLot.get(pos - 1).getAvailable())
					return false;
				if (!farmLot.get(pos + 10).getAvailable())
					return false;
				break;

			case 40:
				if (!farmLot.get(pos + 1).getAvailable())
					return false;
				if (!farmLot.get(pos - 10).getAvailable())
					return false;
				break;

			case 49:
				if (!farmLot.get(pos - 1).getAvailable())
					return false;
				if (!farmLot.get(pos - 10).getAvailable())
					return false;
				break;

			}
		}
		// If position is on left edge
		else if (pos % 10 == 0) {
			if (!farmLot.get(pos - 10).getAvailable())
				return false;
			if (!farmLot.get(pos + 1).getAvailable())
				return false;
			if (!farmLot.get(pos + 10).getAvailable())
				return false;

		}
		// If position is on right edge
		else if (pos % 10 == 9) {
			if (!farmLot.get(pos - 10).getAvailable())
				return false;
			if (!farmLot.get(pos - 1).getAvailable())
				return false;
			if (!farmLot.get(pos + 10).getAvailable())
				return false;

		}
		// If position is on top edge
		else if (pos < 10) {
			if (!farmLot.get(pos - 1).getAvailable())
				return false;
			if (!farmLot.get(pos + 10).getAvailable())
				return false;
			if (!farmLot.get(pos + 1).getAvailable())
				return false;

		}
		// If position is on bottom edge
		else if (pos > 39) {
			if (!farmLot.get(pos - 1).getAvailable())
				return false;
			if (!farmLot.get(pos - 10).getAvailable())
				return false;
			if (!farmLot.get(pos + 1).getAvailable())
				return false;

		}
		// If position is within borders
		else {
			if (!farmLot.get(pos - 1).getAvailable())
				return false;
			if (!farmLot.get(pos + 1).getAvailable())
				return false;
			if (!farmLot.get(pos + 10).getAvailable())
				return false;
			if (!farmLot.get(pos - 10).getAvailable())
				return false;
		}

		return true;
	}

	// Public Methods, can be called outside this class.

	/*
		This is the displayStats method.
		+ This method returns a string containing a series of text referring to the farmer's stats;
	*/

	public String displayStats() {
		String display = "";
		String canReg;

		if (canRegister)
			canReg = "\n   (ELIGBLE TO REGISTER)";
		else
			canReg = "\n   (INELIGBLE TO REGISTER YET)";

		/*
		display = display + "\n   Farmer Name: " + name + "\n";
		display = display + "   Farmer Rank : " + rankName + "\n";
		display = display + "   LEVEL " + level + ": " + currentExp + " / 75\n";
		display = display + "   Coins: " + coins + "\n";
		display = display + "   Register Price to next rank: " + regPrice + canReg + " \n";
		*/

		display = String.format(
				"\n   Farmer Name: %s \n   Farmer Rank : %s \n   LEVEL %d: %d / %d\n  Coins: %.2f coins \n   Register Price to next rank: %.2f  %s\n",
				name, rankName, level, currentExp, maxExp, coins, regPrice, canReg);

		return display;
	}

	public int displayEXP() {
		return currentExp;
	}

	/*
		This is the displayBonuses method.
		+ This method returns a string containing a series of text referring to the farmers bonuses based on rank;
	*/

	public String displayBonuses() {
		String display = "";

		if (rank == 1) {
			display = display + "\n\n   " + rankName + "\n";
			display = display + "   Buying Discount: - 2 \n";
			display = display + "   Selling Bonus: + 2 \n";
			display = display + "   Bonus Water and Fertilizer Limits: + 0\n";
			display = display + "   Harvest Time Bonus: - 5% \n";
		} else if (rank == 2) {
			display = display + "\n\n   " + rankName + "\n";
			display = display + "   Buying Discount: - 3 \n";
			display = display + "   Selling Bonus: + 3 \n";
			display = display + "   Bonus Water and Fertilizer Limits: + 1\n";
			display = display + "   Harvest Time Bonus: - 10% \n";
		} else if (rank == 3) {
			display = display + "\n\n   " + rankName + "\n";
			display = display + "   Buying Discount: - 5 \n";
			display = display + "   Selling Bonus: + 5 \n";
			display = display + "   Bonus Water and Fertilizer Limits: + 2\n";
			display = display + "   Harvest Time Bonus: - 15% \n";
		} else {
			display = display + "\n\n   " + rankName + "\n";
			display = display + "   Buying Discount: - 0 \n";
			display = display + "   Selling Bonus: + 0 \n";
			display = display + "   Bonus Water and Fertilizer Limits: + 0\n";
			display = display + "   Harvest Time Bonus: - 0% \n";
		}

		return display;
	}

	/*
		This is the displayPickaxeInfo.
		+ This method returns a string describing what the Pickaxe tool can do.
	*/
	public String displayPickaxeInfo() {
		return "This is a Pickaxe. This tool is used to remove rocks littered across the farm.\n\nPress 'Remove Rock' then select the tile.";
	}

	/*
		This is the displayWaterInfo.
		+ This method returns a string describing what the Watering Can tool can do.
	*/
	public String displayWaterInfo() {
		return "This is a Watering Can. This tool is used to water a tile with a growing plant on it.\n\nYou have unlimited uses for this.\n\nPress 'Water' then select the tile to water it.";
	}

	/*
		This is the displayFertilizerInfo.
		+ This method returns a string describing what the Fertilizer tool can do.
	*/
	public String displayFertilizerInfo() {
		return "This is Fertilizer. This tool is used to fertilize a tile with a growing plant on it. You currently have "
				+ fertilizer
				+ " units of fertilizer.\n\nPress 'Fertilize' then select the tile to fertilize it.\n\nPress 'Buy' to buy one unit for 10 Coins.";
	}

	/*
		This is the displayScyteInfo.
		+ This method returns a string describing what the Scyte tool can do.
	*/
	public String displayScyteInfo() {
		return "This is the Plow Tool. This tool is used to plow an unplowed tile or remove a withered plant for a cost.\n\nPress 'Plow' then select the tile to plow the tile or remove a withered plant for 10% of the plant's seed cost.";
	}

	/*
		This is the displayHarvestInfo.
		+ This method returns a string describing what the Scyte tool can do.
	*/
	public String displayHarvestInfo() {
		return "This is the Harvest Tool. This tool is used to harvest a grown plant.\n\nPress 'Harvest' then select the tile to harvest the tile.";
	}

	/*
		This is the register method.
		+ This method allows the register if the farmer is eligible to do so, through the canRegister variable, and if he has enough coins to do so.
		+ This method also sets the register price for the next rank, if there is more to gain, and the rank name.
		+ This method returns true upon successful registration, and returns false otherwise.
	*/
	public boolean register() {
		if (canRegister && coins >= regPrice) {
			coins = coins - regPrice;
			rank++;

			for (int i = 0; i < seedBag.size(); i++)
				seedBag.get(i).updateStats(rank);

			if (rank == 1) {
				regPrice = 250;
				rankName = "Registered Farmer";
			} else if (rank == 2) {
				regPrice = 350;
				rankName = "Distinguished Farmer";
			} else if (rank == 3) {
				regPrice = 0;
				rankName = "Honorable Farmer";
				canRegister = false;
			}

			return true;
		}
		return false;
	}

	/*
		This is the buy method.
		+ This method allows to buy a seed, the seed being based on the position in the seedBag due to the seedBag's of already containing all seeds upon construction of this object.
		+ This method subtracts the seed cost and adds 1 to the quantity variable of the seed.
		+ This method returns true upon successful purchase, and returns false otherwise.
	*/

	public boolean buy(int seedPos) {
		if (coins >= seedBag.get(seedPos).getSC()) {
			coins = coins - seedBag.get(seedPos).getSC();
			seedBag.get(seedPos).addQuantity();
			return true;
		}
		return false;
	}

	/*
		This is the buyFertilizer method.
		+ This method allows to buy fertilizer.
		+ This method returns true upon successful purchase, and returns false otherwise.
	*/

	public boolean buyFertilizer() {
		if (coins >= 10) {
			coins -= 10;
			fertilizer++;
			return true;
		}
		return false;
	}

	/*
		This is the fertilize method.
		+ This method fertilizes the tile based on the index -pos.
		+ This method subtracts 1 unit of fertilizer and adds 1 to the fertilizer count of the tile.
		+ This method fails if the user does not have enough fertilizer or there is nothing planted on the tile or the plant is already grown
		+ This method returns true upon success, and returns false otherwise.
	*/

	public boolean fertilize(int pos) {
		if (fertilizer > 0 && farmLot.get(pos).getReady() == false && farmLot.get(pos).getWithered() == false
				&& farmLot.get(pos).getPlowed() == true && farmLot.get(pos).getOccupant() == null
				&& farmLot.get(pos).getAvailable() == true)// NOT EMPTY, NOT READY, NOT WITHERED, WITH UNITS
		{
			farmLot.get(pos).addFertilizerCount();
			fertilizer--;
			addExp();
			return true;
		}
		return false;
	}

	/*
		This is the water method.
		+ This method waters the tile based on the index -pos.
		+ This method has unlimited usage.
		+ This method only fails if there is nothing planted on the tile or the plant is already grown.
		+ This method returns true upon success, and returns false otherwise.
	*/

	public boolean water(int pos) {
		if (farmLot.get(pos).getOccupant() != null && farmLot.get(pos).getReady() == false
				&& farmLot.get(pos).getWithered() == false && farmLot.get(pos).getOccupant().getWM() > farmLot.get(pos).getWC()) // NOT EMPTY, NOT READY, and NOT WITHERED
		{
			farmLot.get(pos).addWaterCount();
			addExp();
			return true;
		}

		return false;
	}

	/*
		This is the removeRock method.
		+ This method removes the rock inhabiting the tile based on the index -pos.
		+ This method fails if there is no rock on the tile in the first place.
		+ This method returns true upon success, and returns false otherwise.
	*/

	public boolean removeRock(int pos) {
		if (farmLot.get(pos).getRocks() == true) {
			farmLot.get(pos).setRocks(false);
			farmLot.get(pos).setAvailable(true);
			farmLot.get(pos).setPlow(false);
			addExp();
			return true;
		}

		return false;
	}

	/*
		This is plow method.
		+ This method plows a tile based on the index -pos.
		+ This method turns a tile available for planting if it was empty and unplowed, or if it was previously inhabited by a withered plant.
		+ This method fails if the tile is unavailable.
		+ This method returns true upon success, and returns false otherwise.
	*/

	public boolean plow(int pos) {
		if (farmLot.get(pos).getAvailable() == false && farmLot.get(pos).getWithered() == false)
			return false;

		if (farmLot.get(pos).getPlowed() == false) {
			farmLot.get(pos).setPlow(true);
			farmLot.get(pos).setAvailable(true);
			addExp();
			return true;
		} else if (farmLot.get(pos).getWithered() == true && coins >= 2.0) {
			if (farmLot.get(pos).isTree()) {
				coins = coins - farmLot.get(pos).getOccupant().getWitherCost();
				addExp();
				farmLot.get(pos).reset();
				setRoots(pos, true);
				return true;
			} else {
				coins = coins - farmLot.get(pos).getOccupant().getWitherCost();
				addExp();
				farmLot.get(pos).reset();
				return true;
			}
		}
		return false;
	}

	/*
		This is the plant method.
		+This method puts the seed as the occupant of the designated tile position, if it passes all availability checks.
		+This method returns true if the occupant of the tile was successfuly set, and false otherwise.
	*/
	public boolean plant(int pos, int seedPos) {
		if (farmLot.get(pos).getAvailable() == true && farmLot.get(pos).getPlowed() == true
				&& seedBag.get(seedPos).ownsQuantity() == true) // Checks if tile is available and plowed
		{
			if (seedBag.get(seedPos) instanceof FruitTree) // Checks if the see is a tree
			{
				if (isAvailableForTree(pos) == true) // Checks if the surrounding tiles of the given position is available for planting
				{
					farmLot.get(pos).setOccupant(seedBag.get(seedPos));
					seedBag.get(seedPos).minusQuantity();
					setRoots(pos, false); // Sets the surroundings of the tiles unavailable when tile is available for tree.
					addExp();
					return true;
				} else {
					return false;
				}
			} else {
				farmLot.get(pos).setOccupant(seedBag.get(seedPos));
				seedBag.get(seedPos).minusQuantity();
				addExp();
				return true;
			}
		}

		return false;
	}

	/*
		This is the harvest method.
		+ This method harvest the plant at the tile based on the index -pos.
		+ This method automatically computes for the total amount gained from the harvest and automatically adds it to the coins.
		+ This method fails if the plant is not ready or the farmer cannot afford the harvest cost.
		+ This method returns true upon success, and returns false otherwise.
	*/

	public boolean harvest(int pos) {
		if (farmLot.get(pos).getReady() == true) {
			int wc = farmLot.get(pos).getWC();
			int fc = farmLot.get(pos).getFC();
			double total = 0;

			Seed seed = farmLot.get(pos).getOccupant();

			if (coins < seed.getHC())
				return false;

			double bp = seed.getBP();

			if (fc > farmLot.get(pos).getOccupant().getFM())
				fc = farmLot.get(pos).getOccupant().getFM();

			total = total + (bp * 0.25 * wc) + (bp * 0.5 * fc) + bp;

			if (seed instanceof Flower)
				total = total * 1.05;

			int flb = 0;
			if (rank == 0)
				flb = 0;
			else if (rank == 1)
				flb = 2;
			else if (rank == 2)
				flb = 3;
			else
				flb = 5;

			total = total + flb;

			total = total * seed.productsProduced();

			coins = coins - seed.getHC() + total;

			if (seed instanceof FruitTree)
				setRoots(pos, true);

			farmLot.get(pos).reset();
			addExp();
			nHarvested++;
			return true;
		}

		return false;
	}

	// Setters
	public void setName(String s) {
		name = s;
	}

	// Getters

	public ArrayList<Seed> getSeeds() {
		return seedBag;
	}

	public ArrayList<Tile> getFarm() {
		return farmLot;
	}

	public float calculateScore() {
		return (level * 125 + currentExp) * 5 + rank * 300 + nHarvested * 20;
	}

	public String displayHighScore() {
		String display = "";

		display = display + "Username: " + name + "\n";
		display = display + "Rank: " + rankName + "\n";
		display = display + "Level: " + level + "(" + currentExp + "/ 125)\n";
		display = display + "Money: " + coins + "\n";
		display = display + "Successful Harvests: " + nHarvested + "\n";
		display = display + "Score: " + calculateScore() + "\n\n";

		return display;
	}
}