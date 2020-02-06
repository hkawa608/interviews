package onsite.second;

import org.junit.Test;

public class MainTest {

    @Test
    public void lastPos() {
      String[][] input = {{"/", "\\", "\\","/", "\\", "\\","/","/","/","/"},{"/", "\\","/", "\\", "\\", "\\"},{"/", "\\","/", "\\", "\\", "\\","/", "\\", "\\", "\\"}};
      int startPos = 4;
      int ans = Main.lastPos(input, startPos);
      System.out.println(ans);
    }

    @Test
    public void minimizeMaximum() {
      String[][] input = {{"/", "\\", "\\","/", "\\", "\\","/","/","/","/"},{"/", "\\","/", "\\", "\\", "\\"},{"/", "\\","/", "\\", "\\", "\\","/", "\\", "\\", "\\"}};
      int[] balls = {3,5,7,8,4,2,13,5,7,8,3,9,7,4,10,2};
      int maxPos = 11;
      int max = Main.minimizeMaximum(input, maxPos, balls);
      System.out.println(max);
    }

}
