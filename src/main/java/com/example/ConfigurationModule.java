package com.example;

import com.google.inject.AbstractModule;
import io.dropwizard.setup.Environment;

public class ConfigurationModule extends AbstractModule {
    private final BookShelfConfiguration bookShelfConfiguration;
    private final BookRepository bookRepository;
    private final Environment environment;

    public ConfigurationModule(BookShelfConfiguration bookShelfConfiguration,
                               BookRepository bookRepository, Environment environment) {
        this.bookShelfConfiguration = bookShelfConfiguration;
        this.environment = environment;
        this.bookRepository = bookRepository;
    }

    @Override
    protected void configure() {
        bind(BookShelfConfiguration.class).toInstance(bookShelfConfiguration);
        bind(RepositoryInterface.class).to(BookRepository.class);
        bind(BookRepository.class).toInstance(bookRepository);
        bind(Environment.class).toInstance(environment);
    }
}
