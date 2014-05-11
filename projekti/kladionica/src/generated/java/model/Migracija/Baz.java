package model.Migracija;

public class Baz implements java.io.Serializable {
    public Baz() {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.qux = 0;
        this.FooID = 0;
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
        final Baz other = (Baz) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "Baz(" + URI + ')' : "new Baz(" + super.hashCode()
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public Baz(
            final int qux) {
        _serviceLocator = com.dslplatform.client.Bootstrap.getLocator();
        _domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        _crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        setQux(qux);
    }

    @com.fasterxml.jackson.annotation.JsonCreator
    private Baz(
            @com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
            @com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI,
            @com.fasterxml.jackson.annotation.JsonProperty("qux") final int qux,
            @com.fasterxml.jackson.annotation.JsonProperty("FooID") final int FooID) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator
                .resolve(com.dslplatform.client.DomainProxy.class);
        this._crudProxy = _serviceLocator
                .resolve(com.dslplatform.client.CrudProxy.class);
        this.URI = URI;
        this.qux = qux;
        this.FooID = FooID;
    }

    private int qux;

    @com.fasterxml.jackson.annotation.JsonProperty("qux")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getQux() {
        return qux;
    }

    public Baz setQux(final int value) {
        this.qux = value;

        return this;
    }

    private int FooID;

    @com.fasterxml.jackson.annotation.JsonProperty("FooID")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public int getFooID() {
        return FooID;
    }

    public Baz setFooID(final int value) {
        this.FooID = value;

        return this;
    }
}
