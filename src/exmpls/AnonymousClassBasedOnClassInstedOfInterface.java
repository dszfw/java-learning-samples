package exmpls;

public class AnonymousClassBasedOnClassInstedOfInterface {
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
    }
}
