package net.mindsoup.pathfindercharactersheet.pf.items;

public class Armor extends Item {

	@Override
	public String getName() {
		return null;
	}

	@Override
	public ItemType getType() {
		return ItemType.ARMOR;
	}

	@Override
	public boolean isStackable() {
		return false;
	}
	
	public int getArmorClass() {
		return 0;
	}
	
	public int getMaxDexBonus() {
		return 0;
	}
	
	public int getArmorPenalty() {
		return 0;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
