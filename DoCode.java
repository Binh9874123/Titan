public class DoCode {
    public static byte[] Change(byte[] c) {


        for(int i = 0 ; i < c.length ; i++) {

            if (c[i] == 'a') {
                c[i] = 'm';
            } else if (c[i] == 'b') {
                c[i] = 'd';
            } else if (c[i] == 'l') {
                c[i] = 'c';
            } else if (c[i] == 'm') {
                c[i] = 'l';
            } else if (c[i] == 'n') {
                c[i] = 'v';
            } else if (c[i] == 'k') {
                c[i] = 't';
            } else {
                c[i] = c[i];
            }
        }


        return c;

    }
}
