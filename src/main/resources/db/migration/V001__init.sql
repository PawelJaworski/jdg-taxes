create table tax_payer_event_wrapper
(
    id                            uuid not null,
    form_of_taxation_chosen_event jsonb,
    invoice_issued_event          jsonb,
    primary key (id)
);
