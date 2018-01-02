package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Person;

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
public class PersonServiceImplSpyTest {
    @Spy
    private PersonServiceImpl personServiceSpy;

    @Mock
    private Person person;

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetPersonByIdIsCalledWithoutContext() throws Exception {
        //Act
        Person retrievedPerson = personServiceSpy.getPersonById(5);
        //Assert
        assertThat(retrievedPerson, is(equalTo(person)));
    }

    public void shouldThrowNullPointerException_whenSavePersonIsCalledWithoutContext() throws Exception {
        //Act
        personServiceSpy.savePerson(person);
        Person savedPerson = personServiceSpy.getPersonById(person.getId());
        //Assert
        assertThat(savedPerson, is(equalTo(person)));
    }

    @Test
    public void shouldVerifyThatGetPersonByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(person).when(personServiceSpy).getPersonById(5);
        //Act
        Person retrievedPerson = personServiceSpy.getPersonById(5);
        //Assert
        Mockito.verify(personServiceSpy).getPersonById(5);
    }

    @Test
    public void shouldVerifyThatSavePersonIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(person).when(personServiceSpy).getPersonById(5);
        //Act
        Person retrievedPerson = personServiceSpy.getPersonById(5);
        //Assert
        Mockito.verify(personServiceSpy,never()).savePerson(person);
    }
}