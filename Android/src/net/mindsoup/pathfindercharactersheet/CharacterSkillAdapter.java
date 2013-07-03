/**
 * 
 */
package net.mindsoup.pathfindercharactersheet;

import java.util.List;

import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkill;
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
        
        TextView tv = (TextView)convertView.findViewById(R.id.skill_name);     
        tv.setText(skill.getName(activity));
               
        tv = (TextView)convertView.findViewById(R.id.skill_rank);
        tv.setText("Rank: " + Integer.toString(skillRank));
        
        tv = (TextView)convertView.findViewById(R.id.skill_score);
        
        int bonus = activity.getCharacter().getSkillBonus(skill.getType()).sum();
        String name = "Bonus: ";
        if(activity.getCharacter().canUseSkill(skill.getType())) {
        	// add plus sign for positive numbers
        	if(bonus > 0)
        		name = name + "+";
        	
        	name = name + Integer.toString(bonus);
        } else {
        	name = "Not trained";
        }
        
        tv.setText(name);
        
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
