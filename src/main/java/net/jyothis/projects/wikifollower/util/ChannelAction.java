/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.jyothis.projects.wikifollower.util;

/**
 *
 * @author Jyothis
 */
public enum ChannelAction {
    ADD,DEL, NONE;

    public static ChannelAction getAction(String action){

        if(action.equalsIgnoreCase("add")||action.equalsIgnoreCase("put")||action.equalsIgnoreCase("a")){
            return ADD;
        }
        if(action.equalsIgnoreCase("d")||action.equalsIgnoreCase("del")||action.equalsIgnoreCase("delete")){
        
            return ADD;
        }



        return NONE;
        }
    

}
