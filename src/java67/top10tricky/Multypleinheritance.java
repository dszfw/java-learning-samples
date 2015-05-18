package java67.top10tricky;

public class Multypleinheritance implements FaceA, FaceB{

    @Override
    public void doSome() {

    }
}

interface Face0 {
    void doSome();
}

interface FaceA {
    void doSome();
}

interface FaceB extends Face0, FaceA{
}