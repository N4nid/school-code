import java.util.Scanner;

public class vigenere {
  // start attributes
  static String alphabet = "abcdefghijklmnopqrstuvwxyz";
  static Scanner scanner;
  static String text = "";
  static boolean encrypt = true; // otherwise decrypt
  // static String[] alphabet =
  // {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

  // end attributes
  // start methods

  public static void main(String[] args) {
    if (args.length > 0) {
      encrypt = false; // decrypt instead
    }
    scanner = new Scanner(System.in);
    boolean encryptAgain = cli();
    while (encryptAgain) {
      System.out.print("\033\143");
      encryptAgain = cli();
    }
    scanner.close();
  } // end of main

  static boolean cli() {
    if (encrypt)
      System.out.println("*** ENCRYPTING ***");
    else
      System.out.println("*** DECRYPTING ***");

    String key;

    scanner = new Scanner(System.in);
    System.out.println("enter key: ");
    key = scanner.nextLine();
    key = key.toLowerCase();

    if (text.isBlank()) {
      System.out.println("---");
      System.out.println("enter text: ");
      text = scanner.nextLine();
      text = text.toLowerCase();
    } else {
      System.out.println("text entered:");
      System.out.println(text);
    }

    int keyIndex = 0;
    int newIndex;
    String resultText = "";
    for (int i = 0; i < text.length(); i++) {
      char currentChar = text.charAt(i);
      if (keyIndex >= (key.length())) {
        keyIndex = 0;
      }

      if (alphabet.indexOf(currentChar) == -1) { // not a letter
        resultText += currentChar;
        continue;
      }

      if (encrypt) {
        // original char index + key index; fe. "b"-> 1 + "s" -> 18 = 19 -> "t"
        newIndex = alphabet.indexOf(currentChar) + alphabet.indexOf(key.charAt(keyIndex));
        if (newIndex >= alphabet.length()) {
          newIndex -= 26;
        }
      } else {
        newIndex = alphabet.indexOf(currentChar) - alphabet.indexOf(key.charAt(keyIndex));
        if (newIndex < 0) {
          newIndex += 26;
        }
      }

      resultText += alphabet.charAt(newIndex);

      keyIndex++;
    }

    System.out.println(resultText);
    System.out.println("");
    System.out.println("What do you want to do?");
    System.out.println("- (c)ontinue with current text");
    System.out.println("- (e)nter new text");
    System.out.println("- (u)se encrypted text as input text");
    System.out.println("- (s)witch between (de/en)cryption mode");
    System.out.println("- (q)uit");
    System.out.print("> ");

    String answer = scanner.next();

    if (answer.equals("c")) {
      return true;
    } else if (answer.equals("e")) {
      text = "";
      return true;
    } else if (answer.equals("u")) {
      text = resultText;
      return true;
    } else if (answer.equals("s")) {
      text = "";
      encrypt = !encrypt;
      return true;
    }

    return false;
  }

  // end methods
} // end of class sort
