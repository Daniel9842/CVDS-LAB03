package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {
        Person person0 = new Person("Dudu",123,22,Gender.MALE,true);
        RegisterResult result0 = registry.registerVoter(person0);
        Assert.assertEquals(RegisterResult.VALID, result0);
    }

    @Test
    public void invalidateRegistryResultAlive() {
        Person person1 = new Person("Migue",124,22,Gender.MALE,false);
        RegisterResult result1 = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.DEAD, result1);
    }

    @Test
    public void invalidateRegistryResultUnderage() {
        Person person2 = new Person("Maria",125,9,Gender.FEMALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.UNDERAGE, result2);
    }

    @Test
    public void invalidateRegistryResultAge() {
        Person person3 = new Person("Jose",126,150,Gender.MALE,true);
        RegisterResult result3 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result3);
    }

    @Test
    public void invalidateRegistryResultDuplicated() {
        Person person4 = new Person("Toño",127,20,Gender.MALE,true);
        RegisterResult result4 = registry.registerVoter(person4);
        Assert.assertEquals(RegisterResult.VALID, result4);

	Person person5 = new Person("Toña",127,23,Gender.FEMALE,true);
        RegisterResult result5 = registry.registerVoter(person5);
        Assert.assertEquals(RegisterResult.DUPLICATED, result5);
    }

    @Test
    public void invalidateRegistryResultId() {
        Person person6 = new Person("Laura",-123,20,Gender.FEMALE,true);
        RegisterResult result6 = registry.registerVoter(person6);
        Assert.assertEquals(RegisterResult.INVALID_ID, result6);
    }


    // TODO Complete with more test cases
}