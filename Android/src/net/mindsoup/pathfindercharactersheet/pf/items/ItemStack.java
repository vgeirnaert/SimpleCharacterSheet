package net.mindsoup.pathfindercharactersheet.pf.items;

public class ItemStack<T extends StackableItem> extends Item {
	
	private T item;
	private int amount;
	
	public ItemStack(T argItem) {
		if(argItem == null)
			throw new IllegalArgumentException("Item cannot be null in ItemStack constructor.");
		
		item = argItem;
	}

	@Override
	public String getName() {
		return item.getName();
	}

	@Override
	public ItemType getType() {
		return item.getType();
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int argAmount) {
		amount = argAmount;
	}

	@Override
	public boolean isStackable() {
		return false;
	}
	
}
