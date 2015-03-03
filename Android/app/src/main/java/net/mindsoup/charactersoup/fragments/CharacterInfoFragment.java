/**
 * 
 */
package net.mindsoup.charactersoup.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfCharacter;

/**
 * @author Valentijn
 *
 */
public class CharacterInfoFragment extends CharacterFragment implements OnClickListener {
	
	private PfCharacter character;

    private int[] buttonIds = new int[]{R.id.xp_button, R.id.money_button, R.id.hp_button, R.id.skill_button, R.id.feat_button, R.id.spells_button};
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_info, container, false);
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
		setStats();
	}

	@Override
	public void refresh() {
		setStats();
		
	}
	
	private void setStats() {
		if(isAdded()) {
			CharacterActivity ca = (CharacterActivity)this.getActivity();
			character = ca.getCharacter();
			
			TextView editText = (TextView)getActivity().findViewById(R.id.char_info_text);
            String stats = "<b>" + character.getName() + "</b><br>level " + character.getLevel() + " " + character.getRace().toString() + " " + character.getPfClass().toString();
            editText.setText(Html.fromHtml(stats));
			
			EditText edit = (EditText)getActivity().findViewById(R.id.edit_xp);
			edit.setText(Integer.toString(character.getXp()));
			
			edit = (EditText)getActivity().findViewById(R.id.edit_money);
			edit.setText(Integer.toString(character.getMoney()));

            edit = (EditText)getActivity().findViewById(R.id.edit_hp);
            edit.setText(Integer.toString(character.getMaxHitpoints().sum()));

            edit = (EditText)getActivity().findViewById(R.id.edit_skill);
            edit.setText(Integer.toString(character.getAvailableSkillRanks()));

            edit = (EditText)getActivity().findViewById(R.id.edit_feat);
            edit.setText(Integer.toString(character.getAvailableFeats()));

            edit = (EditText)getActivity().findViewById(R.id.edit_spells);
            edit.setText(Integer.toString(character.getAvailableSpecialPowers()));

            for(int id : buttonIds) {
                Button button = (Button) getActivity().findViewById(id);
                button.setOnClickListener(this);
            }
		}
	}
	
	protected void updateCharacter() {
		CharacterActivity ca = (CharacterActivity)this.getActivity();
		ca.updateCharacter(true);
	}
	
	protected void setXp() {
		EditText edit = (EditText)getActivity().findViewById(R.id.edit_xp);
		
		final int newXp = Integer.parseInt( edit.getText().toString() );
		final int currentLevel = character.getLevel();
		final int newLevel = character.getLevel(newXp);
		
		if(newLevel > currentLevel) {
			new AlertDialog.Builder(this.getActivity())
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle("Level up!")
	        .setMessage("You will gain " + (newLevel - currentLevel) + " level(s). Continue?")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	        	@Override
	        	public void onClick(DialogInterface dialog, int which) {
	        		character.setNewLevels(character.getNewLevels() + (newLevel - currentLevel));
	        		character.setXp(newXp);
	        		updateCharacter();
	        	}

	        })
	        .setNegativeButton("No", null)
	        .show();
		} else {
			character.setXp(newXp);
			updateCharacter();
		}
	}
	
	protected void setMoney() throws NumberFormatException {
		EditText edit = (EditText)getActivity().findViewById(R.id.edit_money);
		character.setMoney(Integer.parseInt( edit.getText().toString() ));
		updateCharacter();
	}

    protected void setHp() throws NumberFormatException {
        EditText edit = (EditText)getActivity().findViewById(R.id.edit_hp);
        character.setHitpoints(Integer.parseInt( edit.getText().toString() ));
        updateCharacter();
    }

    protected void setSkills() throws NumberFormatException {
        EditText edit = (EditText)getActivity().findViewById(R.id.edit_skill);
        character.setAvailableSkillRanks(Integer.parseInt( edit.getText().toString() ));
        updateCharacter();
    }

    protected void setFeats() throws NumberFormatException {
        EditText edit = (EditText)getActivity().findViewById(R.id.edit_feat);
        character.setAvailableFeats(Integer.parseInt( edit.getText().toString() ));
        updateCharacter();
    }

    protected void setSpells() throws NumberFormatException {
        EditText edit = (EditText)getActivity().findViewById(R.id.edit_spells);
        character.setAvailableSpecialPowers(Integer.parseInt( edit.getText().toString() ));
        updateCharacter();
    }

    @Override
    public String getHelpTitle() throws NumberFormatException {
        return this.getActivity().getString(R.string.info_fragment_help_title);
    }

    @Override
    public String getHelpText() {
        return this.getActivity().getString(R.string.info_fragment_help_text);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.money_button:
                    setMoney();
                    break;
                case R.id.xp_button:
                    setXp();
                    break;
                case R.id.hp_button:
                    setHp();
                    break;
                case R.id.skill_button:
                    setSkills();
                    break;
                case R.id.feat_button:
                    setFeats();
                    break;
                case R.id.spells_button:
                    setSpells();
                    break;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this.getActivity(), "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
}
