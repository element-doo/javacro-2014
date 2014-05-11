package model.Kladionica;

public class Tekma implements java.io.Serializable {
    public Tekma() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.datumTekme = org.joda.time.DateTime.now();
        this.domacin = "";
        this.gost = "";
        this.PonudaID = 0;
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
            @com.fasterxml.jackson.annotation.JsonProperty("datumTekme") final org.joda.time.DateTime datumTekme,
            @com.fasterxml.jackson.annotation.JsonProperty("domacin") final String domacin,
            @com.fasterxml.jackson.annotation.JsonProperty("gost") final String gost,
            @com.fasterxml.jackson.annotation.JsonProperty("PonudaID") final int PonudaID) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.datumTekme = datumTekme == null ? new org.joda.time.DateTime(1, 1,
                1, 0, 0) : datumTekme;
        this.domacin = domacin == null ? "" : domacin;
        this.gost = gost == null ? "" : gost;
        this.PonudaID = PonudaID;
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

    private int PonudaID;

    @com.fasterxml.jackson.annotation.JsonProperty("PonudaID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getPonudaID() {
        return PonudaID;
    }

    public Tekma setPonudaID(final int value) {
        this.PonudaID = value;

        return this;
    }
}
