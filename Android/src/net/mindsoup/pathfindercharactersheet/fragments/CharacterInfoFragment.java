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
import android.view.ViewGroup;
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
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		character = ca.getCharacter();
		
		TextView editText = (TextView)getActivity().findViewById(R.id.char_info_text);
		String stats = "";
		
		stats += "Name: </b>" + character.getName() + "</b> (level " + character.getLevel() + " " + character.getRace().toString() + " " + character.getPfClass().toString() + ")<br>";
		stats += "Xp: " + character.getXp() + "<br>";
		stats += "Max HP: " + character.getMaxHitpoints() + "<br>";
		
		editText.setText(Html.fromHtml(stats));
	}

}
