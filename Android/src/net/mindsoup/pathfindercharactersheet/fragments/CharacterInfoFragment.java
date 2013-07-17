/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
		character.setXp(Integer.parseInt( edit.getText().toString() ));
		updateCharacter();
	}
	
	protected void setMoney() {
		EditText edit = (EditText)getActivity().findViewById(R.id.edit_money);
		character.setMoney(Integer.parseInt( edit.getText().toString() ));
		updateCharacter();
	}

}
