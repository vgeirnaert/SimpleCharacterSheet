package net.mindsoup.pathfindercharactersheet.pf.skills;

public enum PfSkills {
	ACROBATICS, APPRAISE, BLUFF, CLIMB, CRAFT, DIPLOMACY, DISABLE_DEVICE, DISGUISE, ESCAPE_ARTIST, FLY, HANDLE_ANIMAL, HEAL, 
	INTIMIDATE, KNOWLEDGE_ARCANA, KNOWLEDGE_DUNGEONEERING, KNOWLEDGE_ENGINEERING, KNOWLEDGE_GEOGRAPHY, KNOWLEDGE_HISTORY, 
	KNOWLEDGE_LOCAL, KNOWLEDGE_NATURE, KNOWLEDGE_NOBILITY, KNOWLEDGE_PLANES, KNOWLEDGE_RELIGION, LINGUISTICS, PERCEPTION,
	PERFORM, PROFESSION, RIDE, SENSE_MOTIVE, SLEIGHT_OF_HAND, SPELLCRAFT, STEALTH, SURVIVAL, SWIM, USE_MAGIC_DEVICE;
	
	public static PfSkills getSkill(int i) {
		switch(i) {
		case 0: return PfSkills.ACROBATICS;
		case 1: return PfSkills.APPRAISE;
		case 2: return PfSkills.BLUFF;
		case 3: return PfSkills.CLIMB;
		case 4: return PfSkills.CRAFT;
		case 5: return PfSkills.DIPLOMACY;
		case 6: return PfSkills.DISABLE_DEVICE;
		case 7: return PfSkills.DISGUISE;
		case 8: return PfSkills.ESCAPE_ARTIST;
		case 9: return PfSkills.FLY;
		case 10: return PfSkills.HANDLE_ANIMAL;
		case 11: return PfSkills.HEAL;
		case 12: return PfSkills.INTIMIDATE;
		case 13: return PfSkills.KNOWLEDGE_ARCANA;
		case 14: return PfSkills.KNOWLEDGE_DUNGEONEERING;
		case 15: return PfSkills.KNOWLEDGE_ENGINEERING;
		case 16: return PfSkills.KNOWLEDGE_GEOGRAPHY;
		case 17: return PfSkills.KNOWLEDGE_HISTORY;
		case 18: return PfSkills.KNOWLEDGE_LOCAL;
		case 19: return PfSkills.KNOWLEDGE_NATURE;
		case 20: return PfSkills.KNOWLEDGE_NOBILITY;
		case 21: return PfSkills.KNOWLEDGE_PLANES;
		case 22: return PfSkills.KNOWLEDGE_RELIGION;
		case 23: return PfSkills.LINGUISTICS;
		case 24: return PfSkills.PERCEPTION;
		case 25: return PfSkills.PERFORM;
		case 26: return PfSkills.PROFESSION;
		case 27: return PfSkills.RIDE;
		case 28: return PfSkills.SENSE_MOTIVE;
		case 29: return PfSkills.SLEIGHT_OF_HAND;
		case 30: return PfSkills.SPELLCRAFT;
		case 31: return PfSkills.STEALTH;
		case 32: return PfSkills.SURVIVAL;
		case 33: return PfSkills.SWIM;
		default: return PfSkills.USE_MAGIC_DEVICE;
		}
	}
}
