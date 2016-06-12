package exmpls;

public class AnonymousClassBasedOnClassInsteadOfInterface {
    public static void main(String[] args) {
        Object o = new Object() {
            {

            }

            private Integer i;

            public void setI(Integer i) {
                this.i = i;
            }

            @Override
            public String toString() {
                return "$classname{" +
                        "i=" + i +
                        '}';
            }
        };

        System.out.println(o);
        System.out.println(o.getClass());
        // always true
        System.out.println(Object.class.isAssignableFrom(o.getClass()));
        System.out.println(o instanceof Object);
    }
}
