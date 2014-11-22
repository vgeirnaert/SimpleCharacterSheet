/**
 * 
 */
package net.mindsoup.charactersoup.adapters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mindsoup.charactersoup.CalculationView;
import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.skills.PfSkill;
import net.mindsoup.charactersoup.pf.skills.PfSkills;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * @author Valentijn
 *
 */
public class CharacterSkillAdapter extends ArrayAdapter<PfSkill> {
	
	private List<PfSkill> skills;
	private int viewResourceId;
	private CharacterActivity activity;
	private Set<PfSkills> classSkills = null;

	public CharacterSkillAdapter(Context context, int textViewResourceId, List<PfSkill> objects, SherlockFragmentActivity activity) {
		super(context, textViewResourceId, objects);
		this.skills = objects;
		this.viewResourceId = textViewResourceId;
		this.activity = (CharacterActivity)activity;		
	}
	
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(viewResourceId, null);
        
        PfSkill skill = skills.get(position);
        int skillRank = activity.getCharacter().getSkillRank(skill.getType());
        if(classSkills == null)
        	classSkills = new HashSet<PfSkills>(Arrays.asList(activity.getCharacter().getPfClass().getClassSkills()));

        TextView tv = (TextView)convertView.findViewById(R.id.skill_name);     
        tv.setText(skill.getName(activity));
        
        // this is a class skill
        if(classSkills.contains(skill.getType()))
        	tv.setTextColor(0xff00cc99);

        tv = (TextView)convertView.findViewById(R.id.skill_type);
        tv.setText("Attribute: " + skill.getAttribute().toString());
               
        tv = (TextView)convertView.findViewById(R.id.skill_rank);
        tv.setText("Rank: " + Integer.toString(skillRank));
        
        CalculationView cv = (CalculationView)convertView.findViewById(R.id.skill_score);
        String content = "";
        if(activity.getCharacter().canUseSkill(skill.getType())) {
            if(activity.getCharacter().getSkillBonus(skill.getType()).sum() > 0) {
                content = "+";
            }
        	cv.setCalculation(activity.getCharacter().getSkillBonus(skill.getType()));
        } else {
        	content = "N.A.";
        	cv.setCalculation(null);
        }
        
        cv.setText(content);
        
        int height_pixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 3, activity.getResources().getDisplayMetrics());
        int margin_pixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 2, activity.getResources().getDisplayMetrics());
        float width = 1.0f / activity.getCharacter().getLevel();
        

        // set skill rank bars
        for(int i = 0; i < skillRank; i++) {
        	View bar = new View(this.getContext());
        	
        	LayoutParams params = new LinearLayout.LayoutParams(0, height_pixels, width);
        	params.setMargins(margin_pixels, margin_pixels, margin_pixels, margin_pixels);
        	bar.setBackgroundColor(0xFF0099CC);
        	bar.setLayoutParams(params);
        	
        	LinearLayout container = (LinearLayout)convertView.findViewById(R.id.skill_ranks);
        	container.addView(bar);
        }
        
        return convertView;
	}

}
