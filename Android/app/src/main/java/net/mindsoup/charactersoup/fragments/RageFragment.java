/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.classes.PfBarbarian;
import net.mindsoup.charactersoup.util.CharacterSoupUtils;
import net.mindsoup.charactersoup.util.ListElement;

/**
 * @author Valentijn
 *
 */
public class RageFragment extends CharacterFragment {
	
	ToggleButton toggle;

    private final String rage = "Rage";
    private final String PICK_RAGE = "pick_rage";
	
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

        Button addButton = (Button)v.findViewById(R.id.rage_add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRagePicker();
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

    private void showRagePicker() {
        CharacterSoupUtils.showListDialog(PICK_RAGE, this.getActivity(), "pf_data/rage.json", this.getActivity().getString(R.string.select_rage), new PickFromListFragment.ParcelablePickFromListListener() {
            @Override
            public void onPicked(ListElement element) {

            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
            }
        });
    }

}
