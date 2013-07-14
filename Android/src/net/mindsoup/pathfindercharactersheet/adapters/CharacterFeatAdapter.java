/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.adapters;

import java.util.List;

import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeat;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Valentijn
 *
 */
public class CharacterFeatAdapter extends ArrayAdapter<PfFeat> {
	
	private List<PfFeat> feats;
	private int viewResourceId;
	
	public CharacterFeatAdapter(Context context, int textViewResourceId, List<PfFeat> objects) {
		super(context, textViewResourceId, objects);
		
		this.feats = objects;
		this.viewResourceId = textViewResourceId;
	
	}
	
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(viewResourceId, null);
        
        TextView tv = (TextView)view.findViewById(R.id.feat_name);
        tv.setText(feats.get(position).getName());
        
        tv = (TextView)view.findViewById(R.id.feat_description);
        tv.setText(feats.get(position).getDescription());
        
        return view;
	}

}
