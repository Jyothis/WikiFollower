/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower.util;

import org.pircbotx.Colors;



/**
 *
 * @author Jyothis
 */
public enum ChannelCommand {

    NONE {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Unknown Command" + Colors.NORMAL;

        }
        public boolean execute(){
            return true;
        }
        
    },
    WL {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Whitelist" + Colors.NORMAL;

        }
        public boolean execute(){
            return true;
        }
        
    },
    BL {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Black List" + Colors.NORMAL;

        }
    
    },
    GL {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Gray List" + Colors.NORMAL;

        }
     
    },
    QUIT {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Quit" + Colors.NORMAL;

        }
    
    },
    INTEL {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Intel" + Colors.NORMAL;

        }
   
    },
    TRANS {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Translation :" + Colors.NORMAL;

        }
 
    },
    SUBSC {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Subscribe" + Colors.NORMAL;

        }
   
    },
    UNSUB {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Unsubscribe" + Colors.NORMAL;

        }
 
    },
    JOIN {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Join channel" + Colors.NORMAL;

        }
  
    },
    REBOOT {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Reboot" + Colors.NORMAL;

        }
  
    },
    SLEEP {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Sleep" + Colors.NORMAL;

        }
 
    },
    SPEAK {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Speak" + Colors.NORMAL;

        }
 
    },
    FOLLOW {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Follow" + Colors.NORMAL;

        }
 
    },
    IGNORE {

        @Override
        public String toString() {
            return "" + Colors.BLUE + "Ignore" + Colors.NORMAL;

        }
  
    };

    public static ChannelCommand getCommand(String cmd) {
        //this.args = args;

        if (cmd.equalsIgnoreCase("wl")) {

            //parseCommand(args,"^(.+?)\\,(.*)");

            return WL;
        }
        if (cmd.equalsIgnoreCase("bl")) {
            return BL;
        }
        if (cmd.equalsIgnoreCase("gl")) {
            return GL;
        }
        if (cmd.equalsIgnoreCase("quit")) {
            return QUIT;
        }
        if (cmd.equalsIgnoreCase("intel")) {
            return INTEL;
        }
        if (cmd.equalsIgnoreCase("trans")) {
            return TRANS;
        }
        if (cmd.equalsIgnoreCase("subsc")||cmd.equalsIgnoreCase("subscribe")) {
            return SUBSC;
        }
        if (cmd.equalsIgnoreCase("unsub")) {
            return UNSUB;
        }
        if (cmd.equalsIgnoreCase("join")) {
            return JOIN;
        }
        if (cmd.equalsIgnoreCase("reboot")) {
            return REBOOT;
        }
        if (cmd.equalsIgnoreCase("sleep") || cmd.equalsIgnoreCase("quite")) {
            return SLEEP;
        }
        if (cmd.equalsIgnoreCase("speak") || cmd.equalsIgnoreCase("wake")) {
            return SPEAK;
        }
        if (cmd.equalsIgnoreCase("follow")) {
            return FOLLOW;
        }
        if (cmd.equalsIgnoreCase("ignore")) {
            return IGNORE;
        }
        return NONE;
    }

    public static boolean shouldProcessArgs(ChannelCommand cmd){

        if((cmd.equals(QUIT)&&cmd.equals(REBOOT)&&cmd.equals(SLEEP)&&cmd.equals(SPEAK)&&cmd.equals(NONE))){
            return false;
        }


        return true;
    }

  

 
}

