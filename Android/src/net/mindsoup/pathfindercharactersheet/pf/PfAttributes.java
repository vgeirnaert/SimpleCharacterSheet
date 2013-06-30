package net.mindsoup.pathfindercharactersheet.pf;

public enum PfAttributes {
	CHA, CON, DEX, INT, STR, WIS;
	
	public static PfAttributes getAttribute(int i) {
		switch(i) {
			case 0: return PfAttributes.CHA;
			case 1: return PfAttributes.CON;
			case 2: return PfAttributes.DEX;
			case 3: return PfAttributes.INT;
			case 4: return PfAttributes.STR;
			default: return PfAttributes.WIS;
		}
	}
}
