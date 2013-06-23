/**
 * 
 */
package net.mindsoup.pathfindercharactersheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Valentijn
 *
 */
public class NavDrawerAdapter extends ArrayAdapter<String> {
	
	private TypedArray icons;
	private int viewResourceId;
	
	public NavDrawerAdapter(Context context, int viewResourceId, String[] strings, TypedArray icons) {
		super(context, viewResourceId, strings);
		
		this.icons = icons;
		this.viewResourceId = viewResourceId;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(viewResourceId, null);

        TextView tv = (TextView)convertView.findViewById(R.id.nav_text);
        tv.setText(this.getItem(position));        
        tv.setCompoundDrawablesWithIntrinsicBounds(icons.getDrawable(position), null, null, null);
        
        return convertView;
    }

}
