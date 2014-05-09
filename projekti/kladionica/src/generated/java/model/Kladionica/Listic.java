package model.Kladionica;

public class Listic implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public Listic() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.ID = 0;
        this.parovi = new java.util.ArrayList<model.Kladionica.Ponuda>();
        this.datumUplate = org.joda.time.LocalDate.now();
        this.iznos = java.math.BigDecimal.ZERO;
        this.ukupniKoeficijent = java.math.BigDecimal.ZERO;
        this.moguciDobitak = java.math.BigDecimal.ZERO;
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
        final Listic other = (Listic) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Listic(" + URI + ')' : "new Listic("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Listic(
            final java.util.List<model.Kladionica.Ponuda> parovi,
            final org.joda.time.LocalDate datumUplate,
            final java.math.BigDecimal iznos) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setParovi(parovi);
        setDatumUplate(datumUplate);
        setIznos(iznos);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Listic(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("parovi") final java.util.List<model.Kladionica.Ponuda> parovi,
            @com.fasterxml.jackson.annotation.JsonProperty("datumUplate") final org.joda.time.LocalDate datumUplate,
            @com.fasterxml.jackson.annotation.JsonProperty("iznos") final java.math.BigDecimal iznos,
            @com.fasterxml.jackson.annotation.JsonProperty("ukupniKoeficijent") final java.math.BigDecimal ukupniKoeficijent,
            @com.fasterxml.jackson.annotation.JsonProperty("moguciDobitak") final java.math.BigDecimal moguciDobitak,
            @com.fasterxml.jackson.annotation.JsonProperty("dobitniLisic") final Boolean dobitniLisic) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.parovi = parovi == null
                ? new java.util.ArrayList<model.Kladionica.Ponuda>()
                : parovi;
        this.datumUplate = datumUplate == null ? new org.joda.time.LocalDate(1,
                1, 1) : datumUplate;
        this.iznos = iznos == null ? java.math.BigDecimal.ZERO : iznos;
        this.ukupniKoeficijent = ukupniKoeficijent;
        this.moguciDobitak = moguciDobitak;
        this.dobitniLisic = dobitniLisic == null ? Boolean.FALSE : dobitniLisic;
    }

    private int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private Listic setID(final int value) {
        this.ID = value;

        return this;
    }

    public static Listic find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static Listic find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(Listic.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Listic> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Listic> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(Listic.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Listic> findAll() throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Listic> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<Listic> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Listic> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(Listic.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Listic> search(
            final com.dslplatform.patterns.Specification<Listic> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Listic> search(
            final com.dslplatform.patterns.Specification<Listic> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<Listic> search(
            final com.dslplatform.patterns.Specification<Listic> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Listic> search(
            final com.dslplatform.patterns.Specification<Listic> specification,
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
                    .count(Listic.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Listic> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Listic> specification,
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

    private void updateWithAnother(final model.Kladionica.Listic result) {
        this.URI = result.URI;

        this.parovi = result.parovi;
        this.datumUplate = result.datumUplate;
        this.iznos = result.iznos;
        this.ukupniKoeficijent = result.ukupniKoeficijent;
        this.moguciDobitak = result.moguciDobitak;
        this.dobitniLisic = result.dobitniLisic;
        this.ID = result.ID;
    }

    public Listic persist() throws java.io.IOException {
        if (this.getParovi() != null) {
            for (final model.Kladionica.Ponuda thisparovi : this.getParovi()) {
                if (thisparovi.getTekmaURI() == null) {
                    throw new IllegalArgumentException(
                            "Cannot persist instance of 'model.Kladionica.Listic' because reference 'tekma' (in 'model.Kladionica.Ponuda') was not assigned");
                }
            }
        }
        final Listic result;
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

    public Listic delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(Listic.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.util.List<model.Kladionica.Ponuda> parovi;

    @com.fasterxml.jackson.annotation.JsonProperty("parovi")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public java.util.List<model.Kladionica.Ponuda> getParovi() {
        return parovi;
    }

    public Listic setParovi(final java.util.List<model.Kladionica.Ponuda> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"parovi\" cannot be null!");
        model.Guards.checkNulls(value);
        this.parovi = value;

        return this;
    }

    private org.joda.time.LocalDate datumUplate;

    @com.fasterxml.jackson.annotation.JsonProperty("datumUplate")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.LocalDate getDatumUplate() {
        return datumUplate;
    }

    public Listic setDatumUplate(final org.joda.time.LocalDate value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"datumUplate\" cannot be null!");
        this.datumUplate = value;

        return this;
    }

    private java.math.BigDecimal iznos;

    @com.fasterxml.jackson.annotation.JsonProperty("iznos")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public java.math.BigDecimal getIznos() {
        return iznos;
    }

    public Listic setIznos(final java.math.BigDecimal value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"iznos\" cannot be null!");
        this.iznos = value;

        return this;
    }

    private java.math.BigDecimal ukupniKoeficijent;

    @com.fasterxml.jackson.annotation.JsonProperty("ukupniKoeficijent")
    public java.math.BigDecimal getUkupniKoeficijent() {
        return this.ukupniKoeficijent;
    }

    private java.math.BigDecimal moguciDobitak;

    @com.fasterxml.jackson.annotation.JsonProperty("moguciDobitak")
    public java.math.BigDecimal getMoguciDobitak() {
        return this.moguciDobitak;
    }

    private Boolean dobitniLisic;

    @com.fasterxml.jackson.annotation.JsonProperty("dobitniLisic")
    public Boolean getDobitniLisic() {
        return this.dobitniLisic;
    }
}
