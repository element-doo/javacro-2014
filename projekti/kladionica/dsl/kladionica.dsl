module Kladionica {

  root Tekma {
    Timestamp  datumTekme;
    String     domacin;
    String     gost;
  }
    
  entity Ponuda {
    String   tip;
    Tekma*   tekma;
    Decimal  koeficijent;
    Bool     istekla;
    Bool?    ishod;
  }
  
  root Listic {
    List<Ponuda>  parovi;
    Date          datumUplate;
    Decimal       iznos;
    
    calculated Decimal  ukupniKoeficijent from 'it => it.parovi.Select(par=> par.koeficijent).Aggregate(1M, (produkt, koef) => produkt * koef)';
    calculated Decimal  moguciDobitak     from 'it => it.ukupniKoeficijent * it.iznos';
    calculated Boolean? dobitniLisic      from 'it => it.parovi.All(par => par.ishod != null) ? (bool?)it.parovi.All(par => par.ishod == true) : (bool?)null';
  }
  
  enum PonudaTip {
    Jedan;
    Iks;
    Dva;
  }
}
