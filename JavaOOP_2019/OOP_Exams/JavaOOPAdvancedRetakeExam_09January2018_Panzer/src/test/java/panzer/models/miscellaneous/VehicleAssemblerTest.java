package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.models.Parts.ArsenalPart;
import panzer.models.Parts.EndurancePart;
import panzer.models.Parts.ShellPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {

    private static final Double ONE = 1D;
    private static final int TWO = 2;
    private static final BigDecimal PRICE_DEFAULT_VALUE = new BigDecimal("10");
    private static final BigDecimal TOTAL_PRICE_EXPECTED_VALUE = new BigDecimal("30");
    private static final Integer MODIFIER_DEFAULT_VALUE = 100;

    private VehicleAssembler vehicleAssembler;

    @Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();
        ArsenalPart arsenalPart = Mockito.mock(ArsenalPart.class);
        Mockito.when(arsenalPart.getWeight()).thenReturn(ONE);
        Mockito.when(arsenalPart.getPrice()).thenReturn(PRICE_DEFAULT_VALUE);
        Mockito.when(arsenalPart.getAttackModifier()).thenReturn(MODIFIER_DEFAULT_VALUE);

        ShellPart shellPart = Mockito.mock(ShellPart.class);
        Mockito.when(shellPart.getPrice()).thenReturn(PRICE_DEFAULT_VALUE);
        Mockito.when(shellPart.getDefenseModifier()).thenReturn(MODIFIER_DEFAULT_VALUE);

        EndurancePart endurancePart = Mockito.mock(EndurancePart.class);
        Mockito.when(endurancePart.getPrice()).thenReturn(PRICE_DEFAULT_VALUE);
        Mockito.when(endurancePart.getHitPointsModifier()).thenReturn(MODIFIER_DEFAULT_VALUE);


        this.vehicleAssembler.addArsenalPart(arsenalPart);
        this.vehicleAssembler.addShellPart(shellPart);
        this.vehicleAssembler.addEndurancePart(endurancePart);

    }

    @Test
    public void getTotalWeight() {
        assertEquals(ONE, this.vehicleAssembler.getTotalWeight(), 0.0);
    }

    @Test
    public void getTotalPrice() {
        assertEquals(TOTAL_PRICE_EXPECTED_VALUE, this.vehicleAssembler.getTotalPrice());
    }

    @Test
    public void getTotalAttackModification() {
        assertEquals((int) MODIFIER_DEFAULT_VALUE, this.vehicleAssembler.getTotalAttackModification());
    }

    @Test
    public void getTotalDefenseModification() {
        assertEquals((int) MODIFIER_DEFAULT_VALUE, this.vehicleAssembler.getTotalDefenseModification());
    }

    @Test
    public void getTotalHitPointModification() {
        assertEquals((int) MODIFIER_DEFAULT_VALUE, this.vehicleAssembler.getTotalHitPointModification());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addArsenalPart() {
        try {
            Field arsenalPartsField = this.vehicleAssembler.getClass()
                    .getDeclaredField("arsenalParts");
            arsenalPartsField.setAccessible(true);

            ArsenalPart arsenalPart = Mockito.mock(ArsenalPart.class);
            this.vehicleAssembler.addArsenalPart(arsenalPart);

            List<ArsenalPart> arsenalParts =
                    (List<ArsenalPart>) arsenalPartsField.get(this.vehicleAssembler);

            Assert.assertEquals(TWO, arsenalParts.size());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addShellPart() {
        try {
            Field shellPartsField = this.vehicleAssembler.getClass()
                    .getDeclaredField("shellParts");
            shellPartsField.setAccessible(true);

            ShellPart shellPart = Mockito.mock(ShellPart.class);
            this.vehicleAssembler.addShellPart(shellPart);

            List<ShellPart> shellParts =
                    (List<ShellPart>) shellPartsField.get(this.vehicleAssembler);

            Assert.assertEquals(TWO, shellParts.size());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addEndurancePart() {
        try {
            Field endurancePartsField = this.vehicleAssembler.getClass()
                    .getDeclaredField("enduranceParts");
            endurancePartsField.setAccessible(true);

            EndurancePart endurancePart = Mockito.mock(EndurancePart.class);
            this.vehicleAssembler.addEndurancePart(endurancePart);

            List<EndurancePart> enduranceParts =
                    (List<EndurancePart>) endurancePartsField.get(this.vehicleAssembler);

            Assert.assertEquals(TWO, enduranceParts.size());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}