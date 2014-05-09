package model.Kladionica.repositories;

public class TekmaRepository
        extends
        com.dslplatform.client.ClientPersistableRepository<model.Kladionica.Tekma> {
    public TekmaRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.Kladionica.Tekma.class, locator);
    }
}
