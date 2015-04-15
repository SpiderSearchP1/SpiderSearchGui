/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logica.ListaSdoble;
import TCP_IP.Cliente;

/**
 *
 * @author osboxes
 */
public class interData {
    private Cliente client;
    private boolean stateConn=true;
    
    public void strartCliente(String ip, int puerto){
        try{
            client= new Cliente(ip, puerto);
            new Thread(client).start();
            stateConn=client.getStateClient();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * devuelve el cliente en caso de que se tenga que darle algun uso
     * @return client
     */
    public Cliente getCliente(){
        return client;
    }
    
    /**
     * devuelve el estado de la conexion con el servidor.
     * @return 
     */
    public boolean get_state(){
        return stateConn;
    }
    
    /**
     * envia un mensaje por medio del cliente al servidor para esperar 
     * una respuesta
     * @param msj 
     */
    public void sendMsj(String msj){
        client.sendMsj(msj);
    }
    
    /**
     * devuelve una lista con todos los datos que se hayan recibido 
     * de parte del servidor.
     * @return 
     */
    public ListaSdoble getDatos(){
        return client.extracInData();
    }
}
