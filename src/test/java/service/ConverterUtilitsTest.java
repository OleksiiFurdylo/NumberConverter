package service;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 09.07.2018.
 */
public class ConverterUtilitsTest {

    @Test
    public void convertTralfmagorianPartsArrayToLong() throws Exception {
        ArrayList<String[]> transmadorianParts = ConverterUtilits.splitTralfamadorianToParts("γ++δ+β|");
        ConverterUtilits.createSpecialSymbolsToCompareWithQuantityOf(10);

        Assert.assertEquals(342, ConverterUtilits.convertTralfmagorianPartsArrayToLong(transmadorianParts));
    }

    @Test
    public void splitTralfamadorianToParts() throws Exception {
        ArrayList<String[]> transmadorianParts = ConverterUtilits.splitTralfamadorianToParts("γ++δ+β|");
        transmadorianParts.stream().forEach((i) -> System.out.println(i[0] + " " + i[1]));
    }

    @Test
    public void createSpecialSymbolsToCompare() throws Exception {


       ArrayList<String> test = ConverterUtilits.createSpecialSymbolsToCompareWithQuantityOf(10);
       Assert.assertEquals("++xxxx", test.get(10));
    }

}