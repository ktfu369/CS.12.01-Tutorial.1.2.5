public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {
        if(wordArr.length%2 != 0){
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for(String word:wordArr){
            if(word.contains(" ")){
                throw new IllegalArgumentException("Word Array must contain single words only! "+word+" contains more than one word!");
            }
        }
        scrambledWords = mixedWords(wordArr);

    }

    private String recombine(String word1, String word2) {
        String ans = "";
        ans += word1.substring(0,word1.length()/2);
        ans += word2.substring(word2.length()/2,word2.length());
        return ans;

    }

    private String[] mixedWords(String[] words) {
        String[] ans = new String[words.length];
        for(int i=0;i<words.length;i+=2){
            String w1 = words[i];
            String w2 = words[i+1];
            ans[i] = recombine(w1,w2);
            ans[i+1] = recombine(w2,w1);
        }
        return ans;
    }

    public String[] getScrambledWords(){
        return scrambledWords;
    }
}
