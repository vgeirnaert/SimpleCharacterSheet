package net.mindsoup.charactersoup.pf.classes;

import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.PfClasses;
import net.mindsoup.charactersoup.pf.feats.PfFeats;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import net.mindsoup.charactersoup.pf.util.Calculation;
import net.mindsoup.charactersoup.pf.util.Dice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentijn on 20-10-2014.
 */
public class PfFighter implements PfClass {
    @Override
    public PfClasses getPfClass() {
        return PfClasses.FIGHTER;
    }

    @Override
    public int getBaseSkillRanksPerLevel() {
        return 2;
    }

    @Override
    public Dice getHitDie() {
        return new Dice(10,1);
    }

    @Override
    public int getFortSaveModifier(int level) {
        return (int)Math.floor(level / 2.0) + 2; // + 2 at level 1, +3 at level 2, +4 at level 4
    }

    @Override
    public int getWillSaveModifier(int level) {
        return (int)Math.floor(level / 3.0); // +1 at level 3, +2 at level 6
    }

    @Override
    public int getReflexSaveModifier(int level) {
        return (int)Math.floor(level / 3.0); // +1 at level 3, +2 at level 6
    }

    @Override
    public int getExtraAttackPerNumLevels() {
        return 6;
    }

    @Override
    public PfSkills[] getClassSkills() {
        return new PfSkills[]{PfSkills.CLIMB, PfSkills.CRAFT, PfSkills.HANDLE_ANIMAL, PfSkills.INTIMIDATE, PfSkills.KNOWLEDGE_DUNGEONEERING, PfSkills.KNOWLEDGE_ENGINEERING, PfSkills.PROFESSION, PfSkills.RIDE, PfSkills.SURVIVAL, PfSkills.SWIM};
    }

    @Override
    public PfFeats[] getClassFeats() {
        return new PfFeats[]{PfFeats.SIMPLE_WEAPON_PROFICIENCY, PfFeats.ARMOR_PROFICIENCY_LIGHT, PfFeats.ARMOR_PROFICIENCY_MEDIUM, PfFeats.SHIELD_PROFICIENCY, PfFeats.ARMOR_PROFICIENCY_HEAVY, PfFeats.TOWER_SHIELD_PROFICIENCY, PfFeats.MARTIAL_WEAPON_PROFICIENCY};
    }

    @Override
    public int getAttackBonus(int level) {
        return level;
    }

    @Override
    public Map<String, String> getFragments() {
        return new HashMap<String, String>();
    }

    @Override
    public Calculation modifyAttribute(PfCharacter.Attributes attribute, Calculation current, PfCharacter character) {
        return current;
    }

    @Override
    public String toString() {
        return "Fighter";
    }
}
