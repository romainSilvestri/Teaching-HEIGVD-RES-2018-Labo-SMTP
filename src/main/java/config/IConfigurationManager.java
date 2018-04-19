/**
 * File: IConfigurationManager.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This interface contains all the methode to load and manage informations about victims.
 * (All informations are in files in the folder config).
 */

package config;

import model.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface IConfigurationManager {

    /**
     * Load (in config/victims.utf8), generates and return a list of victims
     * @param filename
     * @return The list of victims
     * @throws IOException
     */
    ArrayList<Person> loadVictims(String filename) throws IOException;

    ArrayList<Person> getListVictims();

    /**
     * Load (in config/victims.utf8), generates and return a list of message (who will be send to victims)
     * @param filename
     * @return The list of messages
     * @throws IOException
     */
    ArrayList<String> loadMessages(String filename) throws IOException;

    ArrayList<String> getListMessages();

    ArrayList<Person> getwitnessesToCC();

    int getSmtpServerPort();

    int getNumberOfGroups();

    String getSmtpServerAdress();
}
