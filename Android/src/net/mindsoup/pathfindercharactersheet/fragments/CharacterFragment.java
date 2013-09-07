package net.mindsoup.pathfindercharactersheet.fragments;

import android.app.Activity;

import com.actionbarsherlock.app.SherlockFragment;

public abstract class CharacterFragment extends SherlockFragment {
	abstract public void refresh();
	
	public void verboseRefresh() {
		System.out.println("REFRESHING " +  this.toString());
		refresh();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		System.out.println("ATTACHING " + this.toString());
		
	}
}
