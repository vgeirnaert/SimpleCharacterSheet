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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        final View mainView = inflater.inflate(R.layout.create_character, container);
        getDialog().setTitle(R.string.character_dialog);
        
        ((Button)mainView.findViewById(R.id.create_char_create)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				acceptCharacter(view);
			}
        });
        
        ((Button)mainView.findViewById(R.id.create_char_cancel)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				cancelCharacter(view);
			}
        });
        
        ((Spinner)mainView.findViewById(R.id.create_char_race)).setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// if the selection is half elf, half orc or human
				if(position == 3 || position == 5 || position == 6) {
					// set bonus attribute selection
					((ViewGroup) mainView).findViewById(R.id.create_char_stat).setVisibility(View.VISIBLE);
				} else {
					((ViewGroup) mainView).findViewById(R.id.create_char_stat).setVisibility(View.GONE);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});

        return mainView;
    }
	
	public void acceptCharacter(View view) {
		MainActivity activity = (MainActivity)this.getActivity();
		String name = ((EditText)this.getView().findViewById(R.id.create_char_name)).getText().toString();
		
		if(name.trim().length() > 0) {
			int char_race = ((Spinner)this.getView().findViewById(R.id.create_char_race)).getSelectedItemPosition();
			int char_class = ((Spinner)this.getView().findViewById(R.id.create_char_class)).getSelectedItemPosition();
			int char_stat = ((Spinner)this.getView().findViewById(R.id.create_char_stat)).getSelectedItemPosition();
			
			boolean hpPerLevel = true;
			
			if(((Spinner)this.getView().findViewById(R.id.create_char_perlevel)).getSelectedItemPosition() == 1)
				hpPerLevel = false;
			
			activity.addNewCharacter(name, char_race, char_class, hpPerLevel, char_stat);
			this.dismiss();
		} else {
			Toast.makeText(this.getActivity(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void cancelCharacter(View view) {
		this.dismiss();
	}
}
