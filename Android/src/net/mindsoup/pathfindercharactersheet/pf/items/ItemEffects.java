package net.mindsoup.pathfindercharactersheet.pf.items;

public enum ItemEffects {
	AC_BONUS, DAMAGE_BONUS, ATTACK_BONUS;
	
	public static ItemEffects getEffect(int i) {
		return ItemEffects.values()[i];
	}
}
