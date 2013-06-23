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

import com.actionbarsherlock.app.SherlockFragment;

/**
 * @author Valentijn
 *
 */
public class AttributesFragment extends SherlockFragment {
	
	private PfCharacter character;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attributes, container, false);
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		character = ca.getCharacter();
		
		TextView editText = (TextView)getActivity().findViewById(R.id.attributes_text);
		String stats = "";
		
		stats += "Str: <b>" + character.getStrength() + "</b><br>";
		stats += "Con: <b>" + character.getConstitution() + "</b><br>";
		stats += "Dex: <b>" + character.getDexterity() + "</b><br>";
		stats += "Wis: <b>" + character.getWisdom() + "</b><br>";
		stats += "Int: <b>" + character.getIntelligence() + "</b><br>";
		stats += "Cha: <b>" + character.getCharisma() + "</b><br>";
		
		editText.setText(Html.fromHtml(stats));
	}

}
