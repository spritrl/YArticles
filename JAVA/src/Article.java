
public class Article {

	private String title;
	private String slug;
	private String content;
	private String author;
	private String date;
	
	public Article(String title,
					String slug,
					String content,
					String author,
					String date) {
		this.title = title;
		this.slug = slug;
		this.content = content;
		this.author = author;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String generateJson() {
		String json = "{\n" +
				"    \"title\":\"" + getTitle() + "\",\n" +
				"    \"slug\": \"" + getSlug() + "\",\n" +
				"    \"content\": \"" + getContent() + "\",\n" +
				"    \"author\": \"" + getAuthor() + "\",\n" +
				"    \"date\": \"" + getDate() + "\"\n" +
				"}";
		return json;
	}
}
