package item6;

import chapter2.item6.adapater.BugattiVeyron;
import chapter2.item6.adapater.Movable;
import chapter2.item6.adapater.MovableAdapter;
import chapter2.item6.adapater.MovableAdapterImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BugattiVeyronTest {
    @Test
    public void whenConvertingMPHtoKMPH_thenSuccessfullyConverted() {
        Movable bugattiVeyron = new BugattiVeyron();
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

        assertEquals(bugattiVeyronAdapter.getSpeed(), 431.30312, 0.00001);
    }
}
