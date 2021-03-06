package com.sho.hire.hw;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 12/16/14
 * Time: 10:10 PM
 * # The main purpose of this class is for the use of the function 'ecalpeResrever',
 * # which replaces text from left to right and then reverses the resulting text
 */
public class ReplaceRogersJosh {

    /**
     * Restricts the use of the buffer to keep track of each character inserted.
     * Designed to reverse the order of words in a string given one character at a time
     */
    public static final class ReverseStringBuffer {
        private int insertPos = 0;
        private final StringBuffer buf;
        public ReverseStringBuffer(int capacity){
            buf = new StringBuffer(capacity);
        }
        private final void insert(char c){
            buf.insert(insertPos,c);
            insertPos++;
        }

        /**
         * inserts a space at the beginning of the buffer and then
         * resets the position to 0. Any new text will then be added before
         * the old text within buf
         */
        private final void insertSpace(){
            buf.insert(0,' ');
            insertPos = 0;
        }

        /**
         * inserts the string into the buffer by looping through each character of the string and calling
         * addInReverse(char)
         * @param s - the string to inserted into buf
         */
        public final void addInReverse(String s){
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                addInReverse(c);
            }
        }
        /**
         * inserts the buffer into the class level buffer by looping through each character of the buffer and calling
         * addInReverse(char)
         * @param buff - the buffer to be merged into class level buff
         */
        public final void addInReverse(StringBuffer buff){
            for(int i = 0; i < buff.length(); i++){
                char c = buff.charAt(i);
                addInReverse(c);
            }
        }

        /**
         * Check if c is a space character. If so, call insertSpace(). If not, insert as normal
         * @param c - character to be added to buf
         */
        public final void addInReverse(char c){
            if(c == ' '){
                insertSpace();
            }else{
                insert(c);
            }
        }
        public String toString(){
            return buf.toString();
        }
    }

    /**
     * Replaces all text in 'haystack' that matches 'needle' with 'replacement' then reverses haystack.
     * Assuming needle << haystack, and the haystack does not consist of mostly needles,
     * this program should run in close to n time, where n is the character length of haystack
     * @param haystack - large text to be reversed
     * @param needle - small text to be found in haystack and replaced with replacement
     * @param replacement - replacement text
     * @return the text after all replacements have been made and haystack has been reversed
     */
    public String ecalpeResrever(String haystack, String needle, String replacement){
        //keeps track of matched needle text in haystack
        int needlepos = 0;
        //are we currently matching a needle in haystack?
        boolean isMarked = false;
        //keeps track of the matched needle within the haystack to eventually lead to replacement
        StringBuffer needlebuf = new StringBuffer(needle.length());
        //the result is stored here
        ReverseStringBuffer buf = new ReverseStringBuffer(haystack.length());
        int i = 0;
        /**
         * For each character, check the following:
         * 1. Is the character matched with the current position of needle? If so, add to needlebuf and
         *    move to next character
         * 2. Do we have a match for needle in haystack? If so, add replacement to the reverse buffer
         * 3. Were we in the process of matching but the most recent character did not match? If so,
         *    add contents of needlebuf to buf and reset matching.
         * 4. No matches? Just add the character to reverse buffer and go to next character
         */
        while(i < haystack.length()){
            char c = haystack.charAt(i);
            if(isMarked && needlebuf.length() == needle.length()){
                isMarked = false;
                buf.addInReverse(replacement);
                //do no increment i here, otherwise we will skip this character
            }else if(isMarked && c == needle.charAt(needlepos)){
                needlebuf.append(c);
                needlepos++;
                i++;
            }else if(isMarked){
                isMarked = false;
                buf.addInReverse(needlebuf);
                //do not increment i here, because we need to check again if the character is the
                // beginning of the needle
            }else if (!isMarked && c == needle.charAt(0)){
                needlebuf.setLength(0);
                needlepos = 0;
                isMarked = true;
                //do not increment i here, because if needle is one character long, then we must apply the first if
                // statement without skipping over any other characters
            }else{
                buf.addInReverse(c);
                i++;
            }
        }
        //flush out the rest of needlebuf
        if(isMarked && needlebuf.length() == needle.length()){
            buf.addInReverse(replacement);
        }
        return buf.toString();
    }
}
