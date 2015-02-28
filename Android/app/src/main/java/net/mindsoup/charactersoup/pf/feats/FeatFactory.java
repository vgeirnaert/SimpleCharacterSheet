/**
 * 
 */
package net.mindsoup.charactersoup.pf.feats;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.mindsoup.charactersoup.pf.PfCharacter;
import net.mindsoup.charactersoup.util.ListElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentijn
 *
 */
public class FeatFactory {
	
	private static String[] feat_names = null;
	private static String[] feat_descriptions = null;

    private static ArrayList<ListElement> feats = null;
	
	public static PfFeat getFeat(Context context, PfFeats feat) {

        if(feats == null) {
            InputStream json;
            try {
                json = context.getAssets().open("pf_data/feats.json");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

            ObjectMapper mapper = new ObjectMapper();

            try {
                feats = mapper.readValue(json, new TypeReference<List<ListElement>>(){});
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
		
		return new PfFeat(feats.get(feat.ordinal()).getTitle(), feats.get(feat.ordinal()).getDescription(), feat);
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
