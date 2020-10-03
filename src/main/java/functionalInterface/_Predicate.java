package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid.test("07000000000"));
        System.out.println(isPhoneNumberValid.and(isPhoneNumberContains3).test("07123456789"));
        System.out.println(isPhoneNumberValid.or(isPhoneNumberContains3).test("07000000000"));
    }

    static Predicate<String> isPhoneNumberValid = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> isPhoneNumberContains3 = phoneNumber -> phoneNumber.contains("3");
}
