
public class Comment {
	private String title;
	private String content;
	private Integer article_id;

	public Comment(String title, String content, Integer article_id) {
		this.title = title;
		this.content = content;
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	
	public String generateJson() {
		String json = 
				"{\n" +
				"    \"title\": \"" + getTitle() + "\",\n" +
				"    \"content\": \"" + getContent() + "\",\n" +
				"    \"article_id\":" + getArticle_id() + "\n" +
				"}";
		return json;
	}

}
