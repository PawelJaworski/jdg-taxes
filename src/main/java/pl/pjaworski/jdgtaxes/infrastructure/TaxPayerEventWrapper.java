package pl.pjaworski.jdgtaxes.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationChosenEvent;
import pl.pjaworski.jdgtaxes.domain.InvoiceIssuedEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvent;

import java.util.UUID;

@Entity
@Immutable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaxPayerEventWrapper {
    @Id
    @GeneratedValue
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    private FormOfTaxationChosenEvent formOfTaxationChosenEvent;

    @JdbcTypeCode(SqlTypes.JSON)
    private InvoiceIssuedEvent invoiceIssuedEvent;

    public TaxPayerEventWrapper(TaxPayerEvent taxPayerEvent) {
        switch (taxPayerEvent) {
            case FormOfTaxationChosenEvent formOfTaxationChosenEvent:
                this.formOfTaxationChosenEvent = formOfTaxationChosenEvent;
                break;
            case InvoiceIssuedEvent invoiceIssuedEvent:
                this.invoiceIssuedEvent = invoiceIssuedEvent;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public TaxPayerEvent toTaxPayerEvent() {
        return formOfTaxationChosenEvent != null ? formOfTaxationChosenEvent : invoiceIssuedEvent;
    }
}
