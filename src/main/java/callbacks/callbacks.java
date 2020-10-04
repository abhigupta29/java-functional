package callbacks;

import java.util.function.Consumer;

public class callbacks {
    public static void main(String[] args) {

        hello("John", null, firstName -> System.out.println("no lastName provided for "+ firstName));

        hello2("John", null, () -> System.out.println("No lastname provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
