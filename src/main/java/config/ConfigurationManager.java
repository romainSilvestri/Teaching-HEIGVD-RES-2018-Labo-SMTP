/**
 * File: ConfigurationManager.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This class contains the implementation of the interface IConfigurationManager
 */


package config;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigurationManager implements IConfigurationManager {
    private String smtpServerAdress;
    private int smtpServerPort;
    private int numberOfGroups;
    private ArrayList<Person> witnessesToCC;
    private ArrayList<Person> listVictims;
    private ArrayList<String> listMessages;

    public ConfigurationManager() throws IOException {
        listVictims = loadVictims("./config/victims.utf8");
        listMessages = loadMessages("./config/messages.utf8");
        getSMTPConf("./config/config.properties");
    }

    public ArrayList<Person> loadVictims(String filename) throws IOException {
        ArrayList<Person> victims = new ArrayList<Person>();
        FileInputStream file = new FileInputStream(filename);
        BufferedReader in = new BufferedReader(new InputStreamReader(file));
        String mail;
        while ((mail = in.readLine()) != null) {
            victims.add(new Person(mail));
        }
        return victims;
    }

    public ArrayList<Person> getListVictims() {
        return listVictims;
    }

    public ArrayList<String> loadMessages(String filename) throws IOException {
        ArrayList<String> messages = new ArrayList<String>();
        FileInputStream file = new FileInputStream(filename);
        BufferedReader in = new BufferedReader(new InputStreamReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = in.readLine()) != null) {
            if (line.equals("==")) {
                messages.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(line).append("\n");
            }
        }
        return messages;

    }

    public ArrayList<String> getListMessages() {
        return listMessages;
    }

    public ArrayList<Person> getwitnessesToCC() {
        return witnessesToCC;
    }

    public int getSmtpServerPort() {
        return smtpServerPort;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public String getSmtpServerAdress() {
        return smtpServerAdress;
    }

    private void getSMTPConf(String filename) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(filename);
        properties.load(file);
        numberOfGroups = Integer.parseInt(properties.getProperty("numberOfGroups"));
        smtpServerAdress = properties.getProperty("smtpServerAdress");
        smtpServerPort = Integer.parseInt(properties.getProperty("smtpServerPort"));
        witnessesToCC = new ArrayList<Person>();

        String loadedWitnesses = properties.getProperty("witnessesToCC");
        String[] splitedWitness = loadedWitnesses.split(",");
        for(String s : splitedWitness){
            witnessesToCC.add(new Person(s));
        }
    }
}
