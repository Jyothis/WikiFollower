/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Jyothis
 */
public class MessageQueue {

    private static final Queue<WikiChannelMessage> queue = new LinkedList<WikiChannelMessage>();

    public synchronized void add(WikiChannelMessage msg) {
        try{
        queue.add(msg);
        }catch(IllegalStateException illex){
            illex.printStackTrace();
        }catch(NullPointerException nullex){
            nullex.printStackTrace();
        }
        //System.out.println("Current que length is"+queue.size());

    }

    public synchronized WikiChannelMessage remove() {
        WikiChannelMessage msg = null;
        try {
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }

            msg = queue.remove();
            notifyAll();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }

        return msg;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public int size(){
        return queue.size();
    }
}
