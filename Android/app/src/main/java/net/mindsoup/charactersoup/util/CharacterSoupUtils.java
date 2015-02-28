package net.mindsoup.charactersoup.util;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.mindsoup.charactersoup.fragments.PickFromListFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentijn on 28-2-2015.
 */
public class CharacterSoupUtils {

    public static void showListDialog(final String tag, final FragmentActivity activity, final String filename, final String title, final PickFromListFragment.ParcelablePickFromListListener listener) {
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
            pickFeat.setArguments(arguments);
            pickFeat.show(fm, tag);
        }
    }
}
