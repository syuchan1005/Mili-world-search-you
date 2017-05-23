/**
 * Created by syuchan on 2017/05/23.
 */
public enum WaterNeed {
	NEED(0.2);

	double freq;

	WaterNeed(double freq) {
		this.freq = freq;
	}


	public double getWaterFreq() {
		return freq;
	}
}
