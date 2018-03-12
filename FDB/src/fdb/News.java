/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

/**
 *
 * @author accou
 */
public class News {
    int NewsId;
    int ClubId;
    String Title;
    String Content;
    String Author;
    
    public News(int nNewsId, int nClubId, String nTitle, String nContent, String nAuthor) 
    {
        NewsId = nNewsId;
        ClubId = nClubId;
        Title = nTitle;
        Content = nContent;
        Author = nAuthor;
    }
    
    public int getNewsId() {
        return NewsId;
    }
    
    public int getClubId() {
        return ClubId;
    }
    
    public String getTitle() {
        return Title;
    }
    public String getContent(){
        return Content;
    }
    
    public String getAuthor(){
        return Author;
    }
    
}