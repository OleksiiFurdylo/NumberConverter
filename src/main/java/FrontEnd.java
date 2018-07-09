import service.ConverterUtilits;

import java.util.Scanner;

/**
 * Created by OleksiiF on 08.07.2018.
 */
public class FrontEnd {
    public static void main(String[] args) {
        ConverterUtilits.createSpecialSymbolsToCompareWithQuantityOf(20);

        System.out.println("Enter String representation of Transmadorian number:");
        Scanner in = new Scanner(System.in);
        String userInput = in.next();

        if(userInput.matches("[αβ+xα+θ|γδεζηθι].*")) {

            System.out.println("Decimal representation of Transmadorian number is:");
            System.out.println(ConverterUtilits
                    .convertTralfmagorianPartsArrayToLong(
                            ConverterUtilits
                                    .splitTralfamadorianToParts(userInput)
                    ));
        } else {
            System.out.println("Input is not valid");
        }

    }
}
