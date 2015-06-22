package exmpls;

public class FinalMethodOverride {
}

class FMO {
    public void doOne() {}
    public final void doTwo() {}
}

class CustomFMO extends FMO {
    @Override
    public void doOne() {
        super.doOne();
    }

    // cannot be override final method
    /*@Override
    public void doTwo() {
        super.doTwo();
    }*/
}