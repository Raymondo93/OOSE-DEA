package koenenkramers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by royho on 3-10-2016.
 */
public class WoordenboekTest extends TestCase {

    public WoordenboekTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( WoordenboekTest.class );
    }

    public void testKoenen()
    {
        Woordenboek w = Woordenboek.getInstance();
        System.out.println(w.translate("paard"));
        System.out.println(w.translate("submarine"));
    }
}
