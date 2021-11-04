import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {


	private static Scanner reader;
	private static Integer v = 0;

	public static void main(String[] args) throws IOException {
		int n = 0;

		while(n != 1 || n != 2) {
			try {
				n = getMethodeToUse();
			} catch (Exception e) {
				System.out.println("Error : " + e);
		    }
			switch(n) {
				case 1 :
					sendAutomaticRequests();
					break;
				case 2 :
					while(v != 1 && v != 2) {
						try {
							v = createArticleOrComment();
							System.out.println("=======================");
							switch(v) {
								case 1 :
									// Create an Article
									createArticle();
									break;
								case 2 :
									// Create a Comment
									createComment();
									break;
								default:
									System.out.println("This choice does not exist.");
									break;
							}
						} catch (Exception e) {
							System.out.println("Error : " + e);
					    }
					}
					v = 0;
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
		URL url = new URL ("http://localhost:8000/articles/2/comment");
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
		url = new URL ("http://localhost:8000/articles");
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
	 *
	 * This function will which New Request the user wants to create.
	 *
	 */
	public static int createArticleOrComment() {
		int n;
		reader = new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("Do you want to create an Article or a Comment: "
							+ "\n"
							+ "\n1 - Create an Article"
							+ "\n2 - Create a Comment"
							+ "\n=======================");
		System.out.println("Enter a number :");
		n = reader.nextInt();
		return n;
	}

	/**
	 *
	 * This function will create an Article with the user responses.
	 * 
	 */
	public static void createArticle() throws MalformedURLException {

		URL url = new URL ("http://localhost:8000/articles");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		String date = dtf.format(now);
		String title;
		String slug;
		String content;
		String author;

		reader = new Scanner(System.in);
		System.out.println("Enter a Title :");
		title = reader.nextLine();
		System.out.println("Enter a Slug :");
		slug = reader.nextLine();
		System.out.println("Enter a Content:");
		content = reader.nextLine();
		System.out.println("Enter an Author:");
		author = reader.nextLine();

		Article article = new Article(title, slug, content, author, date);

		try {
			sendRequest(article.generateJson(), url);
		} catch (Exception e) {
			System.out.println("Error : " + e);
	    }
	}

	/**
	 *
	 * This function will create a Comment with the user responses.
	 * 
	 */
	public static void createComment() throws MalformedURLException {

		String title;
		String content;
		int article_id = 2;

		reader = new Scanner(System.in);
		System.out.println("Enter a Title :");
		title = reader.nextLine();
		System.out.println("Enter a Content :");
		content = reader.nextLine();
		System.out.println("Enter an Article_Id :");
		article_id = reader.nextInt();

		Comment comment = new Comment(title, content, article_id);
		
		URL url = new URL ("http://localhost:8000/articles/" + article_id +"/comment");

		try {
			sendRequest(comment.generateJson(), url);
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
