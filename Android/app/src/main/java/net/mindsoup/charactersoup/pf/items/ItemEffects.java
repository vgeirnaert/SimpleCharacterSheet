package net.mindsoup.charactersoup.pf.items;

public enum ItemEffects {
	NONE, AC_BONUS, DAMAGE_BONUS, ATTACK_BONUS, RESISTANCE, AB_AND_DAMAGE, CHA_BONUS, CON_BONUS, DEX_BONUS, INT_BONUS, STR_BONUS, WIS_BONUS, CON_DEX_STR_BONUS;
	
	public static ItemEffects getEffect(int i) {
		return ItemEffects.values()[i];
	}
}
