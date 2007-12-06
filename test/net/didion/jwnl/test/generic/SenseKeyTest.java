package net.didion.jwnl.test.generic;

import java.io.FileInputStream;

import junit.framework.TestCase;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

import org.junit.Test;

/**
 * Tests accessing the various sense keys and usage counts for the lemma "tank". 
 * @author brett
 *
 */
public class SenseKeyTest extends TestCase {

	@Test
	public void testSimpleSenseKey() {
		try {
			JWNL.initialize(new FileInputStream("C:\\21csi\\workspaces\\hicin-data-translator\\com.p21csi.lib.net.didion.jwnl\\config\\file_properties.xml"));
			IndexWord word = Dictionary.getInstance().getIndexWord(POS.NOUN, "tank");
			Synset[] syns = word.getSenses();
			for (Synset syn : syns) {
				for (Word w: syn.getWords()) {
                    w.getUsageCount();
                    w.getSenseKey();
				}
			}
			
			
		} catch(Exception e) {
            fail("Exception in Sense Key test caught");
			e.printStackTrace();
		}
		
		System.out.println("Sense key test passed.");
		
	}
	
}