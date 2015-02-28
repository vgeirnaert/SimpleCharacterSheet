/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.adapters.CharacterSkillAdapter;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.skills.PfSkill;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import net.mindsoup.charactersoup.pf.skills.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentijn
 *
 */
public class SkillsFragment extends CharacterFragment {
	
	private PfCharacter character;
	private List<PfSkill> skills = new ArrayList<PfSkill>();
	private CharacterSkillAdapter adapter;
	private CharacterActivity ca;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }

	@Override
	public void onResume() {
		super.onResume();
		
		if(isAdded()) {
			
			character = ((CharacterActivity)this.getActivity()).getCharacter();
			ca = (CharacterActivity)this.getActivity();
			
			if(skills.size() == 0) {
				for(PfSkills s : PfSkills.values()) {
					PfSkill skill = SkillFactory.getSkill(s);
					
					if(character.getTrainedSkills().containsKey(skill.getType())) {
						skill.setRank(character.getTrainedSkills().get(skill.getType()).getRank());
					}
					
					skills.add(skill);
				}
			}
			
			ListView list = (ListView)this.getActivity().findViewById(R.id.skills_list);
			adapter = new CharacterSkillAdapter(this.getActivity(), R.layout.skill_list_item, skills, this.getSherlockActivity());
			list.setAdapter(adapter);
			list.setOnItemClickListener(new OnItemClickListener() {
	
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					trainSkill(position);	
				}
			});
			
			list.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
					untrainSkill(position);
					
					return true;
				}
			});
			
			refresh();
		}
	}
	
	private void trainSkill(int skill) {
		int newSP = character.spendSkillRankOnSkill(skills.get(skill).getType(), 1);
		
		// save to DB if there was a change
		if(newSP > 0)
			ca.updateCharacter();
		
		refresh();	
	}
	
	private void untrainSkill(int skill) {
		int untrainedRanks = character.untrainSkill(skills.get(skill).getType(), 1);
		
		if(untrainedRanks > 0) {			
			ca.updateCharacter();
		}
		
		refresh();
	}

	@Override
	public void refresh() {
		if(isAdded()) {
			character = ((CharacterActivity)this.getActivity()).getCharacter();
			TextView tv = (TextView)this.getActivity().findViewById(R.id.available_skill_ranks);
			int ranks = character.getAvailableSkillRanks();
			
			if(ranks > 0)
				tv.setVisibility(View.VISIBLE);
			else
				tv.setVisibility(View.GONE);
			
			tv.setText("Available skill ranks: " + ranks);
		
			adapter.notifyDataSetChanged();
		}
	}

    @Override
    public String getHelpTitle() {
        return this.getActivity().getString(R.string.skills_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.skills_fragment_help_text);
    }
}
