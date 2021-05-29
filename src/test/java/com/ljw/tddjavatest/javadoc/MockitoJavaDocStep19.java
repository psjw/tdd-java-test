package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep19 {

    @Test
    @DisplayName("19. Aliases for behavior driven development (Since 1.8.0)")
    void step_19_test() {
        //step1 :  given
        List<String> mockedList = mock(List.class);
        given(mockedList.get(0)).willReturn("one");

           //when
        String value = mockedList.get(0);

        //then
        assertThat(value).isEqualTo("one");
        then(mockedList).should(times(1)).get(0);
    }
}


