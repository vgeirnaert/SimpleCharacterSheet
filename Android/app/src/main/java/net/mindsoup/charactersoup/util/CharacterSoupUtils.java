package net.mindsoup.charactersoup.util;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.mindsoup.charactersoup.fragments.PickFromListFragment;
import net.mindsoup.charactersoup.fragments.UpdateMessageFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentijn on 28-2-2015.
 */
public class CharacterSoupUtils {

    public static void showTextDialog(final FragmentActivity activity, final String message, final String title) {
        FragmentManager fm = activity.getSupportFragmentManager();
        UpdateMessageFragment messageFragment = new UpdateMessageFragment();
        Bundle arguments = new Bundle();
        arguments.putString(UpdateMessageFragment.messageTitleKey, title);
        arguments.putString(UpdateMessageFragment.messageKey, message);
        messageFragment.setArguments(arguments);
        messageFragment.show(fm, "help_message");
    }

    public static void showListDialog(final String tag, final FragmentActivity activity, final String filename, final String title, final PickFromListFragment.ParcelablePickFromListListener listener, boolean showCategories) {
        FragmentManager fm = activity.getSupportFragmentManager();
        if(fm.findFragmentByTag(tag) == null) {
            InputStream json;
            try {
                json = activity.getAssets().open(filename);
            } catch (IOException e) {
                Toast.makeText(activity, "Error reading " + filename, Toast.LENGTH_SHORT).show();
                return;
            }

            ObjectMapper mapper = new ObjectMapper();

            ArrayList<ListElement> list;
            try {
                list = mapper.readValue(json, new TypeReference<List<ListElement>>(){});
            } catch (IOException e) {
                Toast.makeText(activity, "Error parsing json from " + filename, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                return;
            }

            PickFromListFragment pickFeat = new PickFromListFragment();
            Bundle arguments = new Bundle();
            arguments.putString(PickFromListFragment.titleKey, title);
            arguments.putParcelableArrayList(PickFromListFragment.listKey, list);
            arguments.putParcelable(PickFromListFragment.callbackKey, listener);
            arguments.putBoolean(PickFromListFragment.categoriesKey, showCategories);
            pickFeat.setArguments(arguments);
            pickFeat.show(fm, tag);
        }
    }

    public static List<String> getCategoriesFromListElements(List<ListElement> elements) {
        List<String> categories = new LinkedList<String>();
        String currentCategory = "";
        for(ListElement e : elements) {
            if(!e.getCategory().equalsIgnoreCase(currentCategory)) {
                categories.add(e.getCategory());
            }
        }

        return categories;
    }

    public static Map<String, List<ListElement>> convertListElementListToCategoryMap(List<ListElement> elements) {
        Map<String, List<ListElement>> categoryMap = new LinkedHashMap<String, List<ListElement>>();

        for(ListElement e : elements) {
            if(!categoryMap.containsKey(e.getCategory())) {
                categoryMap.put(e.getCategory(), new ArrayList<ListElement>());
            }

            categoryMap.get(e.getCategory()).add(e);
        }

        return categoryMap;
    }
}
