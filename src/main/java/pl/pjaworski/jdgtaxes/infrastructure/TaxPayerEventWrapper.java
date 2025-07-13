package pl.pjaworski.jdgtaxes.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvent;

import java.util.UUID;

@Entity
@Immutable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaxPayerEventWrapper {
    @Id
    @GeneratedValue
    private UUID id;

    public TaxPayerEventWrapper(TaxPayerEvent taxPayerEvent) {

    }

    public TaxPayerEvent toTaxPayerEvent() {
        return null;
    }
}
