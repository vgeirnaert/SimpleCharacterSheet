package net.mindsoup.pathfindercharactersheet.pf.classes;

import net.mindsoup.pathfindercharactersheet.pf.PfClasses;

public class PfBarbarian implements PfClass {

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

}