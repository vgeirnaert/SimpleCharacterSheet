/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.adapters.CharacterFeatAdapter;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.pf.feats.PfFeats;
import net.mindsoup.charactersoup.util.CharacterSoupUtils;
import net.mindsoup.charactersoup.util.ListElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentijn
 *
 */
public class FeatsFragment extends CharacterFragment {
	
	private CharacterFeatAdapter adapter;
	private List<PfFeats> feats = new ArrayList<PfFeats>();
	private final String PICK_FEAT = "pick_feat";
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feats, container, false);
    }

	@Override
	public void refresh() {
		if(isAdded()) {
			PfCharacter ca = ((CharacterActivity)this.getActivity()).getCharacter();
			ViewGroup vg = (ViewGroup)this.getActivity().findViewById(R.id.available_feats_group);
			int ranks = ca.getAvailableFeats();
			
			if(ranks > 0)
				vg.setVisibility(View.VISIBLE);
			else
				vg.setVisibility(View.GONE);
			
			TextView tv = (TextView)this.getActivity().findViewById(R.id.available_feats_text);
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
					((CharacterActivity)getActivity()).removeFeat(feat);
					return true;
				}
			});
			
			Button addFeat = (Button)this.getActivity().findViewById(R.id.add_feats_button);
			addFeat.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showFeatsPicker();
				}
			});
			
			refresh();
		}
	}
	
	private void showFeatsPicker() {
        CharacterSoupUtils.showListDialog(PICK_FEAT, this.getActivity(), "pf_data/feats.json", this.getActivity().getString(R.string.select_feat), new PickFromListFragment.ParcelablePickFromListListener() {
            @Override
            public void onPicked(ListElement element) {
                ((CharacterActivity)getActivity()).addFeat(PfFeats.getFeat(element.getIndex()));
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {}
        });
	}

    @Override
    public String getHelpTitle() {
        return this.getActivity().getString(R.string.feats_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.feats_fragment_help_text);
    }

}
