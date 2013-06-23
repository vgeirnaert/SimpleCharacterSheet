/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkill;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
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
public class SkillsFragment extends SherlockFragment {
	
	private PfCharacter character;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }

	@Override
	public void onResume() {
		super.onResume();
		
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		character = ca.getCharacter();
		
		TextView editText = (TextView)getActivity().findViewById(R.id.skills_text);
		String stats = "";
		
		for(PfSkills s : PfSkills.values()) {
			stats += PfSkill.getName(getActivity(), s) + ": ";
			if(character.canUseSkill(s)) {
				stats += "<b>" + character.getSkillBonus(s).sum() + "</b>";
			} else {
				stats += "(untrained)";
			}
			
			stats += "<br>";
		}
		
		editText.setText(Html.fromHtml(stats));
	}
}
