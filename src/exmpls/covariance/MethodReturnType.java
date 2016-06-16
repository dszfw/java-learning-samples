package exmpls.covariance;

public class MethodReturnType {

    public static void main(String[] args) {
        // one .getObj() method in B
        new B().getObj();
    }
}

class A {
    public Object getObj() {
        return null;
    }
}

class B extends A {
    @Override
    // method return types are covariant
    public String getObj() {
        return "s";
    }
}