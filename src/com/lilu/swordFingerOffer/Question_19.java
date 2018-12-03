package com.lilu.swordFingerOffer;

public class Question_19 {
    public boolean match(char[] str,char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str,0,pattern,0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex > str.length || patternIndex > pattern.length) {
            return false;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] || strIndex != str.length && pattern[patternIndex] == '.') {
                return matchCore(str,strIndex,pattern,patternIndex + 2) ||
                        matchCore(str,strIndex + 1,pattern,patternIndex) ||
                        matchCore(str,strIndex + 1,pattern,patternIndex + 2);
            }
        } else {
            if (strIndex != str.length && str[strIndex] == pattern[patternIndex] || strIndex != str.length && pattern[patternIndex] == '.') {
                return matchCore(str,strIndex + 1,pattern,patternIndex + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question_19 question_19 = new Question_19();
        System.out.println(question_19.match(new char[]{'a'},new char[]{'.','*'}));
    }
}
