/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Cartman
 */
public class Server {

    ServerSocket serverSocket;
    Socket socket;
    
    public Server() {
    }
    
    public void start() throws IOException{
        serverSocket=new ServerSocket(9000);
        System.out.println("waiting...");
        socket=serverSocket.accept();
        System.out.println("connected!");
        
        ClientHandler handler=new ClientHandler(socket);
        handler.handleClient();
    }
    
}
