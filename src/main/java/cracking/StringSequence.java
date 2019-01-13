package cracking;

public class StringSequence {

    public static void main(String[] args) {

        System.out.println(stringSequence("aabcc"));
    }

    private static String stringSequence(String input) {

        if(input == null || input.length()==0) return input;

        char[] chars = input.toCharArray();
        char lastSeenCharacter = chars[0];
        int lastSeenCharacterCounter = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<input.length();i++){

            if(lastSeenCharacter == input.charAt(i)){
                lastSeenCharacterCounter++;
            }
            else{
                sb.append(lastSeenCharacter+""+ lastSeenCharacterCounter);
                lastSeenCharacter = input.charAt(i);
                lastSeenCharacterCounter = 1;
            }
        }
        sb.append(lastSeenCharacter+""+ lastSeenCharacterCounter);
        return sb.toString();

    }

}
