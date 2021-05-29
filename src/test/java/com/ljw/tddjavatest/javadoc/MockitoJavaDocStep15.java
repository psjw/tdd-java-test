package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep15 {

    @Test
    @DisplayName("15. Capturing arguments for further assertions (Since 1.8.0)")
    void step_15_test() {
        //step1
        List mockedList = mock(List.class);

        //step2
        mockedList.add("one");
        mockedList.add("two");

        //step3
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockedList, times(2)).add(argumentCaptor.capture());

        //step4
        final List<String> allValues = argumentCaptor.getAllValues();
        assertThat(allValues.get(0)).isEqualTo("one");
        assertThat(allValues.get(1)).isEqualTo("two");
    }
}


