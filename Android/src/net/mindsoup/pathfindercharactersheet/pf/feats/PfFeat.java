package net.mindsoup.pathfindercharactersheet.pf.feats;

import android.os.Parcel;
import android.os.Parcelable;

public class PfFeat implements Parcelable {
	
	private final String name;
	private final String description;
	private final PfFeats type;
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
	    new Parcelable.Creator() {
	        public PfFeat createFromParcel(Parcel in) {
	            return new PfFeat(in);
	        }

	        public PfFeat[] newArray(int size) {
	            return new PfFeat[size];
	        }
	    };
	
	public PfFeat(String name, String description, PfFeats type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public PfFeat(Parcel in) {
		name = in.readString();
		description = in.readString();
		type = PfFeats.getFeat(in.readInt());
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public PfFeats getType() {
		return this.type;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.description);
		dest.writeInt(this.type.ordinal());
		
	}

}
