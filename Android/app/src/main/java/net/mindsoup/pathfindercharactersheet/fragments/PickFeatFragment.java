/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.adapters.CharacterFeatAdapter;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeats;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockDialogFragment;

/**
 * @author Valentijn
 *
 */
public class PickFeatFragment extends SherlockDialogFragment {
	
	private List<PfFeats> feats = new ArrayList<PfFeats>();
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(feats.size() == 0) 
			feats.addAll(Arrays.asList(PfFeats.values()));
		
		View view = inflater.inflate(R.layout.pick_feat_dialog, container);
        getDialog().setTitle("Pick a feat");
        
        ListView list = (ListView)view.findViewById(R.id.all_feats_list);
        CharacterFeatAdapter adapter = new CharacterFeatAdapter(this.getActivity(), R.layout.feats_list_item, feats);
		list.setAdapter(adapter);
		
		list.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				PfFeats feat = feats.get(position);
				selectFeat(feat);
				return true;
			}
		});
        
        return view;
	}

	protected void selectFeat(PfFeats feat) {
		((CharacterActivity)this.getActivity()).addFeat(feat);
		this.dismiss();
	}

}
