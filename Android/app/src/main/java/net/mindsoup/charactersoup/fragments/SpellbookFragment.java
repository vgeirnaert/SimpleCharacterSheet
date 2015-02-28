/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mindsoup.charactersoup.R;

/**
 * @author Valentijn
 *
 */
public class SpellbookFragment extends CharacterFragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spellbook, container, false);
    }

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.fragments.CharacterFragment#refresh()
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

    @Override
    public String getHelpTitle() {
        return this.getActivity().getString(R.string.spells_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.spells_fragment_help_text);
    }

}
