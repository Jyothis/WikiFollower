/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jyothis
 */
public class ChannelMessage {

    private final String channel;
    private final String sender;
    private final String message;

    private final String hostname;
    private String command;
    private List args;
    //private String action;
    private ChannelCommand cmd;
    private ChannelAction action;
    private static final String cmdpattern1 = "^Jotterbot\\s?(.+?)\\s+?(.*)";
    private static final String cmdpattern2 = "^-{2}\\s?(.+?)\\s+?(.*)";
    private static final String cmdaction = "^\\s?(.+?)\\s+?(.*)";
    private static final Pattern cmd1 = Pattern.compile(cmdpattern1);
    private static final Pattern cmd2 = Pattern.compile(cmdpattern2);

    public ChannelMessage(String channel, String sender, String message, String hostname) {

        this.channel = channel;
        this.sender = sender;
        this.message = message;
        this.hostname = hostname;
        processMessage();



    }

    private ChannelMessage() {
        throw new UnsupportedOperationException("Cannot Instantiate without parameters");
    }

    public String getChannel() {
        return channel;
    }

    public String getHostname() {
        return hostname;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    private void processMessage() {
        Matcher matcher;
        //System.out.println(message);
        try {

            if (message.startsWith("--")) {
                //System.out.println("--");
                matcher = cmd2.matcher(message);
            } else {
                matcher = cmd1.matcher(message);
            }
            if (matcher.find()) {
                //System.out.println("Matched");
                command = matcher.group(1);
                if (command.length() > 0) {
                    cmd = ChannelCommand.getCommand(command);
                }
                if (cmd.equals(ChannelCommand.BL) || cmd.equals(ChannelCommand.WL) || cmd.equals(ChannelCommand.GL)) {
                    Pattern paction = Pattern.compile(cmdaction);
                    Matcher maction = paction.matcher(matcher.group(2));
                    if(maction.matches()){
                        action = ChannelAction.getAction(maction.group(1).trim());
                        args = getArgsList(maction.group(2).trim());
                    }

                    //System.out.println("Ok this is as expected" + cmd);

                } else {
                    //System.out.println("did not match object");
                    action = ChannelAction.NONE;
                    args = getArgsList(matcher.group(2).trim());
                }

               
            } else {
                //System.out.println("did not match");
            }


            if (ChannelCommand.shouldProcessArgs(cmd)) {

                System.out.println("Ok, process args" + cmd);
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    public String getCommand() {
        return command;
    }

    public ChannelCommand getCmd() {
        return cmd;
    }
     public static List getArgsList(String args){
        List<String> argslist = new LinkedList<String>();
        
        for(String arg:args.split(",")){
            argslist.add(arg.trim());

        }
        //argslist.addAll(());

        return argslist;
    }

    public ChannelAction getAction() {
        return action;
    }

    public List<String> getArgs() {
        return args;
    }
}
