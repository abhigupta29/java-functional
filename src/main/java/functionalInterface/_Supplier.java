package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDbConnectionString.get());
        System.out.println(getDbConnectionList.get());
    }

    static Supplier<String> getDbConnectionString = () -> "jdbc::/localhost:5436/";
    static Supplier<List<String>> getDbConnectionList = () -> List.of(
            "jdbc::/localhost:5436",
            "jdbc::/localhost:3306"
    );
}
