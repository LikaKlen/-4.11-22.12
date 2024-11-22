import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class ListManager {
    private final Number list1;
    private final Number list2;
    public ListManager(Number list1, Number list2) {
        this.list1 = list1;
        this.list2 = list2;
    }
    public Set<BigInteger> getUnion() {
        Set<BigInteger> union = new TreeSet<>(list1.getNumbers());
        union.addAll(list2.getNumbers());
        return union;
    }
}
