package naftalinwadler.generics.chapter3;

public class EnumerableExamples {

    public static void main(String[] args) {
        System.out.println(Season.WINTER.getClass());
    }

    private enum Season { WINTER, SPRING, SUMMER, FALL }
}