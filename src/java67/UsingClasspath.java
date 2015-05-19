package java67;

import exmpls.initialization.InitializationBlock;

// D:\>java -cp "d:\other\java-learning-samples\out\production\java-learning-samples;d:\111" java67.UsingClasspath
// exmpls.Initialization@2a139a55
public class UsingClasspath {
    public static void main(String[] args) {
        System.out.println(new InitializationBlock());
        System.out.println(System.getProperty("java.class.path"));
    }
}
