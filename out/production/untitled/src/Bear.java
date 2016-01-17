
public class Bear extends Animal {


    private final String name;

    public Bear(TagId tagId, String name) {
        super(tagId);
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bear bear = (Bear) o;

        return name != null ? name.equals(bear.name) : bear.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "name='" + name + '\'' +
                '}';
    }
}
