package fdb;

/**
 *
 * @author INSE Team 5C
 */
public class News {

    int NewsID;
    int ClubID;
    String Title;
    String Content;
    String Author;

    /**
     * constructor for an article of news
     * @param news_ID
     * @param news_ClubId
     * @param news_Title
     * @param news_Content
     * @param news_Author
     */
    public News(int news_ID, int news_ClubId, String news_Title, String news_Content, String news_Author) {
        NewsID = news_ID;
        ClubID = news_ClubId;
        Title = news_Title;
        Content = news_Content;
        Author = news_Author;
    }
    /**
     * get the ID of the news article
     * @return NewsID
     */
    public int getNewsID() {
        return NewsID;
    }
    
    /**
     * get the ID of the club associated with the news article
     * @return ClubID
     */
    public int getClubID() {
        return ClubID;
    }
    
    /**
     * get the title of the news article
     * @return title
     */
    public String getTitle() {
        return Title;
    }
    
    /**
     * get the content of the news article
     * @return content
     */
    public String getContent() {
        return Content;
    }
     
    /**
     * get the author of the news article
     * @return author
     */
    public String getAuthor() {
        return Author;
    }

}
