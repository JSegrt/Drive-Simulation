/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import client.Client;
import java.io.IOException;

/**
 *
 * @author Cartman
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Client client=new Client();
        client.upload("mojFile.txt");
    }
}
