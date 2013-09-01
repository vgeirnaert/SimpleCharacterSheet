package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.adapters.ItemAdapter;
import net.mindsoup.pathfindercharactersheet.pf.items.Item;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

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
			adapter = new ItemAdapter(this.getActivity(), R.layout.items_list_items, ca.getCharacter().getInventoryItems());
			list.setAdapter(adapter);
			
			list.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
					deleteItem(position);
					
					return true;
				}
			});
			
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
	
	private void deleteItem(int position) {
		Item i = ca.getCharacter().getInventoryItems().get(position);
		ca.removeItem(i, 1);
	}
	
	private void addItem() {
		Item i = new Item("TEST ITEM");
		i.setDescription("This is the description");
		i.setStackSize(3);
		i.setValue(50);
		i.setWeight(0.5f);
		
		ca.addItem(i);
	}

	@Override
	public void refresh() {
		if(isAdded()) {
			adapter.notifyDataSetChanged();
		}
	}

}
