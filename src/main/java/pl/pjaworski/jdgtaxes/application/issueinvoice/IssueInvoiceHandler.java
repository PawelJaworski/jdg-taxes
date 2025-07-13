package pl.pjaworski.jdgtaxes.application.issueinvoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pjaworski.jdgtaxes.domain.InvoiceIssuedEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents;

@Component
@RequiredArgsConstructor
class IssueInvoiceHandler {
    private final TaxPayerEvents taxPayerEvents;

    void issueInvoice(IssueInvoiceCmd cmd) {

    }
}
