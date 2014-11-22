/**
 * 
 */
package net.mindsoup.charactersoup.pf.races;

import net.mindsoup.charactersoup.pf.PfEffectTypes;
import net.mindsoup.charactersoup.pf.PfRaces;
import net.mindsoup.charactersoup.pf.PfSizes;
import net.mindsoup.charactersoup.pf.skills.PfSkills;

/**
 * @author Valentijn
 *
 */
public class PfHalfOrc extends PfChooseBonusAttributeRace {
	
	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getRace()
	 */
	@Override
	public PfRaces getRace() {
		return PfRaces.HALFORC;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getSize()
	 */
	@Override
	public PfSizes getSize() {
		return PfSizes.MEDIUM;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getCMBModifier()
	 */
	@Override
	public int getCMBModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getCMDModifier()
	 */
	@Override
	public int getCMDModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getACModifier()
	 */
	@Override
	public int getACModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getSavingThrowModifier(net.mindsoup.charactersoup.pf.PfEffectTypes)
	 */
	@Override
	public int getSavingThrowModifier(PfEffectTypes effect) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getSkillBonus(net.mindsoup.charactersoup.pf.skills.PfSkills)
	 */
	@Override
	public int getSkillBonus(PfSkills skill) {
		switch(skill) {
		case INTIMIDATE: return 2;
		default: return 0;
	}
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getBaseSpeed()
	 */
	@Override
	public int getBaseSpeed() {
		return 30;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getDarkvisionRange()
	 */
	@Override
	public int getDarkvisionRange() {
		return 60;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.races.PfRace#getLowlightvisionRange()
	 */
	@Override
	public int getLowlightvisionRange() {
		return 60;
	}
	
	@Override
	public String toString() {
		return "Half-orc";
	}

}
