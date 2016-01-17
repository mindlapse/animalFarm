public class DeerParser implements AnimalParser<Deer> {


    public Deer getAnimal(String line) {
        String[] data = line.split(",");
        long id       = Long.parseLong(data[0]);
        String antler = data[1];
        int legs      = Integer.parseInt(data[2]);

        return new Deer(new TagId(id), antler, legs);
    }

}