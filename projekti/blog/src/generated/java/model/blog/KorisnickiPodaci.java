package model.blog;

public final class KorisnickiPodaci implements java.io.Serializable {
    public KorisnickiPodaci(
            final String email,
            final String ime) {
        setEmail(email);
        setIme(ime);
    }

    public KorisnickiPodaci() {
        this.email = "";
        this.ime = "";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1653077094;
        result = prime * result
                + (this.email != null ? this.email.hashCode() : 0);
        result = prime * result + (this.ime != null ? this.ime.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof KorisnickiPodaci)) return false;
        final KorisnickiPodaci other = (KorisnickiPodaci) obj;

        if (!(this.email.equals(other.email))) return false;
        if (!(this.ime.equals(other.ime))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "KorisnickiPodaci(" + email + ',' + ime + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private String email;

    @com.fasterxml.jackson.annotation.JsonProperty("email")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getEmail() {
        return email;
    }

    public KorisnickiPodaci setEmail(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"email\" cannot be null!");
        this.email = value;

        return this;
    }

    private String ime;

    @com.fasterxml.jackson.annotation.JsonProperty("ime")
    @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
    public String getIme() {
        return ime;
    }

    public KorisnickiPodaci setIme(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"ime\" cannot be null!");
        this.ime = value;

        return this;
    }
}
