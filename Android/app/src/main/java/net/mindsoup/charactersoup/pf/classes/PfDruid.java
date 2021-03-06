package net.mindsoup.charactersoup.pf.classes;

import net.mindsoup.charactersoup.fragments.SpellbookFragment;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.PfClasses;
import net.mindsoup.charactersoup.pf.feats.PfFeats;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import net.mindsoup.charactersoup.pf.util.Calculation;
import net.mindsoup.charactersoup.pf.util.Dice;
import net.mindsoup.charactersoup.util.CharacterSoupUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentijn on 20-10-2014.
 */
public class PfDruid implements PfClass {
    @Override
    public PfClasses getPfClass() {
        return PfClasses.DRUID;
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
        return (int)Math.floor(level / 3.0); // +1 at level 3, +2 at level 6
    }

    @Override
    public int getExtraAttackPerNumLevels() {
        return 8;
    }

    @Override
    public PfSkills[] getClassSkills() {
        return new PfSkills[0];
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
        return "Druid";
    }

    @Override
    public int getLevelupSpecialPowers(int level, PfCharacter character) {
        int bonusSpells = CharacterSoupUtils.getBonusSpellsPerDay((int) Math.ceil(character.getAttributeBonus(character.getWisdom())));
        switch (level) {
            case 1:
                return 4 + bonusSpells;
            case 2:
                return 2 + bonusSpells;
            case 3:
                return 1 + bonusSpells;
            case 4:
                return 2 + bonusSpells;
            case 5:
                return 1 + bonusSpells;
            case 6:
                return 2 + bonusSpells;
            case 7:
                return 2 + bonusSpells;
            case 8:
                return 2 + bonusSpells;
            case 9:
                return 2 + bonusSpells;
            case 10:
                return 2 + bonusSpells;
            case 11:
                return 2 + bonusSpells;
            case 12:
                return 2 + bonusSpells;
            case 13:
                return 2 + bonusSpells;
            case 14:
                return 2 + bonusSpells;
            case 15:
                return 2 + bonusSpells;
            case 16:
                return 2 + bonusSpells;
            case 17:
                return 2 + bonusSpells;
            case 18:
                return 2 + bonusSpells;
            case 19:
                return 2 + bonusSpells;
            case 20:
                return 2 + bonusSpells;
        }
        return 0;
    }
}
