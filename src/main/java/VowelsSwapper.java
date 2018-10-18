import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VowelsSwapper {

    private static Set<Character> VOWELS = new HashSet<Character>() {{
        add('a');
        add('e');
        add('o');
        add('i');
        add('u');
    }};


    public static void main(String[] args) {
        System.out.println(swap(Arrays.asList('a', 'b', 'a', 'e', 'c', 'i', 'u')));
    }


    public static List<Character> swap(List<Character> letters) {
        int i = 0;
        int j = letters.size() - 1;

        while (i < j) {
            if (!isVowel(letters.get(i))) {
                i++;
            }

            while (j > i) {
                if (isVowel(letters.get(j)) && isVowel(letters.get(i))) {
                    swap(letters, i, j);
                    i++;

                }
                j--;
                break;
            }
        }
        return letters;
    }


    private static boolean isVowel(Character character) {
        return VOWELS.contains(character);
    }

    private static void swap(List<Character> letters, int i, int j) {
        Character ch = letters.get(i);
        letters.set(i, letters.get(j));
        letters.set(j, ch);
    }

}
