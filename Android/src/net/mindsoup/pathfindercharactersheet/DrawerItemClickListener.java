package net.mindsoup.pathfindercharactersheet;

import net.mindsoup.pathfindercharactersheet.fragments.AttributesFragment;

import android.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;

public class DrawerItemClickListener implements OnItemClickListener {
	
	private SherlockActivity activity = null;

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(view.getContext(), Integer.toString(position), Toast.LENGTH_LONG).show();
		
		FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
		
		SherlockFragment frag = new AttributesFragment();
		fragmentTransaction.add(R.id.fragment_group, frag);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
	
	public void setActivity(SherlockActivity a) {
		activity = a;
	}

}
