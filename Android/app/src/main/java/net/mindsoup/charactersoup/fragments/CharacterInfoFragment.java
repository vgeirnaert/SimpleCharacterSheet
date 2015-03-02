/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfCharacter;

/**
 * @author Valentijn
 *
 */
public class CharacterInfoFragment extends CharacterFragment {
	
	private PfCharacter character;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_info, container, false);
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
		setStats();
	}

	@Override
	public void refresh() {
		setStats();
		
	}
	
	private void setStats() {
		if(isAdded()) {
			CharacterActivity ca = (CharacterActivity)this.getActivity();
			character = ca.getCharacter();
			
			TextView editText = (TextView)getActivity().findViewById(R.id.char_info_text);
			String stats = "";
			
			EditText edit = (EditText)getActivity().findViewById(R.id.edit_xp);
			edit.setText(Integer.toString(character.getXp()));
			
			Button button = (Button)getActivity().findViewById(R.id.xp_button);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					setXp();					
				}
			});
			
			edit = (EditText)getActivity().findViewById(R.id.edit_money);
			edit.setText(Integer.toString(character.getMoney()));
			button = (Button)getActivity().findViewById(R.id.money_button);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					setMoney();					
				}
			});
			
			stats += "Name: </b>" + character.getName() + "</b> (level " + character.getLevel() + " " + character.getRace().toString() + " " + character.getPfClass().toString() + ")<br>";
			
			editText.setText(Html.fromHtml(stats));
		}
	}
	
	protected void updateCharacter() {
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		ca.updateCharacter(true);
	}
	
	protected void setXp() {
		EditText edit = (EditText)getActivity().findViewById(R.id.edit_xp);
		
		final int newXp = Integer.parseInt( edit.getText().toString() );
		final int currentLevel = character.getLevel();
		final int newLevel = character.getLevel(newXp);
		
		if(newLevel > currentLevel) {
			new AlertDialog.Builder(this.getActivity())
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle("Level up!")
	        .setMessage("You will gain " + (newLevel - currentLevel) + " level(s). Continue?")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	        	@Override
	        	public void onClick(DialogInterface dialog, int which) {
	        		character.setNewLevels(character.getNewLevels() + (newLevel - currentLevel));
	        		character.setXp(newXp);
	        		updateCharacter();
	        	}

	        })
	        .setNegativeButton("No", null)
	        .show();
		} else {
			character.setXp(newXp);
			updateCharacter();
		}
	}
	
	protected void setMoney() {
		EditText edit = (EditText)getActivity().findViewById(R.id.edit_money);
		character.setMoney(Integer.parseInt( edit.getText().toString() ));
		updateCharacter();
	}

    @Override
    public String getHelpTitle() {
        return this.getActivity().getString(R.string.info_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.info_fragment_help_text);
    }
}
