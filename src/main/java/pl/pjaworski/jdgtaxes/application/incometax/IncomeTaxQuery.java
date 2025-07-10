package pl.pjaworski.jdgtaxes.application.incometax;

import java.time.YearMonth;

public record IncomeTaxQuery(String nip, YearMonth month) {
}
