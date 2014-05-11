module Kladionica {

  entity Tekma {
    Timestamp  datumTekme;
    String     domacin;
    String     gost;
  }

  root Ponuda {
    String   tip;
    Tekma    tekma;
    Decimal  koeficijent;
    Bool     istekla;
    Bool?    ishod;

    specification aktivne 'it => !it.istekla';

  }

  root Listic {
    List<Ponuda>  *parovi;
    Date          datumUplate;
    Decimal       iznos;

  }

  snowflake<Listic> UplaceniListic {
    ID;
    parovi;
    datumUplate;
    iznos;

    calculated Decimal  ukupniKoeficijent from 'it => it.parovi.Select(par=> par.koeficijent).Aggregate(1M, (produkt, koef) => produkt * koef)';
    calculated Decimal  moguciDobitak     from 'it => it.ukupniKoeficijent * it.iznos';
    calculated Boolean? dobitniLisic      from 'it => it.parovi.All(par => par.ishod != null) ? (bool?)it.parovi.All(par => par.ishod == true) : (bool?)null';

    specification findByID 'it => it.ID == ID' {
      Int ID;
    }
  }
}
