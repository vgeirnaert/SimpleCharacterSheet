package net.mindsoup.simplecharactersheet.pf.races;

import net.mindsoup.simplecharactersheet.pf.PfEffectTypes;
import net.mindsoup.simplecharactersheet.pf.PfRaces;
import net.mindsoup.simplecharactersheet.pf.PfSizes;

public interface PfRace {
	public PfRaces getRace();
	public PfSizes getSize();
	
	public int getConModifier();
	public int getStrModifier();
	public int getDexModifier();
	public int getIntModifier();
	public int getWisModifier();
	public int getChaModifier();
	
	
	
	public int getCMBModifier();
	public int getCMDModifier();
	public int getACModifier();
	public int getSavingThrowModifier(PfEffectTypes effect);
	
	public int getBaseSpeed();
	public int getDarkvisionRange();
	public int getLowlightvisionRange();
}
