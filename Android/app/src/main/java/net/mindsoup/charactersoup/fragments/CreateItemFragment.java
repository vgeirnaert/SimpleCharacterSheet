/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfHandedness;
import net.mindsoup.charactersoup.pf.items.Item;
import net.mindsoup.charactersoup.pf.items.ItemEffects;
import net.mindsoup.charactersoup.pf.items.ItemSlots;
import net.mindsoup.charactersoup.pf.items.Weapon;
import net.mindsoup.charactersoup.pf.items.Wearable;
import net.mindsoup.charactersoup.pf.util.Dice;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockDialogFragment;

import java.util.ArrayList;

/**
 * @author Valentijn
 *
 */
public class CreateItemFragment extends SherlockDialogFragment {
	
	public CreateItemFragment() {
		
	}

    private int speedPenalty;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View mainView = inflater.inflate(R.layout.create_item, container);
        getDialog().setTitle(R.string.item_dialog_title);
        
        ((Button)mainView.findViewById(R.id.create_item_create)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				accept(view);
			}
        });
        
        ((Button)mainView.findViewById(R.id.create_item_cancel)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				cancel(view);
			}
        });
        
        // fill item effects spinner
        ItemEffects[] ie = ItemEffects.values();
        String[] effects = new String[ie.length];
        
        for(int i = 0; i < ie.length; i++)
        	effects[i] = ie[i].toString();
        
        ArrayAdapter<String> effectAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, effects);
        effectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)mainView.findViewById(R.id.create_item_effecttype)).setAdapter(effectAdapter);
        
        // fill item slot spinner
        ItemSlots[] is = ItemSlots.values();
        String[] slots = new String[is.length];
        
        for(int i = 0; i < is.length; i++)
        	slots[i] = is[i].toString();
        
        ArrayAdapter<String> slotAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, slots);
        slotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)mainView.findViewById(R.id.create_item_slot)).setAdapter(slotAdapter);
        
        ((Spinner)mainView.findViewById(R.id.create_item_slot)).setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if(position == ItemSlots.WEAPON.ordinal()) {
					mainView.findViewById(R.id.create_item_weapon).setVisibility(View.VISIBLE);
					mainView.findViewById(R.id.create_item_armor).setVisibility(View.GONE);
				} else if(position == ItemSlots.NOT_EQUIPABLE.ordinal()) {
					mainView.findViewById(R.id.create_item_weapon).setVisibility(View.GONE);
					mainView.findViewById(R.id.create_item_armor).setVisibility(View.GONE);
				} else {
					mainView.findViewById(R.id.create_item_weapon).setVisibility(View.GONE);
					mainView.findViewById(R.id.create_item_armor).setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});
        
        
        // fill item handedness
        PfHandedness[] hs = PfHandedness.values();
        String[] hands = new String[hs.length];
        
        for(int i = 0; i < hs.length; i++)
        	hands[i] = hs[i].toString();
        
        ArrayAdapter<String> handAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, hands);
        handAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)mainView.findViewById(R.id.create_weapon_handedness)).setAdapter(handAdapter);

        return mainView;
	}
	
	public void cancel(View view) {
		this.dismiss();
	}
	
	public void accept(View view) {
		CharacterActivity activity = (CharacterActivity)this.getActivity();

		String name = ((EditText)this.getView().findViewById(R.id.create_item_name)).getText().toString();
		String description = ((EditText)this.getView().findViewById(R.id.create_item_description)).getText().toString();
		float weight = 0.0f;
		int amount = 1;
		int value = 0;
		try {
			weight = Float.parseFloat( ((EditText)this.getView().findViewById(R.id.create_item_weight)).getText().toString() );
		} catch(NumberFormatException e) {}
		try {
			amount = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_item_amount)).getText().toString() );
		} catch(NumberFormatException e) {}
		try {
			value = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_item_value)).getText().toString() );
		} catch(NumberFormatException e) {}
		ItemEffects effect = ItemEffects.getEffect( ((Spinner)this.getView().findViewById(R.id.create_item_effecttype)).getSelectedItemPosition() );
		String effectValueString = ((EditText)this.getView().findViewById(R.id.create_item_effectvalue)).getText().toString();
		
		int effectValue = 0;
		if(effectValueString.length() > 0)
			effectValue = Integer.parseInt( effectValueString );
		
		ItemSlots slot = ItemSlots.getItemSlot(((Spinner)this.getView().findViewById(R.id.create_item_slot)).getSelectedItemPosition());
		
		Item i = null;
		
		switch(slot) {
		case WEAPON:
			Dice damage = new Dice(((EditText)this.getView().findViewById(R.id.create_weapon_damage)).getText().toString());
			int multi = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_weapon_critmulti)).getText().toString() );
			int rangeindex = ((Spinner)this.getView().findViewById(R.id.create_weapon_critrange)).getSelectedItemPosition() + 1;
			PfHandedness hand = PfHandedness.getHandedness(((Spinner)this.getView().findViewById(R.id.create_weapon_handedness)).getSelectedItemPosition());
			i = new Weapon(name, damage, multi, rangeindex, hand);
			((Weapon)i).setDamageType(((EditText)this.getView().findViewById(R.id.create_weapon_damagetype)).getText().toString());
			break;
		case NOT_EQUIPABLE:
			i = new Item(name);
			break;
		default:
			int ac = 0, maxdex = 99, penalty = 0, speed = 0;
            Spinner spinner = (Spinner) this.getView().findViewById(R.id.create_armor_type);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.armor_types, R.layout.sherlock_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    setSpeedPenalty(position);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            try {
				ac = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_armor_ac)).getText().toString() );
			} catch (NumberFormatException e) {}
			try {
				maxdex = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_armor_maxdex)).getText().toString() );
			} catch (NumberFormatException e) {}
			try {
				penalty = Integer.parseInt( ((EditText)this.getView().findViewById(R.id.create_armor_penalty)).getText().toString() );
			} catch (NumberFormatException e) {}
            speed = speedPenalty;
			i = new Wearable(name, ac, maxdex, penalty, speed);
			break;
		}
		
		
		i.setDescription(description);
		i.setStackSize(amount);
		i.setValue(value);
		i.setWeight(weight);

        if(effect == ItemEffects.AB_AND_DAMAGE) {
            i.addEffect(ItemEffects.ATTACK_BONUS, effectValue);
            i.addEffect(ItemEffects.DAMAGE_BONUS, effectValue);
        } else {
            i.addEffect(effect, effectValue);
        }
		i.setSlot(slot);
		activity.addItem(i);
		
		this.dismiss();
		
	}

    private void setSpeedPenalty(int armorType) {
        CharacterActivity characterActivity = new CharacterActivity();
        int baseSpeed = characterActivity.getCharacter().getRace().getBaseSpeed();
        switch (armorType){
            case 0:
                break;
            case 1:
                break;
            case 2:
                if (baseSpeed == 30) {
                    speedPenalty = -10;
                } else {
                    speedPenalty = -5;
                }
                break;
            case 3:
                if (baseSpeed == 30) {
                    speedPenalty = -10;
                } else {
                    speedPenalty = -5;
                }
                break;
        }
    }
}
