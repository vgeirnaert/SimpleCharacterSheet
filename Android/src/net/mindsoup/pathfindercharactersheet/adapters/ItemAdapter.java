/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.adapters;

import java.util.List;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.items.Item;
import net.mindsoup.pathfindercharactersheet.pf.items.ItemEffects;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.items.Wearable;
import android.content.Context;
import android.text.Html;
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
	private CharacterActivity activity;
	
	public ItemAdapter(Context context, int textViewResourceId, List<Item> objects, SherlockFragmentActivity activity) {
		super(context, textViewResourceId, objects);
		
		this.items = objects;
		this.textView = textViewResourceId;
		this.activity = (CharacterActivity)activity;
	}
	
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(textView, null);
        
        final Item item = items.get(position);
        
        TextView tv = (TextView)view.findViewById(R.id.item_name);
        String name = item.getName();
        if(item.getStackSize() > 1)
        	name += " (" + Integer.toString(item.getStackSize()) + ")";
        
        tv.setText(name);
        
        if(item.isEquiped()) {
        	tv.setTextColor(0xff00cc99);
        }
        
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
        
        String description = "";
        
        switch(item.getType()) {
	        case WEAPON:
	        	description += "Damage: <b>" + ((Weapon)item).getDamage().toString() + "</b><br>";
	        	description += "Damage type: <b>" + ((Weapon)item).getDamageType() + "</b><br>";
	        	description += "Crit range: <b>" + ((Weapon)item).getCriticalRange() + " x" + ((Weapon)item).getCriticalMultiplier() + "</b><br>";
	        	description += ((Weapon)item).getHandedness().toString() + "<br>";
	        	break;
	        case ARMOR:
	        	description += "AC bonus: <b>" + ((Wearable)item).getArmorClass() + "</b><br>";
	        	description += "Max dex bonus: <b>" + ((Wearable)item).getMaxDexBonus() + "</b><br>";
	        	description += "AC penalty: <b>" + ((Wearable)item).getArmorPenalty() + "</b><br>";
	        	break;
        	default:
        		break;
        }
        
        for(ItemEffects e : item.getEffects().keySet()) {
        	description += e.toString() + " +" +  item.getEffects().get(e) + "<br>";
        }
        
        description += "<br><b>" + item.getName() + "</b><br>"+ item.getDescription();
        tv = (TextView)view.findViewById(R.id.item_description);
        tv.setText(Html.fromHtml(description));
                
        tv = (TextView)view.findViewById(R.id.item_value);
        tv.setText(Float.toString((float)item.getStackValue() / 100.0f) + " Gold");
        
        tv = (TextView)view.findViewById(R.id.item_weight);
        tv.setText(Float.toString(item.getStackWeight()) + " Lbs");
        
        tv = (TextView)view.findViewById(R.id.item_equip);
        tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {		
				activity.equipItem(item);
			}
		});
        
        return view;
	}

}
