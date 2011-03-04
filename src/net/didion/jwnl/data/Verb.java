package net.didion.jwnl.data;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.dictionary.Dictionary;

import java.util.BitSet;

/**
 * A <code>Verb</code> is a subclass of <code>Word</code> that can have 1 or more
 * <code>VerbFrame</code>s (use cases of the verb).
 *
 * @author didion
 * @author Aliaksandr Autayeu avtaev@gmail.com
 */
public class Verb extends Word {
    private static final long serialVersionUID = 1L;
    /**
     * A bit array of all the verb frames that are valid for this word.
     * see {@link VerbFrame} for more explanation.
     */
    private BitSet verbFrameFlags;

    public Verb(Dictionary dictionary, Synset synset, int index, String lemma, BitSet verbFrameFlags) {
        super(dictionary, synset, index, lemma);
        this.verbFrameFlags = verbFrameFlags;
    }

    public BitSet getVerbFrameFlags() {
        return verbFrameFlags;
    }

    public int[] getVerbFrameIndices() {
        return VerbFrame.getVerbFrameIndices(verbFrameFlags);
    }

    public String[] getVerbFrames() {
        return VerbFrame.getFrames(getVerbFrameFlags());
    }

    private String getVerbFramesAsString() {
        String[] frames = getVerbFrames();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < frames.length; i++) {
            buf.append(frames[i]);
            if (i != frames.length - 1) {
                buf.append(", ");
            }
        }
        return buf.toString();
    }

    public String toString() {
        return JWNL.resolveMessage("DATA_TOSTRING_008", new Object[]{getPOS(), getLemma(), getSynset(),
                getIndex(),
                getVerbFramesAsString()});
    }
}