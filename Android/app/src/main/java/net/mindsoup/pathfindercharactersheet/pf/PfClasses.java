package net.mindsoup.pathfindercharactersheet.pf;

import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBard;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfClass;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfCleric;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfDruid;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfFighter;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfMonk;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfPaladin;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfRanger;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfRogue;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfSorcerer;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfWizard;

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
			case BARD: return new PfBard();
			case CLERIC: return new PfCleric();
			case DRUID: return new PfDruid();
			case FIGHTER: return new PfFighter();
			case MONK: return new PfMonk();
			case PALADIN: return new PfPaladin();
			case RANGER: return new PfRanger();
			case ROGUE: return new PfRogue();
			case SORCERER: return new PfSorcerer();
            default: return new PfWizard(); // wizard
		}
	}
}
