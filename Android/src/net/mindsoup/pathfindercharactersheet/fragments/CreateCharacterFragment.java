/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.MainActivity;
import net.mindsoup.pathfindercharactersheet.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockDialogFragment;

/**
 * @author Valentijn
 *
 */
public class CreateCharacterFragment extends SherlockDialogFragment {
	
	public CreateCharacterFragment() {
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_character, container);
        getDialog().setTitle(R.string.character_dialog);
        
        ((Button)view.findViewById(R.id.create_char_create)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				acceptCharacter(view);
			}
        });
        
        ((Button)view.findViewById(R.id.create_char_cancel)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				cancelCharacter(view);
			}
        });

        return view;
    }
	
	public void acceptCharacter(View view) {
		MainActivity activity = (MainActivity)this.getActivity();
		String name = ((EditText)this.getView().findViewById(R.id.create_char_name)).getText().toString();
		int char_race = ((Spinner)this.getView().findViewById(R.id.create_char_race)).getSelectedItemPosition();
		int char_class = ((Spinner)this.getView().findViewById(R.id.create_char_class)).getSelectedItemPosition();
		
		boolean hpPerLevel = true;
		
		if(((Spinner)this.getView().findViewById(R.id.create_char_perlevel)).getSelectedItemPosition() == 1)
			hpPerLevel = false;
		
		activity.addNewCharacter(name, char_race, char_class, hpPerLevel);
		this.dismiss();
	}
	
	public void cancelCharacter(View view) {
		this.dismiss();
	}
}
