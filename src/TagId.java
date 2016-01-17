public class TagId {

    private String x = "yz";
    private long id;

    public TagId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagId tagId = (TagId) o;

        if (id != tagId.id) return false;
        return x != null ? x.equals(tagId.x) : tagId.x == null;

    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TagId{" +
                "id=" + id +
                '}';
    }
}