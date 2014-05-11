package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import model.Kladionica.Listic;
import model.Kladionica.Ponuda;
import model.Kladionica.Tekma;
import model.Kladionica.UplaceniListic;
import model.Kladionica.repositories.PonudaRepository;
import model.Kladionica.repositories.UplaceniListicRepository;

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


    //stvoriPonude(locator, logger);

    ispisiSvePonude(locator, logger);

    //uciniListic(locator, logger, Arrays.asList("1029","1031"), new BigDecimal(123));

    ispisiSveListice(locator, logger);

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


  private static void ispisiSveListice(ServiceLocator locator, Logger logger) throws Exception {
    List<UplaceniListic> ull = locator.resolve(UplaceniListicRepository.class).findAll().get();

    for(UplaceniListic ul : ull) {
      ispisiListic(ul, logger, locator);
    }
  }

  private static void uciniListic(ServiceLocator locator, Logger logger, Iterable<String> uris, BigDecimal ulog) throws Exception {


    PonudaRepository pr = locator.resolve(PonudaRepository.class);

    List<Ponuda> odabrane = pr.find(uris).get();

    Listic listic2 = new Listic()
      .setDatumUplate(LocalDate.now())
      .setIznos(ulog)
      .setParovi(odabrane);

    listic2.persist();


    UplaceniListic.findByID uls = new UplaceniListic.findByID(listic2.getID());
    UplaceniListic ul = uls.search(locator).get(0);
    ispisiListic(ul, logger, locator);

  }

  private static void ispisiListic(UplaceniListic ul, Logger logger, ServiceLocator locator) throws Exception {
    logger.info("###########################################################################");
    logger.info("###########################################################################");
    logger.info("\n  ID: {}\n  Datum: {}\n  Uplaceni iznos: {}\n  Ukupni koeficijent: {}\n  Moguci dobitak: {}\n"
    , ul.getID()
    , ul.getDatumUplate()
    , ul.getIznos()
    , ul.getUkupniKoeficijent()
    , ul.getMoguciDobitak()
    );
    ispisiPonude(locator, logger, ul.getParovi());
  }

  private static void ispisiSvePonude(ServiceLocator locator, Logger logger) throws Exception {
    Ponuda.aktivne a = new Ponuda.aktivne();

    List<Ponuda> ponude = a.search(locator);
    ispisiPonude(locator, logger, ponude);

  }

  private static void ispisiPonude(ServiceLocator locator, Logger logger, List<Ponuda> ponude) throws Exception {

    logger.info(String.format("%-6s  %-12s  %-12s  %-10s  %-5s  %-6s", "ID", "DOMACIN", "GOST", "TIP", "KOEF", "ISHOD"));
    logger.info("---------------------------------------------------------------");
    for (Ponuda p : ponude) {
      logger.info(String.format("%-6s  %-12s  %-12s  %-10s  %-5s  %-6s"
          , p.getURI()
          , p.getTekma().getDomacin()
          , p.getTekma().getGost()
          , p.getTip()
          , p.getKoeficijent()
          , p.getIshod()
          ));

    }
  }

  private static void stvoriPonude() throws Exception {

    Tekma tekma = new Tekma()
      .setDatumTekme(DateTime.now())
      .setDomacin("Hajduk")
      .setGost("Rijeka");

    Ponuda ponuda11 = new Ponuda()
      .setTekma(tekma)
      .setTip("Jedan")
      .setKoeficijent(new BigDecimal("1.5"))
      .setIstekla(false);

    ponuda11.persist();

    Ponuda ponuda1X = new Ponuda()
      .setTekma(tekma)
      .setTip("Iks")
      .setKoeficijent(new BigDecimal("2.1"))
      .setIstekla(false);

    ponuda1X.persist();


    Ponuda ponuda12 = new Ponuda()
      .setTekma(tekma)
      .setTip("Dva")
      .setKoeficijent(new BigDecimal("3.2"))
      .setIstekla(false);

    ponuda12.persist();

    Listic listic = new Listic()
      .setDatumUplate(LocalDate.now())
      .setIznos(new BigDecimal(100))
      .setParovi(Arrays.asList(ponuda11, ponuda12, ponuda1X));

    listic.persist();


    Tekma tekma2 = new Tekma()
    .setDatumTekme(DateTime.now())
    .setDomacin("Barcelona")
    .setGost("Real");

    Ponuda ponuda21 = new Ponuda()
      .setTekma(tekma2)
      .setTip("Jedan")
      .setKoeficijent(new BigDecimal("1.7"))
      .setIstekla(false);

    ponuda21.persist();

    Ponuda ponuda2X = new Ponuda()
      .setTekma(tekma2)
      .setTip("Iks")
      .setKoeficijent(new BigDecimal("1.9"))
      .setIstekla(false);

    ponuda2X.persist();


    Ponuda ponuda22 = new Ponuda()
      .setTekma(tekma2)
      .setTip("Dva")
      .setKoeficijent(new BigDecimal("2.1"))
      .setIstekla(false);

    ponuda22.persist();

    Listic listic2 = new Listic()
      .setDatumUplate(LocalDate.now())
      .setIznos(new BigDecimal(100))
      .setParovi(Arrays.asList(ponuda21, ponuda22, ponuda2X));

    listic2.persist();


  }
}
