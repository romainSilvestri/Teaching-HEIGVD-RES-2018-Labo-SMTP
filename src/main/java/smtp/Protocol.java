/**
 * File: Protocol.java
 * Author: Romain Silvestri & Guillaume Blanco
 *
 * This class contains all the constant that the client use to speak with the server
 */
package smtp;

public class Protocol {

    public final static String CMD_END_DATA = "\r\n.\r\n";
    public final static String CMD_MAIL_FROM = "MAIL FROM: ";
    public final static String CMD_QUIT = "quit\r\n";
    public final static String CMD_RCPT_TO = "RCPT TO: ";
    public final static String CMD_DATA = "DATA";
    public final static String CMD_HELLO = "EHLO ";
}
