package model;

import java.io.IOException;

import model.blog.KorisnickiPodaci;
import model.blog.Korisnik;
import model.blog.Post;

import org.joda.time.LocalDate;
import org.slf4j.Logger;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.patterns.ServiceLocator;

public class Main {
    public static void main(final String[] args) throws IOException {
        // An instance of Service Locator.
        // You can use it to fetch instances of repositories.
        final ServiceLocator locator = init();
        Logger logger = locator.resolve(Logger.class);
        logger.info("Filling or model with some data...");
        new Korisnik().setKorisnickiPodaci(new KorisnickiPodaci("pero@example.com", "Pero")).persist();

        Korisnik pero = new Korisnik.traziPoEmailu("pero@example.com").search().get(0);
        Post post = new Post()
	        .setAutor(pero)
	        .setDatumObjave(LocalDate.now())
	        .setNaslov("Prvi Post")
	        .setSadrzaj("Evo samo da bude nekog teksta...")
	        .persist();
        // TODO: Your code here
        logger.info("Finished.");

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
