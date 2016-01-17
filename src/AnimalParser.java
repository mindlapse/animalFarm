import java.util.ArrayList;
import java.util.List;

public interface AnimalParser<ANIMALTYPE extends Animal> {

    ANIMALTYPE getAnimal(String line);

}

class SomeTest {

    public static void main(String[] args) {

        AnimalParser<Deer> deerParser = new AnimalParser<Deer>() {
            @Override
            public Deer getAnimal(String line) {
                String[] data = line.split(",");
                long id       = Long.parseLong(data[0]);
                String antler = data[1];
                int legs      = Integer.parseInt(data[2]);

                return new Deer(new TagId(id), antler, legs);
            }
        };

        AnimalParser<Bear> bearParser = new AnimalParser<Bear>() {
            @Override
            public Bear getAnimal(String line) {
                String[] data = line.split(",");
                long id       = Long.parseLong(data[0]);
                String name   = data[1];
                return new Bear(new TagId(id), name);
            }
        };

        System.out.println(deerParser.getAnimal("111,Furry,4"));
        System.out.println(bearParser.getAnimal("345,Teddy"));

    }

}
