/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.jyothis.projects.wikifollower.util.WikiChannelMessage;
import org.pircbotx.ChannelListEntry;
import org.pircbotx.Colors;
import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ChannelInfoEvent;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.InviteEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

/**
 *
 * @author jedathoot
 */
class BotListener extends ListenerAdapter implements Listener {

    public BotListener() {
    }

    @Override
    public void onConnect(ConnectEvent event) throws Exception {
        event.getBot().listChannels();
        //event.getBot().disconnect();
    }

    @Override
    public void onInvite(InviteEvent event) throws Exception {
        super.onInvite(event); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onMessage(MessageEvent event) throws Exception {
        //System.out.println("ONMSG "+event.getMessage());
        String msg = event.getMessage();
        WikiChannelMessage chanmsg = new WikiChannelMessage(event.getChannel().getName(), msg);
        if (chanmsg.isInteresting()) {
            System.out.println(chanmsg);
        }


    }

    @Override
    public void onEvent(Event event) throws Exception {
        //super.onEvent(event); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("EVENT: "+event);

        if (event instanceof MessageEvent) {
            onMessage((MessageEvent) event);
        }
    }

    @Override
    public void onChannelInfo(ChannelInfoEvent event) throws Exception {
        for (Object str : event.getList()) {
            System.out.println(((ChannelListEntry) str).getName());
            //event.getBot().joinChannel(((ChannelListEntry) str).getName());
        }

    }

    @Override
    public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
        //super.onPrivateMessage(event); //To change body of generated methods, choose Tools | Templates.
        System.out.println("PriveMsg: " + event.getMessage());
    }
}
