package net.mindsoup.pathfindercharactersheet.pf.items;

import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;

public class Weapon extends Item {
	private Dice damage;
	private int criticalMultiplier;
	private int criticalRange;
	private PfHandedness handedness;
	
	public Weapon(Dice argDamage, int argCriticalMultiplier, int argCriticalRange, PfHandedness hand) {
		this.damage = argDamage;
		this.criticalMultiplier = argCriticalMultiplier;
		this.criticalRange = argCriticalRange;
		this.handedness = hand;
	}
	
	public Dice getDamage() {
		return damage;
	}
	
	public String getCriticalRange() {
		if(criticalRange > 1)
			return Integer.toString(21 - criticalRange) + "-20";
			
		return "20";
	}
	
	public int getCriticalMultiplier() {
		return criticalMultiplier;
	}
	
	public int getMaxDamage() {
		return damage.getMax() * criticalMultiplier;
	}
	
	public PfHandedness getHandedness() {
		return handedness;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemType getType() {
		return ItemType.WEAPON;
	}

	@Override
	public boolean isStackable() {
		return false;
	}
}
