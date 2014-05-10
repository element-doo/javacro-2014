module blog
{
  value KorisnickiPodaci {
    String email;
    String ime;
  }
  
  root Korisnik {
    KorisnickiPodaci korisnickiPodaci;
    
    detail postovi Post.autor;

    specification traziPoEmailu 'it => it.korisnickiPodaci.email == email' {
      String email;
    }

  }
  
  root Post {
    Korisnik *autor;
    String naslov;
    Date datumObjave;
    String sadrzaj;
 
    Set<String> tagovi;
    List<Komentar> komentari;

    specification traziPoDatumu 'it => it.datumObjave == datumPretrage'{
      Date datumPretrage;
    }
  }
  
  entity Komentar {    
    Korisnik? *autor;   // Dopustamo anonimne komentare
    Date datumObjave;
    String sadrzaj;
  } 
}
