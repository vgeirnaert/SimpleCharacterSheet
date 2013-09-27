package net.mindsoup.pathfindercharactersheet.pf.items;

public enum ItemSlots {
	NOT_EQUIPABLE, 
	BODY,	// armour, robes, etc
	CHEST, 	// shirts, vests
	EYES,	// glasses, goggles
	FEET, 	// shoes, boots
	HANDS,	// gloves, gauntlets
	HEAD, 	// helmets, hats
	HEADBAND,	// headbands, phylacteries
	NECK,	// amulet, necklace
	RING,	// rings (max 2)
	SHIELD,	// shields
	SHOULDERS,	// capes, cloaks
	WEAPON, // weapons of all kinds
	WRIST;	// bracers, bracelets
	
	public static ItemSlots getItemSlot(int i) {
		return ItemSlots.values()[i];
	}
}
