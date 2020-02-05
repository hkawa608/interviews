package onsite.first;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
    }

    static List<String> ls(List<String> inputStr, int len) {
        // Your code here!
        int maxColumn = inputStr.size();
        for(int i = maxColumn; 0 < i ; i--) {
            List<String> ans = lsWithColumn(inputStr, len, i);
            if(!ans.isEmpty())
                return ans;
        }
        return new ArrayList();
    }

    static List<String> lsWithColumn(List<String> inputStr, int len, int column) {
        List<String> ans = new ArrayList();

        int maxLen[] = new int[column];
        int totalLen = 0;
        for (int i = 0; i < inputStr.size(); i++) {
            int pos = i % column;
            String str = inputStr.get(i);
            totalLen -= maxLen[pos];
            maxLen[pos] = Math.max(maxLen[pos], str.length() + 1);
            totalLen += maxLen[pos];
        }

        if (totalLen > len)
            return ans;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputStr.size(); i++) {
            int pos = i % column;
            if (pos == 0)
                sb = new StringBuilder();
            sb.append(inputStr.get(i));
            for (int j = 0; j < maxLen[pos] - inputStr.get(i).length(); j++) {
                sb.append(" ");
            }
            if (pos == column - 1 || i == inputStr.size() - 1)
                ans.add(sb.toString());
        }
        return ans;
    }

    static List<String> subnetIp(String subnet) {
        List<String> ans = new ArrayList<>();
        int slushPos = subnet.indexOf('/');
        String ip = subnet.substring(0, slushPos);
        String mask = subnet.substring(slushPos+1, subnet.length());
        int maskBit = Integer.valueOf(mask);
        long maskAddr = 0;
        for(int i = 0; i < maskBit; i++){
            maskAddr += (1L << (32-maskBit + i));
        }
        long ipAddr = 0;
        String[] ips = ip.split("\\.");
        ipAddr += Long.valueOf(ips[0]) << 24;
        ipAddr += Long.valueOf(ips[1]) << 16;
        ipAddr += Long.valueOf(ips[2]) << 8;
        ipAddr += Long.valueOf(ips[3]);

        long startAddr = ipAddr&maskAddr;
        long endAddr = ipAddr|(~maskAddr)&Integer.MAX_VALUE;
        for(long i = startAddr; i <= endAddr; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append((i & (255L << 24)) >> 24);
            sb.append(".");
            sb.append((i & (255 << 16)) >> 16);
            sb.append(".");
            sb.append((i & (255 << 8)) >> 8);
            sb.append(".");
            sb.append(i & 255);
            ans.add(sb.toString());
        }

        return ans;
    }
}