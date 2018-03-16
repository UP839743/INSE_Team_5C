/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

/**
 *
 * @author up777361
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   PlayerTest.class,
   ManagerTest.class,
   ClubTest.class,
   FixtureTest.class,
   NewsTest.class,
   StadiumTest.class,
   TrophyTest.class,
   PosHistTest.class
})

public class JunitTestSuite {   
}  	
