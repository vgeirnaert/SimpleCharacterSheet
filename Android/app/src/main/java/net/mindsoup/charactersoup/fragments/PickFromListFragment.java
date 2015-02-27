package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockDialogFragment;

import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.adapters.SelectListAdapter;
import net.mindsoup.charactersoup.util.ListElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Valentijn on 27-2-2015.
 */
public class PickFromListFragment extends SherlockDialogFragment {

    public interface ParcelablePickFromListListener extends Parcelable {
        public void onPicked(ListElement element);
    }

    public static final String titleKey = "title";
    public static final String listKey = "list";
    public static final String callbackKey = "callback";

    private SelectListAdapter adapter;
    private List<ListElement> originalItems;
    private List<ListElement> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String title = getArguments().getString(titleKey);

        if(title == null) {
            title = "Pick an item";
        }

        originalItems = getArguments().getParcelableArrayList(listKey);
        items = new ArrayList<ListElement>(originalItems);
        final ParcelablePickFromListListener listener = getArguments().getParcelable(callbackKey);

        View view = inflater.inflate(R.layout.pick_item_dialog, container);
        getDialog().setTitle(title);

        ListView list = (ListView)view.findViewById(R.id.all_items_list);
        adapter = new SelectListAdapter(this.getActivity(), R.layout.select_list_item, items, listener, this);
        list.setAdapter(adapter);

        EditText search = (EditText)view.findViewById(R.id.pick_item_search);
        search.addTextChangedListener(new TextWatcher() {
            private Timer timer = new Timer();
            private final long DELAY = 1000; // in ms

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int oldLength, int changeLength) {}

            @Override
            public void onTextChanged(final CharSequence charSequence, int start, int oldLength, int changeLength) {
                timer.cancel();
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        filterList(charSequence.toString());
                    }
                }, DELAY);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        return view;
    }

    private void filterList(String filter) {
        // no filtering
        if(filter.length() == 0) {
            items.clear();
            items.addAll(originalItems);
        } else {
            // filter
            items.clear();
            filter = filter.toLowerCase();
            for (ListElement item : originalItems) {
                if (item.getTitle().toLowerCase().contains(filter)) {
                    items.add(item);
                }
            }
        }

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }
}
