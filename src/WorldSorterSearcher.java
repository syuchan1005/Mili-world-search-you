import java.util.ArrayList;
import java.util.List;

/**
 * Created by syuchan on 2017/05/23.
 */
public class WorldSorterSearcher {

	public void bubbleSortByLoveliness(Thing[] things) {
		if (things.length <= 1) {
			return;
		}
		int length = things.length;
		while (length != 0) {
			int sorted = 0;
			for (int i = 1; i < length; i++) {
				if (things[i -1].getLoveliness() > things[i].getLoveliness()) {
					Thing temp = things[i];
					things[i] = things[i - 1];
					things[i - 1] = temp;
					sorted = i;
				}
			}
			length = sorted;
		}
	}

	public void insertionSortBySweetness(Thing[] things) {
		if (things.length <= 1) {
			return;
		}
		for (int i = 1; i < things.length; i++) {
			for (int j = i; j > 0; i--) {
				if (things[j].getSweetness() < things[j - 1].getSweetness()) {
					Thing temp = things[j];
					things[j] = things[j - 1];
					things[j - 1] = temp;
				}
			}
		}
	}

	public int searchTable(World world) {
		int index = -1;
		Table[] tables = world.getTable();
		Thing me = world.getMe();
		for (int i = 0; i < tables.length; i++) {
			boolean wobbly = true;
			if (tables[i].getLegLength(0) == tables[i].getLegLength(1) &&
					tables[i].getLegLength(1) == tables[i].getLegLength(2) &&
					tables[i].getLegLength(2) == tables[i].getLegLength(3)) {
				wobbly = false;
			}
			if (tables[i].getHeight() == me.getHeightToElbow() && wobbly) {
				index = i;
			}
		}
		return index;
	}

	public int searchEggplant(World world) {
		int index = -1;
		Eggplant[] eggplants = world.getEggplant();
		for (int i = 0; i < eggplants.length; i++) {
			boolean nailed = false;
			for (int j = 0; j < eggplants[i].getDamage().length; j++) {
				nailed = eggplants[i].getDamage(j).getWeapon().getName().equals("nail");
			}
			if (eggplants[i].getColourHex().equals("800080") && nailed) {
				index = i;
			}
		}
		return index;
	}

	public int searchCat(World world) {
		int index = -1;
		Cat[] cats = world.getCat();
		for (int i = 0; i < cats.length; i++) {
			if(cats[i].getCoatStyle.getName().equals("bluePoint") &&
					cats[i].getMeowFreq() < 1 &&
					cats[i].getHissFreq() < 1 &&
					cats[i].getPurrFreq() == 0) {
				index = i;
			}
		}
		return index;
	}

	public int searchSteak(World world) {
		int index = -1;
		Steak[] steaks = world.getSteak();
		for (int i = 0; i < steaks.length; i++) {
			if (steaks[i].getCut().getName().equals("filetMignon") &&
					steaks[i].getSauce().getName().equals("mushroom") &&
					steaks[i].getOutCondition().getColourHex().equals("A52A2A") &&
					steaks[i].getDoneness().getName().equals("mediumRare")) {
				index = i;
			}
		}
		return index;
	}

	public int searchFlower(World world) {
		int index = -1;
		Flower[] flowers = world.getFlower();
		for (int i = 0; i < flowers.length; i++) {
			if (flowers[i].getWaterNeed().getWaterFreq() < 5 &&
					flowers[i].getStamina() < 0.2 &&
					flowers[i].getBloomFreq() > 7885) {
				index = i;
			}
		}
		return index;
	}

	public int searchHuman(World world) {
		int index = -1;
		Human[] humans = world.getHuman();
		for (int i = 0; i < humans.length; i++) {
			if (humans[i].getTempHandL() > 37 &&
					humans[i].getTempHandR() > 37 &&
					humans[i].getBreath().getSmell().getStinkiness() > 30 &&
					humans[i].getHair().getGreasiness() > 40) {
				index = i;
			}
		}
		return index;
	}

