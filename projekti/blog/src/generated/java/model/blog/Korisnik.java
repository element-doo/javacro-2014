package model.blog;

public class Korisnik implements java.io.Serializable,
        com.dslplatform.patterns.AggregateRoot {
    public Korisnik() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.ID = 0;
        this.korisnickiPodaci = new model.blog.KorisnickiPodaci();
        this.postovi = new model.blog.Post[] {};
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
        final Korisnik other = (Korisnik) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Korisnik(" + URI + ')' : "new Korisnik("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Korisnik(
            final model.blog.KorisnickiPodaci korisnickiPodaci,
            final model.blog.Post[] postovi) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setKorisnickiPodaci(korisnickiPodaci);
        setPostovi(postovi);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Korisnik(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("korisnickiPodaci") final model.blog.KorisnickiPodaci korisnickiPodaci,
            @com.fasterxml.jackson.annotation.JsonProperty("postoviURI") final String[] postoviURI) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.korisnickiPodaci = korisnickiPodaci == null
                ? new model.blog.KorisnickiPodaci()
                : korisnickiPodaci;
        this.postoviURI = postoviURI == null ? new String[0] : postoviURI;
    }

    private int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private Korisnik setID(final int value) {
        this.ID = value;

        return this;
    }

    public static Korisnik find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static Korisnik find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(Korisnik.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Korisnik> find(final Iterable<String> uris)
            throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Korisnik> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(Korisnik.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Korisnik> findAll() throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Korisnik> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<Korisnik> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Korisnik> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(Korisnik.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<Korisnik> search(
            final com.dslplatform.patterns.Specification<Korisnik> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Korisnik> search(
            final com.dslplatform.patterns.Specification<Korisnik> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<Korisnik> search(
            final com.dslplatform.patterns.Specification<Korisnik> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<Korisnik> search(
            final com.dslplatform.patterns.Specification<Korisnik> specification,
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
                    .count(Korisnik.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Korisnik> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<Korisnik> specification,
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

    private void updateWithAnother(final model.blog.Korisnik result) {
        this.URI = result.URI;

        this.korisnickiPodaci = result.korisnickiPodaci;
        this.postovi = result.postovi;
        this.postoviURI = result.postoviURI;
        this.ID = result.ID;
    }

    public Korisnik persist() throws java.io.IOException {
        final Korisnik result;
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

    public Korisnik delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(Korisnik.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private model.blog.KorisnickiPodaci korisnickiPodaci;

    @com.fasterxml.jackson.annotation.JsonProperty("korisnickiPodaci")
    public model.blog.KorisnickiPodaci getKorisnickiPodaci() {
        return korisnickiPodaci;
    }

    public Korisnik setKorisnickiPodaci(final model.blog.KorisnickiPodaci value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"korisnickiPodaci\" cannot be null!");
        this.korisnickiPodaci = value;

        return this;
    }

    private model.blog.Post[] postovi;

    @com.fasterxml.jackson.annotation.JsonIgnore
    public model.blog.Post[] getPostovi() throws java.io.IOException {
        if (postoviURI != null
                && (postovi == null || postovi.length != postoviURI.length))
            try {
                postovi = _domainProxy.find(model.blog.Post.class, postoviURI)
                        .get().toArray(new model.blog.Post[postoviURI.length]);;
            } catch (final InterruptedException e) {
                throw new java.io.IOException(e);
            } catch (final java.util.concurrent.ExecutionException e) {
                throw new java.io.IOException(e);
            }
        return postovi;
    }

    public Korisnik setPostovi(final model.blog.Post[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"postovi\" cannot be null!");
        model.Guards.checkNulls(value);

        if (value != null) {
            for (final model.blog.Post refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"blog.Post\" for property \"postovi\" must be persisted before it's assigned");
        }
        this.postovi = value;

        this.postoviURI = new String[value.length];
        int _i = 0;
        for (final model.blog.Post _it : value) {
            this.postoviURI[_i++] = _it.getURI();
        }
        return this;
    }

    private String[] postoviURI;

    @com.fasterxml.jackson.annotation.JsonProperty("postoviURI")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String[] getPostoviURI() {
        return this.postoviURI;
    }

    public static class traziPoEmailu implements java.io.Serializable,
            com.dslplatform.patterns.Specification<Korisnik> {
        public traziPoEmailu(
                final String email) {
            setEmail(email);
        }

        public traziPoEmailu() {
            this.email = "";
        }

        private static final long serialVersionUID = 0x0097000a;

        private String email;

        @com.fasterxml.jackson.annotation.JsonProperty("email")
        @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
        public String getEmail() {
            return email;
        }

        public traziPoEmailu setEmail(final String value) {
            if (value == null)
                throw new IllegalArgumentException(
                        "Property \"email\" cannot be null!");
            this.email = value;

            return this;
        }

        public java.util.List<Korisnik> search() throws java.io.IOException {
            return search(null, null,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<Korisnik> search(
                final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            return search(null, null, locator);
        }

        public java.util.List<Korisnik> search(
                final Integer limit,
                final Integer offset) throws java.io.IOException {
            return search(limit, offset,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<Korisnik> search(
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
