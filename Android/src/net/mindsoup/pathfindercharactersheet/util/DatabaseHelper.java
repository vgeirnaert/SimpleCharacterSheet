/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.util;

import java.util.ArrayList;
import java.util.List;

import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfClasses;
import net.mindsoup.pathfindercharactersheet.pf.PfPace;
import net.mindsoup.pathfindercharactersheet.pf.PfRaces;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * @author Valentijn
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	// db
	private static final String DATABASE = "SimplePathfinderCharacterSheet.db";
	private static final int DATABASE_VERSION = 5;
	
	public static abstract class Db implements BaseColumns {

		// table characters
		private static final String CHARACTER_TABLE = "Characters";
		private static final String CHAR_NAME = "name";
		private static final String CHAR_CLASS = "class";
		private static final String CHAR_RACE = "race";
		private static final String CHAR_XP = "xp";
		private static final String CHAR_HPPL = "getHpPerLevel";
		private static final String CHAR_PACE = "pace";
		private static final String CHAR_ASRANKS = "availableSkillRanks";
		private static final String CHAR_CHA = "charisma";
		private static final String CHAR_CON = "constitution";
		private static final String CHAR_DEX = "dexterity";
		private static final String CHAR_INT = "intelligence";
		private static final String CHAR_STR = "strength";
		private static final String CHAR_WIS = "wisdom";
			
		//create
		public static final String CREATE_CHARACTER_TABLE = "CREATE TABLE IF NOT EXISTS " + Db.CHARACTER_TABLE + " (" +
				Db._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +  
				Db.CHAR_NAME + " TEXT NOT NULL ON CONFLICT FAIL," +
				Db.CHAR_CLASS + " SMALLINT NOT NULL ON CONFLICT FAIL," + 
				Db.CHAR_RACE + " SMALLINT NOT NULL ON CONFLICT FAIL," + 
				Db.CHAR_XP + " INT NOT NULL ON CONFLICT FAIL DEFAULT 0," + 
				Db.CHAR_HPPL + " BOOL NOT NULL ON CONFLICT FAIL DEFAULT 0," + 
				Db.CHAR_PACE + " SMALLINT NOT NULL ON CONFLICT FAIL DEFAULT 1," + 
				Db.CHAR_ASRANKS + " INT NOT NULL ON CONFLICT FAIL DEFAULT 0," + 
				Db.CHAR_CHA + " INT DEFAULT 1," +
				Db.CHAR_CON + " INT DEFAULT 1," + 
				Db.CHAR_DEX + " INT DEFAULT 1," + 
				Db.CHAR_INT + " INT DEFAULT 1," + 
				Db.CHAR_STR + " INT DEFAULT 1," + 
				Db.CHAR_WIS + " INT DEFAULT 1);";
		
		private static final String DROP_CHARACTERS = "DROP TABLE IF EXISTS " + Db.CHARACTER_TABLE;
		
		// table skills
		private static final String SKILLS_TABLE = "TrainedSkills";
		private static final String SKILL_ID = "skill";
		private static final String SKILL_RANKS = "ranks";
		private static final String SKILL_CHAR_ID = "character_id";		
		
		public static final String CREATE_SKILLS_TABLE = "CREATE TABLE IF NOT EXISTS " + Db.SKILLS_TABLE + " (" +
				  Db._ID + " INTEGER PRIMARY KEY AUTOINCREMENT CONSTRAINT character_id_fk REFERENCES " + Db.CHARACTER_TABLE + "(" + Db._ID + ") ON DELETE CASCADE ON UPDATE CASCADE," +
				  Db.SKILL_ID + " SMALLINT NOT NULL ON CONFLICT FAIL," + 
				  Db.SKILL_RANKS + " INT NOT NULL ON CONFLICT FAIL DEFAULT 1," + 
				  Db.SKILL_CHAR_ID + " INT NOT NULL ON CONFLICT FAIL);";

		public static final String CREATE_SKILLS_INDEX = "CREATE INDEX character_id_index ON " + Db.SKILLS_TABLE + " (" + Db.SKILL_CHAR_ID + ")";
		
		private static final String DROP_SKILLS = "DROP TABLE IF EXISTS " + Db.SKILLS_TABLE;
	}

	public DatabaseHelper(Context context) {
		super(context, DATABASE, null, DATABASE_VERSION);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Db.CREATE_CHARACTER_TABLE);
		db.execSQL(Db.CREATE_SKILLS_TABLE);
		db.execSQL(Db.CREATE_SKILLS_INDEX);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(Db.DROP_CHARACTERS);
		db.execSQL(Db.DROP_SKILLS);
		
		onCreate(db);

	}
	
	public List<PfCharacter> getCharacters() {
		// TODO: this should only be done once
		SQLiteDatabase db = this.getReadableDatabase();
		
		List<PfCharacter> characters = new ArrayList<PfCharacter>();
		
		String[] columns = {Db._ID, Db.CHAR_NAME, Db.CHAR_CLASS, Db.CHAR_RACE, Db.CHAR_XP, Db.CHAR_PACE};
		String orderBy = Db.CHAR_NAME + " ASC";
		
		Cursor c = db.query(Db.CHARACTER_TABLE, columns, null, null, null, null, orderBy);
		
		if(c.moveToFirst()) {
			do {
				characters.add(getNewCharacter(c));
			} while(c.moveToNext());
		}
		
		db.close();
		
		return characters;
	}
	
	private PfCharacter getNewCharacter(Cursor c) {
		String name = c.getString(c.getColumnIndex(Db.CHAR_NAME));
		PfClasses charClass = PfClasses.getPfClass(c.getInt(c.getColumnIndex(Db.CHAR_CLASS)));
		PfRaces charRace = PfRaces.getRace(c.getInt(c.getColumnIndex(Db.CHAR_RACE)));
		int xp = c.getInt(c.getColumnIndex(Db.CHAR_XP));
		PfPace pace = PfPace.getPace(c.getInt(c.getColumnIndex(Db.CHAR_PACE)));
		long id = c.getLong(c.getColumnIndex(Db._ID));
		
		PfCharacter newChar = new PfCharacter(PfRaces.getRace(charRace), PfClasses.getPfClass(charClass), true, name);
		newChar.setPace(pace);
		newChar.setXp(xp);
		newChar.setId(id);
		
		return newChar;
	}
	
	public long addCharacter(PfCharacter character) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(Db.CHAR_NAME, character.getName());
		values.put(Db.CHAR_CLASS, character.getPfClass().getPfClass().ordinal());
		values.put(Db.CHAR_RACE, character.getRace().getRace().ordinal());
		values.put(Db.CHAR_XP, character.getXp());
		values.put(Db.CHAR_HPPL, character.getsHpPerLevel());
		values.put(Db.CHAR_PACE, character.getPace().ordinal());
		
		long result = db.insert(Db.CHARACTER_TABLE, null, values);
		db.close();
		
		return result;
		
	}
	
	public void deleteCharacter(PfCharacter character) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		String whereClause = Db._ID + " = ?";
		String[] whereArgs = {Long.toString(character.getId())};
		
		db.delete(Db.CHARACTER_TABLE, whereClause, whereArgs);
		db.close();
	}

}
