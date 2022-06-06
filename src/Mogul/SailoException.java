package Mogul;

/**
 * Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille
 * @author Topi
 * @version 20.3.2022
 *
 */
public class SailoException extends Exception {
    
    private static final long serialVersionUID = 1L;

    
    /**
     * Poikkeuksen muodostaja jolle tuodaan poikkeuksessa käytettävä viesti
     * @param viesti Poikkeuksen viesti
     */
    public SailoException(String viesti) {
        super(viesti);
    }
}
