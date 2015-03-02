/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.adapters.ExpandableSelectListAdapter;
import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.util.CharacterSoupUtils;
import net.mindsoup.charactersoup.util.ListElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Valentijn
 *
 */
public class SpellbookFragment extends CharacterFragment {

    private final String PICK_SPELL = "pick_spell";

    private List<ListElement> spells = new ArrayList<ListElement>();
    private ExpandableSelectListAdapter adapter;
    private List<ListElement> allSpells;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spellbook, container, false);

        Button addButton = (Button)v.findViewById(R.id.spells_add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSpellPicker();
            }
        });

        ExpandableListView list = (ExpandableListView)v.findViewById(R.id.spell_list);
        adapter = new ExpandableSelectListAdapter(this.getActivity(), CharacterSoupUtils.convertListElementListToCategoryMap(spells), null, null, R.layout.simple_list_item, R.layout.select_list_header);
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (ExpandableListView.getPackedPositionType(id) == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                    int groupPosition = ExpandableListView.getPackedPositionGroup(id);
                    int childPosition = ExpandableListView.getPackedPositionChild(id);
                    ListElement item = (ListElement)adapter.getChild(groupPosition, childPosition);
                    ((CharacterActivity) getActivity()).removeSpecialPower(item.getIndex());
                    return true;
                }
                return false;
            }
        });

        setAllSpells();

        return v;
    }

    private void setAllSpells() {
        InputStream json;
        try {
            json = this.getActivity().getAssets().open(getSpellsFile());
            ObjectMapper mapper = new ObjectMapper(); // todo: use one objectmapper throughout the app
            allSpells = mapper.readValue(json, new TypeReference<List<ListElement>>(){});
        } catch (IOException e) {
            return;
        }
    }

    private String getSpellsFile() {
        String filename = "pf_data/wizard_spells.json";

        switch (getCharacter().getPfClass().getPfClass()) {
            case BARD:
                filename = "pf_data/bard_spells.json";
                break;
            case CLERIC:
                filename = "pf_data/cleric_spells.json";
                break;
            case DRUID:
                filename = "pf_data/druid_spells.json";
                break;
            case PALADIN:
                filename = "pf_data/paladin_spells.json";
                break;
            case RANGER:
                filename = "pf_data/ranger_spells.json";
                break;
        }

        return filename;
    }

    private void showSpellPicker() {


        CharacterSoupUtils.showListDialog(PICK_SPELL, this.getActivity(), getSpellsFile(), this.getActivity().getString(R.string.select_rage), new PickFromListFragment.ParcelablePickFromListListener() {
            @Override
            public void onPicked(ListElement element) {
                ((CharacterActivity) getActivity()).addSpecialPower(element.getIndex());
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
            }
        }, true);
    }

	/* (non-Javadoc)
	 * @see net.mindsoup.charactersoup.fragments.CharacterFragment#refresh()
	 */
	@Override
	public void refresh() {
        if(isAdded()) {
            final PfCharacter character = this.getCharacter();
            if(character.getAvailableSpecialPowers() > 0) {
                this.getActivity().findViewById(R.id.spells_add_button).setVisibility(View.VISIBLE);
                this.getActivity().findViewById(R.id.available_powers_text).setVisibility(View.VISIBLE);
            } else {
                this.getActivity().findViewById(R.id.spells_add_button).setVisibility(View.GONE);
                this.getActivity().findViewById(R.id.available_powers_text).setVisibility(View.GONE);
            }

            TextView tv = (TextView)this.getActivity().findViewById(R.id.available_powers_text);
            tv.setText("Available spells: " + character.getAvailableSpecialPowers());

            spells.clear();
            Set<Integer> powers = character.getSpecialPowers();
            for(ListElement e : allSpells) {
                if(powers.contains(new Integer(e.getIndex()))) {
                    spells.add(e);
                }
            }

            adapter.setItems(CharacterSoupUtils.convertListElementListToCategoryMap(spells));
            adapter.notifyDataSetChanged();
        }

	}

    @Override
    public String getHelpTitle() {
        return this.getActivity().getString(R.string.spells_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.spells_fragment_help_text);
    }

    @Override
    public void onStart() {
        super.onStart();

        if(isAdded()) {
            refresh();
        }
    }

}
