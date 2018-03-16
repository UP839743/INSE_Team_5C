package fdb;

/**
 *
 * @author INSE Team 5C
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
