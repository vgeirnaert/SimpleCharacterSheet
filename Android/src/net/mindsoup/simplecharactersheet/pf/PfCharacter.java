package net.mindsoup.simplecharactersheet.pf;

import net.mindsoup.simplecharactersheet.pf.classes.PfClass;
import net.mindsoup.simplecharactersheet.pf.races.PfRace;

public class PfCharacter {
	private PfRace myRace;
	private PfClass myClass;
	
	private Weapon ActiveMainhandWeapon = null;
	private Weapon ActiveOffhandWeapon= null;
	
	// stats
	private int constitution = 0;
	private int strength = 0;
	private int dexterity = 0;
	private int intelligence = 0;
	private int wisdom = 0;
	private int charisma = 0;
	
	private int xp = 0;
	private PfPace pace = PfPace.MEDIUM;
	
	private boolean getHpPerLevel;
	
	public PfCharacter(PfRace argRace, PfClass argClass, boolean argHpPerLevel) {
		if(argRace == null) {
			throw new IllegalArgumentException("Character constructor does not accept null values for race.");
		}
		
		if(argClass == null) {
			throw new IllegalArgumentException("Character constructor does not accept null values for class.");
		}
		
		this.myRace = argRace;
		this.myClass = argClass;
		this.getHpPerLevel = argHpPerLevel;
	}
	
	public void setPace(PfPace argPace) {
		this.pace = argPace;
	}
	
	public void setConstitution(int argCon) {
		this.constitution = argCon;
	}
	
	public int getConstitution() {
		return this.constitution + myRace.getConModifier();
	}
	
	public void setStrength(int argStr) {
		this.strength = argStr;
	}
	
	public int getStrength() {
		return this.strength + myRace.getStrModifier();
	}
	
	public void setDexterity(int argDex) {
		this.dexterity = argDex;
	}
	
	public int getDexterity() {
		return this.dexterity + myRace.getDexModifier();
	}
	
	public void setIntelligence(int argInt) {
		this.intelligence = argInt;
	}
	
	public int getIntelligence() {
		return this.intelligence + myRace.getIntModifier();
	}
	
	public void setWisdom(int argWis) {
		this.wisdom = argWis;
	}
	
	public int getWisdom() {
		return this.wisdom + myRace.getWisModifier();
	}
	
	public void setCharisma(int argCha) {
		this.charisma = argCha;
	}
	
	public int getCharisma() {
		return this.charisma + myRace.getChaModifier();
	}
	
	public int getLevel() {
		// TODO: make this complete/better
		switch(this.pace) {
		case SLOW:
			if(this.xp < 3000)
				return 1;
			else if (this.xp < 7500)
				return 2;
			else if (this.xp < 14000)
				return 3;
			else if (this.xp < 23000)
				return 4;
			else if (this.xp < 35000)
				return 5;
			else
				return 6;
		case FAST:
			if(this.xp < 1300)
				return 1;
			else if (this.xp < 3300)
				return 2;
			else if (this.xp < 6000)
				return 3;
			else if (this.xp < 10000)
				return 4;
			else if (this.xp < 15000)
				return 5;
			else
				return 6;
		default:	// medium
			if(this.xp < 2000)
				return 1;
			else if (this.xp < 5000)
				return 2;
			else if (this.xp < 9000)
				return 3;
			else if (this.xp < 15000)
				return 4;
			else if (this.xp < 23000)
				return 5;
			else
				return 6;
		} 
		
		
	}
	
	public int getAttributeBonus(int attribute) {
		// see core rulebook page 17
		return (int)Math.floor( (attribute / 2.0) - 5);
	}
	
	/**
	 * Get the Base Attack Bonus. Since some characters can do multiple attacks per round (see getNumAttacksPerRound()),
	 * make sure to include if this is attack 0, 1, 2, etc.
	 * <br><br>
	 * Note that this attack index is zero based, so the first attack has index 0, second attack index 1, etc.
	 *  
	 * @param attack Attack index within the round.
	 * @return Base Attack Bonus
	 */
	public int getBaseAttackBonus(int attack) {
		return Math.max( this.getLevel() - (attack * this.myClass.getExtraAttackPerNumLevels()), 0);
	}
	
	public int getNumAttacksPerRound() {
		return (int)Math.ceil(this.getLevel() / this.myClass.getExtraAttackPerNumLevels());
	}
	
	/**
	 * Change this character's active mainhand weapon. When changing weapons, always change mainhand first.
	 * 
	 * @param weapon
	 * @return true on success
	 */
	public boolean setMainhandWeapon(Weapon weapon) {
		this.ActiveMainhandWeapon = weapon;
		
		// if the weapon is a two handed weapon, we don't carry another weapon in our offhand
		if(this.ActiveMainhandWeapon.getHandedness() == PfHandedness.TWOHAND) 
			this.ActiveOffhandWeapon = null;
		
		return true;
	}
	
	/**
	 * Change this character's active offhand weapon. When changing weapons, always change mainhand first.
	 * 
	 * @param weapon
	 * @return true on success
	 */
	public boolean setOffhandWeapon(Weapon weapon) {
		// set an offhand weapon only if we're not already carrying a two handed weapon
		if(this.ActiveMainhandWeapon.getHandedness() != PfHandedness.TWOHAND) {
			this.ActiveOffhandWeapon = weapon;
			return true;
		}
		
		return false;
	}
	
	public Weapon getMainhandWeapon() {
		return this.ActiveMainhandWeapon;
	}
	
	public Weapon getOffhanddWeapon() {
		return this.ActiveOffhandWeapon;
	}
	
	public int getXp() {
		return xp;
	}
	
	public void setXp(int amount) {
		this.xp = amount;
	}
	
	public int getMaxHitpoints() {
		int hp = this.myClass.getHitDie() + this.getAttributeBonus(this.getConstitution());
				
		if(getHpPerLevel)
			hp += this.getLevel();
				
		return hp;
	}
	
	public int getAC() {
		// core rulebook page 179
		// TODO: add armor/shield
		return 10 + this.getAttributeBonus(this.getDexterity());
	}
	
	public int getAttackBonus(int attack) {
		// core rulebook page 178
		return this.getBaseAttackBonus(attack) + this.getAttributeBonus(this.getStrength()) + this.getSizeModifier(); 
	}
	
	public int getSizeModifier() {
		switch(this.myRace.getSize()) {
			case SMALL:
				return 1;
			case MEDIUM:
				return 0;
			case LARGE:
				return -1;
			default:
				return 0;
		}
	}
	
	public int getDamageModifier() {
		double multiplier = 1.0;
		
		if(this.ActiveMainhandWeapon.getHandedness() == PfHandedness.TWOHAND)
			multiplier = 1.5;
			
		return (int)Math.floor(this.getAttributeBonus(this.getStrength()) * multiplier);
	}
	
}
