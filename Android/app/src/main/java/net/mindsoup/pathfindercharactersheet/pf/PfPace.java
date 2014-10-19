package net.mindsoup.pathfindercharactersheet.pf;

public enum PfPace {
	SLOW, MEDIUM, FAST;
	
	public static PfPace getPace(int i) {
		switch(i) {
			case 0: return PfPace.SLOW;
			case 2: return PfPace.FAST;
			default: return PfPace.MEDIUM;
		}
	}
}
