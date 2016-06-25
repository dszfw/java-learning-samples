package naftalinwadler.generics.chapter3;

import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

public class MultipleBounds {

    public static <S extends Readable & Closeable,
            T extends Appendable & Closeable>void copy(S source, T target, int bufferSize) throws IOException {
        try {
            try {
                CharBuffer buffer = CharBuffer.allocate(bufferSize);
                int i = source.read(buffer);
                while (i >= 0) {
                    buffer.flip();
                    target.append(buffer);
                    buffer.clear();
                    i = source.read(buffer);
                }
            }
            finally {
                source.close();
            }
        } finally {
            target.close();
        }
    }

}
