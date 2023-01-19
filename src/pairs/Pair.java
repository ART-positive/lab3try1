package pairs;

public class Pair{
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int geta() {
        return this.a;
    }

    public int getb() {
        return this.b;
    }

    @Override
    public String toString() {
        return "Pair: "
                + "First element = '" + geta() + '\''
                + ", Second element = " + geta() + '\'';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return  this.geta() == ((Pair) object).geta()
                && this.getb() == ((Pair) object).getb();
    }
    @Override
    public int hashCode() {
        int result = 29 * this.geta();
        result += 31 * this.getb();
        return result;
    }
}