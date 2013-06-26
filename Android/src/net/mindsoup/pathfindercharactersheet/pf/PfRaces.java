package net.mindsoup.pathfindercharactersheet.pf;

import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.races.PfElf;
import net.mindsoup.pathfindercharactersheet.pf.races.PfRace;

public enum PfRaces {
	DWARF, ELF, GNOME, HALFELF, HALFORC, HALFLING, HUMAN;
	
	public static PfRaces getRace(int i) {
		switch(i) {
		case 0: return PfRaces.DWARF;
		case 1: return PfRaces.ELF;
		case 2: return PfRaces.GNOME;
		case 3: return PfRaces.HALFELF;
		case 4: return PfRaces.HALFORC;
		case 5: return PfRaces.HALFLING;
		default: return PfRaces.HUMAN;
		}
	}
	
	public static PfRace getRace(PfRaces race) {
		switch(race) {
			case DWARF: return new PfDwarf();
			case ELF: return new PfElf();
			case GNOME: return new PfElf();
			case HALFELF: return new PfElf();
			case HALFLING: return new PfElf();
			case HALFORC: return new PfElf();
			default: return new PfElf(); //human
		}
	}
}
