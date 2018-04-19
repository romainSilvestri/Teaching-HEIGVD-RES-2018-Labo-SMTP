/**
 * File: Main.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This file create a new client who start a connection with the smtp server and do the prank
 */


import config.ConfigurationManager;
import model.PrankGenerator;
import smtp.SMTPClient;

import java.io.IOException;

public class Main {
    public static void main(String[] argv) throws IOException {
        ConfigurationManager conf = new ConfigurationManager();
        PrankGenerator generator = new PrankGenerator(conf);
        SMTPClient client = new SMTPClient(conf.getSmtpServerAdress(), conf.getSmtpServerPort(), generator.generatePranks());
        client.startPrank();
    }
}