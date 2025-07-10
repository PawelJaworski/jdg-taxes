package pl.pjaworski.jdgtaxes.application.chooseformoftaxation;

import java.util.function.Consumer;

import static pl.pjaworski.jdgtaxes.testutil.TestDataExamples.NIP;

public interface ChooseFormOfTaxationHandlerAbility {
    ChooseFormOfTaxationHandler INSTANCE = new ChooseFormOfTaxationHandler();

    default void choose_form_of_taxation(Consumer<ChooseFormOfTaxationCmd.ChooseFormOfTaxationCmdBuilder> useCase) {
        var cmd = ChooseFormOfTaxationCmd.builder()
                .nip(NIP);
        useCase.accept(cmd);
        getChooseFormOfTaxationHandler().chooseFormOfTaxation(cmd.build());
    }

    default ChooseFormOfTaxationHandler getChooseFormOfTaxationHandler() {
        return INSTANCE;
    }
}