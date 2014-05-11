package model.Kladionica.repositories;

public class UplaceniListicRepository
        extends
        com.dslplatform.client.ClientRepository<model.Kladionica.UplaceniListic> {
    public UplaceniListicRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.Kladionica.UplaceniListic.class, locator);
    }

    public UplaceniListicRepository() {
        this(com.dslplatform.client.Bootstrap.getLocator());
    }
}
