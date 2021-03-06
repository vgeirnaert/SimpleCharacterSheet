package net.mindsoup.charactersoup.pf;

import net.mindsoup.charactersoup.pf.races.PfDwarf;
import net.mindsoup.charactersoup.pf.races.PfElf;
import net.mindsoup.charactersoup.pf.races.PfGnome;
import net.mindsoup.charactersoup.pf.races.PfHalfElf;
import net.mindsoup.charactersoup.pf.races.PfHalfOrc;
import net.mindsoup.charactersoup.pf.races.PfHalfling;
import net.mindsoup.charactersoup.pf.races.PfHuman;
import net.mindsoup.charactersoup.pf.races.PfRace;

public enum PfRaces {
	DWARF, ELF, GNOME, HALFELF, HALFLING, HALFORC, HUMAN;
	
	public static PfRaces getRace(int i) {
		switch(i) {
		case 0: return PfRaces.DWARF;
		case 1: return PfRaces.ELF;
		case 2: return PfRaces.GNOME;
		case 3: return PfRaces.HALFELF;
		case 4: return PfRaces.HALFLING;
		case 5: return PfRaces.HALFORC;
		default: return PfRaces.HUMAN;
		}
	}
	
	public static PfRace getRace(PfRaces race) {
		switch(race) {
			case DWARF: return new PfDwarf();
			case ELF: return new PfElf();
			case GNOME: return new PfGnome();
			case HALFELF: return new PfHalfElf();
			case HALFLING: return new PfHalfling();
			case HALFORC: return new PfHalfOrc();
			default: return new PfHuman(); //human
		}
	}
}
