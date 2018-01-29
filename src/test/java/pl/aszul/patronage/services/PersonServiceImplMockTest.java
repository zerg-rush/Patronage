package pl.aszul.patronage.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import pl.aszul.patronage.domain.Person;

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
        Person retrievedPerson = personService.read(5);
        // Assert
        assertThat(retrievedPerson, is(equalTo(person)));

    }

    @Test
    public void shouldReturnPerson_whenSavePersonIsCalled() throws Exception {
        // Act
        Person savedPerson = personService.create(person);
        // Assert
        assertThat(savedPerson, is(equalTo(person)));
    }

    @Test
    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
        // Act
        personService.delete(5);
        // Assert
        verify(personService, times(1)).delete(5);
    }
}