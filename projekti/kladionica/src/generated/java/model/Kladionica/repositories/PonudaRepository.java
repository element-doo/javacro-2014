package model.Kladionica.repositories;

public class PonudaRepository
        extends
        com.dslplatform.client.ClientPersistableRepository<model.Kladionica.Ponuda> {
    public PonudaRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.Kladionica.Ponuda.class, locator);
    }
}
