package net.mindsoup.pathfindercharactersheet.pf.races;

import net.mindsoup.pathfindercharactersheet.pf.PfEffectTypes;
import net.mindsoup.pathfindercharactersheet.pf.PfRaces;
import net.mindsoup.pathfindercharactersheet.pf.PfSizes;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;

public class PfElf implements PfRace {

	@Override
	public PfRaces getRace() {
		return PfRaces.ELF;
	}

	@Override
	public PfSizes getSize() {
		return PfSizes.MEDIUM;
	}

	@Override
	public int getConModifier() {
		return -2;
	}

	@Override
	public int getStrModifier() {
		return 0;
	}

	@Override
	public int getDexModifier() {
		return 2;
	}

	@Override
	public int getIntModifier() {
		return 2;
	}

	@Override
	public int getWisModifier() {
		return 0;
	}

	@Override
	public int getChaModifier() {
		return 0;
	}

	@Override
	public int getCMBModifier() {
		return 0;
	}

	@Override
	public int getCMDModifier() {
		return 0;
	}

	@Override
	public int getACModifier() {
		return 0;
	}

	@Override
	public int getSavingThrowModifier(PfEffectTypes effect) {
		return 0;
	}

	@Override
	public int getBaseSpeed() {
		return 30;
	}

	@Override
	public int getDarkvisionRange() {
		return 0;
	}

	@Override
	public int getLowlightvisionRange() {
		return 30;
	}
	
	@Override
	public String toString() {
		return "Elf";
	}

	@Override
	public int getSkillBonus(PfSkills skill) {
		switch(skill) {
			case PERCEPTION: return 2;
			case SPELLCRAFT: return 2;
			default: return 0;
		}
	}

}
