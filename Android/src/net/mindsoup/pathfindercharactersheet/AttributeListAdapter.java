/**
 * 
 */
package net.mindsoup.pathfindercharactersheet;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Valentijn
 *
 */
public class AttributeListAdapter extends ArrayAdapter<CharacterAttributeAdapter> {
	
	ArrayList<CharacterAttributeAdapter> attributes;
	int viewResourceId;

	public AttributeListAdapter(Context context, int textViewResourceId, ArrayList<CharacterAttributeAdapter> objects) {
		super(context, textViewResourceId, objects);
		this.attributes = objects;
		this.viewResourceId = textViewResourceId;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(viewResourceId, null);
        
        TextView tv = (TextView)convertView.findViewById(R.id.attribute_name);
        tv.setText(attributes.get(position).getAttribute().toString());
        
        tv = (TextView)convertView.findViewById(R.id.attribute_bonus);
        tv.setText(Integer.toString(attributes.get(position).getBonus()));
        
        tv = (TextView)convertView.findViewById(R.id.attribute_temp_bonus);
        tv.setText(Integer.toString(attributes.get(position).getTempBonus()));
        
        tv = (TextView)convertView.findViewById(R.id.edit_attribute);
        tv.setText(Integer.toString(attributes.get(position).getValue()));
        tv.setOnClickListener(new OnClickListener() {
        	
        	private boolean isToggled = false;

			@Override
			public void onClick(View view) {
				ViewGroup vg = (ViewGroup)view.getParent();
				
				if(!isToggled) {
					LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, 50, 0.2f);
					
					int index = vg.indexOfChild(view) - 1;
					Button button = new Button(view.getContext());
					button.setText("-");
					button.setLayoutParams(param);
					vg.removeViewAt(index);
					vg.addView(button, index);
					
					index = vg.indexOfChild(view) + 1;
					button = new Button(view.getContext());
					button.setLayoutParams(param);
					button.setText("+");
					vg.removeViewAt(index);
					vg.addView(button, index);
				}
			}
        	
        });
        
        tv = (TextView)convertView.findViewById(R.id.edit_temp_attribute);
        tv.setText(Integer.toString(attributes.get(position).getTempValue()));
        
        return convertView;
	}

}
