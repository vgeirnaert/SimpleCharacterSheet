package net.mindsoup.pathfindercharactersheet.pf.items;

import android.os.Parcel;
import android.os.Parcelable;
import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;

public class Weapon extends Item {
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public Weapon createFromParcel(Parcel in) {
	            return new Weapon(in);
	        }

	        public Weapon[] newArray(int size) {
	            return new Weapon[size];
	        }
	    };
	    
	private Dice damage;
	private int criticalMultiplier;
	private int criticalRange;
	private PfHandedness handedness;
	private String damageType = "Bludgeoning";
	private int range = 1;
	
	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public Weapon(String name, Dice argDamage, int argCriticalMultiplier, int argCriticalRange, PfHandedness hand) {
		super(name);
		
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
	
	public int getCriticalRangeNumeric() {
		return this.criticalRange;
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
	public ItemType getType() {
		return ItemType.WEAPON;
	}
	
	public Weapon(Parcel in) {
		super(in);
		
		this.criticalMultiplier = in.readInt();
		this.criticalRange = in.readInt();
		this.damage = new Dice(in.readString());
		this.damageType = in.readString();
		this.handedness = PfHandedness.getHandedness(in.readInt());
		this.range = in.readInt();
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		
		dest.writeInt(this.getCriticalMultiplier());
		dest.writeInt(this.criticalRange);
		dest.writeString(this.getDamage().toString());
		dest.writeString(this.getDamageType());
		dest.writeInt(this.getHandedness().ordinal());
		dest.writeInt(this.getRange());
	}

}
