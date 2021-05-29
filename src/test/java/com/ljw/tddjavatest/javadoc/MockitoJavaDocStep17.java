package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep17 {

    @Test
    @DisplayName("17. Resetting mocks (Since 1.8.0)")
    void step_17_test() {
        //step1
        List mock = mock(List.class);

        //step2
        when(mock.size()).thenReturn(10);
        mock.add(1);

        //step3
        assertThat(mock.size()).isEqualTo(10);

        //step4
        reset(mock);

        //step5
        assertThat(mock.size()).isEqualTo(0);
    }
}


