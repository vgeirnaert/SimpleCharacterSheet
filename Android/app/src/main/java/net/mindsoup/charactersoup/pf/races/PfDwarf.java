package net.mindsoup.charactersoup.pf.races;

import net.mindsoup.charactersoup.pf.PfEffectTypes;
import net.mindsoup.charactersoup.pf.PfRaces;
import net.mindsoup.charactersoup.pf.PfSizes;
import net.mindsoup.charactersoup.pf.skills.PfSkills;

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
			default: return 0;
		}
	}
	

}
