/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;

/**
 *
 * @author Cartman
 */
public class Client {

    Socket socket;
    public Client() throws IOException {
        socket=new Socket("localhost", 9000);
    }
    
    
    
    public void upload(String path) throws IOException{
        PrintWriter txtOut=new PrintWriter(socket.getOutputStream(), true);
        OutputStream binOut=socket.getOutputStream();
        txtOut.println(path);
        File file=new File(path);
        
        byte [] fileContent = Files.readAllBytes(file.toPath());
        for (byte b : fileContent) {
            System.out.println(b);
        }
        txtOut.println(fileContent.length+"");
        binOut.write(fileContent);
        binOut.flush();
        socket.close();
    }
}
