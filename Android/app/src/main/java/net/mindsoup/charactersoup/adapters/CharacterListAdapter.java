/**
 * 
 */
package net.mindsoup.charactersoup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfCharacter;

import java.util.ArrayList;

/**
 * @author Valentijn
 *
 */
public class CharacterListAdapter extends ArrayAdapter<PfCharacter> {
	
	private ArrayList<PfCharacter> characters;
	private int viewResourceId;

	public CharacterListAdapter(Context context, int textViewResourceId, ArrayList<PfCharacter> characters) {
		super(context, textViewResourceId, characters);
		
		this.characters = characters;
		this.viewResourceId = textViewResourceId;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(viewResourceId, null);
        
        String name ="Character " + position;
        String detail = "Character not present";
        int portrait = R.drawable.ic_action_user;
        
        PfCharacter character = characters.get(position);
        
        if(character != null) {
	        name = character.getName();
	    	detail = "Level " + character.getLevel() + " " + character.getRace() + " " + character.getPfClass();
	    	portrait = character.getPortraitRes(); 
        }
        
        TextView tv = (TextView)convertView.findViewById(R.id.char_name);
        tv.setText(name);     
        
        tv = (TextView)convertView.findViewById(R.id.char_details);
        tv.setText(detail);
        
        ImageView iv = (ImageView)convertView.findViewById(R.id.char_img);
        iv.setImageDrawable(this.getContext().getResources().getDrawable( portrait ));
        
        return convertView;
    }
	
	public void addAll(ArrayList<PfCharacter> chars) {
		System.out.println("adding " + chars.size());
		
		ArrayList<PfCharacter> newCharacters = new ArrayList<PfCharacter>();
		
		for(PfCharacter c : chars)
			newCharacters.add(c);
		
		this.characters = newCharacters;
	}

}
