package model.blog.repositories;

public class KorisnikRepository extends
        com.dslplatform.client.ClientPersistableRepository<model.blog.Korisnik> {
    public KorisnikRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.blog.Korisnik.class, locator);
    }
}
