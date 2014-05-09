package model.Kladionica.repositories;

public class ListicRepository
        extends
        com.dslplatform.client.ClientPersistableRepository<model.Kladionica.Listic> {
    public ListicRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.Kladionica.Listic.class, locator);
    }
}
