package java67.top10tough;

public class IntegerPool {
    public static void main(String[] args) {
        Integer i1 = 11;
        Integer i2 = 11;
        System.out.println(i1 == i2);
        System.out.println("and without pool (more then 127 or less than 128)");
        i1 = 128;
        i2 = 128;
        System.out.println(i1 == i2);
        i1 = -129;
        i2 = -129;
        System.out.println(i1 == i2);
        System.out.println("and without pool by new");
        i1 = new Integer("11");
        i2 = new Integer("11");
        System.out.println(i1 == i2);
    }
}
