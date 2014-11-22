package net.mindsoup.charactersoup.pf.items;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;


public class Item implements Comparable<Item>, Parcelable {
	
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
	private ItemSlots slot = ItemSlots.NOT_EQUIPABLE;
	private Map<ItemEffects, Integer> effects = new HashMap<ItemEffects, Integer>();
	private boolean isEquiped = false;
	
	public Item(String name) {
		this.name = name;
	}
	
	public void addEffect(ItemEffects effect, int value) {
		if(effect != ItemEffects.NONE)
			effects.put(effect, value);
	}
	
	public Map<ItemEffects, Integer> getEffects() {
		return effects;
	}
	
	public ItemSlots getSlot() {
		return slot;
	}

	public void setSlot(ItemSlots slot) {
		this.slot = slot;
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
	
	public void equip() {
		if(this.getSlot() != ItemSlots.NOT_EQUIPABLE)
			isEquiped = true;
	}
	
	public void unequip() {
		isEquiped = false;
	}
	
	public boolean isEquiped() {
		return isEquiped;
	}
	
	public Item(Parcel in) {
		this.name = in.readString();
		this.description = in.readString();
		this.value = in.readInt();
		this.amount = in.readInt();
		this.weight = in.readFloat();
		this.slot = ItemSlots.getItemSlot(in.readInt());
		
		Bundle bun = in.readBundle();
		
		for(String s : bun.keySet()) {
			this.addEffect(ItemEffects.valueOf(s), bun.getInt(s));
		}
		
		this.isEquiped = (in.readByte() == 1);
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(description);
		dest.writeInt(value);
		dest.writeInt(amount);
		dest.writeFloat(weight);
		dest.writeInt(slot.ordinal());
		
		Bundle bun = new Bundle();
		for(ItemEffects e : effects.keySet())
			bun.putInt(e.toString(), effects.get(e));
		
		dest.writeBundle(bun);
		dest.writeByte((byte)(isEquiped ? 1 : 0));
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

	@Override
	public int compareTo(Item another) {
		return this.name.compareTo( another.getName() );
	}
}
