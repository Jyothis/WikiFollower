/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jyothis
 */
public class WikiChannelMessage {

    private final String channel;
    private String page;
    private String action;
    private String diffurl;
    private String user;
    private String diff;
    private String comment;
    private final Date date;
    private final WikiMessageActionType actiontype;
    private boolean ipedit;
    private boolean sendit;
    private final String longmsg;
    private String blockedid;
    //Precompiled patters for string extraction
    private static final Pattern p = Pattern.compile("^.+\\[{2}.+?07(.+?)14\\]{2}.\\d{1,2}\\s?(.*?)\\s?.\\d{1,2}\\s.\\d{2}\\s?(.*)\\s?.+\\d\\*\\s?.+03(.*)\\s+.+?\\d\\*.+?\\((.*)\\)\\s+?(.*)");
    private static final Pattern splpattern = Pattern.compile("^.+\\[{2}.+?07(.+?)14\\]{2}.\\d{1,2}\\s?(.*?)\\s?.\\d{1,2}\\s.\\d{2}\\s?.*\\s?.+\\d\\*\\s?.+03(.*)\\s+.+?5\\*.+?10(.*)");
    private static final Pattern ippattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
    //private static final Pattern blockpattern = Pattern.compile("^.+\\[{2}.+?02(.+?)10\\]{2}.*");
    private static final Pattern blockpattern = Pattern.compile("^.+\\[{2}.+?02.+?\\:(.+?)10\\]{2}.*");

    public WikiChannelMessage(String channel, String message) {


        this.channel = channel.substring(1);
        date = new Date();
        longmsg = message;



        try {
            Matcher m = null;

            m = p.matcher(message);
            if (m.matches()) {
                this.page = m.group(1).trim();
                this.action = m.group(2).trim();
                this.diffurl = m.group(3).trim();
                this.user = m.group(4).trim();
                this.diff = m.group(5).trim();
                this.comment = m.group(6).trim();
            }
        } catch (Exception e) {
            System.out.println("Could not run match");
            throw new IllegalStateException();

        }
        //This gets invoked when it is a Special action
        if (page == null) {
            //System.out.println("Page is null ->"+message);
            try {
                Matcher m1 = splpattern.matcher(message);
                if (m1.matches()) {
                    this.page = m1.group(1).trim();
                    this.action = m1.group(2).trim();
                    this.user = m1.group(3).trim();
                    this.comment = m1.group(4).trim();


                }
            } catch (Exception e) {
                System.out.println("Could not run match for Spl");
            }
        }

        actiontype = (WikiMessageActionType) WikiMessageActionType.getActionType(action);

        //Is this an IP edit?
        ipedit = false;

        if (user != null) {
            Matcher ip = ippattern.matcher(user);
            if (ip.matches()) {
                ipedit = true;
            }
        }
        if (actiontype == WikiMessageActionType.BLOCK) {
            try {
                //System.out.println(message);
                Matcher block = blockpattern.matcher(message);

                if (block.matches()) {
                    this.blockedid = block.group(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Could not run match" + message);
            }
            if (blockedid.length()==0){
                System.out.println("Did not parse"+message);
            }

        }
    }

    public boolean sendIt() {
        return sendit;
    }

    public void setSendit(boolean sendit) {
        this.sendit = sendit;
    }

    public String getBlockedid() {
        return blockedid==null?"":blockedid;
    }

    public String getLongmsg() {
        return longmsg;
    }

    public boolean isIpedit() {
        return ipedit;
    }

    public Date getDate() {
        return date;
    }

    public String getDiff() {
        return diff;
    }

    public String getAction() {
        return action;
    }

    public String getComment() {
        return comment;
    }

    /* public int getDiff() {
    int dif = 0;
    if (diff != null) {
    dif = Integer.parseInt(diff);
    }

    return dif;

    }*/
    public String getDiffurl() {
        return diffurl;
    }

    public String getPage() {
        return page;
    }

    public String getUser() {
        return user;
    }

    public WikiChannelMessage() {
        throw new UnsupportedOperationException("Cannot Instantiate without parameters");
    }

    public String getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return date + ":-" + actiontype + ", Channel = " + channel + ", page = " + page + ", action = " + action + ", diffurl = " + diffurl + ", user = " + user + ", diff = " + diff + ", comment = " + comment;
    }

    public WikiMessageActionType getActiontype() {
        return actiontype;
    }

    public boolean isInteresting() {
        if (actiontype == WikiMessageActionType.BOT
                || actiontype == WikiMessageActionType.PATROL
                || actiontype == WikiMessageActionType.DELETE
                || actiontype == WikiMessageActionType.PROTECT) {
            return false;

        }
        return true;
    }
}
