package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Vehicle;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceImplSpyTest {
    @Spy
    private VehicleServiceImpl vehicleServiceSpy;

    @Mock
    private Vehicle vehicle;

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetVehicleByIdIsCalledWithoutContext() throws Exception {
        //Act
        Vehicle retrievedVehicle = vehicleServiceSpy.getVehicleById(5);
        //Assert
        assertThat(retrievedVehicle, is(equalTo(vehicle)));
    }

    public void shouldThrowNullPointerException_whenSaveVehicleIsCalledWithoutContext() throws Exception {
        //Act
        Vehicle savedVehicle = vehicleServiceSpy.saveVehicle(vehicle);
        //Assert
        assertThat(savedVehicle, is(equalTo(vehicle)));
    }

    @Test
    public void shouldVerifyThatGetVehicleByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(vehicle).when(vehicleServiceSpy).getVehicleById(5);
        //Act
        Vehicle retrievedVehicle = vehicleServiceSpy.getVehicleById(5);
        //Assert
        Mockito.verify(vehicleServiceSpy).getVehicleById(5);
    }

    @Test
    public void shouldVerifyThatSaveVehicleIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(vehicle).when(vehicleServiceSpy).getVehicleById(5);
        //Act
        Vehicle retrievedVehicle = vehicleServiceSpy.getVehicleById(5);
        //Assert
        Mockito.verify(vehicleServiceSpy,never()).saveVehicle(vehicle);
    }
}