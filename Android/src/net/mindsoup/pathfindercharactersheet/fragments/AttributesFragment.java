/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import java.util.ArrayList;

import net.mindsoup.pathfindercharactersheet.AttributeListAdapter;
import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.CharacterAttributeAdapter;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfAttributes;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author Valentijn
 *
 */
public class AttributesFragment extends CharacterFragment {
	
	private PfCharacter character;
	private AttributeListAdapter adapter;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attributes, container, false);
    }
	
	@Override 
	public void onStart() {
		super.onStart();
		
		ArrayList<CharacterAttributeAdapter> attributes = new ArrayList<CharacterAttributeAdapter>();
		
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		character = ca.getCharacter();
		
		attributes.add(new CharacterAttributeAdapter(PfAttributes.CHA, character));
		attributes.add(new CharacterAttributeAdapter(PfAttributes.CON, character));
		attributes.add(new CharacterAttributeAdapter(PfAttributes.DEX, character));
		attributes.add(new CharacterAttributeAdapter(PfAttributes.INT, character));
		attributes.add(new CharacterAttributeAdapter(PfAttributes.STR, character));
		attributes.add(new CharacterAttributeAdapter(PfAttributes.WIS, character));
		
		ListView list = (ListView)this.getActivity().findViewById(R.id.attribute_list);
		adapter = new AttributeListAdapter(this.getActivity(), R.layout.attribute_list_item, attributes, this.getSherlockActivity());
		list.setAdapter(adapter);
	}
	
	@Override
	public void refresh() {
		if(adapter != null)
			adapter.notifyDataSetChanged();
	}
}
