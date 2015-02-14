package net.mindsoup.charactersoup.pf.classes;

import net.mindsoup.charactersoup.fragments.SpellbookFragment;
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
public class PfWizard implements PfClass {
    @Override
    public PfClasses getPfClass() {
        return PfClasses.WIZARD;
    }

    @Override
    public int getBaseSkillRanksPerLevel() {
        return 2;
    }

    @Override
    public Dice getHitDie() {
        return new Dice(6,1);
    }

    @Override
    public int getFortSaveModifier(int level) {
        return (int)Math.floor(level / 3.0); // +1 at level 3, +2 at level 6
    }

    @Override
    public int getWillSaveModifier(int level) {
        return (int)Math.floor(level / 2.0) + 2; // + 2 at level 1, +3 at level 2, +4 at level 4
    }

    @Override
    public int getReflexSaveModifier(int level) {
        return (int)Math.floor(level / 3.0); // +1 at level 3, +2 at level 6
    }

    @Override
    public int getExtraAttackPerNumLevels() {
        return 12;
    }

    @Override
    public PfSkills[] getClassSkills() {
        return new PfSkills[]{PfSkills.APPRAISE, PfSkills.CRAFT, PfSkills.FLY, PfSkills.KNOWLEDGE_ARCANA, PfSkills.KNOWLEDGE_DUNGEONEERING, PfSkills.KNOWLEDGE_ENGINEERING, PfSkills.KNOWLEDGE_GEOGRAPHY, PfSkills.KNOWLEDGE_HISTORY, PfSkills.KNOWLEDGE_LOCAL, PfSkills.KNOWLEDGE_NATURE, PfSkills.KNOWLEDGE_NOBILITY, PfSkills.KNOWLEDGE_PLANES, PfSkills.KNOWLEDGE_RELIGION, PfSkills.LINGUISTICS, PfSkills.PROFESSION, PfSkills.SPELLCRAFT};
    }

    @Override
    public PfFeats[] getClassFeats() {
        return new PfFeats[0];
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
    public Calculation modifyAttribute(PfCharacter.Attributes attribute, Calculation current, PfCharacter character) {
        return current;
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
