package pl.pjaworski.jdgtaxes.domain;

import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceIssuedEvent(@NonNull String nip, @NonNull LocalDate invoiceDate, @NonNull BigDecimal amountNet) implements TaxPayerEvent {
}
