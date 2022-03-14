// To run the code at any time, please hit the run button located in the top left corner.

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class PigLaatinizeSolution {
  public static void main(String[] args) {
    System.out.println(pigLatinize("amazing")); // should print out "ig-pay"
  }

  public static String vowels = "aeiou";

  // Implement this method:
  public static String pigLatinize(String     ) {

    System.out.println("Original string - " + phrase);
    String[] originalWords = phrase.split(" ");

    StringBuffer latinizedString = new StringBuffer();

    for(int i=0; i<originalWords.length; i++) {
      String currentWord = originalWords[i];
      String latinWord = "";

      if (vowels.indexOf(Character.toLowerCase(currentWord.charAt(0))) != -1)
        latinWord = currentWord.concat("-way");
      else {
        int cIndex = getFirstVowelIndex(currentWord);
        System.out.println("Consonant found at index " + cIndex);

        if(cIndex != -1 || cIndex != 0) {
          String consonants = currentWord.substring(0, cIndex);
          System.out.println("Consonant word  " + consonants);

          String remainingWord = currentWord.substring(cIndex);
          System.out.println("Remaining word  " + remainingWord);

          latinWord = remainingWord.concat("-").concat(consonants).concat("ay");
        }
      }

      latinizedString.append(latinWord.concat(" "));
    }

    return latinizedString.substring(0, latinizedString.length());
  }

  private static int getFirstVowelIndex(String word) {
    for(int j = 0 ; j < word.length(); j++) {
      if(vowels.indexOf(Character.toLowerCase(word.charAt(j))) == -1)
        continue ;
      else
        return j;
    }
    return -1 ;
  }
}
