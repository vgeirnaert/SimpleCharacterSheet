package net.mindsoup.simplecharactersheet.pf.classes;

import net.mindsoup.simplecharactersheet.pf.PfClasses;

public interface PfClass {
	public PfClasses getPfClass();
	
	public int getBaseSkillRanksPerLevel();
	public int getHitDie();
	
	public int getFortSaveModifier(int level);
	public int getWillSaveModifier(int level);
	public int getReflexSaveModifier(int level);
	public int getExtraAttackPerNumLevels();
	
	
	
	
	
}
