package net.mindsoup.pathfindercharactersheet.pf.items;

public abstract class StackableItem extends Item {

	@Override
	public boolean isStackable() {
		return true;
	}

}
