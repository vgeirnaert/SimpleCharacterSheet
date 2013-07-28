package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InventoryFragment extends CharacterFragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false);

    }

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
