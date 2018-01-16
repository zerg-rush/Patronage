package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Vehicle;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleServiceHashMapMockTest {

    private VehicleServiceHashMap vehicleService;

    @Mock
    private Vehicle vehicle;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        vehicleService = new VehicleServiceHashMap();
    }

    @Test
    public void shouldReturnVehicle_whenGetVehicleByIdIsCalled() throws Exception {
        // Act
        Vehicle retrievedVehicle = vehicleService.getVehicleById(5);
        // Assert
        assertThat(retrievedVehicle, is(equalTo(vehicle)));

    }

    @Test
    public void shouldReturnVehicle_whenSaveVehicleIsCalled() throws Exception {
        // Act
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        // Assert
        assertThat(savedVehicle, is(equalTo(vehicle)));
    }

    @Test
    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
        // Act
        vehicleService.deleteVehicle(5);
        // Assert
        verify(vehicleService, times(1)).deleteVehicle(5);
    }
}