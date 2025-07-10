package pl.pjaworski.jdgtaxes.application.issueinvoice;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record IssueInvoiceCmd(String nip, LocalDate invoiceDate, BigDecimal amountNet) {
}
