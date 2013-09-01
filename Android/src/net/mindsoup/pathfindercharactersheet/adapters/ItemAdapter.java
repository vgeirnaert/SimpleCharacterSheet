/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.adapters;

import java.util.List;

import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.items.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Valentijn
 *
 */
public class ItemAdapter extends ArrayAdapter<Item> {
	
	private List<Item> items;
	private int textView;
	
	public ItemAdapter(Context context, int textViewResourceId, List<Item> objects) {
		super(context, textViewResourceId, objects);
		
		this.items = objects;
		this.textView = textViewResourceId;
	}
	
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(textView, null);
        
        Item item = items.get(position);
        
        TextView tv = (TextView)view.findViewById(R.id.item_name);
        tv.setText(item.getName());
        
        tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ViewGroup description = (ViewGroup)view.findViewById(R.id.item_description_group);
				
				if(description.getVisibility() == View.GONE)
					description.setVisibility(View.VISIBLE);
				else
					description.setVisibility(View.GONE);
			}
		});
        
        tv = (TextView)view.findViewById(R.id.item_description);
        tv.setText(item.getDescription());
        
        tv = (TextView)view.findViewById(R.id.item_amount);
        tv.setText("Stack: " + Integer.toString(item.getStackSize()));
        
        tv = (TextView)view.findViewById(R.id.item_value);
        tv.setText(Float.toString((float)item.getStackValue() / 100.0f) + " Gold");
        
        tv = (TextView)view.findViewById(R.id.item_weight);
        tv.setText(Float.toString(item.getStackWeight()) + " Lbs");
        
        return view;
	}

}
