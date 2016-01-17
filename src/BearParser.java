
public class BearParser implements AnimalParser<Bear> {

    @Override
    public Bear getAnimal(String line) {
        String[] data = line.split(",");
        long id       = Long.parseLong(data[0]);
        String name   = data[1];
        return new Bear(new TagId(id), name);
    }
}
