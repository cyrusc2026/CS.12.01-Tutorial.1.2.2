public class HiddenWord {
    //I have neither given nor received unauthorized aid on this piece of work.
    private final String hiddenWord;
    public HiddenWord(String hiddenWord){
        this.hiddenWord = hiddenWord.toUpperCase();
    }
    public String getHint(String input) throws IllegalArgumentException {
        if (!input.toUpperCase().equals(input)){
            throw new IllegalArgumentException("Your guess ( " + input + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }
        if (input.length()!=hiddenWord.length()) {
            throw new IllegalArgumentException ("Your guess ( " + input + " ) has " + input.length() + " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!");
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            boolean isSame = false;
            boolean haveRepeat = false;
            boolean haveAdded = false;
            for (int j = 0; j < hiddenWord.length(); j++){
                if (hiddenWord.substring(j,j+1).equals(input.substring(i,i+1))) {
                    if (i==j) isSame = true;
                    else haveRepeat = true;
                }
            }
            if (isSame) {
                answer.append(hiddenWord.charAt(i));
                haveAdded=true;
            }
            if (haveRepeat && !isSame) {
                answer.append("+");
                haveAdded=true;

            }
            else if (!haveAdded
            ) answer.append("*");
        }
        return answer.toString();
    }
    public String getHiddenWord(){
        return hiddenWord;
    }
}
