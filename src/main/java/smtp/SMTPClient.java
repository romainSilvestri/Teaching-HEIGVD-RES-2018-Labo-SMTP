package smtp;

import model.Person;
import model.Prank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SMTPClient {
    private Socket socketClient;
    private String smtpServerAdress;
    private int smtpServerPort;
    private BufferedReader input;
    private PrintWriter output;
    private ArrayList<Prank> pranks;


    public SMTPClient(String smtpServerAdress, int smtpServerPort, ArrayList<Prank> pranks){
        this.smtpServerAdress = smtpServerAdress;
        this.smtpServerPort = smtpServerPort;
        this.pranks = pranks;
    }

    public void sentToServer(String s){
        output.println(s);
        output.flush();
    }

    public void startPrank(){
        try {
            socketClient = new Socket(smtpServerAdress, smtpServerPort);
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output = new PrintWriter(socketClient.getOutputStream());

            input.readLine();

            sentToServer(Protocol.CMD_HELLO);

            String response;

            do{
                response = input.readLine();
                response = response.substring(3, 4);
            }while (response.equals("-"));

            // Sending the prank intels to the server
            for(Prank p : pranks){

                // Sender
                sentToServer(Protocol.CMD_MAIL_FROM + p.getSender().getMail());
                input.readLine();

                // Victims
                for(Person person : p.getVictims()){
                    sentToServer(Protocol.CMD_RCPT_TO + person.getMail());
                    input.readLine();
                }

                // Witnesses
                for(Person person : p.getWitnessesToCC()){
                    sentToServer(Protocol.CMD_RCPT_TO + person.getMail());
                    input.readLine();
                }

                sentToServer(Protocol.CMD_DATA);
                input.readLine();

                StringBuilder data = new StringBuilder();
                data.append("From: ").append(p.getSender().getMail());

                data.append("\r\n").append("To: ");
                for(Person person : p.getVictims()){
                    data.append(person.getMail());
                    if(!person.equals(p.getVictims().get(p.getVictims().size()-1))){
                        data.append(", ");
                    }
                }

                data.append("\r\n").append("CC: ");
                for(Person person : p.getWitnessesToCC()){
                    data.append(person.getMail());
                    if(!person.equals(p.getWitnessesToCC().get(p.getWitnessesToCC().size()-1))){
                        data.append(", ");
                    }
                }

                data.append("\r\n").append(p.getMessage()).append(Protocol.CMD_END_DATA);
                sentToServer(data.toString());

                input.readLine();
            }

            sentToServer(Protocol.CMD_QUIT);
            socketClient.close();
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

