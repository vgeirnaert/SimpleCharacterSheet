package net.mindsoup.pathfindercharactersheet;

import java.util.ArrayList;
import java.util.List;

import net.mindsoup.pathfindercharactersheet.fragments.AttributesFragment;
import net.mindsoup.pathfindercharactersheet.fragments.CharacterInfoFragment;
import net.mindsoup.pathfindercharactersheet.fragments.OverviewFragment;
import net.mindsoup.pathfindercharactersheet.fragments.SkillsFragment;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfHandedness;
import net.mindsoup.pathfindercharactersheet.pf.PfPace;
import net.mindsoup.pathfindercharactersheet.pf.classes.PfBarbarian;
import net.mindsoup.pathfindercharactersheet.pf.items.Weapon;
import net.mindsoup.pathfindercharactersheet.pf.races.PfDwarf;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class CharacterActivity extends SherlockFragmentActivity {
	
	private PfCharacter dagrim = new PfCharacter(new PfDwarf(), new PfBarbarian(), true, "Dagrim Toragson");
	
	private ListView drawerList;
	private DrawerLayout drawerLayout;
	private CharacterPagerAdapter pagerAdapter;
	private ViewPager pager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character);
		
		// create navigation drawer
		initialiseNavDrawer();
		
		// set up fragment paging
		initialisePaging();
		
		// set up action bar
		initialiseActionBar();
		
		dagrim.setCharisma(8);
		dagrim.setConstitution(16);
		dagrim.setStrength(17);
		dagrim.setDexterity(15);
		dagrim.setIntelligence(11);
		dagrim.setWisdom(14);
		
		dagrim.setMainhandWeapon(new Weapon(new Dice(12, 1), 3, 1, PfHandedness.TWOHAND));
		dagrim.setPace(PfPace.FAST);
		dagrim.setXp(382);
		
		dagrim.trainSkill(PfSkills.ACROBATICS, 1);
		dagrim.trainSkill(PfSkills.SURVIVAL, 1);
		dagrim.trainSkill(PfSkills.KNOWLEDGE_NATURE, 1);
		dagrim.trainSkill(PfSkills.PERCEPTION, 1);
	}
	
	private void initialisePaging() {
		List<SherlockFragment> fragments = new ArrayList<SherlockFragment>();
		fragments.add((SherlockFragment)SherlockFragment.instantiate(this, OverviewFragment.class.getName()));
		fragments.add((SherlockFragment)SherlockFragment.instantiate(this, AttributesFragment.class.getName()));
		fragments.add((SherlockFragment)SherlockFragment.instantiate(this, SkillsFragment.class.getName()));
		fragments.add((SherlockFragment)SherlockFragment.instantiate(this, CharacterInfoFragment.class.getName()));
		this.pagerAdapter = new CharacterPagerAdapter(getSupportFragmentManager(), fragments);
		
		pager = (ViewPager)findViewById(R.id.viewpager);
		pager.setAdapter(pagerAdapter);
		
		OnPageChangeListener listener = new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				getSupportActionBar().setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {}
		};
		
		pager.setOnPageChangeListener(listener);
	}
	
	private void initialiseNavDrawer() {
		// create navigation drawer
		String[] drawerItems = getResources().getStringArray(R.array.drawer_items_array);
		drawerList = (ListView)findViewById(R.id.left_drawer);
		
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawerItems));		
		drawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				toggleDrawer();
				changeFragment(position);
			}
		});
		
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
	}
	
	private void initialiseActionBar() {
		// set up action bar
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setIcon(R.drawable.ic_drawer);
		getSupportActionBar().setTitle(dagrim.getName());
		
		// set up tabs
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				pager.setCurrentItem(tab.getPosition());
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {}
		};
		
		String[] drawerItems = getResources().getStringArray(R.array.drawer_items_array);
		for(String s : drawerItems) {
			Tab tab = getSupportActionBar().newTab();
			tab.setText(s);
			tab.setTabListener(tabListener);
			getSupportActionBar().addTab(tab);
		}
		
	}
	
	private void changeFragment(int fragment) {
		pager.setCurrentItem(fragment);
	}
	
	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.character, menu);
		   
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case android.R.id.home:
	        	toggleDrawer();
	            return true;
	        case R.id.home_button:
	        	heroButtonClicked();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	private void heroButtonClicked() {
		NavUtils.navigateUpFromSameTask(this);
	}
	
	private void toggleDrawer() {
		// if our home icon is pressed
    	// toggle the navigation drawer
    	if(drawerLayout.isDrawerOpen(drawerList)) {
    		drawerLayout.closeDrawer(drawerList);
    	}
    	else {
    		drawerLayout.openDrawer(drawerList);
    	}
	}
	
	public PfCharacter getCharacter() {
		return dagrim;
	}
	
	@Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
        	pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

}
