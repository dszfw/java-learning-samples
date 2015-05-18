package java67.top21frequently;

import java.util.concurrent.ConcurrentHashMap;

public class AboutClassloaders {
    public static void main(String[] args) {
        // null - it is Bootstrap ClassLoader (loads classes from rt.jar)
        System.out.println(String.class.getClassLoader());
        System.out.println(ConcurrentHashMap.class.getClassLoader());
        System.out.println(AboutClassloaders.class.getClassLoader().getClass().getClassLoader());
        // AppClassLoader
        System.out.println(AboutClassloaders.class.getClassLoader());
    }
}
