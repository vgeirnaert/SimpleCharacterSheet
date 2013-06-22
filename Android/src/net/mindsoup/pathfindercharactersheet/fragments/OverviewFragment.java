package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkill;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;

public class OverviewFragment extends SherlockFragment {
	
	private PfCharacter character;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false);

    }
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstance) {
		super.onActivityCreated(savedInstance);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		Toast.makeText(getActivity(), "resuming!", Toast.LENGTH_SHORT).show();
		
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		character = ca.getCharacter();
		
		TextView editText = (TextView)getActivity().findViewById(R.id.overview_text);
		String stats = "";
		
		stats += "Str: " + character.getStrength() + " [" + character.getAttributeBonus(character.getStrength()) + "]\n";
		stats += "Con: " + character.getConstitution() + " [" + character.getAttributeBonus(character.getConstitution()) + "]\n";
		stats += "Dex: " + character.getDexterity() + " [" + character.getAttributeBonus(character.getDexterity()) + "]\n";
		stats += "Wis: " + character.getWisdom() + " [" + character.getAttributeBonus(character.getWisdom()) + "]\n";
		stats += "Int: " + character.getIntelligence() + " [" + character.getAttributeBonus(character.getIntelligence()) + "]\n";
		stats += "Cha: " + character.getCharisma() + " [" + character.getAttributeBonus(character.getCharisma()) + "]\n";
		
		stats += "\n";
		
		stats += "HP: " + character.getMaxHitpoints() + "\n";
		stats += "AC: " + character.getAC() + "\n";
		stats += "Attack bonus: " + character.getAttackBonus(0) + ")\n";
		stats += "Damage modifier: " + character.getDamageModifier() + "\n";
		
		stats += "\n";
		
		for(PfSkills s : PfSkills.values()) {
			stats += PfSkill.getName(getActivity(), s) + " ";
			if(character.canUseSkill(s)) {
				stats += character.getSkillBonus(s);
			} else {
				stats += "(untrained)";
			}
			
			stats += "\n";
		}
		
		editText.setText(stats);
	}
	
	
}
