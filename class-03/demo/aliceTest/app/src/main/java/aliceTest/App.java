/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aliceTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class App {
  public String getGreeting() {
      return "Hello World!";
  }

  public static void main(String[] args) {
    System.out.println("My current directory is: " + System.getProperty("user.dir"));

    Path alicePath = Paths.get("./alice_in_wonderland.txt");
    System.out.println(alicePath.toAbsolutePath());



    Scanner aliceScanner = null;
    try
    {
      aliceScanner = new Scanner(alicePath);
    } catch (IOException ioe)
    {
      System.out.println("That file cannot be scanned! File path is: " + alicePath.toAbsolutePath());
      ioe.printStackTrace();
      System.exit(1);
    } finally  // always executes even when there isn't an error
    {
      System.out.println("This happened finally");
    }

    HashMap<String, Integer> characterCountMap = new HashMap<>();
    String[] literaryCharacters = {"Alice", "Mock turtle", "Rabbit"};

    while(aliceScanner.hasNextLine())
    {
      String currentLine = aliceScanner.nextLine();
      for (String character : literaryCharacters)
      {
        if (currentLine.toLowerCase(Locale.ROOT).contains(character.toLowerCase(Locale.ROOT)))  // case insensitive way
        {
          if (!characterCountMap.containsKey(character))
            characterCountMap.put(character, 1);
          else
          {
            int currentCount = characterCountMap.get(character);
            characterCountMap.put(character, currentCount + 1);
          }
        }
      }

    }



    System.out.println("Character count map: " + characterCountMap);
  }
}
