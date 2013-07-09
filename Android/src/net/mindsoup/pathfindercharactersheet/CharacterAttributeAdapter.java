/**
 * 
 */
package net.mindsoup.pathfindercharactersheet;

import net.mindsoup.pathfindercharactersheet.pf.PfAttributes;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;

/**
 * @author Valentijn
 *
 */
public class CharacterAttributeAdapter {
	
	private final PfAttributes attribute;
	private final PfCharacter character;
	private int tempValue = 0;
	
	public CharacterAttributeAdapter(PfAttributes attribute, PfCharacter character) {
		this.attribute = attribute;
		this.character = character;
	}
	
	public PfAttributes getAttribute() {
		return this.attribute;
	}
	
	public void setAttribute(int value) {
		switch(this.attribute) {
		case CHA: 
			character.setBaseCharisma(value);
			break;
		case CON: 
			character.setBaseConstitution(value);
			break;
		case DEX:
			character.setBaseDexterity(value);
			break;
		case INT:
			character.setBaseIntelligence(value);
			break;
		case STR:
			character.setBaseStrength(value);
			break;
		case WIS:
			character.setBaseWisdom(value);
			break;		
		}
	}
	
	public int getValue() {
		return character.getAttributeValue(this.attribute).sum();
	}
	
	public int getBonus() {
		return character.getAttributeBonus(character.getAttributeValue(this.attribute));
	}
	
	public void setTempValue(int value) {
		tempValue = value;
	}
	
	public int getTempValue() {
		return tempValue + this.getValue();
	}
	
	public int getTempBonus() {
		return character.getAttributeBonus(this.getTempValue());
	}
	
	public void sync() {
		this.setTempValue(this.getValue());
	}

}
