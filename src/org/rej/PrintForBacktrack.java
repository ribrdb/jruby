package org.rej;

public class PrintForBacktrack {
    public static void main(String[] args) throws Exception {
        byte[] reg = ".*_p".getBytes();
        byte[] str = "_petstore_session_id=1b341ffe23b5298676d535fcabd3d0d7; path=/".getBytes();
        Pattern p = Pattern.compile(reg);
        int times = 1;

        for(int i = 0; i < times; i++) {
            p.search(str,0,str.length,0,str.length,new Registers());
        }
    }
}
