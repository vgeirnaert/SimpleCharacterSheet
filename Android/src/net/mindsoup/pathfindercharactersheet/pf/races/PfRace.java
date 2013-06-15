package net.mindsoup.pathfindercharactersheet.pf.races;

import net.mindsoup.pathfindercharactersheet.pf.PfEffectTypes;
import net.mindsoup.pathfindercharactersheet.pf.PfRaces;
import net.mindsoup.pathfindercharactersheet.pf.PfSizes;

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
