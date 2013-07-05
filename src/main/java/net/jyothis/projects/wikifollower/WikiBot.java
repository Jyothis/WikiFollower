/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.exception.NickAlreadyInUseException;

/**
 *
 * @author jedathoot
 */
public class WikiBot {
    
   public void runBot(){
       PircBotX bot = null;
        try {
            
            bot = new PircBotX();
            bot.setVerbose(true);
            bot.setAutoNickChange(true);
            bot.getListenerManager().addListener(new BotListener());
            bot.setName("JBot");
            bot.setLogin("JBot");
            bot.connect("irc.wikimedia.org");
            bot.joinChannel("#en.wikipedia");
            //bot.listChannels();
            bot.setVerbose(false);
            
        } catch (IOException ex) {
            Logger.getLogger(WikiBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IrcException ex) {
            Logger.getLogger(WikiBot.class.getName()).log(Level.SEVERE, null, ex);
        } 

   }
    
}
