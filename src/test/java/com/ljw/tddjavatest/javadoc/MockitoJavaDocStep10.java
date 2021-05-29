package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep10 {

    @Test
    @DisplayName("10. Stubbing consecutive calls (iterator-style stubbing)")
    void step_10_test(){
        //step1
        List<String> mockedList = mock(List.class);

        //step2
        when(mockedList.get(anyInt()))
                .thenReturn("one")
                .thenReturn("two")
                .thenThrow(new RuntimeException());

        //step3
        assertThat(mockedList.get(0)).isEqualTo("one");
        assertThat(mockedList.get(0)).isEqualTo("two");
        assertThatThrownBy(() -> mockedList.get(0))
                .isInstanceOf(RuntimeException.class);
    }
}


