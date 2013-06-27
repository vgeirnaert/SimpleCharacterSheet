package net.mindsoup.pathfindercharactersheet.pf.races;

import net.mindsoup.pathfindercharactersheet.pf.PfEffectTypes;
import net.mindsoup.pathfindercharactersheet.pf.PfRaces;
import net.mindsoup.pathfindercharactersheet.pf.PfSizes;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;

public class PfDwarf implements PfRace {

	@Override
	public PfRaces getRace() {
		return PfRaces.DWARF;
	}

	@Override
	public PfSizes getSize() {
		return PfSizes.MEDIUM;
	}

	@Override
	public int getConModifier() {
		return +2;
	}

	@Override
	public int getStrModifier() {
		return 0;
	}

	@Override
	public int getDexModifier() {
		return 0;
	}

	@Override
	public int getIntModifier() {
		return 0;
	}

	@Override
	public int getWisModifier() {
		return +2;
	}

	@Override
	public int getChaModifier() {
		return -2;
	}

	@Override
	public int getCMBModifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCMDModifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getACModifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSavingThrowModifier(PfEffectTypes effect) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBaseSpeed() {
		return 20;
	}

	@Override
	public int getDarkvisionRange() {
		return 60;
	}

	@Override
	public int getLowlightvisionRange() {
		return 60;
	}

	@Override
	public String toString() {
		return "Dwarf";
	}

	@Override
	public int getSkillBonus(PfSkills skill) {
		switch(skill) {
			case APPRAISE: return 2;
			case PERCEPTION: return 2;
			default: return 0;
		}
	}
	

}
