/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.items.Item;
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
public class CreateItemFragment extends SherlockDialogFragment {
	
	public CreateItemFragment() {
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View mainView = inflater.inflate(R.layout.create_item, container);
        getDialog().setTitle(R.string.item_dialog_title);
        
        ((Button)mainView.findViewById(R.id.create_item_create)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				accept(view);
			}
        });
        
        ((Button)mainView.findViewById(R.id.create_item_cancel)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				cancel(view);
			}
        });
        
        return mainView;
	}
	
	public void cancel(View view) {
		this.dismiss();
	}
	
	public void accept(View view) {
		CharacterActivity activity = (CharacterActivity)this.getActivity();
		
		String name = ((EditText)this.getView().findViewById(R.id.create_item_name)).getText().toString();
		String description = ((EditText)this.getView().findViewById(R.id.create_item_description)).getText().toString();
		float weight = Float.parseFloat( ((EditText)this.getView().findViewById(R.id.create_item_weight)).getText().toString() );
		int amount = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_item_amount)).getText().toString() );
		int value = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_item_value)).getText().toString() );
		
		Item i = new Item(name);
		i.setDescription(description);
		i.setStackSize(amount);
		i.setValue(value);
		i.setWeight(weight);
		
		activity.addItem(i);
		
		this.dismiss();
		
	}

}
