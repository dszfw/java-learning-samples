package jdk8;

public class LambdaSample {
    public LambdaSample() {
    }

    public LambdaSample(SomeInterface si) {
        si.doSomeOne();
        si.doSomeTwo();
    }

    public LambdaSample(SomeLamdaIterface sli) {
        sli.doSome(22);
    }

//    public LambdaSample(SomeLamdaIterface2 sli2) {
//        sli2.doSome(22);
//    }

    public static void main(String[] args) {
        LambdaSample lambdaSample = new LambdaSample(new SomeInterface() {
            @Override
            public void doSomeOne() {}
            @Override
            public void doSomeTwo() {}
        });


        LambdaSample lambdaSample1 = new LambdaSample(x -> {

        });

        LambdaSample lambdaSample2 = new LambdaSample(System.out::print);
    }
}

interface SomeInterface {
    void doSomeOne();
    void doSomeTwo();
}

interface SomeLamdaIterface {
    void doSome(int x);
}

interface SomeLamdaIterface2 {
    void doSome(int x);
}