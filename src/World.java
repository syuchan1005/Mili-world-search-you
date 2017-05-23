/**
 * Created by syuchan on 2017/05/23.
 */
public class World {
	private static WorldSorterSearcher searcher = new WorldSorterSearcher();
	private static Lovable you = new Lovable();
	private static Lovable me = new Lovable();

	public World(int i) {

	}

	public Table[] getTable() {
		return new Table[0];
	}

	public Lovable getYou() {
		return you;
	}

	public Lovable getMe() {
		return me;
	}

	public Eggplant[] getEggplant() {
		return new Eggplant[0];
	}

	public Cat[] getCat() {
		return new Cat[0];
	}

	public Steak[] getSteak() {
		return new Steak[0];
	}

	public Flower[] getFlower() {
		return new Flower[0];
	}

	public Human[] getHuman() {
		return new Human[0];
	}

	public Shit[] getShit() {
		return new Shit[0];
	}

	public Thing[] getThing(String s) {
		return new Thing[0];
	}

	public Dog[] getDog() {
		return new Dog[0];
	}

	public void search(Lovable you) {
		search(you, "None");
	}

	public void search(Lovable you, String type) {
		switch (type) {
			case "Table":
				searcher.searchTable(this);
				break;
			case "Eggplant":
				searcher.searchEggplant(this);
				break;
			case "Flower":
				searcher.searchFlower(this);
				break;
			case "Human":
				searcher.searchHuman(this);
				break;
			case "None":
				break;
		}
	}
}
