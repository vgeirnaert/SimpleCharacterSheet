package net.mindsoup.charactersoup.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.fragments.PickFromListFragment;
import net.mindsoup.charactersoup.util.ListElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentijn on 1-3-2015.
 */
public class ExpandableSelectListAdapter extends BaseExpandableListAdapter {

    final private Context context;
    private Map<String, List<ListElement>> elements;
    final private PickFromListFragment.ParcelablePickFromListListener listener;
    final private PickFromListFragment dialog;
    private ArrayList<String> categories;
    final int childView;
    final int headerView;

    public ExpandableSelectListAdapter(Context context, Map<String, List<ListElement>> elements, PickFromListFragment.ParcelablePickFromListListener listener, PickFromListFragment dialog, int childView, int headerView) {
        this.context = context;
        this.listener = listener;
        this.dialog = dialog;
        setItems(elements);

        this.childView = childView;
        this.headerView = headerView;
    }

    public void setItems(Map<String, List<ListElement>> elements) {
        this.elements = elements;
        this.categories = new ArrayList<String>();
        for (Map.Entry<String,List<ListElement>> entry : elements.entrySet()) {
            this.categories.add(entry.getKey());
        }
    }

    @Override
    public int getGroupCount() {
        return elements.keySet().size();
    }

    @Override
    public int getChildrenCount(int group) {
        return elements.get(categories.get(group)).size();
    }

    @Override
    public Object getGroup(int group) {
        return categories.get(group);
    }

    @Override
    public Object getChild(int group, int child) {
        return elements.get(categories.get(group)).get(child);
    }

    @Override
    public long getGroupId(int group) {
        return group;
    }

    @Override
    public long getChildId(int group, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int group, boolean isExpanded, View view, ViewGroup parent) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(headerView, null);
        }

        TextView tv = (TextView)view.findViewById(R.id.select_list_header_text);
        tv.setText((String)this.getGroup(group));

        return view;
    }

    @Override
    public View getChildView(int group, int child, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(childView, null);
        }

        final View view = convertView;
        final ListElement item = (ListElement)this.getChild(group, child);

        TextView tv = (TextView)view.findViewById(R.id.select_title);
        tv.setText(item.getTitle());
        final int bgcolor = tv.getDrawingCacheBackgroundColor();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup description = (ViewGroup)view.findViewById(R.id.select_list_description_group);

                if(description.getVisibility() == View.GONE) {
                    v.setBackgroundColor(Color.BLACK);
                    description.setBackgroundColor(Color.BLACK);
                    description.setVisibility(View.VISIBLE);
                } else {
                    v.setBackgroundColor(bgcolor);
                    description.setBackgroundColor(bgcolor);
                    description.setVisibility(View.GONE);
                }
            }
        });

        tv = (TextView)view.findViewById(R.id.select_list_description);
        tv.setText(item.getDescription());

        Button select = (Button)view.findViewById(R.id.select_list_button);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPicked(item);
                dialog.dismiss();
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int group, int child) {
        return true;
    }
}
