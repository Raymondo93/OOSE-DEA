package oose.koenenkramers;

import nl.oose.dea.koenenkramers.KoenenDictionary;
import nl.oose.dea.koenenkramers.KramersDictionary;

/**
 * Created by Ray on 29/09/16.
 */
public class DictionaryAdapter implements IDictionary{
    private KoenenDictionary koenen;
    private KramersDictionary kramer;

    public DictionaryAdapter () {
        koenen = new KoenenDictionary();
        kramer = new KramersDictionary();
    }

    private String lookUp(String word) {
        return koenen.lookUp(word);
    }

    private String find(String word) {
        return kramer.find(word);
    }

    public String getWord(String word){
        String answer;
        word = word.toLowerCase();
        if (this.lookUp(word) != null) {
            answer = this.lookUp(word);
            return answer;
        } else if(this.find(word) != null) {
            answer = this.find(word);
            return answer;
        }
        return null;
    }
}
