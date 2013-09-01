package net.mindsoup.pathfindercharactersheet.pf.items;

import android.os.Parcel;
import android.os.Parcelable;


public class Item implements Parcelable {
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public Item createFromParcel(Parcel in) {
	            return new Item(in);
	        }

	        public Item[] newArray(int size) {
	            return new Item[size];
	        }
	    };
	
	private String name = "";
	private String description = "";
	private int value = 0;
	private float weight = 1;
	private int amount = 1;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(Parcel in) {
		this.name = in.readString();
		this.description = in.readString();
		this.value = in.readInt();
		this.amount = in.readInt();
		this.weight = in.readFloat();
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ItemType getType() {
		return ItemType.ITEM;
	}
	
	public int getStackSize() {
		return amount;
	}
	
	public int getValue() {
		return value;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public float getStackWeight() {
		return getWeight() * amount;
	}
	
	public int getStackValue() {
		return getValue() * amount;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStackSize(int amount) {
		this.amount = amount;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(description);
		dest.writeInt(value);
		dest.writeInt(amount);
		dest.writeFloat(weight);
	}

	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
    public boolean equals(Object object) {
        if(object != null && object instanceof Item) {
        	return ((Item)object).getName().equalsIgnoreCase(this.getName());
        }
        
        return false;
    }
}
