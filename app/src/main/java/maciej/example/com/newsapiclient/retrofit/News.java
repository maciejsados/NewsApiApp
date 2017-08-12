package maciej.example.com.newsapiclient.retrofit;


public class News {

    private final String title;
    private final String content;
    private final String imageUrl;
    private final int index;

    public News(String title, String content, String imageUrl, int index) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getIndex() {
        return index;
    }
}

