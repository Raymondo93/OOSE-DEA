/**
 * Created by Ray on 15/09/16.
 */
public class Lottomachine {

    private Scorebord s;
    private GlazenBol g;

    public void voerTrekkingUit() {
        g.verzamelAlleBallen();
        s.maakLeeg();

        for (int i = 0; i < 6, i++) {
            s.plaatsBal(g.schepBal());
        }

    }
}
