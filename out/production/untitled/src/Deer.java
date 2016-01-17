import java.util.HashMap;
import java.util.Map;

public class Deer extends Animal implements Waveable {

    private static String snowball;
    private String antlers;
    private int legs;

    public Deer(TagId tagId, String antlers, int legs) {
        super(tagId);
        this.antlers = antlers;
        this.legs = legs;
    }

    public void wave() {
        WaveHelper.wave();
    }



    public String getAntlers() {
        return antlers;
    }

    public final void setAntlers(String antlers) {
        this.antlers = antlers;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deer deer = (Deer) o;

        if (legs != deer.legs) return false;
        if (tagId != null ? !tagId.equals(deer.tagId) : deer.tagId != null) return false;
        return antlers != null ? antlers.equals(deer.antlers) : deer.antlers == null;

    }

    @Override
    public int hashCode() {
        int result = tagId != null ? tagId.hashCode() : 0;
        result = 31 * result + (antlers != null ? antlers.hashCode() : 0);
        result = 31 * result + legs;
        return result;
    }

    @Override
    public String toString() {
        return "Deer{" +
                "antlers='" + antlers + '\'' +
                ", legs=" + legs +
                '}';
    }

    public static void main(String[] args) {


        snowball = "Snowball";


        Map<TagId, Deer> wildlife = new HashMap<TagId, Deer>();

        for (int i = 0; i < 100; i++) {
            TagId id = new TagId(i);

            wildlife.put(id, new Deer(id, "Antlers", 4));
        }

        for (TagId tagId : wildlife.keySet()) {
            System.out.println(tagId + " has the hashcode " + tagId.hashCode());
        }




        // N*N = N^2

        /*

        N = 1 or N = 10000000;
        O(1) = 23 steps

        N = 3000;
        O(1)   = 1 step
        O(N)   = 3000 steps
        O(N^2) = 9,000,000 steps
        O(N^3) = 27,000,000,000 steps
        O(N^4) = 81,000,000,000,000 steps

        N = 30000
        O(1)   = 1 step
        O(N)   = 30000 steps
        O(N^2) = 900,000,000 steps
        O(N^3) = 27,000,000,000,000 steps
        O(N^4) = 810,000,000,000,000,000 steps

        N = 3,000,000;
        O(N) = 6,000,000 steps

         */




        // O(1)     Constant        A fixed number of steps to solve a problem.

        // O(N)     Linear          Looking for an object in an arraylist takes linear time.

        // O(N^2)   Quadratic
        // O(N^3)   Cubic




    }

}


