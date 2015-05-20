package java67.top10tough;

public class StringImmutablePool {
    public static void main(String[] args) {
        System.out.println("asd1".equals("asd1"));
        System.out.println("asd1" == "asd1");

        String asd1 = new String("asd");
        String asd2 = new String("asd");
        System.out.println(asd1.equals(asd2));
        System.out.println(asd1 == asd2);

        asd1 = "asd";
        asd2 = "asd";
        System.out.println(asd1 == asd2);

        System.out.println("abc" == new String("abc").intern());
    }
}
