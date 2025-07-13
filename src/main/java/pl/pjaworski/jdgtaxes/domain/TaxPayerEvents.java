package pl.pjaworski.jdgtaxes.domain;

import java.util.List;

public interface TaxPayerEvents {
    void registerTaxPayerEvent(TaxPayerEvent taxPayerEvent);

    <T extends TaxPayerEvent> List<T> findByNipAndType(String nip, Class<T> type);

    void deleteAll();
}
