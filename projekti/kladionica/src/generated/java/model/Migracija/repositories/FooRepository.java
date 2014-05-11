package model.Migracija.repositories;

public class FooRepository extends
        com.dslplatform.client.ClientPersistableRepository<model.Migracija.Foo> {
    public FooRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.Migracija.Foo.class, locator);
    }
}
