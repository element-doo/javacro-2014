package model.Kladionica;

public final class UplaceniListic implements
        com.dslplatform.patterns.Identifiable, java.io.Serializable {
    @com.fasterxml.jackson.annotation.JsonCreator
    public UplaceniListic(
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
            @com.fasterxml.jackson.annotation.JsonProperty("parovi") final java.util.List<model.Kladionica.Ponuda> parovi,
            @com.fasterxml.jackson.annotation.JsonProperty("datumUplate") final org.joda.time.LocalDate datumUplate,
            @com.fasterxml.jackson.annotation.JsonProperty("iznos") final java.math.BigDecimal iznos,
            @com.fasterxml.jackson.annotation.JsonProperty("ukupniKoeficijent") final java.math.BigDecimal ukupniKoeficijent,
            @com.fasterxml.jackson.annotation.JsonProperty("moguciDobitak") final java.math.BigDecimal moguciDobitak,
            @com.fasterxml.jackson.annotation.JsonProperty("dobitniLisic") final Boolean dobitniLisic) {
        this.URI = URI;
        this.ID = ID;
        this.parovi = parovi;
        if (parovi == null)
            throw new IllegalArgumentException(
                    "Property \"parovi\" cannot be null!");
        model.Guards.checkNulls(parovi);
        this.datumUplate = datumUplate;
        if (datumUplate == null)
            throw new IllegalArgumentException(
                    "Property \"datumUplate\" cannot be null!");
        this.iznos = iznos;
        if (iznos == null)
            throw new IllegalArgumentException(
                    "Property \"iznos\" cannot be null!");
        this.ukupniKoeficijent = ukupniKoeficijent;
        this.moguciDobitak = moguciDobitak;
        this.dobitniLisic = dobitniLisic;
    }

    public UplaceniListic() {
        this.URI = null;
        this.ID = 0;
        this.parovi = null;
        this.datumUplate = null;
        this.iznos = null;
        this.ukupniKoeficijent = null;
        this.moguciDobitak = null;
        this.dobitniLisic = null;
    }

    private final String URI;

    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;
        final UplaceniListic other = (UplaceniListic) obj;

        return URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return "UplaceniListic(" + URI + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private final int ID;

    @com.fasterxml.jackson.annotation.JsonProperty("ID")
    public int getID() {
        return this.ID;
    }

    private final java.util.List<model.Kladionica.Ponuda> parovi;

    @com.fasterxml.jackson.annotation.JsonProperty("parovi")
    public java.util.List<model.Kladionica.Ponuda> getParovi() {
        return this.parovi;
    }

    private final org.joda.time.LocalDate datumUplate;

    @com.fasterxml.jackson.annotation.JsonProperty("datumUplate")
    public org.joda.time.LocalDate getDatumUplate() {
        return this.datumUplate;
    }

    private final java.math.BigDecimal iznos;

    @com.fasterxml.jackson.annotation.JsonProperty("iznos")
    public java.math.BigDecimal getIznos() {
        return this.iznos;
    }

    private final java.math.BigDecimal ukupniKoeficijent;

    public java.math.BigDecimal getUkupniKoeficijent() {
        return this.ukupniKoeficijent;
    }

    private final java.math.BigDecimal moguciDobitak;

    public java.math.BigDecimal getMoguciDobitak() {
        return this.moguciDobitak;
    }

    private final Boolean dobitniLisic;

    public Boolean getDobitniLisic() {
        return this.dobitniLisic;
    }

    public static class findByID implements java.io.Serializable,
            com.dslplatform.patterns.Specification<UplaceniListic> {
        public findByID(
                final int ID) {
            setID(ID);
        }

        public findByID() {
            this.ID = 0;
        }

        private static final long serialVersionUID = 0x0097000a;

        private int ID;

        @com.fasterxml.jackson.annotation.JsonProperty("ID")
        @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
        public int getID() {
            return ID;
        }

        public findByID setID(final int value) {
            this.ID = value;

            return this;
        }

        public java.util.List<UplaceniListic> search()
                throws java.io.IOException {
            return search(null, null,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<UplaceniListic> search(
                final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            return search(null, null, locator);
        }

        public java.util.List<UplaceniListic> search(
                final Integer limit,
                final Integer offset) throws java.io.IOException {
            return search(limit, offset,
                    com.dslplatform.client.Bootstrap.getLocator());
        }

        public java.util.List<UplaceniListic> search(
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

    public static UplaceniListic find(final String uri)
            throws java.io.IOException {
        return find(uri, null);
    }

    public static UplaceniListic find(
            final String uri,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.CrudProxy.class)
                    .read(UplaceniListic.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<UplaceniListic> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<UplaceniListic> find(
            final Iterable<String> uris,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .find(UplaceniListic.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<UplaceniListic> findAll()
            throws java.io.IOException {
        return findAll(null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<UplaceniListic> findAll(
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<UplaceniListic> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<UplaceniListic> findAll(
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null
                    ? locator
                    : com.dslplatform.client.Bootstrap.getLocator())
                    .resolve(com.dslplatform.client.DomainProxy.class)
                    .findAll(UplaceniListic.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<UplaceniListic> search(
            final com.dslplatform.patterns.Specification<UplaceniListic> specification)
            throws java.io.IOException {
        return search(specification, null, null,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<UplaceniListic> search(
            final com.dslplatform.patterns.Specification<UplaceniListic> specification,
            final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<UplaceniListic> search(
            final com.dslplatform.patterns.Specification<UplaceniListic> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<UplaceniListic> search(
            final com.dslplatform.patterns.Specification<UplaceniListic> specification,
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
                    .count(UplaceniListic.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final com.dslplatform.patterns.Specification<UplaceniListic> specification)
            throws java.io.IOException {
        return count(specification,
                com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(
            final com.dslplatform.patterns.Specification<UplaceniListic> specification,
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
}
