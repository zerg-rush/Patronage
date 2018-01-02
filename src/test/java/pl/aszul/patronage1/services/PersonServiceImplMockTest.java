package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Person;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonServiceImplMockTest {

    private PersonServiceImpl personService;

    @Mock
    private Person person;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        personService = new PersonServiceImpl();
    }

    @Test
    public void shouldReturnPerson_whenGetPersonByIdIsCalled() throws Exception {
        // Act
        Person retrievedPerson = personService.getPersonById(5);
        // Assert
        assertThat(retrievedPerson, is(equalTo(person)));

    }

    @Test
    public void shouldReturnPerson_whenSavePersonIsCalled() throws Exception {
        // Act
        Person savedPerson = personService.savePerson(person);
        // Assert
        assertThat(savedPerson, is(equalTo(person)));
    }

    @Test
    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
        // Act
        personService.deletePerson(5);
        // Assert
        verify(personService, times(1)).deletePerson(5);
    }
}