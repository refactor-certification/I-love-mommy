package refactoring.certification;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不定长的字符串，如果其元音(aeiou)的数量占比超过30%，那么将每个连续的元音集合替换成"mommy". 例如：
 * * hard → hard
 * * his → hmommys
 * * hear → hmommyr
 *
 * 现在我们的任务有两个：
 *
 * 1. 重构代码，确保可读性和可维护性达到要求(Cognitive Complexity <= 16, issues == 0)。
 * 2. 增加对大写元音（AEIOU）的支持(测试通过).
 */
public class ILoveMommy {
    public String transform(String input) {
        if (input == null || input.length() == 0) {
            return input;
        } else {
            Boolean consecutive = false;
            StringBuffer inputAsBuffer = new StringBuffer(input);
            List<String> allVowels = new ArrayList();
            for (int i1 = 0; i1 < input.length(); i1++) {
                char character1 = input.charAt(i1);
                boolean result1 = false;
                if ("aeiou".contains(String.valueOf(character1))) {
                    result1 = true;
                }
                if (result1) {
                    allVowels.add(String.valueOf(character1));
                }
            }
            if ((allVowels.size() >= 0.3 * input.length())) {
                for (int i = 0; i < inputAsBuffer.length(); i++) {
                    char character = inputAsBuffer.charAt(i);
                    boolean result = false;
                    if ("aeiou".contains(String.valueOf(character))) {
                        result = true;
                    }
                    if (result) {
                        inputAsBuffer.deleteCharAt(i);
                        if (!consecutive) {
                            inputAsBuffer.insert(i, "mommy");
                            i = i + "mommy".length() - 1;
                            consecutive = true;
                            continue;
                        } else {
                            i = i - 1;
                        }
                    } else {
                        consecutive = false;
                    }
                }
            }
            return inputAsBuffer.toString();
        }
    }
}
