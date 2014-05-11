package model.blog.repositories;

public class PostRepository extends
        com.dslplatform.client.ClientPersistableRepository<model.blog.Post> {
    public PostRepository(
            final com.dslplatform.patterns.ServiceLocator locator) {
        super(model.blog.Post.class, locator);
    }
}
