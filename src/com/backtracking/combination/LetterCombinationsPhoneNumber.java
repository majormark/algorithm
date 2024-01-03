package com.backtracking.combination;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//17. Letter Combinations of a Phone Number
public class LetterCombinationsPhoneNumber {
    public HashMap<Character, Character[]> numLetterMap = new HashMap<Character, Character[]>() {{
        put('2', new Character[]{'a', 'b', 'c'});
        put('3', new Character[]{'d', 'e', 'f'});
        put('4', new Character[]{'g', 'h', 'i'});
        put('5', new Character[]{'j', 'k', 'l'});
        put('6', new Character[]{'m', 'n', 'o'});
        put('7', new Character[]{'p', 'q', 'r', 's'});
        put('8', new Character[]{'t', 'u', 'v'});
        put('9', new Character[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        backtrack(digits.toCharArray(), 0, res, new StringBuilder());
        return res;
    }

    public void backtrack(char[] digitChars, int start, List<String> res, StringBuilder path) {
        if (start >= digitChars.length) {
            res.add(path.toString());
            return;
        }
        Character[] letters = numLetterMap.get(digitChars[start]);
        for (int i = 0; i < letters.length; i++) {
            path.append(letters[i]);
            backtrack(digitChars, start + 1, res, path);
            path.deleteCharAt(start);
        }
    }
}
