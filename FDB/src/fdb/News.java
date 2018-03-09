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
    
    public News(int nNewsId, int nClubId, String nTitle, String nContent) 
    {
        NewsId = nNewsId;
        ClubId = nClubId;
        Title = nTitle;
        Content = nContent;
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
    
}