package net.mindsoup.pathfindercharactersheet.pf;

import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfClass;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfSorcerer;

public enum PfClasses {
	BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WIZARD;
	
	public static PfClasses getPfClass(int i) {
		switch(i) {
		case 0: return PfClasses.BARBARIAN;
		case 1: return PfClasses.BARD;
		case 2: return PfClasses.CLERIC;
		case 3: return PfClasses.DRUID;
		case 4: return PfClasses.FIGHTER;
		case 5: return PfClasses.MONK;
		case 6: return PfClasses.PALADIN;
		case 7: return PfClasses.RANGER;
		case 8: return PfClasses.ROGUE;
		case 9: return PfClasses.SORCERER;
		default: return PfClasses.WIZARD;
		}
	}
	
	public static PfClass getPfClass(PfClasses pfClass) {
		switch(pfClass) {
			case BARBARIAN: return new PfBarbarian();
			case BARD: return new PfBarbarian(); 
			case CLERIC: return new PfBarbarian(); 
			case DRUID: return new PfBarbarian(); 
			case FIGHTER: return new PfBarbarian(); 
			case MONK: return new PfBarbarian(); 
			case PALADIN: return new PfBarbarian(); 
			case RANGER: return new PfBarbarian(); 
			case ROGUE: return new PfBarbarian(); 
			case SORCERER: return new PfSorcerer(); 
			default: return new PfBarbarian(); // wizard
		}
	}
}
