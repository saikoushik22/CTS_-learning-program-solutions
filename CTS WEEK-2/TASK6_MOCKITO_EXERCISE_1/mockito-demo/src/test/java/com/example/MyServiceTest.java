package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MyServiceTest {

    @Test
    void testExternalApi() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub behaviour
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Use mock in service
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // 4. Assert + optional verify
        assertEquals("Mock Data", result);
        verify(mockApi).getData(); // proves the call happened
    }
}
