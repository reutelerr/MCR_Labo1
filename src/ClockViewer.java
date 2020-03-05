/*
 * Laboratoire : 01
 * Fichier     : ClockViewer.java
 * Auteur(s)   : Delhomme Claire, Reuteler Robin
 * Date        : 05.03.2020
 *
 * But         : Interface implémentée par les vues d'horloge
 */

public interface ClockViewer {
    /**
     * @brief   refreshes the view when notified by subject
     */
    public abstract void update();
}
