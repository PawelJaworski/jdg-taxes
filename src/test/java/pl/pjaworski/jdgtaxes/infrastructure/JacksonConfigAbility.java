package pl.pjaworski.jdgtaxes.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public interface JacksonConfigAbility {
    JacksonConfig INSTANCE = new JacksonConfig();

    @SneakyThrows
    default void generateJson(Object dto, String fileName) {
        var directoryPath = "./public/";
        Path directory = Path.of(directoryPath).getParent();
        Files.createDirectories(directory);

        BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + fileName));


        writer.write(getObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(dto));

        writer.close();
    }

    default ObjectMapper getObjectMapper() {
        return getJacksonConfig().jackson2ObjectMapperBuilder().build();
    }

    default JacksonConfig getJacksonConfig() {
        return INSTANCE;
    }
}
