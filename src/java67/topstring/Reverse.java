package java67.topstring;

public class Reverse {
    private int id;
    public static final String TEXT = "Some text!";
    public static void main(String[] args) {
        System.out.println(new StringBuffer(TEXT).reverse());
        System.out.println(new StringBuilder(TEXT).reverse());
        System.out.println(reverse(TEXT));
    }

    private static String reverse(String source) {
        String reverse = "";
        for (int i = source.length() -1; i >= 0; i--) {
            reverse += source.charAt(i);
        }
        return reverse;
    }
}
