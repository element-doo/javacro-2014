package model.Kladionica;

public class Tekma implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public Tekma() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.ID = 0;
        this.datumTekme = org.joda.time.DateTime.now();
        this.domacin = "";
        this.gost = "";
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
        final Tekma other = (Tekma) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Tekma(" + URI + ')' : "new Tekma("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Tekma(
            final org.joda.time.DateTime datumTekme,
            final String domacin,
            final String gost) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setDatumTekme(datumTekme);
        setDomacin(domacin);
        setGost(gost);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Tekma(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("datumTekme") final org.joda.time.DateTime datumTekme,
            @com.fasterxml.jackson.annotation.JsonProperty("domacin") final String domacin,
            @com.fasterxml.jackson.annotation.JsonProperty("gost") final String gost) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.datumTekme = datumTekme == null ? new org.joda.time.DateTime(1, 1,
                1, 0, 0) : datumTekme;
        this.domacin = domacin == null ? "" : domacin;
        this.gost = gost == null ? "" : gost;
    }

    private int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private Tekma setID(final int value) {
        this.ID = value;

        return this;
    }

    public static Tekma find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static Tekma find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(Tekma.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Tekma> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Tekma> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(Tekma.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Tekma> findAll() throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Tekma> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<Tekma> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Tekma> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(Tekma.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Tekma> search(
            final com.dslplatform.patterns.Specification<Tekma> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Tekma> search(
            final com.dslplatform.patterns.Specification<Tekma> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<Tekma> search(
            final com.dslplatform.patterns.Specification<Tekma> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Tekma> search(
            final com.dslplatform.patterns.Specification<Tekma> specification,
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
                    .count(Tekma.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Tekma> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Tekma> specification,
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

    private void updateWithAnother(final model.Kladionica.Tekma result) {
        this.URI = result.URI;

        this.datumTekme = result.datumTekme;
        this.domacin = result.domacin;
        this.gost = result.gost;
        this.ID = result.ID;
    }

    public Tekma persist() throws java.io.IOException {
        final Tekma result;
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

    public Tekma delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(Tekma.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private org.joda.time.DateTime datumTekme;

    @com.fasterxml.jackson.annotation.JsonProperty("datumTekme")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.DateTime getDatumTekme() {
        return datumTekme;
    }

    public Tekma setDatumTekme(final org.joda.time.DateTime value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"datumTekme\" cannot be null!");
        this.datumTekme = value;

        return this;
    }

    private String domacin;

    @com.fasterxml.jackson.annotation.JsonProperty("domacin")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getDomacin() {
        return domacin;
    }

    public Tekma setDomacin(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"domacin\" cannot be null!");
        this.domacin = value;

        return this;
    }

    private String gost;

    @com.fasterxml.jackson.annotation.JsonProperty("gost")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getGost() {
        return gost;
    }

    public Tekma setGost(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"gost\" cannot be null!");
        this.gost = value;

        return this;
    }
}
