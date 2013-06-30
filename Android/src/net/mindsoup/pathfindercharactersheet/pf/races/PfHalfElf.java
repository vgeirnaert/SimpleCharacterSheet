/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.pf.races;

import net.mindsoup.pathfindercharactersheet.pf.PfEffectTypes;
import net.mindsoup.pathfindercharactersheet.pf.PfRaces;
import net.mindsoup.pathfindercharactersheet.pf.PfSizes;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;

/**
 * @author Valentijn
 *
 */
public class PfHalfElf extends PfChooseBonusAttributeRace { 
	
	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getRace()
	 */
	@Override
	public PfRaces getRace() {
		return PfRaces.HALFELF;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getSize()
	 */
	@Override
	public PfSizes getSize() {
		return PfSizes.MEDIUM;
	}

	
	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getCMBModifier()
	 */
	@Override
	public int getCMBModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getCMDModifier()
	 */
	@Override
	public int getCMDModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getACModifier()
	 */
	@Override
	public int getACModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getSavingThrowModifier(net.mindsoup.pathfindercharactersheet.pf.PfEffectTypes)
	 */
	@Override
	public int getSavingThrowModifier(PfEffectTypes effect) {
		switch(effect) {
			case ECHANTMENT: return 2;
			default: return 0;
		}
		
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getSkillBonus(net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills)
	 */
	@Override
	public int getSkillBonus(PfSkills skill) {
		switch(skill) {
			case PERCEPTION: return 2;
			default: return 0;
		}
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getBaseSpeed()
	 */
	@Override
	public int getBaseSpeed() {
		return 30;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getDarkvisionRange()
	 */
	@Override
	public int getDarkvisionRange() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getLowlightvisionRange()
	 */
	@Override
	public int getLowlightvisionRange() {
		return 30;
	}

	@Override
	public String toString() {
		return "Half-elf";
	}
}
