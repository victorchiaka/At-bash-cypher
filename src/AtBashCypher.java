import java.util.Scanner;

public class AtBashCypher {
  private Scanner scanner = new Scanner(System.in);
  static AtBashCypher atBashCypher;
  static char[] upperHalf = {
      'a',
      'b',
      'c',
      'd',
      'e',
      'f',
      'g',
      'h',
      'i',
      'j',
      'k',
      'l',
      'm',
  };

  private static char[] upperHalfMirror = {
      'z',
      'y',
      'x',
      'w',
      'v',
      'u',
      't',
      's',
      'r',
      'q',
      'p',
      'o',
      'n',
  };

  private String getWordFromConsole() {
    System.out.print("Enter your desired word_ ");
    return scanner.next().toLowerCase();
  }

  public void eval() {
    String word;
    word = getWordFromConsole();
    getMirrorOfLetter(word);
  }

  protected static boolean isLetterInUpperHalf(char letter) {
    for (int i = 0; i < upperHalf.length; i++) {
      if (upperHalf[i] == letter) {
        return true;
      }
    }
    return false;
  }

  protected static boolean isLetterInUpperHalfMirror(char letter) {
    for (int i = 0; i < upperHalfMirror.length; i++) {
      if (upperHalfMirror[i] == letter) {
        return true;
      }
    }
    return false;
  }

  private static int index = -1;

  protected static int getIndexOfLetter(char[] characterArray, char letter) {
    for (int i = 0; i < characterArray.length; i++) {
      if (characterArray[i] == letter) {
        index = i;
      }
    }
    return index;
  }

  char letterMirror;

  private void getMirrorOfLetter(String word) {
    for (char letter : word.toCharArray()) {
      if ((!isLetterInUpperHalf(letter) && !isLetterInUpperHalfMirror(letter))) {
        letterMirror = '#';
        System.out.print(letterMirror);
      } else if (isLetterInUpperHalf((letter))) {
        letterMirror = upperHalfMirror[getIndexOfLetter(upperHalf, letter)];
        System.out.print(letterMirror);
      } else {
        letterMirror = upperHalf[getIndexOfLetter(upperHalfMirror, letter)];
        System.out.print(letterMirror);
      }
    }
  }

  public static synchronized AtBashCypher getInstance() {
    if (atBashCypher == null) {
      return new AtBashCypher();
    }
    return atBashCypher;
  }
}