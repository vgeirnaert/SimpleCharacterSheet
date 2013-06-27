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
public class PfGnome implements PfRace {

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getRace()
	 */
	@Override
	public PfRaces getRace() {
		return PfRaces.GNOME;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getSize()
	 */
	@Override
	public PfSizes getSize() {
		return PfSizes.SMALL;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getConModifier()
	 */
	@Override
	public int getConModifier() {
		return 2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getStrModifier()
	 */
	@Override
	public int getStrModifier() {
		return -2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getDexModifier()
	 */
	@Override
	public int getDexModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getIntModifier()
	 */
	@Override
	public int getIntModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getWisModifier()
	 */
	@Override
	public int getWisModifier() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getChaModifier()
	 */
	@Override
	public int getChaModifier() {
		return 2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getCMBModifier()
	 */
	@Override
	public int getCMBModifier() {
		return -1;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getCMDModifier()
	 */
	@Override
	public int getCMDModifier() {
		return -1;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getACModifier()
	 */
	@Override
	public int getACModifier() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getSavingThrowModifier(net.mindsoup.pathfindercharactersheet.pf.PfEffectTypes)
	 */
	@Override
	public int getSavingThrowModifier(PfEffectTypes effect) {
		switch(effect) {
			case ILLUSION: return 2;
			default: return 0;
		}
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getBaseSpeed()
	 */
	@Override
	public int getBaseSpeed() {
		// TODO Auto-generated method stub
		return 0;
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
	public int getSkillBonus(PfSkills skill) {
		switch(skill) {
			case CRAFT: return 2;
			case PERCEPTION: return 2;
			case PROFESSION: return 2;
			case STEALTH: return 4;
			default: return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Gnome";
	}

}
