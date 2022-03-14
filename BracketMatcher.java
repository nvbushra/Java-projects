// To run the code at any time, please hit the run button located in the top left corner.

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class BracketMatcher {
  public static void main(String[] args) {
    System.out.println(jsValidator("testihg{sfs{sa\nfd(fsdf)asf}sfds}"));
  }

  public static Stack<String> bracketStack = new Stack<String> ();

  public static boolean jsValidator(String code) {
    
    boolean result = true ;
    String openBrackets = "{[(" ;
    String closeBrackets = "}])" ;
    

    for(int i =0 ; i< code.length(); i++) {
      char strChar = code.charAt(i);

      if(openBrackets.indexOf(strChar) != -1) {
        if(isOpener(strChar)) {
          System.out.println("Found an open bracket " + strChar + " at index " + i );
          bracketStack.add(String.valueOf(strChar));
        }
      } else if(closeBrackets.indexOf(strChar) != -1) {
        //check if the bracketStack contains that on the top
        // first get the matching open bracket
        System.out.println("Found a closing bracket " + strChar + " at index " + i );
        char matchingOpenBracket = getMatchingCloseBracket(strChar);
        System.out.println("Matching openBracket " + matchingOpenBracket );
        if(validateCloseBracketOnTop(matchingOpenBracket)) {
          System.out.println("All good at index - " + i) ;
        }
        else {
          System.out.println("Mismatch at index - " + i) ;
          return false ;
        }
      }
    }   
    System.out.println("seems all good - " + code) ;
    return result ;    
  }

  

  private static char getMatchingCloseBracket(char closer) {
    System.out.println("Entering  getMatchingCloseBracket- " + closer) ;
    assert isCloser(closer);
    System.out.println("Entering  getMatchingCloseBracket- " + closer) ;
    switch(closer) {
      case '}' :
        return '{' ;
      case ')' :
        return '(' ;
      case ']' :
        return '[' ;
    }
    return 0 ;
  }

  static boolean isOpener(char character) { 
    return character == '(' || character == '[' || character == '{';
  }

  static boolean isCloser(char character) { 
    return character == ')' || character == ']' || character == '}';
  }

  static boolean validateCloseBracketOnTop(char openBracket) {
    if(!bracketStack.empty() && bracketStack.peek().equals(String.valueOf(openBracket)))
      {
        bracketStack.pop();
        return true ;
      }
    return false ;
  }
  
}
 
