package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    private ArrayList<Integer> idRegister = new ArrayList<>();

    public RegisterResult registerVoter(Person p) {

	RegisterResult stadeRegister = RegisterResult.VALID;

	if (p.isAlive() == false) {
		stadeRegister = RegisterResult.DEAD;

	} else if ((p.getAge() > 0) && (p.getAge() < 18)) {
		stadeRegister = RegisterResult.UNDERAGE;		

	} else if ((p.getAge() < 0) || (p.getAge() > 122)){
		stadeRegister = RegisterResult.INVALID_AGE;

	} else if (idRegister.contains(p.getId())) {
 		stadeRegister = RegisterResult.DUPLICATED;

	} else if (p.getId() < 0) {
		stadeRegister = RegisterResult.INVALID_ID;
	}

	if (stadeRegister == RegisterResult.VALID) {
		idRegister.add(p.getId());
	}
        return stadeRegister;
    }
}