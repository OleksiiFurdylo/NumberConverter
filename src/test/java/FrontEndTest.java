import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ConverterUtilits;

/**
 * Created by OleksiiF on 09.07.2018.
 */
public class FrontEndTest {

    @Before
    public void prepareEnvironment(){
        ConverterUtilits.createSpecialSymbolsToCompareWithQuantityOf(20);
    }

    @Test
    public void mainOutput2018() throws Exception {
        long expected = 2018L;
        long actual =
        ConverterUtilits
                .convertTralfmagorianPartsArrayToLong(
                        ConverterUtilits
                                .splitTralfamadorianToParts("β+xα+θ|")
                );
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mainAllExamplesInput(){

        Assert.assertEquals
                (ConverterUtilits.convertTralfmagorianPartsArrayToLong(
                        ConverterUtilits.splitTralfamadorianToParts("α|")
                ), 1);

        Assert.assertEquals
                (ConverterUtilits.convertTralfmagorianPartsArrayToLong(
                        ConverterUtilits.splitTralfamadorianToParts("γ++δ+β|")
                ), 342);

        Assert.assertEquals
                (ConverterUtilits.convertTralfmagorianPartsArrayToLong(
                        ConverterUtilits.splitTralfamadorianToParts("ι+x")
                ), 9000);
    }


}