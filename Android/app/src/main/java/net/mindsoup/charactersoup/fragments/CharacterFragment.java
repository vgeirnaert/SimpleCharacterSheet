package net.mindsoup.charactersoup.fragments;

import android.app.Activity;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragment;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.pf.PfCharacter;

public abstract class CharacterFragment extends SherlockFragment {
	abstract public void refresh();
	
	public void verboseRefresh() {
		System.out.println("REFRESHING " +  this.toString());
		refresh();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		//System.out.println("ATTACHING " + this.toString());
		
	}
	
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		
		//System.out.println("ON CREATE " + this.toString());
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		
		//System.out.println("DETACHING " + this.toString());
	}
	
	public PfCharacter getCharacter() {
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		
		if(ca != null)
			return ca.getCharacter();
		
		return null;
	}

    abstract public String getHelpTitle();
    abstract public String getHelpText();

}
