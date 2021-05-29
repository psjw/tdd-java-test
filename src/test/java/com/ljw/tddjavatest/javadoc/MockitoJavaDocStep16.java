package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class Person3 {
    private Long id;
    private String name;

    public Person3() {
    }

    public Person3(Long id, String name) {
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
class MockitoJavaDocStep16 {

    @Test
    @DisplayName("16. Real partial mocks (Since 1.8.0)")
    void step_16_test() {
        //step1
        List list = spy(new LinkedList());

        //step2
        Person3 mock = mock(Person3.class);

        //step3
        when(mock.getName()).thenCallRealMethod();
    }
}


