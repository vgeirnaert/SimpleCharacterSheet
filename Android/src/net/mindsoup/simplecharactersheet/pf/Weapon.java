package net.mindsoup.simplecharactersheet.pf;

public class Weapon {
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
	
	public String getDamage() {
		return damage.toString();
	}
	
	public String getCriticalRange() {
		if(criticalRange > 1)
			return Integer.toString(21 - criticalRange) + "-20";
			
		return "20";
	}
	
	public String getCriticalMultiplier() {
		return Integer.toString(criticalMultiplier);
	}
	
	public int getMaxDamage() {
		return damage.getMax() * criticalMultiplier;
	}
	
	public PfHandedness getHandedness() {
		return handedness;
	}
}
