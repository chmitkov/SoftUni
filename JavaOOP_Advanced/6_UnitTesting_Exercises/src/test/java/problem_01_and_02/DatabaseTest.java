package problem_01_and_02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final int SIXTEEN = 16;
    private static final int ZERO = 0;


    private Database database;
    private Person mockedPerson;

    @Before
    public void createListOfPersons() throws OperationNotSupportedException {
        this.database = new Database();
        this.mockedPerson = Mockito.mock(Person.class);
        Mockito.when(this.mockedPerson.getName()).thenReturn("Pesho");
        this.database.getPeople().add(mockedPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNegativeOrZeroId() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getId()).thenReturn(0L);
        this.database.add(this.mockedPerson);
    }

//    @Test
//    public void addPerson() throws OperationNotSupportedException {
//        int sizeBeforeAddedPerson = this.database.getPeople().size();
//        Mockito.when(this.mockedPerson.getId()).thenReturn(1L);
//        this.database.add(this.mockedPerson);
//        Assert.assertEquals(++sizeBeforeAddedPerson,sizeBeforeAddedPerson);
//    }


    @Test
    public void remove() throws OperationNotSupportedException {
        this.database.remove(this.mockedPerson);
        Assert.assertEquals(ZERO, this.database.getPeople().size());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyListOfPersons() throws OperationNotSupportedException {
        this.database.remove(this.mockedPerson);
        this.database.remove(this.mockedPerson);
    }

    @Test
    public void findByUsername() throws OperationNotSupportedException {
        Person person = this.database.findByUsername("Pesho");
        Assert.assertEquals("Pesho", person.getName());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameWithNullArgument() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test
    public void findById() throws OperationNotSupportedException {
        Person person = this.database.findById(0L);
        Assert.assertSame(0L, person.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdWithWrongId() throws OperationNotSupportedException {
        this.database.findById(2L);
    }
}