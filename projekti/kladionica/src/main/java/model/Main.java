package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Kladionica.Listic;
import model.Kladionica.Ponuda;
import model.Kladionica.Tekma;
import model.Kladionica.UplaceniListic;
import model.Kladionica.repositories.*;

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


    stvoriPonude(locator, logger);

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

  private static void stvoriPonude(ServiceLocator locator, Logger logger) throws Exception {
    Tekma tekma = new Tekma()
      .setDatumTekme(DateTime.now())
      .setDomacin("Hajduk")
      .setGost("Rijeka");

    Ponuda ponuda1X = new Ponuda()
      .setTekma(tekma)
      .setTip("Iks")
      .setKoeficijent(new BigDecimal("1.1"))
      .setIstekla(false);

    ponuda1X.persist();

    Ponuda ponuda11 = new Ponuda()
      .setTekma(tekma)
      .setTip("Jedan")
      .setKoeficijent(new BigDecimal("1.01"))
      .setIstekla(false);

    ponuda11.persist();

    Ponuda ponuda12 = new Ponuda()
      .setTekma(tekma)
      .setTip("Dva")
      .setKoeficijent(new BigDecimal("1.2"))
      .setIstekla(false);

    ponuda12.persist();

    Listic listic = new Listic()
      .setDatumUplate(LocalDate.now())
      .setIznos(new BigDecimal(100))
      .setParovi(Arrays.asList(ponuda11, ponuda12, ponuda1X));

    listic.persist();


    UplaceniListicRepository lRep = locator.resolve(UplaceniListicRepository.class);
    UplaceniListic list = lRep.findAll().get().get(0);

    logger.info("LIST: \n  Datum: {}\n  Dobio?: {}\n  Iznos: {}\n  Dobivam: {}\n  UkKoef: {}"
        , list.getDatumUplate()
        , list.getDobitniLisic()
        , list.getIznos()
        , list.getMoguciDobitak()
        , list.getUkupniKoeficijent());

  }
}
