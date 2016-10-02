package oose.koenenkramers;

import nl.oose.dea.koenenkramers.KoenenDictionary;
import nl.oose.dea.koenenkramers.KramersDictionary;


/**
 * Created by Ray on 30/09/16.
 */
public class DictionaryAdapter implements IDictionary {

    private KoenenDictionary koenen;
    private KramersDictionary kramers;

<<<<<<< Updated upstream
    public DictionaryAdapter () {
        koenen = new KoenenDictionary();
        kramer = new KramersDictionary();
=======
    public DictionaryAdapter() {

>>>>>>> Stashed changes
    }

    private String getKoenen(String input) {
        return koenen.lookUp(input);
    }

    private String getKramers(String input) {
        return kramers.find(input);
    }

    public String translate(String input) {
        String answer = getKoenen(input);
        if (answer == null) {
            answer = getKramers(input);
            return answer;
        } else {
            answer = "No answer";
            return answer;
        }
    }
}
