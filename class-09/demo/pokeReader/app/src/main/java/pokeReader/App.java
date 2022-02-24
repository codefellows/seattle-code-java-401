/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pokeReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pokeReader.model.Pokemon;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App {
  static final String HTTP_GET = "GET";

  public String getGreeting() {
      return "Hello World!";
  }

  public static void main(String[] args) throws IOException
  {
    System.out.println(new App().getGreeting());
    URL pokeUrl = new URL("https://pokeapi.co/api/v2/pokemon/squirtle");
    URLConnection pokeUrlConnection = pokeUrl.openConnection();
    HttpURLConnection pokeHttpUrlConnection = (HttpURLConnection)pokeUrlConnection;
    pokeHttpUrlConnection.setRequestMethod(HTTP_GET);
    InputStreamReader pokeInputStreamReader = new InputStreamReader(pokeHttpUrlConnection.getInputStream());
    BufferedReader pokeBufferedReader = new BufferedReader(pokeInputStreamReader);

    String pokeLine = pokeBufferedReader.readLine();
    //System.out.println(pokeLine);

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Pokemon squirtle = gson.fromJson(pokeLine, Pokemon.class);

    //System.out.println(squirtle);
    String squirtleJson = gson.toJson(squirtle);

    File squirtleJsonFile = new File("./squirtle.json");
    try (FileWriter squirtleJsonFileWriter = new FileWriter(squirtleJsonFile);)
    {
      squirtleJsonFileWriter.write(squirtleJson);
    }
  }
}
