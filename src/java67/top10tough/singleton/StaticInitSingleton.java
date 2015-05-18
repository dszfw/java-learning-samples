package java67.top10tough.singleton;

public class StaticInitSingleton {
    public static void main(String[] args) {
//        Singleton singleton = Singleton.getSingleton();
//        Singleton.doSome();
//        System.out.println(Arrays.toString(Singleton.class.getMethods()));
        EnumSingleton.OLOLO.doSome();
        EnumSingleton.TVOYA_MAMKA.doSome();
    }
}

// Thread safe enum singleton based on static initialization
class Singleton {
    //initailzed during class loading
    private static final Singleton INSTANCE = init();

    //to prevent creating another instance of Singleton
    private Singleton() {
    }

    private static Singleton init() {
        System.out.println("init singleton");
        return new Singleton();
    }

    public static Singleton getSingleton() {
        return INSTANCE;
    }

    public static void doSome() {
    }
}

// Thread safe enum singleton based on enum
enum EnumSingleton {
    OLOLO("dsad", 25),
    TVOYA_MAMKA("MAMKA", 55);

    private String id;
    private int count;

    EnumSingleton(String s, int i) {
        id = s;
        count = i;
    }

    public void doSome() {
        System.out.println("doSome " + toString());
    }

    @Override
    public String toString() {
        return "Some__" + name() + "{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}