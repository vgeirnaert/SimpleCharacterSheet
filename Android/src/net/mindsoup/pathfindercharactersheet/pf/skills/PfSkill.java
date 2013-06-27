package net.mindsoup.pathfindercharactersheet.pf.skills;

import java.util.Arrays;

import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfAttributes;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfClass;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class PfSkill implements Parcelable{
	
	private int level = 0;
	private final PfSkills type;
	private final PfAttributes attribute;
	private final boolean armorCheckPenalty;
	private final boolean canUseUntrained;
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public PfSkill createFromParcel(Parcel in) {
	            return new PfSkill(in);
	        }

	        public PfSkill[] newArray(int size) {
	            return new PfSkill[size];
	        }
	    };
	
	public PfSkill(Parcel in) {		
		level = in.readInt();
		type = PfSkills.getSkill(in.readInt());
		attribute = PfAttributes.getAttribute(in.readInt());
		armorCheckPenalty = in.readByte() == 1;
		canUseUntrained = in.readByte() == 1;
	}
	
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(level);
		dest.writeInt(type.ordinal());
		dest.writeInt(attribute.ordinal());
		dest.writeByte((byte) (armorCheckPenalty ? 1 : 0));
		dest.writeByte((byte) (canUseUntrained ? 1 : 0));	
	}
}
