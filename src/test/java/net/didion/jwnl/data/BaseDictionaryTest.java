package net.didion.jwnl.data;

import net.didion.jwnl.JWNLException;
import net.didion.jwnl.dictionary.Dictionary;
import org.junit.After;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Base class for tests.
 *
 * @author Aliaksandr Autayeu avtaev@gmail.com
 */
public class BaseDictionaryTest {

    private final String properties = "./config/clean_file.xml";

    protected Dictionary dictionary;

    protected InputStream getProperties() throws IOException {
        return new FileInputStream(properties);
    }

    @Before
    public void setUp() throws JWNLException, IOException {
        dictionary = Dictionary.getInstance(getProperties());
    }

    @After
    public void tearDown() throws JWNLException {
        dictionary.close();
        dictionary.delete();
    }
}