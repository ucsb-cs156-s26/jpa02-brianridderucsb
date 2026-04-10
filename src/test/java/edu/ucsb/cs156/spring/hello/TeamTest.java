package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_value_case1() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_correct_value_case2() {
        String testString = new String("Im not a Team");
        assert(!(team.equals(testString)));
    }

    @Test
    public void equals_returns_correct_value_case3() {
        team.addMember("Chris G.");
        Team team2 = new Team("test-team2"  );
        team2.addMember("Chris B.");
        Team team3 = new Team("test-team3");
        team3.addMember("Chris G.");
        Team team4 = new Team("test-team");
        team4.addMember("Chris B.");
        Team team5 = new Team("test-team");
        team5.addMember("Chris G.");
        assert(!(team.equals(team2)));
        assert(!(team.equals(team3)));
        assert(!(team.equals(team4)));
        assert(team.equals(team5));
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_incorrect_value_when_mutated() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
    

}
