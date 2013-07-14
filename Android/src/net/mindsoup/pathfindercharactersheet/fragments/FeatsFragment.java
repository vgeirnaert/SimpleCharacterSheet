/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import java.util.ArrayList;
import java.util.List;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.adapters.CharacterFeatAdapter;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeats;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Valentijn
 *
 */
public class FeatsFragment extends CharacterFragment {
	
	private CharacterFeatAdapter adapter;
	private List<PfFeats> feats = new ArrayList<PfFeats>();
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feats, container, false);
    }

	@Override
	public void refresh() {
		if(isAdded()) {
			PfCharacter ca = ((CharacterActivity)this.getActivity()).getCharacter();
			TextView tv = (TextView)this.getActivity().findViewById(R.id.available_feats);
			int ranks = ca.getAvailableFeats();
			
			if(ranks > 0)
				tv.setVisibility(View.VISIBLE);
			else
				tv.setVisibility(View.GONE);
			
			tv.setText("Available feats: " + ranks);
			
			feats.clear();
			feats.addAll( ((CharacterActivity)this.getActivity()).getCharacter().getFeats() );
		
			adapter.notifyDataSetChanged();
		}
		
	}
	
	@Override 
	public void onStart() {
		super.onStart();
		
		if(isAdded()) {			
			ListView list = (ListView)this.getActivity().findViewById(R.id.feats_list);
			adapter = new CharacterFeatAdapter(this.getActivity(), R.layout.feats_list_item, feats);
			list.setAdapter(adapter);
			list.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
					PfFeats feat = feats.get(position);
					((CharacterActivity)getActivity()).getCharacter().removeFeat(feat);
					refresh();
					return true;
				}
			});
			
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					ViewGroup description = (ViewGroup)view.findViewById(R.id.feat_description_group);
					
					if(description.getVisibility() == View.GONE)
						description.setVisibility(View.VISIBLE);
					else
						description.setVisibility(View.GONE);
				}
			});
			
			refresh();
		}
	}

}
