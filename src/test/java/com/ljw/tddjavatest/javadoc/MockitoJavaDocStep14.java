package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

class Person2 {
    private Long id;
    private String name;

    public Person2() {
    }

    public Person2(Long id, String name) {
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
class MockitoJavaDocStep14 {


    @Test
    @DisplayName("14. Changing default return values of unstubbed invocations (Since 1.7)")
    void step_14_test() {
        //step1
        Person2 mockedP = mock(Person2.class);
        assertThat(mockedP.getName()).isNull();

        //step2
        Person2 mockedSmartP = mock(Person2.class, RETURNS_SMART_NULLS);
        assertThat(mockedSmartP.getName()).isNotNull();
        assertThat(mockedSmartP.getName()).isEqualTo("");
    }
}


