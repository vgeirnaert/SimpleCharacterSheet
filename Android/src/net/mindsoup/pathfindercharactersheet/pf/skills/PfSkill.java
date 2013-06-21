package net.mindsoup.pathfindercharactersheet.pf.skills;

import java.util.Arrays;

import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfAttributes;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfClass;
import android.content.Context;

public class PfSkill {
	
	private int level = 0;
	private final PfSkills type;
	private final PfAttributes attribute;
	private final boolean armorCheckPenalty;
	private final boolean canUseUntrained;
	
	protected PfSkill(PfSkills type, PfAttributes attribute, boolean armorCheckPenalty, boolean canUseUntrained) {
		this.type = type;
		this.attribute = attribute;
		this.armorCheckPenalty = armorCheckPenalty;
		this.canUseUntrained = canUseUntrained;
	}
	
	public PfSkills getType() {
		return this.type;
	}
	
	public PfAttributes getAttribute() {
		return this.attribute;
	}
	
	public String getName(Context context) {
		return getName(context, this.getType());
	}
	
	public static String getName(Context context, PfSkills type) {
		return context.getResources().getStringArray(R.array.skill_names)[type.ordinal()];
	}
	
	public int getRank() {
		return level;
	}

	public void setRank(int rank) {
		this.level = rank;
	}
	
	public boolean hasArmorCheckPenalty() {
		return this.armorCheckPenalty;
	}
	
	public boolean canUseUntrained() {
		return this.canUseUntrained;
	}
	
	public boolean isClassSkill(PfClass argClass) {
		if(Arrays.asList(argClass.getClassSkills()).contains(this.getType()))
			return true;
		
		return false;
	}
}
