package onsite.first;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MainTest {

    @Test
    public void lscommand() {
        List<String> inputString = Arrays.asList(new String[]{"hoge", "hogehoge", "hogehogehogehog", "fugafuga", "fuga", "fugafuga", "fuga"});
        int len = 35;

        List<String> output = Main.ls(inputString, len);
        output.stream().forEach(str -> System.out.println(str));
    }

    @Test
    public void subnetIpAddresses() {
        String subnet = "192.168.10.8/28";

        List<String> output = Main.subnetIp(subnet);
        output.stream().forEach(str -> System.out.println(str));
    }
}
