package edu.uoc.pac1;

public class PAC1Ex2 {

    // Alkali metals data
    private static final double[] ALKALI_METALS_MASSES = {6.941, 22.990, 39.098, 85.468, 132.905};

    // Halogens data
    private static final double[] HALOGENS_MASSES = {18.998, 35.450, 79.904, 126.904};

    private static final double MIN_MOLAR_MASS_FOR_DRUGS = 150.0;
    private static final double MAX_MOLAR_MASS_FOR_DRUGS = 500.0;

    public static boolean isSuitableForDrugs(double molarMass) {
        return molarMass <= MAX_MOLAR_MASS_FOR_DRUGS && molarMass >= MIN_MOLAR_MASS_FOR_DRUGS;
    }

    public static double getAlkalineMetalMolarMass(int alkaliMetalIndex) {
        return ALKALI_METALS_MASSES[alkaliMetalIndex];
    }

    public static double getHalogenMolarMass(int halogenIndex) {
        return HALOGENS_MASSES[halogenIndex];
    }

    public static double calculateMolarMass(int alkaliMetalIndex, int alkalineMetalQuantity, int halogenIndex, int halogenQuantity) {
        double valorMassMolarAlok = getAlkalineMetalMolarMass(alkaliMetalIndex);
        double valorMassMolarHal = getHalogenMolarMass(halogenIndex);
        return valorMassMolarAlok * alkalineMetalQuantity + valorMassMolarHal * halogenQuantity;
    }

    public static String getStability(int alkaliAtoms, int halogenAtoms) {
        String stability;
        int sumAtoms = alkaliAtoms + halogenAtoms;
        stability = switch (sumAtoms) {
            case 2 -> "Very stable";
            case 3, 4 -> "Moderately stable";
            case 5, 6 -> "Very unstable";
            default -> "Unknown";
        };
        return stability;
    }

    public static void getCompoundsForDrugs(String[] compoundsNames, int[] alkaliMetalIndexes, int[] alkalineMetalQuantities, int[] halogenIndexes, int[] halogenQuantities) {
        //TODO
        System.out.println("Results of the compounds for drugs:");

        System.lineSeparator();
        for (int i=0; i<= compoundsNames.length; i++){
            double c = calculateMolarMass(alkaliMetalIndexes[i], alkalineMetalQuantities[i], halogenIndexes[i], halogenQuantities[i]);
            isSuitableForDrugs(c);
            System.out(compoundsNames + getStability(i));

        }
    }

}
