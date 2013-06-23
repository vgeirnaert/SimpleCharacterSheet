package net.mindsoup.pathfindercharactersheet.pf;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfClass;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.races.PfRace;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkill;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.skills.SkillFactory;
import net.mindsoup.pathfindercharactersheet.pf.util.Calculation;
import android.os.Parcel;
import android.os.Parcelable;

public class PfCharacter implements Parcelable {
	private PfRace myRace;
	private PfClass myClass;
	private String name;
	
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
	private int availableSkillRanks = 0;
	
	private boolean getHpPerLevel;
	
	private Map<PfSkills, PfSkill> trainedSkills = new HashMap<PfSkills, PfSkill>();
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public PfCharacter createFromParcel(Parcel in) {
	            return new PfCharacter(in);
	        }

	        public PfCharacter[] newArray(int size) {
	            return new PfCharacter[size];
	        }
	    };
	    
	public PfCharacter(Parcel in) {
		readFromParcel(in);
	}
	
	public PfCharacter(PfRace argRace, PfClass argClass, boolean argHpPerLevel, String name) {
		if(argRace == null) {
			throw new IllegalArgumentException("Character constructor does not accept null values for race.");
		}
		
		if(argClass == null) {
			throw new IllegalArgumentException("Character constructor does not accept null values for class.");
		}
		
		this.myRace = argRace;
		this.myClass = argClass;
		this.getHpPerLevel = argHpPerLevel;
		this.name = name;
	}
	
	public PfRace getRace() {
		return myRace;
	}
	
	public PfClass getPfClass() {
		return myClass;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPace(PfPace argPace) {
		this.pace = argPace;
	}
	
	public int getAvailableSkillRanks() {
		return availableSkillRanks;
	}
	
	/**
	 * This function should not be called to add skill ranks when
	 * leveling up - only to initialise skill ranks at a certain 
	 * amount. 
	 * 
	 * For leveling up, add XP (either addXp() or setXp())  and if 
	 * a new level is reached levelUp() is automatically called, 
	 * which adds the correct amount of skill ranks.
	 */
	public void setAvailableSkillRanks(int ranks) {
		this.availableSkillRanks = ranks;
	}
	
	public void setConstitution(int argCon) {
		this.constitution = argCon;
	}
	
	public Calculation getConstitution() {
		Calculation c = new Calculation();
		c.add("Constitution",  this.constitution);
		c.add("Racial modifier", myRace.getConModifier());
		
		return c;
	}
	
	public void setStrength(int argStr) {
		this.strength = argStr;
	}
	
	public Calculation getStrength() {
		Calculation c = new Calculation();
		c.add("Strength",  this.strength);
		c.add("Racial modifier", myRace.getStrModifier());
		
		return c;
	}
	
	public void setDexterity(int argDex) {
		this.dexterity = argDex;
	}
	
	public Calculation getDexterity() {
		Calculation c = new Calculation();
		c.add("Dexterity",  this.dexterity);
		c.add("Racial modifier", myRace.getDexModifier());
		
		return c;
	}
	
	public void setIntelligence(int argInt) {
		this.intelligence = argInt;
	}
	
	public Calculation getIntelligence() {
		Calculation c = new Calculation();
		c.add("Intelligence",  this.intelligence);
		c.add("Racial modifier", myRace.getIntModifier());
		
		return c;
	}
	
	public void setWisdom(int argWis) {
		this.wisdom = argWis;
	}
	
	public Calculation getWisdom() {
		Calculation c = new Calculation();
		c.add("Wisdom",  this.wisdom);
		c.add("Racial modifier", myRace.getWisModifier());
		
		return c;
	}
	
	public void setCharisma(int argCha) {
		this.charisma = argCha;
	}
	
	public Calculation getCharisma() {
		Calculation c = new Calculation();
		c.add("Charisma",  this.charisma);
		c.add("Racial modifier", myRace.getChaModifier());
		
		return c;
	}
	
	public Calculation getAttributeValue(PfAttributes attribute) {
		switch(attribute) {
		case CHARISMA:
			return getCharisma();
		case CONSTITUTION:
			return getConstitution();
		case DEXTERITY:
			return getDexterity();
		case INTELLIGENCE:
			return getIntelligence();
		case STRENGTH:
			return getStrength();
		case WISDOM:
			return getWisdom();
		default:
			throw new RuntimeException("Invalid attribute. This should never happen!");
		}
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
	
	public int getAttributeBonus(Calculation attribute) {
		return getAttributeBonus(attribute.sum());
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
		return (int)Math.ceil((double)this.getLevel() / this.myClass.getExtraAttackPerNumLevels());
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
	

	
	public void levelUp() {
		this.availableSkillRanks = myClass.getBaseSkillRanksPerLevel() + this.getAttributeBonus(this.getIntelligence());
	}
	
	public int getXp() {
		return xp;
	}
	
	public void setXp(int amount) {
		int oldLevel = this.getLevel();
		this.xp = amount;
		
		if(oldLevel < this.getLevel()) 
			levelUp();
	}
	
	public void addXp(int amount) {
		this.setXp(this.getXp() + amount);
	}
	
	public Calculation getMaxHitpoints() {
		Calculation hp = new Calculation();
		
		hp.add("Hit dice", this.myClass.getHitDie());
		hp.add("Constitution bonus", this.getAttributeBonus(this.getConstitution()));
				
		if(getHpPerLevel)
			hp.add("Hitpoints per level", this.getLevel());
				
		return hp;
	}
	
	public Calculation getAC() {
		Calculation ac = new Calculation();
		// core rulebook page 179
		// TODO: add armor/shield
		ac.add("Base", 10);
		ac.add("Dexterity bonus", this.getAttributeBonus(this.getDexterity()));
		return ac;
	}
	
	public Calculation getAttackBonus(int attack) {
		// core rulebook page 178
		Calculation ab = new Calculation();
		ab.add("Base attack bonus", this.getBaseAttackBonus(attack));
		ab.add("Strength modifier", this.getAttributeBonus(this.getStrength()));
		ab.add("Size modifier", this.getSizeModifier());
		
		return ab; 
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
		
		if(this.ActiveMainhandWeapon != null) {
			if(this.ActiveMainhandWeapon.getHandedness() == PfHandedness.TWOHAND)
				multiplier = 1.5;
		}
			
		return (int)Math.floor(this.getAttributeBonus(this.getStrength()) * multiplier);
	}
	
	/**
	 * Makes best effort to train a skill. Game rules may prohibit adding
	 * more ranks to a skill, however. Use the return value to check how
	 * many skill ranks were actually applied.
	 * 
	 * @param type the skill type to train
	 * @param ranks how many ranks to put in the skill
	 * @return the number of skill ranks actually applied to the skill
	 */
	public int trainSkill(PfSkills type, int ranks) {
		PfSkill skill = trainedSkills.get(type);
		
		// if we did not train this skill already
		if(skill == null) {
			// get the skill and add it to our trained skills
			skill = SkillFactory.getSkill(type);
			trainedSkills.put(type, skill);
		}
		
		// calculate the maximum amount of skill ranks that can be applied:
		// total skill rank must remain smaller than or equal to character level
		// skill ranks must be available
		int maxRanks = Math.min(Math.min(this.getLevel() - skill.getRank(), ranks), this.getAvailableSkillRanks());
		
		// apply the skill ranks, making sure not to exceed our character level
		skill.setRank( skill.getRank() + maxRanks);
		
		// return 
		return maxRanks;
	}
	
	public boolean canUseSkill(PfSkills type) {
		return SkillFactory.getSkill(type).canUseUntrained() || trainedSkills.containsKey(type);
	}
	
	public Calculation getSkillBonus(PfSkills type) {
		PfSkill skill = trainedSkills.get(type);
		
		Calculation trainedBonus = new Calculation();
					
		// if we have not trained the skill get an untrained skill 
		// note that here we don't check if this skill can be used untrained
		// use canUseSkill() to determine that
		if(skill == null) {
			skill = SkillFactory.getSkill(type);
		} else {
			// we've trained the skill, so get the skill ranks
			trainedBonus.add("Skill rank", skill.getRank());
			
			// is this a class skill? if so we get a bonus!
			if(skill.isClassSkill(this.myClass))
				trainedBonus.add("Class skill", 3);
		}
		
		// our ability modifier for this skill
		int abilityModifier = this.getAttributeBonus(this.getAttributeValue(skill.getAttribute()));
		trainedBonus.add("Ability modifier", abilityModifier);
		
		// TODO: add armor check penalty for skills where skill.hasArmorCheckPenalty() is true
		
		return trainedBonus;
	}
	
	public Collection<PfSkill> getTrainedSkills() {
		return trainedSkills.values();
	}
	
	public int getPortraitRes() {
		return R.drawable.ic_action_user;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(myClass.getPfClass().ordinal());
		out.writeInt(myRace.getRace().ordinal());
		out.writeString(name);
		out.writeInt(xp);
	}
	
	public void readFromParcel(Parcel in) {
		// TODO: complete parcelization
		myClass = getClass(in.readInt());
		myRace = getRace(in.readInt());
		name = in.readString();
		xp = in.readInt();
	}
	
	public PfClass getClass(int classType) {
		switch(classType) {
			case 0: // barbarian
				return new PfBarbarian();
			case 1: //bard
				return new PfBarbarian();
			case 2:
				return new PfBarbarian();
			case 3:
				return new PfBarbarian();
			case 4:
				return new PfBarbarian();
			case 5:
				return new PfBarbarian();
			case 6:
				return new PfBarbarian();
			case 7:
				return new PfBarbarian();
			case 8:
				return new PfBarbarian();
			case 9:
				return new PfBarbarian();
			case 10:
				return new PfBarbarian();
			default:
				throw new RuntimeException("Unable to create class of type " + classType + ". This should never happen!");
		}
	}
	
	public PfRace getRace(int raceType) {
		switch(raceType) {
		case 0: // dwarf
			return new PfDwarf();
		case 1: // elf
			return new PfDwarf();
		case 2: //gnome
			return new PfDwarf();
		case 3: //halfelf
			return new PfDwarf();
		case 4: //halfling
			return new PfDwarf();
		case 5: //halforc
			return new PfDwarf();
		case 6: //human
			return new PfDwarf();
		default:
			throw new RuntimeException("Unable to create race of type " + raceType + ". This should never happen!");

		}
	}
	
	
}
