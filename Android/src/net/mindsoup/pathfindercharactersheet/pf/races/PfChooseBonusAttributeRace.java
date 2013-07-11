/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.pf.races;

import net.mindsoup.pathfindercharactersheet.pf.PfAttributes;

/**
 * @author Valentijn
 *
 */
public abstract class PfChooseBonusAttributeRace implements PfRace {
	
	private PfAttributes bonusAttribute = null;
	
	public void setBonusAttribute(PfAttributes attribute) {
		bonusAttribute = attribute;
	}
	
	public PfAttributes getBonusAttribute() {
		return this.bonusAttribute;
	}
	
	private int getBonusForAttribute(PfAttributes attribute) {
		System.out.println("getting bonus attribute");
		if(bonusAttribute != null) {
			if(bonusAttribute == attribute)
				return 2;
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getConModifier()
	 */
	@Override
	public int getConModifier() {
		return getBonusForAttribute(PfAttributes.CON);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getStrModifier()
	 */
	@Override
	public int getStrModifier() {
		return getBonusForAttribute(PfAttributes.STR);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getDexModifier()
	 */
	@Override
	public int getDexModifier() {
		return getBonusForAttribute(PfAttributes.DEX);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getIntModifier()
	 */
	@Override
	public int getIntModifier() {
		return getBonusForAttribute(PfAttributes.INT);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getWisModifier()
	 */
	@Override
	public int getWisModifier() {
		return getBonusForAttribute(PfAttributes.WIS);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.races.PfRace#getChaModifier()
	 */
	@Override
	public int getChaModifier() {
		return getBonusForAttribute(PfAttributes.CHA);
	}

}
