package java67.serialization;

import java.io.Serializable;

public class TransientUsage implements Serializable{
    transient static private int staticI;

    transient private int i;
}
