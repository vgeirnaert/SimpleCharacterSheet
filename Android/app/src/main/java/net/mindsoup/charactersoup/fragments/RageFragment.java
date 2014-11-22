/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.classes.PfBarbarian;
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

    private final String rage = "Rage";
	
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
                    character.getTempStrBoost().add(rage, 4);
                    character.getTempConBoost().add(rage, 4);
				} else {
					((PfBarbarian)character.getPfClass()).setRaging(false);
					character.getTempStrBoost().remove(rage);
                    character.getTempConBoost().remove(rage);
				}
				
				activity.updateCharacter(false);
			}
		});
        
        return v;
    }

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.fragments.CharacterFragment#refresh()
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
