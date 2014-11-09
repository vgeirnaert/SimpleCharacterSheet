package net.mindsoup.pathfindercharactersheet.pf.items;

public enum ItemEffects {
	NONE, AC_BONUS, DAMAGE_BONUS, ATTACK_BONUS, RESISTANCE, AB_AND_DAMAGE;
	
	public static ItemEffects getEffect(int i) {
		return ItemEffects.values()[i];
	}
}
