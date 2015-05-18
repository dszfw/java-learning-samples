package java67.top10tricky;

public class TryReturnStatement {
    public static void main(String[] args) {
        try {
//            return;
            System.exit(22);
        } finally {
            System.out.println("FINALLY!");
        }
    }
}
