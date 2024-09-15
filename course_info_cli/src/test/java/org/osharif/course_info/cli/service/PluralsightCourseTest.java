package org.osharif.course_info.cli.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PluralsightCourseTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            01:00:05,60
            00:35:00,35
            23:00:00.2548421,1380
            """)
    void testDurationInMinutes(String duration,int expected) {
        PluralsightCourse pluralsightCourse = new PluralsightCourse("1","fdfdf",duration,"fdsfdsf",false);
        assertEquals(expected,pluralsightCourse.durationInMinutes());
    }
}
