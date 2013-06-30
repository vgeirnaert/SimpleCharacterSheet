/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockDialogFragment;

/**
 * @author Valentijn
 *
 */
public class ChangeAttributeFragment extends SherlockDialogFragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_attribute, container);
        getDialog().setTitle("DEX");
        ((EditText)view.findViewById(R.id.edit_score)).setText("14");
        
        ((Button)view.findViewById(R.id.plus_button)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
			}
        });
        
        ((Button)view.findViewById(R.id.minus_button)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
			}
        });

        return view;
    }
}
