/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.pf.classes;

import net.mindsoup.pathfindercharactersheet.pf.PfClasses;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeats;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;

/**
 * @author Valentijn
 *
 */
public class PfSorcerer implements PfClass {
	
	private Dice hitDice = new Dice(6, 1);
	
	// class skills
	private final PfSkills[] classSkills = {PfSkills.APPRAISE, PfSkills.BLUFF, PfSkills.CRAFT, PfSkills.FLY, PfSkills.INTIMIDATE, PfSkills.KNOWLEDGE_ARCANA, PfSkills.PROFESSION, PfSkills.SPELLCRAFT, PfSkills.USE_MAGIC_DEVICE};
	private final PfFeats[] classFeats = {PfFeats.SIMPLE_WEAPON_PROFICIENCY};

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getPfClass()
	 */
	@Override
	public PfClasses getPfClass() {
		return PfClasses.SORCERER;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getBaseSkillRanksPerLevel()
	 */
	@Override
	public int getBaseSkillRanksPerLevel() {
		return 2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getHitDie()
	 */
	@Override
	public Dice getHitDie() {
		return hitDice;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getFortSaveModifier(int)
	 */
	@Override
	public int getFortSaveModifier(int level) {
		// see core rulebook page 72
		return (int)Math.floor(level / 3.0);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getWillSaveModifier(int)
	 */
	@Override
	public int getWillSaveModifier(int level) {
		// see core rulebook page 72
		return (int)Math.floor(level / 2.0) + 2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getReflexSaveModifier(int)
	 */
	@Override
	public int getReflexSaveModifier(int level) {
		// see core rulebook page 72
		return (int)Math.floor(level / 3.0);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getExtraAttackPerNumLevels()
	 */
	@Override
	public int getExtraAttackPerNumLevels() {
		return 12;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.pf.classes.PfClass#getClassSkills()
	 */
	@Override
	public PfSkills[] getClassSkills() {
		return classSkills;
	}
	
	@Override
	public String toString() {
		return "Sorcerer";
	}

	@Override
	public PfFeats[] getClassFeats() {
		return classFeats;
	}

	@Override
	public int getAttackBonus(int level) {
		return (int)Math.floor(level / 2.0);
	}

}
