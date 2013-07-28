package net.mindsoup.pathfindercharactersheet.pf.items;

import android.os.Parcel;
import android.os.Parcelable;

public class Armor extends Item implements Parcelable {
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public Armor createFromParcel(Parcel in) {
	            return new Armor(in);
	        }

	        public Armor[] newArray(int size) {
	            return new Armor[size];
	        }
	    };
	
	private final String name;
	private final int armorBonus;
	private final int maxDexBonus;
	private final int armorPenalty;
	
	public Armor(String name, int armorBonus, int maxDexBonus, int armorPenalty) {
		this.name = name;
		this.armorBonus = armorBonus;
		this.maxDexBonus = maxDexBonus;
		this.armorPenalty = armorPenalty;
	}

	public Armor(Parcel in) {
		this.name = in.readString();
		this.armorBonus = in.readInt();
		this.maxDexBonus = in.readInt();
		this.armorPenalty = in.readInt();
	
		// value
		in.readInt();
	}

	@Override
	public String getName() {
		return this.name;
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
		return armorBonus;
	}
	
	public int getMaxDexBonus() {
		return maxDexBonus;
	}
	
	public int getArmorPenalty() {
		return armorPenalty;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getName());
		dest.writeInt(getArmorClass());
		dest.writeInt(getMaxDexBonus());
		dest.writeInt(getArmorPenalty());
		dest.writeInt(getValue());
	}
	

}
