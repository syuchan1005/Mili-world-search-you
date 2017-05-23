/**
 * Created by syuchan on 2017/05/23.
 */
public class Steak {
	public Cut getCut() {
		return new Cut();
	}

	public Sauce getSauce() {
		return new Sauce();
	}

	public OutCondition getOutCondition() {
		return new OutCondition();
	}

	public Doneness getDoneness() {
		return new Doneness();
	}
}
