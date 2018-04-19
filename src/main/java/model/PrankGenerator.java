/**
 * File: PrankGenerator.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This class generates the prank that the client will send to the victims.
 * It use the configurationManager class to load the informations.
 */

package model;

import config.ConfigurationManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

public class PrankGenerator {

    private ConfigurationManager conf;
    private static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());

    public PrankGenerator(ConfigurationManager conf) {
        this.conf = conf;
    }

    public ArrayList<Prank> generatePranks() {
        ArrayList<Prank> result = new ArrayList<Prank>();

        // Loading data from the conf file
        ArrayList<String> messages = conf.getListMessages();
        int nbGroups = conf.getNumberOfGroups();
        ArrayList<Person> victims = conf.getListVictims();
        ArrayList<Person> toCC = conf.getwitnessesToCC();

        // Checking if the number of groups is correct (we must have at least 3 people per group). Correct the number of groups to achieve it.
        if (victims.size() / nbGroups < 3) {
            nbGroups = victims.size() / 3;
            LOG.warning("Not enough victims for the number of groups. A group require at least 3 people. Creating " + nbGroups + " groups.");
        }

        ArrayList<Group> groups = new ArrayList<Group>();

        for (int i = 0; i < nbGroups; ++i) {
            groups.add(new Group());
        }

        // Randomizing the groups
        Collections.shuffle(victims);

        // Adding people to the groups until all the victims are in a group.
        for (int i = 0; i < victims.size(); ++i) {
            groups.get(i % nbGroups).addToGroupe(victims.get(i));
        }

        // Randomizing the messages
        Collections.shuffle(messages);

        int i = 0;
        // creating the pranks
        for(Group g : groups){
            ArrayList<Person> prankVictims = g.getGroup();

            result.add(new Prank(prankVictims.remove(0), prankVictims, toCC, messages.get(i++)));
            i %= messages.size();
        }

        return result;
    }
}