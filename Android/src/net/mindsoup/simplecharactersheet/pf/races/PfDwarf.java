package net.mindsoup.simplecharactersheet.pf.races;

import net.mindsoup.simplecharactersheet.pf.PfEffectTypes;
import net.mindsoup.simplecharactersheet.pf.PfRaces;
import net.mindsoup.simplecharactersheet.pf.PfSizes;

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

}
