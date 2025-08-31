package pl.pjaworski.jdgtaxes.application.chooseformoftaxation;

import pl.pjaworski.jdgtaxes.domain.TaxPayerEventsAbility;

import java.util.function.Consumer;

import static pl.pjaworski.jdgtaxes.testutil.TestDataExamples.NIP;

public interface ChooseFormOfTaxationHandlerAbility {
    ChooseFormOfTaxationHandler INSTANCE = new ChooseFormOfTaxationHandler(TaxPayerEventsAbility.INSTANCE);

    default ChooseFormOfTaxationCmd choose_form_of_taxation(Consumer<ChooseFormOfTaxationCmd.ChooseFormOfTaxationCmdBuilder> useCase) {
        var cmd = ChooseFormOfTaxationCmd.builder()
                .nip(NIP);
        useCase.accept(cmd);
        getChooseFormOfTaxationHandler().chooseFormOfTaxation(cmd.build());

        return cmd.build();
    }

    default ChooseFormOfTaxationHandler getChooseFormOfTaxationHandler() {
        return INSTANCE;
    }
}