	public int searchShit(World world) {
		int index = -1;
		Shit[] shits = world.getShit();
		for (int i = 0; i < shits.length; i++) {
			if (shits[i].getDopeness().getValue() > 70) {
				index = i ;
			}
		}
		return index;
	}

	public int[] searchUnchanged(World world) {
		int[] index = {-1, -1};
		Thing[] thingsOld = world.getThing("0617-06-17T0617");
		Thing[] thingsNew = world.getThing("3691-03-06T0901");

		int smaller = thingsOld.length;
		boolean oldIsSmaller = true;
		if (smaller > thingsNew.length) {
			smaller = thingsNew.length;
			oldIsSmaller = false;
		}
		for (int i = 0; i < smaller; i++) {
			if (oldIsSmaller) {
				for (int j = 0; j < thingsNew.length; j++) {
					if (thingsOld[i].equals(thingsNew[j])) {
						index[0] = i;
						index[1] = j;
					}
				}
			}
			if (!oldIsSmaller) {
				for (int j = 0; j < thingsOld.length; j++) {
					if (thingsNew[i].equals(thingsOld[j])) {
						index[0] = i;
						index[1] = j;
					}
				}
			}
		}
		return index;
	}

	public void bucketSortByLovability(Thing[] things, int bucketSize) {
		if (things.length <= 1) {
			return;
		}

		Thing high = things[0];
		Thing low = things[0];
		for (int i = 0; i < things.length; i++) {
			if (things[i].getLovability() > high.getLovability()) {
				high = things[i];
			}
			if (things[i].getLovability() < low.getLovability()) {
				low = things[i];
			}
		}
		int range = (high.getLovability() - low.getLovability() + 1) / 2;
		List<Thing>[] buckets = new ArrayList[bucketSize];
		for (int i = 0; i < bucketSize; i++) {
			buckets[i] = new ArrayList<>();
		}
		for (int i = 0; i < things.length; i++) {
			buckets[(things[i].getLovability() - low.getLovability())
					/ range].add(things[i]);
		}

		int eachBucket = 0;
		for (int i = 0; i < things.length; i += eachBucket) {
			eachBucket = 0;
			while (eachBucket < buckets[i].size()) {
				things[i + eachBucket] = buckets[i].get(eachBucket);
				eachBucket++;
			}
		}

		for (int i = 0; i < things.length; i++) {
			for (int j = i; j > 0; i--) {
				if (things[j].getLovability() < things[j - 1].getLovability()) {
					Thing temp = things[j];
					things[j] = things[j - 1];
					things[j - 1] = temp;
				}
			}
		}
	}

	public void mergeSortbyExp(Thing[] things) {
		if (things.length <= 1) {
			return;
		}

		Thing[] temp = new Thing[things.length];
		for (int i = 0; i < things.length; i *= 2) {
			for (int low = 0; low < i - things.length; low += 2 * i) {
				mergeSortbyExp(things, temp, low, Math.min(i + low,
						things.length), Math.min(low + 2 * i, things.length));
			}
		}
		for (int i = 0; i < things.length; i++) {
			things[i] = temp[i];
		}
	}

	private void mergeSortbyExp(Thing[] things, Thing[] temp, int low, int mid, int high) {
		int l = low;
		int m = mid;
		for (int i = low; i < high; i++) {
			if (l < mid && (high < m || things[m].getExp() > things[l].getExp())) {
				temp[i] = things[l++];
			}
			else {
				temp[i] = things[m++];
			}
		}
	}

	public int searchDog(World world) {
		int index = -1;
		Dog[] dogs = world.getDog();
		for (int i = 0; i < dogs.length; i++) {
			if (dogs[i].getIsBarking() && dogs[i].getBarkFreq() < 0.5 &&
					dogs[i].getBarkSound().equals("ruff")) {
				index = i;
			}
		}
		return index;
	}
}
