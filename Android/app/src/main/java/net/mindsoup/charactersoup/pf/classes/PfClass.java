package net.mindsoup.charactersoup.pf.classes;

import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.PfClasses;
import net.mindsoup.charactersoup.pf.feats.PfFeats;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import net.mindsoup.charactersoup.pf.util.Calculation;
import net.mindsoup.charactersoup.pf.util.Dice;

import java.util.Map;

public interface PfClass {
	public PfClasses getPfClass();
	
	public int getBaseSkillRanksPerLevel();
	public Dice getHitDie();
	
	public int getFortSaveModifier(int level);
	public int getWillSaveModifier(int level);
	public int getReflexSaveModifier(int level);
	public int getExtraAttackPerNumLevels();
	public PfSkills[] getClassSkills();
	public PfFeats[] getClassFeats();
	public int getAttackBonus(int level);
	public Map<String, String> getFragments();
    public int getLevelupSpecialPowers(int level, PfCharacter character);
	public Calculation modifyAttribute(PfCharacter.Attributes attribute, Calculation current, PfCharacter character);
}
