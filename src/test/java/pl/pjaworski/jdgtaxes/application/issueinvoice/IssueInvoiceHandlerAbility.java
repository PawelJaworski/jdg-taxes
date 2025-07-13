package pl.pjaworski.jdgtaxes.application.issueinvoice;

import pl.pjaworski.jdgtaxes.domain.TaxPayerEventsAbility;

import java.util.function.Consumer;

import static pl.pjaworski.jdgtaxes.testutil.TestDataExamples.NIP;

public interface IssueInvoiceHandlerAbility {
    IssueInvoiceHandler INSTANCE = new IssueInvoiceHandler(TaxPayerEventsAbility.INSTANCE);

    default void issue_invoice(Consumer<IssueInvoiceCmd.IssueInvoiceCmdBuilder> useCase) {
      var cmd = IssueInvoiceCmd.builder()
                      .nip(NIP);
      useCase.accept(cmd);
      getIssueInvoiceHandler().issueInvoice(cmd.build());
    }

    default IssueInvoiceHandler getIssueInvoiceHandler() {
        return INSTANCE;
    }
}