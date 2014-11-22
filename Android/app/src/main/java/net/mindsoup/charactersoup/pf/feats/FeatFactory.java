/**
 * 
 */
package net.mindsoup.charactersoup.pf.feats;

import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.pf.PfCharacter;
import android.content.Context;

/**
 * @author Valentijn
 *
 */
public class FeatFactory {
	
	private static String[] feat_names = null;
	private static String[] feat_descriptions = null;
	
	public static PfFeat getFeat(Context context, PfFeats feat) {
		if(feat_names == null) 
			feat_names = context.getResources().getStringArray(R.array.feat_names);
		
		if(feat_descriptions == null) 
			feat_descriptions = context.getResources().getStringArray(R.array.feat_descriptions);
		
		return new PfFeat(feat_names[feat.ordinal()], feat_descriptions[feat.ordinal()], feat);
	}
	
	public static FeatPrerequisite getPrerequisite(PfFeats feat) {
		return new FeatPrerequisite() {
			
			@Override
			public boolean satisfiesPrerequisite(PfCharacter character) {
				return true;
			}
		};
	}

}
