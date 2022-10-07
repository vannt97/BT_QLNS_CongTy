import java.util.Comparator;

public class SortByLuong implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.getLuongThang() - p1.getLuongThang();
    }
}
