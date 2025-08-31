package pl.pjaworski.jdgtaxes.infrastructure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents;

import java.util.ArrayList;
import java.util.List;

@ConditionalOnMissingBean(TaxPayerEvents.class)
@Component
public class TaxPayerEventsInMemoryImpl implements TaxPayerEvents {

    private final List<TaxPayerEvent> taxPayerEvents = new ArrayList<>();

    @Override
    public void registerTaxPayerEvent(TaxPayerEvent taxPayerEvent) {
        taxPayerEvents.add(taxPayerEvent);
    }

    @Override
    public <T extends TaxPayerEvent>List<T> findByNipAndType(String nip, Class<T> type) {
        return taxPayerEvents.stream()
                .filter(it -> it.nip().equals(nip))
                .filter(it -> it.getClass().equals(type))
                .map(it -> (T)it)
                .toList();
    }

    @Override
    public void deleteAll() {
        taxPayerEvents.clear();
    }
}
