/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

/**
 * @author Valentijn
 *
 */
public class RageFragment extends CharacterFragment {
	
	ToggleButton toggle;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rage, container, false);
        
        final PfCharacter character = this.getCharacter();
        final CharacterActivity activity = (CharacterActivity)this.getActivity();
        
        toggle = (ToggleButton)v.findViewById(R.id.rage_toggle);
        if(savedInstanceState != null) {
        	toggle.setChecked(savedInstanceState.getBoolean("toggle"));
        }
        toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					((PfBarbarian)character.getPfClass()).setRaging(true);
					character.setTempStrBoost(character.getTempStrBoost().sum() + 4);
					character.setTempConBoost(character.getTempConBoost().sum() + 4);
				} else {
					((PfBarbarian)character.getPfClass()).setRaging(false);
					character.setTempStrBoost(character.getTempStrBoost().sum() - 4);
					character.setTempConBoost(character.getTempConBoost().sum() - 4);
				}
				
				activity.updateCharacter(false);
			}
		});
        
        return v;
    }

	/* (non-Javadoc)
	 * @see net.mindsoup.pathfindercharactersheet.fragments.CharacterFragment#refresh()
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onSaveInstanceState(final Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean("toggle", toggle.isChecked());
	}

}
