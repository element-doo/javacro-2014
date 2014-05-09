package model.Kladionica;

public class Ponuda implements java.io.Serializable {
    public Ponuda() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.tip = "";
        this.tekmaID = 0;
        this.koeficijent = java.math.BigDecimal.ZERO;
        this.istekla = false;
        this.ListicID = 0;
        this.Index = 0;
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
            @com.fasterxml.jackson.annotation.JsonProperty("tip") final String tip,
            @com.fasterxml.jackson.annotation.JsonProperty("tekmaURI") final String tekmaURI,
            @com.fasterxml.jackson.annotation.JsonProperty("tekmaID") final int tekmaID,
            @com.fasterxml.jackson.annotation.JsonProperty("koeficijent") final java.math.BigDecimal koeficijent,
            @com.fasterxml.jackson.annotation.JsonProperty("istekla") final boolean istekla,
            @com.fasterxml.jackson.annotation.JsonProperty("ishod") final Boolean ishod,
            @com.fasterxml.jackson.annotation.JsonProperty("ListicID") final int ListicID,
            @com.fasterxml.jackson.annotation.JsonProperty("Index") final int Index) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.tip = tip == null ? "" : tip;
        this.tekmaURI = tekmaURI == null ? null : tekmaURI;
        this.tekmaID = tekmaID;
        this.koeficijent = koeficijent == null
                ? java.math.BigDecimal.ZERO
                : koeficijent;
        this.istekla = istekla;
        this.ishod = ishod;
        this.ListicID = ListicID;
        this.Index = Index;
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

    @com.fasterxml.jackson.annotation.JsonIgnore
    public model.Kladionica.Tekma getTekma() throws java.io.IOException {
        if (tekma != null && !tekma.getURI().equals(tekmaURI) || tekma == null
                && tekmaURI != null)
            try {
                tekma = _crudProxy.read(model.Kladionica.Tekma.class, tekmaURI)
                        .get();
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return tekma;
    }

    public Ponuda setTekma(final model.Kladionica.Tekma value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"tekma\" cannot be null!");

        if (value != null && value.getURI() == null)
            throw new IllegalArgumentException(
                    "Reference \"Kladionica.Tekma\" for property \"tekma\" must be persisted before it's assigned");
        this.tekma = value;

        this.tekmaURI = value.getURI();

        this.tekmaID = value.getID();
        return this;
    }

    private String tekmaURI;

    @com.fasterxml.jackson.annotation.JsonProperty("tekmaURI")
    public String getTekmaURI() {
        return this.tekmaURI;
    }

    private int tekmaID;

    @com.fasterxml.jackson.annotation.JsonProperty("tekmaID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getTekmaID() {
        return tekmaID;
    }

    private Ponuda setTekmaID(final int value) {
        this.tekmaID = value;

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

    private int ListicID;

    @com.fasterxml.jackson.annotation.JsonProperty("ListicID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getListicID() {
        return ListicID;
    }

    public Ponuda setListicID(final int value) {
        this.ListicID = value;

        return this;
    }

    private int Index;

    @com.fasterxml.jackson.annotation.JsonProperty("Index")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getIndex() {
        return Index;
    }

    public Ponuda setIndex(final int value) {
        this.Index = value;

        return this;
    }
}
