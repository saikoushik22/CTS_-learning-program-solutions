package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MyServiceCaptorTest {

    @Test
    void capturesSentPayload() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.save("hello-world");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockApi).sendData(captor.capture());

        assertEquals("hello-world", captor.getValue());
    }
}
