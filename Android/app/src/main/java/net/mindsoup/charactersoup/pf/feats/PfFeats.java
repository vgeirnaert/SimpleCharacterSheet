/**
 * 
 */
package net.mindsoup.charactersoup.pf.feats;

/**
 * @author Valentijn
 *
 */
public enum PfFeats {
	
	ACROBATIC, ACROBATIC_STEPS, AGILE_MANEUVERS, ALERTNESS, ALIGNMENT_CHANNEL, ANIMAL_AFFINITY, ARCANE_ARMOR_MASTERY, ARCANE_ARMOR_TRAINING, 
	ARCANE_STRIKE, ARMOR_PROFICIENCY_HEAVY, ARMOR_PROFICIENCY_LIGHT, ARMOR_PROFICIENCY_MEDIUM, ATHLETIC, AUGMENT_SUMMONING, BLEEDING_CRITICAL, 
	BLIND_FIGHT, BLINDING_CRITICAL, BREW_POTION, CATCH_OFF_GUARD, CHANNEL_SMITE, CLEAVE, COMBAT_CASTING, COMBAT_EXPERTISE, COMBAT_REFLEXES, COMMAND_UNDEAD, 
	CRAFT_MAGIC_ARMS_AND_ARMOR, CRAFT_ROD, CRAFT_WAND, CRAFT_STAFF, CRAFT_WONDROUS_ITEM, CRITICAL_FOCUS, CRITICAL_MASTERY, DAZZLING_DISPLAY, 
	DEADLY_AIM, DEADLY_STROKE, DEAFENING_CRITICAL, DECEITFUL, DEFENSIVE_COMBAT_TRAINING, DEFLECT_ARROWS, DEFT_HANDS, DIEHARD, DISRUPTIVE, DODGE, 
	DOUBLE_SLICE, ELEMENTAL_CHANNEL, EMPOWER_SPELL, ENDURANCE, ENLARGE_SPELL, ESCHEW_MATERIALS, EXHAUSTING_CRITICAL, EXOTIC_WEAPON_PROFICIENCY, 
	EXTEND_SPELL, EXTRA_CHANNEL, EXTRA_KI, EXTRA_LAY_ON_HANDS, EXTRA_MERCY, EXTRA_PERFORMANCE, EXTRA_RAGE, FAR_SHOT, FLEET, FORGE_RING, GORGONS_FIST, 
	GREAT_CLEAVE, GREAT_FORTITUDE, GREATER_BULL_RUSH, GREATER_DISARM, GREATER_FEINT, GREATER_GRAPPLE, GREATER_OVERRUN, GREATER_PENETRATING_STRIKE, 
	GREATER_SHIELD_FOCUS, GREATER_SPELL_FOCUS, GREATER_SPELL_PENETRATION, GREATER_SUNDER, GREATER_TRIP, GREATER_TWO_WEAPON_FIGHTING, GREATER_VITAL_STRIKE, 
	GREATER_WEAPON_FOCUS, GREATER_WEAPON_SPECIALIZATION, HEIGHTEN_SPELL, IMPROVED_BULL_RUSH, IMPROVED_CHANNEL, IMPROVED_COUNTERSPELL, IMPROVED_CRITICAL, 
	IMPROVED_DISARM, IMPROVED_FAMILIAR, IMPROVED_FEINT, IMPROVED_GRAPPLE, IMPROVED_GREAT_FORTITUDE, IMPROVED_INITIATIVE, IMPROVED_IRON_WILL, 
	IMPROVED_LIGHTNING_REFLEXES, IMPROVED_OVERRUN, IMPROVED_PRECISE_SHOT, IMPROVED_SHIELD_BASH, IMPROVED_SUNDER, IMPROVED_TRIP, IMPROVED_TWO_WEAPON_FIGHTING, 
	IMPROVED_UNARMED_STRIKE, IMPROVED_VITAL_STRIKE, IMPROVISED_WEAPON_MASTERY, INTIMIDATING_PROWESS, IRON_WILL, LEADERSHIP, LIGHTNING_REFLEXES, LIGHTNING_STANCE, 
	LUNGE, MAGICAL_APTITUDE, MANYSHOT, MARTIAL_WEAPON_PROFICIENCY, MASTER_CRAFTSMAN, MAXIMIZE_SPELL, MEDUSAS_WRATH, MOBILITY, MOUNTED_ARCHERY, 
	MOUNTED_COMBAT, NATURAL_SPELL, NIMBLE_MOVES, PENETRATING_STRIKE, PERSUASIVE, PINPOINT_TARGETING, POINT_BLANK_SHOT, POWER_ATTACK, PRECISE_SHOT, QUICK_DRAW,
	QUICKEN_SPELL, RAPID_RELOAD, RAPID_SHOT, RIDE_BY_ATTACK, RUN, SCORPION_STYLE, SCRIBE_SCROLL, SELECTIVE_CHANNELING, SELF_SUFFICIENT, SHATTER_DEFENSES, 
	SHIELD_FOCUS, SHIELD_PROFICIENCY, SHIELD_SLAM, SHOT_ON_THE_RUN, SICKENING_CRITICAL, SILENT_SPELL, SIMPLE_WEAPON_PROFICIENCY, SKILL_FOCUS, SNATCH_ARROWS, 
	SPELL_FOCUS, SPELL_MASTERY, SPELL_PENETRATION, SPELLBREAKER, SPIRITED_CHARGE, SPRING_ATTACK, STAGGERING_CRITICAL, STAND_STILL, STEALTHY, STEP_UP, STILL_SPELL, 
	STRIKE_BACK, STUNNING_CRITICAL, STUNNING_FIST, THROW_ANYTHING, TIRING_CRITICAL, TOUGHNESS, TOWER_SHIELD_PROFICIENCY, TRAMPLE, TURN_UNDEAD, TWO_WEAPON_DEFENSE, 
	TWO_WEAPON_FIGHTING, TWO_WEAPON_REND, UNSEAT, VITAL_STRIKE, WEAPON_FINESSE, WEAPON_FOCUS, WEAPON_SPECIALIZATION, WHIRLWIND_ATTACK, WIDEN_SPELL, WIND_STANCE, RAGING_VITALITY;

	public static PfFeats getFeat(int i) {
		return PfFeats.values()[i];
	}
}
