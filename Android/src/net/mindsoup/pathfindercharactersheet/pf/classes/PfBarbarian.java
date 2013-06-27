package net.mindsoup.pathfindercharactersheet.pf.classes;

import net.mindsoup.pathfindercharactersheet.pf.PfClasses;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;

public class PfBarbarian implements PfClass {
	
	private Dice hitDice = new Dice(12, 1);
	
	// class skills
	private final PfSkills[] classSkills = {PfSkills.ACROBATICS, PfSkills.CLIMB, PfSkills.CRAFT, PfSkills.HANDLE_ANIMAL, PfSkills.INTIMIDATE, PfSkills.KNOWLEDGE_NATURE, PfSkills.PERCEPTION, PfSkills.RIDE, PfSkills.SURVIVAL, PfSkills.SWIM};

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
		return 5;
	}
	
	public PfSkills[] getClassSkills() {
		return classSkills;
	}
	
	@Override
	public String toString() {
		return "Barbarian";
	}

	

}
