package net.mindsoup.charactersoup.pf.items;

import android.os.Parcel;
import android.os.Parcelable;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.races.PfRace;

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
	private final int speedPenalty;
	
	public Wearable(String name, int armorBonus, int maxDexBonus, int armorPenalty, int speedPenalty) {
		super(name);
		
		this.armorBonus = armorBonus;
		this.maxDexBonus = maxDexBonus;
		this.armorPenalty = armorPenalty;
        this.speedPenalty = speedPenalty;
		
	}

	public Wearable(Parcel in) {
		super(in);
		
		this.armorBonus = in.readInt();
		this.maxDexBonus = in.readInt();
		this.armorPenalty = in.readInt();
        this.speedPenalty = in.readInt();
		
	}

	@Override
	public ItemType getType() {
		return ItemType.WEARABLE;
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
        dest.writeInt(getSpeedPenalty());
		
	}

	public int getSpeedPenalty() {
        return speedPenalty;
	}

	public int getSpellFailureChance() {
		return 0;// TODO: this should be the spell failure chance
	}
	

}
