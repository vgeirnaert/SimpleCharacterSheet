/**
 * 
 */
package net.mindsoup.charactersoup.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.actionbarsherlock.app.SherlockFragment;

import java.util.List;

/**
 * @author Valentijn
 *
 */
public class CharacterPagerAdapter extends FragmentStatePagerAdapter {
	
	private List<SherlockFragment> fragments;

	public CharacterPagerAdapter(FragmentManager fm, List<SherlockFragment> fragments) {
		super(fm);
		
		this.fragments = fragments;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
	 */
	@Override
	public Fragment getItem(int position) {		
		return this.fragments.get(position);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		return this.fragments.size();
	}
	
	public List<SherlockFragment> getItems() {
		return fragments;
	}

}
