package pl.pjaworski.jdgtaxes.domain;

import pl.pjaworski.jdgtaxes.infrastructure.TaxPayerEventsInMemoryImpl;

public interface TaxPayerEventsAbility {
    TaxPayerEvents INSTANCE = new TaxPayerEventsInMemoryImpl();

    default void cleanupTaxPayerEvents() {
        getTaxPayerEvents().deleteAll();
    }

    default TaxPayerEvents getTaxPayerEvents() {
        return INSTANCE;
    }
}