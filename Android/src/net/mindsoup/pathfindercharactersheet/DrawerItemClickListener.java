package net.mindsoup.pathfindercharactersheet;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DrawerItemClickListener implements OnItemClickListener {

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(view.getContext(), Integer.toString(position), Toast.LENGTH_LONG).show();
	}

}
