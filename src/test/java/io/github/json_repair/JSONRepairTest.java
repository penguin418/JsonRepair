package io.github.json_repair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONRepairTest {

    @Test
    void repair() {
        // given
        String jsonString = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 30,\n" +
                "  \"cars\": {\n" +
                "    \"cab1\": \"F\"  \"rd\",\n" +
                "    \"cab2\": \"BMW\",\n" +
                "    \"cab3\": \"Fiat\"\n" +
                "  }\n" +
                "}";
        // when
        String result = JSONRepair.repair(jsonString);
        // then
        assertEquals("{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 30,\n" +
                "  \"cars\": {\n" +
                "    \"cab1\": \"F\\\"  \\\"rd\",\n" +
                "    \"cab2\": \"BMW\",\n" +
                "    \"cab3\": \"Fiat\"\n" +
                "  }\n" +
                "}", result);

    }
}