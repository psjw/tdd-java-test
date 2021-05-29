package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import java.util.List;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;


@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep06 {
    @Test
    @DisplayName("6. Verification in order")
    void step_06_test(){
        //step1
        List singleMock = mock(List.class);

        //step2
        singleMock.add("was added first");
        singleMock.add("was added second");

        //step3
        InOrder inOrder = inOrder(singleMock);

        //step4
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        //step5
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //step6
        firstMock.add("was called first");
        secondMock.add("was called second");

        //step7
        InOrder inOrderTwo = inOrder(firstMock, secondMock);

        //step8
        inOrderTwo.verify(firstMock).add("was called first");
        inOrderTwo.verify(secondMock).add("was called second");
    }
}

