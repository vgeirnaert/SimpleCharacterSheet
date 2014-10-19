/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.pf.feats;

import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;

/**
 * @author Valentijn
 *
 */
public interface FeatPrerequisite {
	
	public boolean satisfiesPrerequisite(PfCharacter character);

}
