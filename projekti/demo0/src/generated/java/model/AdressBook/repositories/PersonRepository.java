package model.AdressBook.repositories;

public class PersonRepository
        extends
        com.dslplatform.client.ClientPersistableRepository<model.AdressBook.Person> {
    public PersonRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.AdressBook.Person.class, locator);
    }
}
