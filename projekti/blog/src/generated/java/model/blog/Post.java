package model.blog;

public class Post implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public Post() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.ID = 0;
        this.autorID = 0;
        this.naslov = "";
        this.datumObjave = org.joda.time.LocalDate.now();
        this.sadrzaj = "";
        this.tagovi = new java.util.HashSet<String>();
        this.komentari = new java.util.ArrayList<model.blog.Komentar>();
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
        final Post other = (Post) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Post(" + URI + ')' : "new Post("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Post(
            final model.blog.Korisnik autor,
            final String naslov,
            final org.joda.time.LocalDate datumObjave,
            final String sadrzaj,
            final java.util.Set<String> tagovi,
            final java.util.List<model.blog.Komentar> komentari) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setAutor(autor);
        setNaslov(naslov);
        setDatumObjave(datumObjave);
        setSadrzaj(sadrzaj);
        setTagovi(tagovi);
        setKomentari(komentari);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Post(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("autorURI") final String autorURI,
            @com.fasterxml.jackson.annotation.JsonProperty("autorID") final int autorID,
            @com.fasterxml.jackson.annotation.JsonProperty("naslov") final String naslov,
            @com.fasterxml.jackson.annotation.JsonProperty("datumObjave") final org.joda.time.LocalDate datumObjave,
            @com.fasterxml.jackson.annotation.JsonProperty("sadrzaj") final String sadrzaj,
            @com.fasterxml.jackson.annotation.JsonProperty("tagovi") final java.util.Set<String> tagovi,
            @com.fasterxml.jackson.annotation.JsonProperty("komentari") final java.util.List<model.blog.Komentar> komentari) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.autorURI = autorURI == null ? null : autorURI;
        this.autorID = autorID;
        this.naslov = naslov == null ? "" : naslov;
        this.datumObjave = datumObjave == null ? new org.joda.time.LocalDate(1,
                1, 1) : datumObjave;
        this.sadrzaj = sadrzaj == null ? "" : sadrzaj;
        this.tagovi = tagovi == null ? new java.util.HashSet<String>() : tagovi;
        this.komentari = komentari == null
                ? new java.util.ArrayList<model.blog.Komentar>()
                : komentari;
    }

    private int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private Post setID(final int value) {
        this.ID = value;

        return this;
    }

    public static Post find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static Post find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(Post.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Post> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Post> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(Post.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Post> findAll() throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Post> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<Post> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Post> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(Post.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Post> search(
            final com.dslplatform.patterns.Specification<Post> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Post> search(
            final com.dslplatform.patterns.Specification<Post> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<Post> search(
            final com.dslplatform.patterns.Specification<Post> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Post> search(
            final com.dslplatform.patterns.Specification<Post> specification,
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
                    .count(Post.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Post> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Post> specification,
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

    private void updateWithAnother(final model.blog.Post result) {
        this.URI = result.URI;

        this.autor = result.autor;
        this.autorURI = result.autorURI;
        this.autorID = result.autorID;
        this.naslov = result.naslov;
        this.datumObjave = result.datumObjave;
        this.sadrzaj = result.sadrzaj;
        this.tagovi = result.tagovi;
        this.komentari = result.komentari;
        this.ID = result.ID;
    }

    public Post persist() throws java.io.IOException {
        if (this.getAutorURI() == null) {
            throw new IllegalArgumentException(
                    "Cannot persist instance of 'model.blog.Post' because reference 'autor' was not assigned");
        }
        final Post result;
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

    public Post delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(Post.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
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
        return autor;
    }

    public Post setAutor(final model.blog.Korisnik value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"autor\" cannot be null!");

        if (value != null && value.getURI() == null)
            throw new IllegalArgumentException(
                    "Reference \"blog.Korisnik\" for property \"autor\" must be persisted before it's assigned");
        this.autor = value;

        this.autorURI = value.getURI();

        this.autorID = value.getID();
        return this;
    }

    private String autorURI;

    @com.fasterxml.jackson.annotation.JsonProperty("autorURI")
    public String getAutorURI() {
        return this.autorURI;
    }

    private int autorID;

    @com.fasterxml.jackson.annotation.JsonProperty("autorID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getAutorID() {
        return autorID;
    }

    private Post setAutorID(final int value) {
        this.autorID = value;

        return this;
    }

    private String naslov;

    @com.fasterxml.jackson.annotation.JsonProperty("naslov")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getNaslov() {
        return naslov;
    }

    public Post setNaslov(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"naslov\" cannot be null!");
        this.naslov = value;

        return this;
    }

    private org.joda.time.LocalDate datumObjave;

    @com.fasterxml.jackson.annotation.JsonProperty("datumObjave")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public org.joda.time.LocalDate getDatumObjave() {
        return datumObjave;
    }

    public Post setDatumObjave(final org.joda.time.LocalDate value) {
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

    public Post setSadrzaj(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"sadrzaj\" cannot be null!");
        this.sadrzaj = value;

        return this;
    }

    private java.util.Set<String> tagovi;

    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    @com.fasterxml.jackson.annotation.JsonProperty("tagovi")
    public java.util.Set<String> getTagovi() {
        return tagovi;
    }

    public Post setTagovi(final java.util.Set<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"tagovi\" cannot be null!");
        model.Guards.checkNulls(value);
        this.tagovi = value;

        return this;
    }

    private java.util.List<model.blog.Komentar> komentari;

    @com.fasterxml.jackson.annotation.JsonProperty("komentari")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public java.util.List<model.blog.Komentar> getKomentari() {
        return komentari;
    }

    public Post setKomentari(final java.util.List<model.blog.Komentar> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"komentari\" cannot be null!");
        model.Guards.checkNulls(value);
        this.komentari = value;

        return this;
    }

    public static class traziPoDatumu implements java.io.Serializable,
            com.dslplatform.patterns.Specification<Post> {
        public traziPoDatumu(
                final org.joda.time.LocalDate datumPretrage) {
            setDatumPretrage(datumPretrage);
        }

        public traziPoDatumu() {
            this.datumPretrage = org.joda.time.LocalDate.now();
        }

        private static final long serialVersionUID = 0x0097000a;

        private org.joda.time.LocalDate datumPretrage;

        @com.fasterxml.jackson.annotation.JsonProperty("datumPretrage")
        @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
        public org.joda.time.LocalDate getDatumPretrage() {
            return datumPretrage;
        }

        public traziPoDatumu setDatumPretrage(
                final org.joda.time.LocalDate value) {
            if (value == null)
                throw new IllegalArgumentException(
                        "Property \"datumPretrage\" cannot be null!");
            this.datumPretrage = value;

            return this;
        }

        public java.util.List<Post> search() throws java.io.IOException {
            return search(null, null,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<Post> search(
                final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            return search(null, null, locator);
        }

        public java.util.List<Post> search(
                final Integer limit,
                final Integer offset) throws java.io.IOException {
            return search(limit, offset,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<Post> search(
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
