package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Kladionica.Listic;
import model.Kladionica.Ponuda;
import model.Kladionica.Tekma;
import model.Kladionica.repositories.ListicRepository;
import model.Kladionica.repositories.TekmaRepository;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.patterns.ServiceLocator;

public class Main {
    public static void main(final String[] args) throws Exception {
        // An instance of Service Locator.
        // You can use it to fetch instances of repositories.
        final ServiceLocator locator = init();


        Logger logger = locator.resolve(Logger.class);
      Tekma derbi = new Tekma().setDatumTekme(DateTime.now()).setDomacin("Hajduk").setGost("Rijeka");
      derbi.persist();

      Tekma tekma = new TekmaRepository(locator).find("1001").get();
      Ponuda ponuda1 = new Ponuda().setTekma(tekma).setTip("Iks").setKoeficijent(new BigDecimal("1.1")).setIstekla(false);
      Ponuda ponuda2 = new Ponuda().setTekma(tekma).setTip("Jedan").setKoeficijent(new BigDecimal("1.01")).setIstekla(false);
      Ponuda ponuda3 = new Ponuda().setTekma(tekma).setTip("Jedan").setKoeficijent(new BigDecimal("1.2")).setIstekla(false);

      List<Ponuda> parovi = new ArrayList<Ponuda>();
      parovi.add(ponuda1);
      parovi.add(ponuda2);
      parovi.add(ponuda3);

      Listic listic = new Listic().setDatumUplate(LocalDate.now()).setIznos(new BigDecimal(100)).setParovi(parovi);

      listic.persist();


      ListicRepository lRep = new ListicRepository(locator);
      List<Listic> listici = lRep.findAll().get();

      Listic list = listici.get(0);

      logger.info("LIST: \n  Datum: {}\n  Dobio?: {}\n  Iznos: {}\n  Dobivam: {}\n  UkKoef: {}"
          , list.getDatumUplate()
          , list.getDobitniLisic()
          , list.getIznos()
          , list.getMoguciDobitak()
          , list.getUkupniKoeficijent());



        // Perform cleanup.
        shutdown(locator);
    }

    /**
     * Call to initialize an instance of ServiceLocator with a dsl-project.ini
     */
    public static ServiceLocator init() throws IOException {
        final ServiceLocator locator =
                Bootstrap.init(Main.class.getResourceAsStream("/dsl-project.ini"));

        // an example how to resolve components from the ServiceLocator
        locator.resolve(Logger.class).info("Locator has been initialized.");
        return locator;
    }

    /**
     * ExecutorService will keep on working up to a minute after program has
     * finished. This method is an example how one could quickly exit the
     * program and can be called to speed up application ending.
     *
     * Alternatively, you can also invoke System.exit();
     */
    public static void shutdown(final ServiceLocator locator)
            throws IOException {
        locator.resolve(java.util.concurrent.ExecutorService.class).shutdown();
    }
}
