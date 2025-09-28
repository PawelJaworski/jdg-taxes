package pl.pjaworski.jdgtaxes.testutil;

import java.time.LocalDate;
import java.time.YearMonth;

public interface TestDataExamples {
    String NIP = "123-456-32-18";
    LocalDate AUG_01_2025 = LocalDate.parse("2025-08-01");
    LocalDate SEP_01_2025 = LocalDate.parse("2025-09-01");
    YearMonth AUG_2025 = YearMonth.parse("2025-08");
    YearMonth SEP_2025 = YearMonth.parse("2025-09");
}
