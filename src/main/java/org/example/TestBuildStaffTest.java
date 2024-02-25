package org.example;

import org.example.domain.person.Staff;

import java.time.LocalDate;

public class TestBuildStaffTest {
    public static Staff getStaff(){
        return  new Staff(
                "Цветков",
                "Иван",
                "Маркович",
                LocalDate.of(1950,11,12),
                "+7(977)9679518",
                "Водитель");
    }
}
