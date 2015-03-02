package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.adapters.ItemAdapter;

public class InventoryFragment extends CharacterFragment {
	
	private ItemAdapter adapter;
	private CharacterActivity ca;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
		if(isAdded()) {
			ca = (CharacterActivity)this.getActivity();			
			
			ListView list = (ListView)this.getActivity().findViewById(R.id.inventory_list);
			adapter = new ItemAdapter(this.getActivity(), R.layout.items_list_item, ca.getCharacter().getInventoryItems(), this.getSherlockActivity());
			list.setAdapter(adapter);
			
			Button button = (Button)this.getActivity().findViewById(R.id.add_item_button);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					addItem();
					
				}
			});
			
			refresh();
		}
	}
	
	private void addItem() {
		 FragmentManager fm = this.getActivity().getSupportFragmentManager();
	     CreateItemFragment createChar = new CreateItemFragment();
	     createChar.show(fm, "fragment_create_item");
	}

	@Override
	public void refresh() {
		if(isAdded()) {
			adapter.notifyDataSetChanged();
			
			TextView tv = (TextView)this.getActivity().findViewById(R.id.character_wealth);
			tv.setText("Gold: " + Float.toString((float)ca.getCharacter().getMoney() / 100.0f));
			
			tv = (TextView)this.getActivity().findViewById(R.id.total_weight);
			tv.setText(Float.toString(ca.getCharacter().getTotalCarryingWeight()) + " Lbs");
		}
	}

    @Override
    public String getHelpTitle() {
        return this.getActivity().getString(R.string.inventory_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.inventory_fragment_help_text);
    }

}
