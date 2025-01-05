package com.testingacademy.ex04012025.assersion.verification;
import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class TestAssersion004Assertj {

    @Test
    public void test_verify_assertj(){
    String name = "Shankar";
    assertThat("Shankar").isEqualTo("Shankar").isNotBlank();

        List<String> list = Arrays.asList("jay","Shankar","Prasad");
        assertThat(list).hasSize(3).isNotNull();

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        assertThat(localDate)
                .isAfterOrEqualTo(LocalDate.of(2021, 1, 1))
                .isBeforeOrEqualTo(LocalDate.of(2024, 12, 31))
                .isBetween(
                        LocalDate.of(2023, 1, 1),
                        LocalDate.of(2023, 12, 31)
                );


        File file = new File("Testdata.json");
        assertThat(file).exists().isFile().canRead();

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Jane", 30);

        assertThat(ages).hasSize(2).containsEntry("John",25).doesNotContainValue(40);
    }
}
