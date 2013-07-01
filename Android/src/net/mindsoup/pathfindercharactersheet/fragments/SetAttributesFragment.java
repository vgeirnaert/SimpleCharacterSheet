/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.fragments;

import net.mindsoup.pathfindercharactersheet.CharacterActivity;
import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockDialogFragment;

/**
 * @author Valentijn
 *
 */
public class SetAttributesFragment extends SherlockDialogFragment {
	
	PfCharacter character;
	View view;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.change_attribute, container);
        getDialog().setTitle("Set Character Attributes");
        
        character = ((CharacterActivity)this.getActivity()).getCharacter();
        
        EditText et = (EditText)view.findViewById(R.id.edit_cha);
        et.setText(Integer.toString(character.getBaseCharisma()));
        
        et = (EditText)view.findViewById(R.id.edit_con);
        et.setText(Integer.toString(character.getBaseConsistution()));
        
        et = (EditText)view.findViewById(R.id.edit_dex);
        et.setText(Integer.toString(character.getBaseDexterity()));
        
        et = (EditText)view.findViewById(R.id.edit_int);
        et.setText(Integer.toString(character.getBaseIntelligence()));
        
        et = (EditText)view.findViewById(R.id.edit_str);
        et.setText(Integer.toString(character.getBaseStrength()));
        
        et = (EditText)view.findViewById(R.id.edit_wis);
        et.setText(Integer.toString(character.getBaseWisdom()));
        
        TextView tv = (TextView)view.findViewById(R.id.cha_bonus);
        int stat = character.getRace().getChaModifier();
        if(stat != 0)
        	tv.setText(Integer.toString(stat));
        
        tv = (TextView)view.findViewById(R.id.con_bonus);
        stat = character.getRace().getConModifier();        
        if(stat != 0)
        	tv.setText(Integer.toString(stat));
        
        tv = (TextView)view.findViewById(R.id.dex_bonus);
        stat = character.getRace().getDexModifier();
        if(stat != 0)
        	tv.setText(Integer.toString(stat));
        
        tv = (TextView)view.findViewById(R.id.int_bonus);
        stat = character.getRace().getIntModifier();
        if(stat != 0)
        	tv.setText(Integer.toString(stat));
        
        tv = (TextView)view.findViewById(R.id.str_bonus);
        stat = character.getRace().getStrModifier();
        if(stat != 0)
        	tv.setText(Integer.toString(stat));
        
        tv = (TextView)view.findViewById(R.id.wis_bonus);
        stat = character.getRace().getWisModifier();
        if(stat != 0)
        	tv.setText(Integer.toString(stat));
        
        Button b = (Button)view.findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setAttributes();				
			}
        	
        });

        return view;
    }
	
	public void setAttributes() {
		EditText et = (EditText)view.findViewById(R.id.edit_cha);
		String num = et.getText().toString();
		int i = Integer.parseInt(num);
		character.setBaseCharisma(i);
		
		et = (EditText)view.findViewById(R.id.edit_con);
		num = et.getText().toString();
		i = Integer.parseInt(num);
		character.setBaseConstitution(i);
		
		et = (EditText)view.findViewById(R.id.edit_dex);
		num = et.getText().toString();
		i = Integer.parseInt(num);
		character.setBaseDexterity(i);
		
		et = (EditText)view.findViewById(R.id.edit_int);
		num = et.getText().toString();
		i = Integer.parseInt(num);
		character.setBaseIntelligence(i);
		
		et = (EditText)view.findViewById(R.id.edit_str);
		num = et.getText().toString();
		i = Integer.parseInt(num);
		character.setBaseStrength(i);
		
		et = (EditText)view.findViewById(R.id.edit_wis);
		num = et.getText().toString();
		i = Integer.parseInt(num);
		character.setBaseWisdom(i);
		
		((CharacterActivity)this.getActivity()).updateCharacter();
		
		this.dismiss();
	}
}
