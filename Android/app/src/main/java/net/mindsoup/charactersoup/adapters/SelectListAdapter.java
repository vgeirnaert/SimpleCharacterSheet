package net.mindsoup.charactersoup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.fragments.PickFromListFragment;
import net.mindsoup.charactersoup.util.ListElement;

import java.util.List;

/**
 * Created by Valentijn on 27-2-2015.
 */
public class SelectListAdapter extends ArrayAdapter<ListElement> {

    private List<ListElement> items;
    final private int viewResourceId;
    final private PickFromListFragment.ParcelablePickFromListListener listener;
    final private PickFromListFragment dialog;

    public SelectListAdapter(Context context, int textViewResourceId, List<ListElement> items, PickFromListFragment.ParcelablePickFromListListener listener, PickFromListFragment dialog) {
        super(context, textViewResourceId, items);

        this.items = items;
        this.viewResourceId = textViewResourceId;
        this.listener = listener;
        this.dialog = dialog;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(viewResourceId, null);

        ListElement item = items.get(position);

        TextView tv = (TextView)view.findViewById(R.id.select_title);
        tv.setText(item.getTitle());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup description = (ViewGroup)view.findViewById(R.id.select_list_description_group);

                if(description.getVisibility() == View.GONE)
                    description.setVisibility(View.VISIBLE);
                else
                    description.setVisibility(View.GONE);
            }
        });

        tv = (TextView)view.findViewById(R.id.select_list_description);
        tv.setText(item.getDescription());

        Button select = (Button)view.findViewById(R.id.select_list_button);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPicked(items.get(position));
                dialog.dismiss();
            }
        });

        return view;
    }

}
