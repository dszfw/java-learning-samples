package java67.top10tricky;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharsBytesString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes));
    }
}
