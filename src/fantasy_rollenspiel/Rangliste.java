package fantasy_rollenspiel;

import java.util.List;

public class Rangliste {

    public static List<Spielcharakter> SortByHealth(List<Spielcharakter> pGespeicherteSpielcharakter)
    {
        int[] array = new int[pGespeicherteSpielcharakter.size()];

        for (int i = 0; i < array.length; i++)
            array[i] = pGespeicherteSpielcharakter.get(i).getLebenspunkte();

        array = InsertionSort(array);

        for (int i = 0; i < array.length; i++)
            pGespeicherteSpielcharakter.get(i).setLebenspunkte(array[i]);

        return pGespeicherteSpielcharakter;
    }

    public static int[] InsertionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            int j = i;
            temp = array[i];
            while (j > 0 && array[j - 1] < temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }

        return array;
    }

}
