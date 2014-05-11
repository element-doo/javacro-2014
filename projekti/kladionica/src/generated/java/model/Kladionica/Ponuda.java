package model.Kladionica;

public class Ponuda implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public Ponuda() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.ID = 0;
        this.tip = "";
        this.koeficijent = java.math.BigDecimal.ZERO;
        this.istekla = false;
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
        final Ponuda other = (Ponuda) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Ponuda(" + URI + ')' : "new Ponuda("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Ponuda(
            final String tip,
            final model.Kladionica.Tekma tekma,
            final java.math.BigDecimal koeficijent,
            final boolean istekla,
            final Boolean ishod) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setTip(tip);
        setTekma(tekma);
        setKoeficijent(koeficijent);
        setIstekla(istekla);
        setIshod(ishod);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Ponuda(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("tip") final String tip,
            @com.fasterxml.jackson.annotation.JsonProperty("tekma") final model.Kladionica.Tekma tekma,
            @com.fasterxml.jackson.annotation.JsonProperty("koeficijent") final java.math.BigDecimal koeficijent,
            @com.fasterxml.jackson.annotation.JsonProperty("istekla") final boolean istekla,
            @com.fasterxml.jackson.annotation.JsonProperty("ishod") final Boolean ishod) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.tip = tip == null ? "" : tip;
        this.tekma = tekma == null ? null : tekma;
        this.koeficijent = koeficijent == null
                ? java.math.BigDecimal.ZERO
                : koeficijent;
        this.istekla = istekla;
        this.ishod = ishod;
    }

    private int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private Ponuda setID(final int value) {
        this.ID = value;

        if (this.tekma != null) this.tekma.setPonudaID(value);
        return this;
    }

    public static Ponuda find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static Ponuda find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(Ponuda.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Ponuda> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Ponuda> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(Ponuda.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Ponuda> findAll() throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Ponuda> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<Ponuda> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Ponuda> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(Ponuda.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Ponuda> search(
            final com.dslplatform.patterns.Specification<Ponuda> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Ponuda> search(
            final com.dslplatform.patterns.Specification<Ponuda> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<Ponuda> search(
            final com.dslplatform.patterns.Specification<Ponuda> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Ponuda> search(
            final com.dslplatform.patterns.Specification<Ponuda> specification,
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
                    .count(Ponuda.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Ponuda> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Ponuda> specification,
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

    private void updateWithAnother(final model.Kladionica.Ponuda result) {
        this.URI = result.URI;

        this.tip = result.tip;
        this.tekma = result.tekma;
        this.koeficijent = result.koeficijent;
        this.istekla = result.istekla;
        this.ishod = result.ishod;
        this.ID = result.ID;
    }

    public Ponuda persist() throws java.io.IOException {
        final Ponuda result;
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

    public Ponuda delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(Ponuda.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private String tip;

    @com.fasterxml.jackson.annotation.JsonProperty("tip")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getTip() {
        return tip;
    }

    public Ponuda setTip(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"tip\" cannot be null!");
        this.tip = value;

        return this;
    }

    private model.Kladionica.Tekma tekma;

    @com.fasterxml.jackson.annotation.JsonProperty("tekma")
    public model.Kladionica.Tekma getTekma() {
        return tekma;
    }

    public Ponuda setTekma(final model.Kladionica.Tekma value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"tekma\" cannot be null!");
        this.tekma = value;

        if (this.tekma != null) this.tekma.setPonudaID(this.ID);
        return this;
    }

    private java.math.BigDecimal koeficijent;

    @com.fasterxml.jackson.annotation.JsonProperty("koeficijent")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public java.math.BigDecimal getKoeficijent() {
        return koeficijent;
    }

    public Ponuda setKoeficijent(final java.math.BigDecimal value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"koeficijent\" cannot be null!");
        this.koeficijent = value;

        return this;
    }

    private boolean istekla;

    @com.fasterxml.jackson.annotation.JsonProperty("istekla")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public boolean getIstekla() {
        return istekla;
    }

    public Ponuda setIstekla(final boolean value) {
        this.istekla = value;

        return this;
    }

    private Boolean ishod;

    @com.fasterxml.jackson.annotation.JsonProperty("ishod")
    public Boolean getIshod() {
        return ishod;
    }

    public Ponuda setIshod(final Boolean value) {
        this.ishod = value;

        return this;
    }

    public static class aktivne implements java.io.Serializable,
            com.dslplatform.patterns.Specification<Ponuda> {
        public aktivne() {}

        private static final long serialVersionUID = 0x0097000a;

        public java.util.List<Ponuda> search() throws java.io.IOException {
            return search(null, null,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<Ponuda> search(
                final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            return search(null, null, locator);
        }

        public java.util.List<Ponuda> search(
                final Integer limit,
                final Integer offset) throws java.io.IOException {
            return search(limit, offset,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<Ponuda> search(
                final Integer limit,
                final Integer offset,
                final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            try {
                return (locator != null
                        ? locator
                        : com.dslplatform.client.Bootstrap.getLocator())
                        .resolve(com.dslplatform.client.DomainProxy.class)
                        .search(this, limit, offset, null).get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        }

        public long count() throws java.io.IOException {
            return count(com.dslplatform.client.Bootstrap.getLocator());
        }

        public long count(final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            try {
                return (locator != null
                        ? locator
                        : com.dslplatform.client.Bootstrap.getLocator())
                        .resolve(com.dslplatform.client.DomainProxy.class)
                        .count(this).get().longValue();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        }
    }
}
