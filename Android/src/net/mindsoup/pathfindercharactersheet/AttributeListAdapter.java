/**
 * 
 */
package net.mindsoup.pathfindercharactersheet;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * @author Valentijn
 *
 */
public class AttributeListAdapter extends ArrayAdapter<CharacterAttributeAdapter> {
	
	ArrayList<CharacterAttributeAdapter> attributes;
	int viewResourceId;
	SherlockFragmentActivity activity;

	public AttributeListAdapter(Context context, int textViewResourceId, ArrayList<CharacterAttributeAdapter> objects, SherlockFragmentActivity activity) {
		super(context, textViewResourceId, objects);
		this.attributes = objects;
		this.viewResourceId = textViewResourceId;
		this.activity = activity;
	}
	
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(viewResourceId, null);
        
        TextView tv = (TextView)convertView.findViewById(R.id.attribute_name);
        tv.setText(attributes.get(position).getAttribute().toString());
        
        tv = (TextView)convertView.findViewById(R.id.attribute_bonus);
        tv.setText(Integer.toString(attributes.get(position).getBonus()));
        
        tv = (TextView)convertView.findViewById(R.id.attribute_temp_bonus);
        tv.setText(Integer.toString(attributes.get(position).getTempBonus()));
        
        tv = (TextView)convertView.findViewById(R.id.edit_attribute);
        tv.setText(Integer.toString(attributes.get(position).getValue()));;
        
        tv = (TextView)convertView.findViewById(R.id.edit_temp_attribute);
        tv.setText(Integer.toString(attributes.get(position).getTempValue()));
        
        return convertView;
	}

}
