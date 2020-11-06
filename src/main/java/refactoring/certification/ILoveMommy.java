package refactoring.certification;

import java.util.ArrayList;
import java.util.List;

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
                if ("aieou".contains(String.valueOf(character1))) {
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
                    if ("aieou".contains(String.valueOf(character))) {
                        result = true;
                    }
                    if (result) {
                        inputAsBuffer.deleteCharAt(i);
                        if (!consecutive) {
                            inputAsBuffer.insert(i, "mommy");
                            i = i + "mommy".length() - 1;
                            consecutive = true;
                            continue;
                        }
                        consecutive = false;
                    } else {
                        consecutive = false;
                    }
                }
            }
            return inputAsBuffer.toString();
        }
    }

}
