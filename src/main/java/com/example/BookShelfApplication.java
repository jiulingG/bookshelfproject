package com.example;

import com.google.inject.Guice;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BookShelfApplication extends Application<BookShelfConfiguration> {
    public static void main(String[] args) throws Exception {
        new BookShelfApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<BookShelfConfiguration> bootstrap) {
    }

    @Override
    public void run(BookShelfConfiguration configuration, Environment environment) {

//        Injector injector = makeInjector(configuration, environment); // write this function
//        final BookShelfResource resource = new BookShelfResource(
//                configuration.getBookShelf(), new BookShelfService(configuration, new BookRepository()));
        environment.jersey().register(Guice.createInjector(new ConfigurationModule(configuration,
                new BookRepository(), environment))
                .getInstance(BookShelfResource.class));
//        environment.jersey().register(BookShelfResource.class);
    }

//    private Injector makeInjector(BookShelfConfiguration configuration, Environment environment) {
//        return Guice.createInjector();
//    }
}
