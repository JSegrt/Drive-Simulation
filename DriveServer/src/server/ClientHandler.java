/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;

/**
 *
 * @author Cartman
 */
public class ClientHandler {
    Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    
    public void handleClient() throws IOException{
        download();
    }

    private void download() throws IOException {
        BufferedReader txtIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        InputStream binIn=socket.getInputStream();
        String fileName=txtIn.readLine();
        FileOutputStream fileOut=new FileOutputStream("Jovana//"+fileName);
        int fileSize=Integer.parseInt(txtIn.readLine());
        byte[] fileContent=new byte[fileSize];
        binIn.read(fileContent);
        for (byte b : fileContent) {
            System.out.println(b);
        }
        fileOut.write(fileContent);
        fileOut.flush();
        fileOut.close();
        socket.close();
        
    }
}
