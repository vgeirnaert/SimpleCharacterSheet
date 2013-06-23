package net.mindsoup.pathfindercharactersheet.pf.classes;

import net.mindsoup.pathfindercharactersheet.pf.PfClasses;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;

public class PfBarbarian implements PfClass {
	
	// TODO: make all methods static?
	
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
	public int getHitDie() {
		return 12;
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
