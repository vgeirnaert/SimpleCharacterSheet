/**
 * 
 */
package net.mindsoup.charactersoup.pf.classes;

import net.mindsoup.charactersoup.fragments.SpellbookFragment;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.PfCharacter.Attributes;
import net.mindsoup.charactersoup.pf.PfClasses;
import net.mindsoup.charactersoup.pf.feats.PfFeats;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import net.mindsoup.charactersoup.pf.util.Calculation;
import net.mindsoup.charactersoup.pf.util.Dice;

import java.util.HashMap;
import java.util.Map;

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
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getPfClass()
	 */
	@Override
	public PfClasses getPfClass() {
		return PfClasses.SORCERER;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getBaseSkillRanksPerLevel()
	 */
	@Override
	public int getBaseSkillRanksPerLevel() {
		return 2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getHitDie()
	 */
	@Override
	public Dice getHitDie() {
		return hitDice;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getFortSaveModifier(int)
	 */
	@Override
	public int getFortSaveModifier(int level) {
		// see core rulebook page 72
		return (int)Math.floor(level / 3.0);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getWillSaveModifier(int)
	 */
	@Override
	public int getWillSaveModifier(int level) {
		// see core rulebook page 72
		return (int)Math.floor(level / 2.0) + 2;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getReflexSaveModifier(int)
	 */
	@Override
	public int getReflexSaveModifier(int level) {
		// see core rulebook page 72
		return (int)Math.floor(level / 3.0);
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getExtraAttackPerNumLevels()
	 */
	@Override
	public int getExtraAttackPerNumLevels() {
		return 12;
	}

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.pf.classes.PfClass#getClassSkills()
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

	@Override
	public Map<String, String> getFragments() {
		final Map<String, String> fragments = new HashMap<String, String>();
		fragments.put("Spells", SpellbookFragment.class.getName());
		return fragments;
	}

	@Override
	public Calculation modifyAttribute(Attributes attribute, Calculation current, PfCharacter character) {
		return current;
	}

    @Override
    public int getLevelupSpecialPowers(int level, PfCharacter character) {
        switch (level) {
            case 1:
                return 6;
            case 2:
                return 1;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 2;
            case 6:
                return 2;
            case 7:
                return 3;
            case 8:
                return 2;
            case 9:
                return 3;
            case 10:
                return 2;
            case 11:
                return 4;
            case 12:
                return 1;
            case 13:
                return 3;
            case 14:
                return 1;
            case 15:
                return 3;
            case 16:
                return 2;
            case 17:
                return 2;
            case 18:
                return 1;
            case 19:
                return 2;
            case 20:
                return 1;
        }
        return 0;
    }

}
