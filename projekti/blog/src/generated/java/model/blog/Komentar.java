package model.blog;

public class Komentar implements java.io.Serializable {
    public Komentar() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.datumObjave = org.joda.time.LocalDate.now();
        this.sadrzaj = "";
        this.PostID = 0;
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
        final Komentar other = (Komentar) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Komentar(" + URI + ')' : "new Komentar("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Komentar(
            final model.blog.Korisnik autor,
            final org.joda.time.LocalDate datumObjave,
            final String sadrzaj) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setAutor(autor);
        setDatumObjave(datumObjave);
        setSadrzaj(sadrzaj);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Komentar(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("autorURI") final String autorURI,
            @com.fasterxml.jackson.annotation.JsonProperty("autorID") final Integer autorID,
            @com.fasterxml.jackson.annotation.JsonProperty("datumObjave") final org.joda.time.LocalDate datumObjave,
            @com.fasterxml.jackson.annotation.JsonProperty("sadrzaj") final String sadrzaj,
            @com.fasterxml.jackson.annotation.JsonProperty("PostID") final int PostID,
            @com.fasterxml.jackson.annotation.JsonProperty("Index") final int Index) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.autorURI = autorURI;
        this.autorID = autorID;
        this.datumObjave = datumObjave == null ? new org.joda.time.LocalDate(1,
                1, 1) : datumObjave;
        this.sadrzaj = sadrzaj == null ? "" : sadrzaj;
        this.PostID = PostID;
        this.Index = Index;
    }

    private model.blog.Korisnik autor;

    @com.fasterxml.jackson.annotation.JsonIgnore
    public model.blog.Korisnik getAutor() throws java.io.IOException {
        if (autor != null && !autor.getURI().equals(autorURI) || autor == null
                && autorURI != null) try {
            autor = _crudProxy.read(model.blog.Korisnik.class, autorURI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
        if (this.autorURI == null && this.autor != null) this.autor = null;
        return autor;
    }

    public Komentar setAutor(final model.blog.Korisnik value) {
        if (value != null && value.getURI() == null)
            throw new IllegalArgumentException(
                    "Reference \"blog.Korisnik\" for property \"autor\" must be persisted before it's assigned");
        this.autor = value;

        this.autorURI = value != null ? value.getURI() : null;

        if (value == null && this.autorID != null) {
            this.autorID = null;
        } else if (value != null) {
            this.autorID = value.getID();
        }
        return this;
    }

    private String autorURI;

    @com.fasterxml.jackson.annotation.JsonProperty("autorURI")
    public String getAutorURI() {
        return this.autorURI;
    }

    private Integer autorID;

    @com.fasterxml.jackson.annotation.JsonProperty("autorID")
    public Integer getAutorID() {
        return autorID;
    }

    private Komentar setAutorID(final Integer value) {
        this.autorID = value;

        return this;
    }

    private org.joda.time.LocalDate datumObjave;

    @com.fasterxml.jackson.annotation.JsonProperty("datumObjave")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.LocalDate getDatumObjave() {
        return datumObjave;
    }

    public Komentar setDatumObjave(final org.joda.time.LocalDate value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"datumObjave\" cannot be null!");
        this.datumObjave = value;

        return this;
    }

    private String sadrzaj;

    @com.fasterxml.jackson.annotation.JsonProperty("sadrzaj")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getSadrzaj() {
        return sadrzaj;
    }

    public Komentar setSadrzaj(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"sadrzaj\" cannot be null!");
        this.sadrzaj = value;

        return this;
    }

    private int PostID;

    @com.fasterxml.jackson.annotation.JsonProperty("PostID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getPostID() {
        return PostID;
    }

    public Komentar setPostID(final int value) {
        this.PostID = value;

        return this;
    }

    private int Index;

    @com.fasterxml.jackson.annotation.JsonProperty("Index")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getIndex() {
        return Index;
    }

    public Komentar setIndex(final int value) {
        this.Index = value;

        return this;
    }
}
