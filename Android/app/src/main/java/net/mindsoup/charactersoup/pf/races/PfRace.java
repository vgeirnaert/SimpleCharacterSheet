package net.mindsoup.charactersoup.pf.races;

import net.mindsoup.charactersoup.pf.PfEffectTypes;
import net.mindsoup.charactersoup.pf.PfRaces;
import net.mindsoup.charactersoup.pf.PfSizes;
import net.mindsoup.charactersoup.pf.skills.PfSkills;

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
	public int getSkillBonus(PfSkills skill);
	
	public int getBaseSpeed();
	public int getDarkvisionRange();
	public int getLowlightvisionRange();
}
