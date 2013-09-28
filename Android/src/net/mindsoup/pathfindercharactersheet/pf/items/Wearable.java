package net.mindsoup.pathfindercharactersheet.pf.items;

import android.os.Parcel;
import android.os.Parcelable;

public class Wearable extends Item implements Parcelable {
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public Wearable createFromParcel(Parcel in) {
	            return new Wearable(in);
	        }

	        public Wearable[] newArray(int size) {
	            return new Wearable[size];
	        }
	    };
	
	private final int armorBonus;
	private final int maxDexBonus;
	private final int armorPenalty;
	
	
	public Wearable(String name, int armorBonus, int maxDexBonus, int armorPenalty) {
		super(name);
		
		this.armorBonus = armorBonus;
		this.maxDexBonus = maxDexBonus;
		this.armorPenalty = armorPenalty;
		
	}

	public Wearable(Parcel in) {
		super(in);
		
		this.armorBonus = in.readInt();
		this.maxDexBonus = in.readInt();
		this.armorPenalty = in.readInt();
		
	}

	@Override
	public ItemType getType() {
		return ItemType.ARMOR;
	}
	
	public int getArmorClass() {
		return armorBonus;
	}
	
	public int getMaxDexBonus() {
		return maxDexBonus;
	}
	
	public int getArmorPenalty() {
		return armorPenalty;
	}

	@Override
	public int describeContents() {
		return 0;
	}
	
	

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		
		dest.writeInt(getArmorClass());
		dest.writeInt(getMaxDexBonus());
		dest.writeInt(getArmorPenalty());
		
	}

	public int getSpeedPenalty() {
		return 0;// TODO: this should actually be -10 or -5 for medium/heavy armor
	}

	public int getSpellFailureChance() {
		return 0;// TODO: this should be the spell failure chance
	}
	

}
