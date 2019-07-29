package character.t;

public class CharacterTest {
    public static void main(String[] args) {
        char ch1 = 'a';
        char ch2 = 'A';
        char ch3 = '1';
        System.out.println(Character.isUpperCase(ch1)); // false
        System.out.println(Character.isLowerCase(ch1)); // true
        System.out.println(Character.isUpperCase(ch2)); // true
        System.out.println(Character.isLowerCase(ch2)); // false
        System.out.println(Character.isDigit(ch3)); // true
        System.out.println(Character.toUpperCase(ch1)); // A
        System.out.println(Character.toLowerCase(ch2)); // a
        System.out.println(Character.isUpperCase('0')); // false
        System.out.println(Character.isLowerCase('0')); // false
        char ch4 = Character.toLowerCase('0');
        System.out.println(ch4); // 0
    }
}
