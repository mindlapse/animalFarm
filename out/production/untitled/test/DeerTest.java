import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.*;


public class DeerTest {


    @Test
    public void testAreEqualObjectsTheSame() {

        Deer e1 = new Deer(new TagId(0), "Antlers", 4);
        Deer e2 = new Deer(new TagId(0), "Antlers", 4);

        assertTrue(e1.equals(e2));
    }

    @Test
    public void testInequalLegsShouldMeanInequalObjects() {

        Deer e1 = new Deer(new TagId(0), "Antlers", 4);
        Deer e2 = new Deer(new TagId(0), "Antlers", 2);

        assertFalse(e1.equals(e2));
    }

    @Test
    public void testInequalAntlersShouldMeanInequalObjects() {

        Deer e1 = new Deer(new TagId(0), "Sport", 4);
        Deer e2 = new Deer(new TagId(0), "Antlers", 4);

        assertFalse(e1.equals(e2));
    }

    @Test
    public void testInequalTagIdsShouldMeanInequalObjects() {

        Deer e1 = new Deer(new TagId(1), "Antlers", 4);
        Deer e2 = new Deer(new TagId(0), "Antlers", 4);

        assertFalse(e1.equals(e2));
    }

    @Test
    public void comparingAgainstNull() {

        Deer e1 = new Deer(new TagId(0), "Sport", 4);

        assertFalse(e1.equals(null));
    }

    @Test
    public void testReadFile() throws Exception {
        Map<TagId, Deer> map = Animal.readFile("deer.txt", new DeerParser());
        assertNotNull(map);
    }


    @Test
    public void testFileNotFound() {
        boolean caught = false;
        try {
            Animal.readFile("aiusdgfoajudshfal.txt", new DeerParser());
        } catch (FileNotFoundException fnfe) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    public void testRead6Items()  throws Exception  {
        Map<TagId, Deer> map = Animal.readFile("deer.txt", new DeerParser());
        assertNotNull(map);
        assertEquals(6, map.size());
    }

    @Test
    public void testGetHappyDeer() throws Exception {
        Map<TagId, Deer> map = Animal.readFile("deer.txt", new DeerParser());
        assertNotNull(map);
        assertEquals(6, map.size());

        Deer deer = map.get(new TagId(1237));

        assertEquals("Happy", deer.getAntlers());
        assertEquals(5, deer.getLegs());

    }




}