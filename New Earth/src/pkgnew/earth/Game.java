/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew.earth;

/**
 *
 * @author arsch_000
 */
public class Game implements Runnable{
    
    public static Thread gameThread;
    private boolean running = false;
    
    public synchronized void start(){
        gameThread = new Thread(this, "Game");
        gameThread.start();
    }
    
    public synchronized void stop(){
        try{
        gameThread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (running){
            
        }
    }
}
