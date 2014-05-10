package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import model.AdressBook.Address;
import model.AdressBook.Person;
import model.AdressBook.repositories.PersonRepository;

import org.joda.time.LocalDate;
import org.slf4j.Logger;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.patterns.ServiceLocator;

public class Main {
    public static void main(final String[] args) throws Exception {
        // An instance of Service Locator.
        // You can use it to fetch instances of repositories.
        final ServiceLocator locator = init();

        final Address address = new Address()
          .setState("Kanada")
          .setCity("Vankuver")
          .setStreet("Cesta javorovog lista 100")
          .setZipcode(10000);

        final Person persona = new Person()
          .setName("Mali Pero")
          .setAddress(address);

        persona.persist();

//        PersonRepository pRepo = new PersonRepository(locator);
//        List<Person> persone = pRepo.findAll().get();
//
//        for(Person p: persone) {
//          p.delete();
//        }



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
        locator.resolve(Logger.class).info("Locator shutdown.");
        locator.resolve(java.util.concurrent.ExecutorService.class).shutdown();
    }
}
