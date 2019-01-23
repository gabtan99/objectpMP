/**
* The abstract class seed implements a class where all
* subtypes of seed are can be inherited from.
*
* @author  Gabriel T. Tan and Adrian Paule D. Ty
* @version 1.0
* @since   2018-08-15
* @see         Vegetable
* @see         FruitTree
* @see         Flower
*/
public abstract class Seed {
	private String name;
	private double timeNeed;
	private int waterNeed;
	private int waterMax;
	private int fertilizerNeed;
	private int fertilizerMax;
	private double harvestCost;
	private double seedCost;
	private double baseSelling;
	private double witheredCost;
	private int qty;

	/**
	*  A constructor for seeds.
	*
	* @param  n  a String referring to the name of the seed
	* @param  tn a double value referring to the time needed of the seed to grow, in mintues
	* @param  wn  an integer value referring to the amount of water needed for a plant to grow
	* @param  wm an integer value referring to the maximum amount of water a plant can receive for bonus computation
	* @param  fn  an integer value referring to the amount of fertilzier needed for a plant to grow
	* @param  fm an integer value referring to the maximum amount of fertilizer a plant can receive for bonus computation
	* @param  hc  a double value referring to the harvest cost of the seed
	* @param  sc a double value referring to the cost of buying a seed
	* @param  bp  a double value referring to the base selling price of a
	* @see         Vegetable
	* @see         FruitTree
	* @see         Flower
	*/
	public Seed(String n, double tn, int wn, int wm, int fn, int fm, double hc, double sc, double bp) {
		name = n;
		timeNeed = tn;
		waterNeed = wn;
		waterMax = wm;
		fertilizerNeed = fn;
		fertilizerMax = fm;
		harvestCost = hc;
		seedCost = sc;
		baseSelling = bp;

		witheredCost = sc * 0.10;

		qty = 0;

	}

	/**
	* An abstract method to be inherited by subclasses; returns a string corresponding to the texts obtained
	*
	* @return	the string containing the seed's information
	*/
	public abstract String displayStats();

	/**
	* An abstract method to be inherited by subclasses; returns an int generated by a random number generator
	*
	* @return	an integer value generated randomly from the variables of the class
	*/
	public abstract int productsProduced();

	/**
	* Automatically updates the information about a seed with respect to the rank specified in the parameters.
	*
	* @param  rank  an integer value representing the rank, of which whom corresponding bonuses are derived
	* @see         Farmer
	*/
	public void updateStats(int rank) {
		if (rank == 1) {
			timeNeed = timeNeed * 0.95;
			seedCost = seedCost - 2;
		}

		if (rank == 2) {
			timeNeed = (timeNeed / 0.95) * 0.90;
			seedCost = seedCost - 1;
			waterMax = waterMax + 1;
			fertilizerMax = fertilizerMax + 1;
		}

		if (rank == 3) {
			timeNeed = (timeNeed / 0.90) * 0.85;
			seedCost = seedCost - 2;
			waterMax = waterMax + 1;
			fertilizerMax = fertilizerMax + 1;
		}

	}

	/**
	* Returns true if there is at least one quantity of this seed owned, returns false otherwise
	*
	* @return	true if the quantity is not 0, false otherwise
	*/
	public boolean ownsQuantity() {
		if (qty == 0)
			return false;

		return true;
	}

	/**
	* Automatically adds one to the quantity of the seed
	*/
	public void addQuantity() {
		qty++;
	}

	/**
	* Automatically subtracts one to the quantity of the seed
	*/
	public void minusQuantity() {
		if (qty > 0)
			qty--;
	}

	/**
	* Returns the value of the wither cost of the seed. The wither cost is calculated as 10% of the seed cost.
	*
	* @return	wither cost of the seed; 10% of the seed cost
	*/
	public double getWitherCost() {
		return seedCost * 0.10;
	}

	/**
	* Returns the name of the seed
	*
	* @return	string representing the name of this seed
	*/
	public String getName() {
		return name;
	}

	/**
	* Returns the time needed for the seed to grow
	*
	* @return	double representing the time; in mintues
	*/
	public double getTN() {
		return timeNeed;
	}

	/**
	* Returns the minimum amount of water needed for the seed to grow
	*
	* @return	integer representing the water count needed
	*/
	public int getWN() {
		return waterNeed;
	}

	/**
	* Returns the maximum amount of water that can be used for final selling price computation
	*
	* @return	integer representing the maximum water count that can be accounted for bonus computation
	*/
	public int getWM() {
		return waterMax;
	}

	/**
	* Returns the minimum amount of fertilizer needed for the seed to grow
	*
	* @return	integer representing the fertilizer count needed
	*/
	public int getFN() {
		return fertilizerNeed;
	}

	/**
	* Returns the maximum amount of fertilizer that can be used for final selling price computation
	*
	* @return	integer representing the maximum fertilizer count that can be accounted for bonus computation
	*/
	public int getFM() {
		return fertilizerMax;
	}

	/**
	* Returns the cost of harvesting this type of seed
	*
	* @return	double representing the harvest cost
	*/
	public double getHC() {
		return harvestCost;
	}

	/**
	* Returns the cost of buying this seed
	*
	* @return	double representing the seed cost
	*/
	public double getSC() {
		return seedCost;
	}

	/**
	* Returns the base selling price of 1 unit of this seed (when grown)
	*
	* @return	double representing the base selling price
	*/
	public double getBP() {
		return baseSelling;
	}

	/**
	* Returns the cost of removing this seed when withered (upon growing and failure to harvest)
	*
	* @return	double representing the withered cost
	*/
	public double getWC() {
		return witheredCost;
	}

	/**
	* Returns the current quantity owned of this seed type
	*
	* @return	integer representing the quantity owned
	*/
	public int getQuantity() {
		return qty;
	}

}
