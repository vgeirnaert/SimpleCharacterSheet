package net.mindsoup.charactersoup.pf.skills;

import net.mindsoup.charactersoup.pf.PfAttributes;

public class SkillFactory {

	public static PfSkill getSkill(PfSkills type) {
		switch (type) {
		case ACROBATICS:
			return new PfSkill(type, PfAttributes.DEX, true, true);
		case APPRAISE:
			return new PfSkill(type, PfAttributes.INT, false, true);
		case BLUFF:
			return new PfSkill(type, PfAttributes.CHA, false, true);
		case CLIMB:
			return new PfSkill(type, PfAttributes.STR, true, true);
		case CRAFT:
			return new PfSkill(type, PfAttributes.INT, false, true);
		case DIPLOMACY:
			return new PfSkill(type, PfAttributes.CHA, false, true);
		case DISABLE_DEVICE:
			return new PfSkill(type, PfAttributes.DEX, true, false);
		case DISGUISE:
			return new PfSkill(type, PfAttributes.CHA, true, true);
		case ESCAPE_ARTIST:
			return new PfSkill(type, PfAttributes.DEX, true, true);
		case FLY:
			return new PfSkill(type, PfAttributes.DEX, true, true);
		case HANDLE_ANIMAL:
			return new PfSkill(type, PfAttributes.CHA, false, false);
		case HEAL:
			return new PfSkill(type, PfAttributes.WIS, false, true);
		case INTIMIDATE:
			return new PfSkill(type, PfAttributes.CHA, false, true);
		case KNOWLEDGE_ARCANA:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_DUNGEONEERING:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_ENGINEERING:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_GEOGRAPHY:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_HISTORY:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_LOCAL:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_NATURE:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_NOBILITY:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_PLANES:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case KNOWLEDGE_RELIGION:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case LINGUISTICS:
			return new PfSkill(type, PfAttributes.DEX, false, false);
		case PERCEPTION:
			return new PfSkill(type, PfAttributes.WIS, false, true);
		case PERFORM:
			return new PfSkill(type, PfAttributes.CHA, false, true);
		case PROFESSION:
			return new PfSkill(type, PfAttributes.WIS, false, false);
		case RIDE:
			return new PfSkill(type, PfAttributes.DEX, true, true);
		case SENSE_MOTIVE:
			return new PfSkill(type, PfAttributes.WIS, false, true);
		case SLEIGHT_OF_HAND:
			return new PfSkill(type, PfAttributes.DEX, true, false);
		case SPELLCRAFT:
			return new PfSkill(type, PfAttributes.INT, false, false);
		case STEALTH:
			return new PfSkill(type, PfAttributes.DEX, true, true);
		case SURVIVAL:
			return new PfSkill(type, PfAttributes.WIS, false, true);
		case SWIM:
			return new PfSkill(type, PfAttributes.STR, true, true);
		case USE_MAGIC_DEVICE:
			return new PfSkill(type, PfAttributes.CHA, false, false);
		default:
			throw new RuntimeException("Invalid skill type specified. This should never happen!");
		}
	}
}
