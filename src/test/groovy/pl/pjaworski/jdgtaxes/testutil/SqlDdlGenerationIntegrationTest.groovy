package pl.pjaworski.jdgtaxes.testutil

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
@SpringBootTest
@ActiveProfiles(["test", "sql-ddl"])
class SqlDdlGenerationIntegrationTest extends Specification {
    def "should generate sql"() {
        expect:
        true
    }
}
