package pl.pjaworski.jdgtaxes.infrastructure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents;

import java.util.List;
import java.util.UUID;

@ConditionalOnMissingBean(TaxPayerEvents.class)
public interface TaxPayerEventsJpaRepository extends JpaRepository<TaxPayerEventWrapper, UUID>, TaxPayerEvents {

    @Override
    default void registerTaxPayerEvent(TaxPayerEvent taxPayerEvent) {
        save(new TaxPayerEventWrapper(taxPayerEvent));
    }

    @Override
    default <T extends TaxPayerEvent>List<T> findByNipAndType(String nip, Class<T> type) {
        return findAll().stream()
                .map(TaxPayerEventWrapper::toTaxPayerEvent)
                .filter(it -> it.nip().equals(nip))
                .filter(it -> it.getClass().equals(type))
                .map(it -> (T)it)
                .toList();
    }
}
