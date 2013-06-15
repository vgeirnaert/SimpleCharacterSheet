package net.mindsoup.pathfindercharactersheet.pf.classes;

import net.mindsoup.pathfindercharactersheet.pf.PfClasses;

public interface PfClass {
	public PfClasses getPfClass();
	
	public int getBaseSkillRanksPerLevel();
	public int getHitDie();
	
	public int getFortSaveModifier(int level);
	public int getWillSaveModifier(int level);
	public int getReflexSaveModifier(int level);
	public int getExtraAttackPerNumLevels();
}