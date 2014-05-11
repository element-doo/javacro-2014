package model.Migracija;

public class Foo implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public Foo() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.ID = 0;
        this.bar = "";
        this.quxMigrated = 0;
    }

    private transient final com.dslplatform.patterns.ServiceLocator _serviceLocator;
    private transient final com.dslplatform.client.DomainProxy _domainProxy;
    private transient final com.dslplatform.client.CrudProxy _crudProxy;

    private String URI;

    @com.fasterxml.jackson.annotation.JsonProperty("URI")
    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI != null ? URI.hashCode() : super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;
        final Foo other = (Foo) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Foo(" + URI + ')' : "new Foo(" + super.hashCode()
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Foo(
            final String bar,
            final model.Migracija.Baz baz) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setBar(bar);
        setBaz(baz);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Foo(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("bar") final String bar,
            @com.fasterxml.jackson.annotation.JsonProperty("baz") final model.Migracija.Baz baz,
            @com.fasterxml.jackson.annotation.JsonProperty("quxMigrated") final int quxMigrated) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.bar = bar == null ? "" : bar;
        this.baz = baz == null ? null : baz;
        this.quxMigrated = quxMigrated;
    }

    private int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private Foo setID(final int value) {
        this.ID = value;

        if (this.baz != null) this.baz.setFooID(value);
        return this;
    }

    public static Foo find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static Foo find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(Foo.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Foo> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Foo> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(Foo.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Foo> findAll() throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Foo> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<Foo> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Foo> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(Foo.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Foo> search(
            final com.dslplatform.patterns.Specification<Foo> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Foo> search(
            final com.dslplatform.patterns.Specification<Foo> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<Foo> search(
            final com.dslplatform.patterns.Specification<Foo> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Foo> search(
            final com.dslplatform.patterns.Specification<Foo> specification,
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .search(specification, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count() throws java.io.IOException {
        return count(com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .count(Foo.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Foo> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Foo> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .count(specification).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private void updateWithAnother(final model.Migracija.Foo result) {
        this.URI = result.URI;

        this.bar = result.bar;
        this.baz = result.baz;
        this.quxMigrated = result.quxMigrated;
        this.ID = result.ID;
    }

    public Foo persist() throws java.io.IOException {
        final Foo result;
        try {
            result = this.URI == null
                    ? _crudProxy.create(this).get()
                    : _crudProxy.update(this).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
        this.updateWithAnother(result);
        return this;
    }

    public Foo delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(Foo.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private String bar;

    @com.fasterxml.jackson.annotation.JsonProperty("bar")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getBar() {
        return bar;
    }

    public Foo setBar(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"bar\" cannot be null!");
        this.bar = value;

        return this;
    }

    private model.Migracija.Baz baz;

    @com.fasterxml.jackson.annotation.JsonProperty("baz")
    public model.Migracija.Baz getBaz() {
        return baz;
    }

    public Foo setBaz(final model.Migracija.Baz value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"baz\" cannot be null!");
        this.baz = value;

        if (this.baz != null) this.baz.setFooID(this.ID);
        return this;
    }

    private int quxMigrated;

    @com.fasterxml.jackson.annotation.JsonProperty("quxMigrated")
    public int getQuxMigrated() {
        return this.quxMigrated;
    }
}
