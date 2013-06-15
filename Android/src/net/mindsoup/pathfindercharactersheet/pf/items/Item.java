package net.mindsoup.pathfindercharactersheet.pf.items;

public abstract class Item {
	
	abstract public String getName();
	abstract public ItemType getType();
	abstract public boolean isStackable();
}
