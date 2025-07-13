package pl.pjaworski.jdgtaxes.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceIssuedEvent(String nip, LocalDate invoiceDate, BigDecimal amountNet) implements TaxPayerEvent {
}
