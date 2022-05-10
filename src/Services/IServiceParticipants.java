/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Participants;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author sofia
 */
public interface IServiceParticipants {
    public ObservableList<Participants> GetParticipant(String trie) throws SQLException;
     public void AddParticipants(Participants par);
}
