package onsite.first;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        solve(System.in, System.out);
    }

    static void solve(InputStream is, PrintStream os) {
        // Your code here!
        Scanner scan = new Scanner(is);
        BigInteger test = new BigInteger("2");
        BigInteger mod =  test.modInverse(new BigInteger("3"));
        os.println(mod.intValue());

    }
}