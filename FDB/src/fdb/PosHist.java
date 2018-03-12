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
public class PosHist {
    int clubID;
    String competition;
    int year;
    int position;
    
    public PosHist(int DBclubID, String DBcompetition, int DByear, int DBposition) 
    {
        clubID = DBclubID;
        competition = DBcompetition;
        year = DByear;
        position = DBposition;
    }
    
    //Getters
    public int getClubID() {
        return clubID;
    }
    
    public String getCompetition() {
        return competition;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getPosition() {
        return position;
    }
}
