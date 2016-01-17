import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Animal {


    private static Logger logger = Logger.getLogger(Deer.class.getName());

    public Animal(TagId tagId) {
        this.tagId = tagId;
    }

    protected TagId tagId;

    public static <ANIMALTYPE extends Animal>  Map<TagId, ANIMALTYPE> readFile(String fileName, AnimalParser<ANIMALTYPE> parser) throws FileNotFoundException {

        Map<TagId, ANIMALTYPE> map = new HashMap<TagId, ANIMALTYPE>();
        BufferedReader br = null;
        logger.log(Level.INFO, "About to read " + fileName);

        try {
            br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                ANIMALTYPE animal = parser.getAnimal(line);
                map.put(animal.getTagId(), animal);
            }

        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "Problem while reading " + fileName, ioe);

            if (ioe instanceof FileNotFoundException) {
                throw (FileNotFoundException)ioe;
            }
        } finally {
            // After
            try {
                if (br != null) {
                    logger.log(Level.INFO, "Closing the buffered reader");
                    br.close();
                }
            } catch (IOException ioe2) {
                logger.log(Level.SEVERE, "Error closing buffered reader", ioe2);
            }
        }
        return map;
    }

    public TagId getTagId() {
        return tagId;
    }
}
