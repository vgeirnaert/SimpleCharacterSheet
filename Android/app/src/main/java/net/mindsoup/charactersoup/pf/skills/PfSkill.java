package net.mindsoup.charactersoup.pf.skills;

import java.util.Arrays;

import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfAttributes;
import net.mindsoup.charactersoup.pf.classes.PfClass;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class PfSkill implements Parcelable {
	
	private int level = 0;
	private final PfSkills type;
	private final PfAttributes attribute;
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
		canUseUntrained = in.readByte() == 1;
	}
	
	protected PfSkill(PfSkills type, PfAttributes attribute, boolean armorCheckPenalty, boolean canUseUntrained) {
		this.type = type;
		this.attribute = attribute;
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
		return (this.attribute == PfAttributes.DEX || this.attribute == PfAttributes.STR); 
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
		dest.writeByte((byte) (canUseUntrained ? 1 : 0));	
	}

	@Override
	public boolean equals(Object another) {
		if(another instanceof PfSkill) {
			if( ((PfSkill)another).getType() == this.getType() )
				return true;
			else
				return false;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 31;
		
		hash += this.getType().hashCode();
		
		return hash;
	}
}
