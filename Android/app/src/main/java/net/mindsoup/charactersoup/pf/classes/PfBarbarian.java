package net.mindsoup.charactersoup.pf.classes;

import net.mindsoup.charactersoup.fragments.RageFragment;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.PfCharacter.Attributes;
import net.mindsoup.charactersoup.pf.PfClasses;
import net.mindsoup.charactersoup.pf.feats.PfFeats;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import net.mindsoup.charactersoup.pf.util.Calculation;
import net.mindsoup.charactersoup.pf.util.Dice;

import java.util.HashMap;
import java.util.Map;

public class PfBarbarian implements PfClass {

	private final String rage = "Rage";
	private boolean isRaging = false;
	private Dice hitDice = new Dice(12, 1);
	
	// class skills
	private final PfSkills[] classSkills = {PfSkills.ACROBATICS, PfSkills.CLIMB, PfSkills.CRAFT, PfSkills.HANDLE_ANIMAL, PfSkills.INTIMIDATE, PfSkills.KNOWLEDGE_NATURE, PfSkills.PERCEPTION, PfSkills.RIDE, PfSkills.SURVIVAL, PfSkills.SWIM};
	private final PfFeats[] classFeats = {PfFeats.ARMOR_PROFICIENCY_LIGHT, PfFeats.ARMOR_PROFICIENCY_MEDIUM, PfFeats.SHIELD_PROFICIENCY, PfFeats.SIMPLE_WEAPON_PROFICIENCY, PfFeats.MARTIAL_WEAPON_PROFICIENCY};

	@Override
	public PfClasses getPfClass() {
		return PfClasses.BARBARIAN;
	}

	@Override
	public int getBaseSkillRanksPerLevel() {
		return 4;
	}

	@Override
	public Dice getHitDie() {
		return hitDice;
	}

	@Override
	public int getFortSaveModifier(int level) {
		// see core rulebook page 32
		return (int)Math.floor(level / 2.0) + 2;
	}

	@Override
	public int getWillSaveModifier(int level) {
		// see core rulebook page 32
		return (int)Math.floor(level / 3.0);
	}

	@Override
	public int getReflexSaveModifier(int level) {
		// see core rulebook page 32
		return (int)Math.floor(level / 3.0);
	}

	@Override
	public int getExtraAttackPerNumLevels() {
		// see core rulebook page 32
		return 6;
	}
	
	public PfSkills[] getClassSkills() {
		return classSkills;
	}
	
	@Override
	public String toString() {
		return "Barbarian";
	}

	@Override
	public PfFeats[] getClassFeats() {
		return classFeats;
	}

	@Override
	public int getAttackBonus(int level) {
		return level;
	}

	@Override
	public Map<String, String> getFragments() {
		final Map<String, String> fragments = new HashMap<String, String>();
		fragments.put("Rage", RageFragment.class.getName());
		
		return fragments;
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public Calculation modifyAttribute(Attributes attribute, Calculation current, PfCharacter character) {
		if(this.isRaging()) {
			double rageMod = 1;
			if(character.getLevel() > 10) {
				rageMod = 1.5;
			}

			if(character.getLevel() > 19) {
				rageMod = 2;
			}

			switch(attribute) {
				case AC:
					current.add(rage, -2);
					break;
				case WILL:
					current.add(rage, (int)(2 * rageMod));
					break;
				case HP:
					int conBoost = (int)(4 * rageMod) + (character.hasFeat(PfFeats.RAGING_VITALITY) ? 2 : 0);

					int conBonus = (int)Math.floor(conBoost / 2);

					current.add(rage, conBonus * character.getLevel());
					break;
				case STR:
					current.add(rage, (int)(4 * rageMod));
					break;
				case CON:
					current.add(rage, (int)(4 * rageMod));

					if(character.hasFeat(PfFeats.RAGING_VITALITY)) {
						current.add("Raging Vitality", 2);
					}
					break;
			}
		}
		return current;
	}

	public boolean isRaging() {
		return isRaging;
	}
	
	public void setRaging(boolean rage) {
		this.isRaging = rage;
	}

    @Override
    public int getLevelupSpecialPowers(int level, PfCharacter character) {
        return (level + 1) % 2;
    }

}
