package mk.topnews;

public class NewsData {

    private String Title;
    private String Author;
    private String ImageId;

    public NewsData(String title, String author, String imageId) {
        Title = title;
        Author = author;
        ImageId = imageId;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getImageId() {
        return ImageId;
    }
}
