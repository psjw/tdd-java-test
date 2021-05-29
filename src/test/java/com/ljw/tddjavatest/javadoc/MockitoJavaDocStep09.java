package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class Person {
    private Long id;
    private String name;

    public Person() {
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep09 {
    @Mock
    private Person person;

    @Test
    @DisplayName("9. Shorthand for mocks creation - @Mock annotation")
    void step_09_test(){
        //step1
        MockitoAnnotations.openMocks(this);

        //step2
        when(person.getName()).thenReturn("psjw");

        //step3
        assertThat(person.getName()).contains("psjw");

        //step4
        verify(person).getName();
    }
}


