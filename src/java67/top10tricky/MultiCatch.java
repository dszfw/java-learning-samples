package java67.top10tricky;

import java.io.IOException;

// TODO wrong
public class MultiCatch {
    public void doSome() throws IOException {
        try {
            if (1 == 1) {
                throw new IOException();
            } else {
//                throw new Exception();
            }
        } catch (IOException e) {

        }
    }
}
