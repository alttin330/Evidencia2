package mx.com.alfonso.server;

import mx.com.alfonso.common.Person;
import mx.com.alfonso.common.PersonInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PersonImplementation extends UnicastRemoteObject implements PersonInterface {

    // Attributes
    private PersonDAO personDAO;

    // Constructor
    public PersonImplementation() throws RemoteException {
        super();
        this.personDAO = new PersonDAO();
    }

    public String sayHello() throws RemoteException {
        return "Hi! Server Here!";
    }

    public String savePerson(Person person) throws RemoteException {
        boolean isInsertSucceed = personDAO.insertPerson(person);
        if(isInsertSucceed) {
            return "Insert Succeed";
        } else {
            return "Insert Wrong";
        }
    }

    public List<Person> getPeople() throws RemoteException {
        return personDAO.getPeople();
    }
}
