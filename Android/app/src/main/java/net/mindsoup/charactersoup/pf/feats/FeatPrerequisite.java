/**
 * 
 */
package net.mindsoup.charactersoup.pf.feats;

import net.mindsoup.charactersoup.pf.PfCharacter;

/**
 * @author Valentijn
 *
 */
public interface FeatPrerequisite {
	
	public boolean satisfiesPrerequisite(PfCharacter character);

}
