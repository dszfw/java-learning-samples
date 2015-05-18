package java67.top10tough;

public class StringPool_2 {
    public static void main(String[] args) {
        String hello = "Hello";
        String lo = "lo";
        System.out.println(hello == ("Hel" + lo));

        String s1 = new String("abcde").intern();
        String s2 = "abcde";
        System.out.println(s1 == s2);

        Integer i1 = -129;
        Integer i2 = -129;
        System.out.println(i1 == i2 );
    }
}
