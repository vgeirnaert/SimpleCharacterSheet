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
public class PfMonk implements PfClass {
    private final PfSkills[] classSkills = {PfSkills.ACROBATICS, PfSkills.CLIMB, PfSkills.CRAFT, PfSkills.ESCAPE_ARTIST, PfSkills.INTIMIDATE, PfSkills.KNOWLEDGE_HISTORY, PfSkills.KNOWLEDGE_RELIGION, PfSkills.PERCEPTION, PfSkills.PERFORM, PfSkills.PROFESSION, PfSkills.RIDE, PfSkills.SENSE_MOTIVE, PfSkills.STEALTH, PfSkills.SWIM};
    @Override
    public PfClasses getPfClass() {
        return PfClasses.MONK;
    }

    @Override
    public int getBaseSkillRanksPerLevel() {
        return 4;
    }

    @Override
    public Dice getHitDie() {
        return new Dice(8,1);
    }

    @Override
    public int getFortSaveModifier(int level) {
        return (int)Math.floor(level / 2.0) + 2; // + 2 at level 1, +3 at level 2, +4 at level 4
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
        return classSkills;
    }

    @Override
    public PfFeats[] getClassFeats() {
        return new PfFeats[0];
    }

    @Override
    public int getAttackBonus(int level) {
        return level - 1 - (int)Math.floor( (level - 1) / 4) ;
    }

    @Override
    public Map<String, String> getFragments() {
        return new HashMap<String, String>();
    }

    @Override
    public Calculation modifyAttribute(PfCharacter.Attributes attribute, Calculation current, PfCharacter character) {
        if(attribute == PfCharacter.Attributes.AC) {
            current.add("WIS", character.getAttributeBonus(character.getWisdom()));
            current.add("AC Bonus", (int) Math.floor(character.getLevel() / 4.0f));
        }
        return current;
    }

    @Override
    public String toString() {
        return "Monk";
    }

    @Override
    public int getLevelupSpecialPowers(int level, PfCharacter character) {
        return 0;
    }
}
