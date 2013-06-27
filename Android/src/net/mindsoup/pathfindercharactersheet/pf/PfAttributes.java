package net.mindsoup.pathfindercharactersheet.pf;

public enum PfAttributes {
	CHARISMA, CONSTITUTION, DEXTERITY, INTELLIGENCE, STRENGTH, WISDOM;
	
	public static PfAttributes getAttribute(int i) {
		switch(i) {
			case 0: return PfAttributes.CHARISMA;
			case 1: return PfAttributes.CONSTITUTION;
			case 2: return PfAttributes.DEXTERITY;
			case 3: return PfAttributes.INTELLIGENCE;
			case 4: return PfAttributes.STRENGTH;
			default: return PfAttributes.WISDOM;
		}
	}
}
