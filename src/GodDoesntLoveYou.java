/**
 * Created by syuchan on 2017/05/23.
 */
public class GodDoesntLoveYou {
	public static void main(String[] args) {
		World world = new World(617);
		Lovable you = world.getYou();
		Lovable me = world.getMe();

		world.search(you, "Table");
		world.search(you, "Eggplant");

		world.search(you, "Flower");
		world.search(you, "Human");

		world.search(you);
		world.search(you);
		world.search(you);
		world.search(you);
		world.search(you);
		world.search(you);

		world.search(you);
		world.search(you);
		world.search(you);
		world.search(me);
	}
}
