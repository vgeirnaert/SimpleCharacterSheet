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
public class PfBard implements PfClass {

    @Override
    public PfClasses getPfClass() {
        return PfClasses.BARD;
    }

    @Override
    public int getBaseSkillRanksPerLevel() {
        return 6;
    }

    @Override
    public Dice getHitDie() {
        return new Dice(8,1);
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
        return (int)Math.floor(level / 2.0) + 2; // + 2 at level 1, +3 at level 2, +4 at level 4
    }

    @Override
    public int getExtraAttackPerNumLevels() {
        return 8;
    }

    @Override
    public PfSkills[] getClassSkills() {
        return new PfSkills[]{PfSkills.ACROBATICS, PfSkills.APPRAISE, PfSkills.BLUFF, PfSkills.CLIMB, PfSkills.CRAFT, PfSkills.DIPLOMACY, PfSkills.DISGUISE, PfSkills.ESCAPE_ARTIST, PfSkills.INTIMIDATE, PfSkills.KNOWLEDGE_ARCANA, PfSkills.KNOWLEDGE_DUNGEONEERING, PfSkills.KNOWLEDGE_ENGINEERING, PfSkills.KNOWLEDGE_GEOGRAPHY, PfSkills.KNOWLEDGE_HISTORY, PfSkills.KNOWLEDGE_LOCAL, PfSkills.KNOWLEDGE_NATURE, PfSkills.KNOWLEDGE_NOBILITY, PfSkills.KNOWLEDGE_PLANES, PfSkills.KNOWLEDGE_RELIGION, PfSkills.LINGUISTICS, PfSkills.PERCEPTION, PfSkills.PERFORM, PfSkills.PROFESSION, PfSkills.SENSE_MOTIVE, PfSkills.SLEIGHT_OF_HAND, PfSkills.SPELLCRAFT, PfSkills.STEALTH, PfSkills.USE_MAGIC_DEVICE};
    }

    @Override
    public PfFeats[] getClassFeats() {
        return new PfFeats[]{PfFeats.SIMPLE_WEAPON_PROFICIENCY, PfFeats.ARMOR_PROFICIENCY_LIGHT, PfFeats.SHIELD_PROFICIENCY};
    }

    @Override
    public int getAttackBonus(int level) {
        return level - 1 - (int)Math.floor( (level - 1) / 4) ;
    }

    @Override
    public Map<String, String> getFragments() {
        final Map<String, String> fragments = new HashMap<String, String>();
        fragments.put("Spells", SpellbookFragment.class.getName());
        return fragments;
    }

    @Override
    public int getLevelupSpecialPowers(int level, PfCharacter character) {
        switch (level) {
            case 1:
                return 6;
            case 2:
                return 2;
            case 3:
                return 2;
            case 4:
                return 2;
            case 5:
                return 1;
            case 6:
                return 1;
            case 7:
                return 3;
            case 8:
                return 1;
            case 9:
                return 1;
            case 10:
                return 3;
            case 11:
                return 2;
            case 12:
                return 1;
            case 13:
                return 3;
            case 14:
                return 2;
            case 15:
                return 1;
            case 16:
                return 3;
            case 17:
                return 2;
            case 18:
                return 1;
            case 19:
                return 1;
            case 20:
                return 2;
        }
        return 0;
    }

    @Override
    public Calculation modifyAttribute(PfCharacter.Attributes attribute, Calculation current, PfCharacter character) {
        // TODO
        return current;
    }

    @Override
    public String toString() {
        return "Bard";
    }
}
