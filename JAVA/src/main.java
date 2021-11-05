import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class main {


	private static Scanner reader;

	public static void main(String[] args) throws IOException {
		int n = 0;

		while(n != 1 || n != 2) {
			n = getMethodeToUse();
			switch(n){
				case 1 :
					sendAutomaticRequests();
					break;
				case 2 :
					System.out.println("case 2");
					break;
				default:
					System.out.println("This choice does not exist.");
					break;
			}
		}
	}

	/**
	 *
	 * This function will print and get the request methode.
	 *
	 */
	public static int getMethodeToUse() {
		int n;
		reader = new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("Menu : "
							+ "\n"
							+ "\n1 - To run automatic requests"
							+ "\n2 - To run manual requests"
							+ "\n=======================");
		System.out.println("Enter a number :");
		n = reader.nextInt();
		return n;
	}

	/**
	 *
	 * This function will send the requests already defined by the code.
	 *
	 */
	public static void sendAutomaticRequests() throws IOException {

		// Create a Comment on /articles/2
		URL url = new URL ("http://localhost:8000/articles/2/comments");
		String jsonComment = "{\n" +
				"    \"title\": \"POST by Java\",\n" +
				"    \"content\": \"Content\",\n" +
				"    \"article_id\": 2\n" +
				"}";
		try {
			sendRequest(jsonComment, url);
		} catch (Exception e) {
			System.out.println("Error : " + e);
	    }

		// Create an Article
		url = new URL ("http://localhost:8000/article");
		String jsonArticles = "{\n" +
				"    \"title\": \"Article by Java\",\n" +
				"    \"slug\": \"Slug by Java\",\n" +
				"    \"content\": \"Content by Java\",\n" +
				"    \"author\": \"Author is Java\",\n" +
				"    \"date\": \"2021-01-01 19:22:00\"\n" +
				"}";
		try {
			sendRequest(jsonArticles, url);
		} catch (Exception e) {
			System.out.println("Error : " + e);
	    }
	}

	/**
	 * Create a POST request
	 *
	 * @param jsonToSend is the Json with all parameters filled in
	 * @param url is the url expected by the API for the request
	 */
	public static void sendRequest(String jsonToSend, URL url) throws IOException {
	    System.out.println("=======================");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = jsonToSend.getBytes("utf-8");
		    os.write(input, 0, input.length);
		    System.out.println("API - Json sent to : " + url);
		}
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
		    StringBuilder response = new StringBuilder();
		    String responseLine = null;
		    while ((responseLine = br.readLine()) != null) {
		        response.append(responseLine.trim());
		    }
		    System.out.println("API - Returned value : " + response.toString());
		}
		System.out.println("=======================");
	}
}
