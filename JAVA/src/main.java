import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

	public static void main(String[] args) throws IOException {

		// Create a Comment on /articles/2
		URL url = new URL ("http://localhost:8000/articles/2/comments");
		String jsonComment = "{\n" +
				"    \"title\": \"POST by Java\",\n" +
				"    \"content\": \"Content\",\n" +
				"    \"article_id\": 2\n" +
				"}";
		sendRequest(jsonComment, url);

		// Create an Article
		url = new URL ("http://localhost:8000/article");
		String jsonArticles = "{\n" +
				"    \"title\": \"Article by Java\",\n" +
				"    \"slug\": \"Slug by Java\",\n" +
				"    \"content\": \"Content by Java\",\n" +
				"    \"author\": \"Author is Java\",\n" +
				"    \"date\": \"2021-01-01 19:22:00\"\n" +
				"}";
		sendRequest(jsonArticles, url);
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
