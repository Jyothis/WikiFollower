/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jyothis.projects.wikifollower.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jyothis
 */
public class DataCommon {

    private static final MessageQueue queue = new MessageQueue();
    private static final List<String> projects = new ArrayList<String>();
    private static final List<String> wl = new ArrayList<String>();
    private static final List<String> gl = new ArrayList<String>();
    private static final List<String> bl = new ArrayList<String>();
    private static final Map<String, ArrayList<String>> subscr = new HashMap<String, ArrayList<String>>();
    private static Properties props = new Properties();

    DataCommon() {
        loadProjects();
        loadWL();
        loadGL();
        loadBL();
        loadSubscr();
        //loadProps()
    }

    public static synchronized boolean addToChannelList(ChannelMessage msg) {
        return true;

    }

    public static synchronized boolean updateWhiteList(ChannelMessage msg) {
        List<String> userlst = msg.getArgs();
        if (msg.getCmd() != ChannelCommand.WL) {
            return false;
        }
        for (String usr : userlst) {

            if (msg.getAction() == ChannelAction.ADD) {
                addToWhiteList(usr);
           } else {
                removeFromWhiteList(usr);
            }
        }
        return true;

    }

    public static synchronized boolean updateGrayList(ChannelMessage msg) {
         List<String> userlst = msg.getArgs();
        if (msg.getCmd() != ChannelCommand.GL) {
            return false;
        }
        for (String usr : userlst) {

            if (msg.getAction() == ChannelAction.ADD) {
                addToGrayList(usr);
           } else {
                removeFromGrayList(usr);
            }
        }
        return true;

    }

    public static synchronized boolean updateBlackList(ChannelMessage msg) {
         List<String> userlst = msg.getArgs();
        if (msg.getCmd() != ChannelCommand.BL) {
            return false;
        }
        for (String usr : userlst) {

            if (msg.getAction() == ChannelAction.ADD) {
                addToBlackList(usr);
           } else {
                removeFromBlackList(usr);
            }
        }
        return true;

    }

    public static synchronized boolean subscribe(ChannelMessage msg) {

        return true;

    }

    public static synchronized boolean unsubscribe(ChannelMessage msg) {
        return true;

    }

    public static synchronized boolean updateProjectList(ChannelMessage msg) {
        return true;

    }

    private static synchronized boolean addToWhiteList(String user) {
        if (!wl.contains(user)) {
            wl.add(user);
            removeFromBlackList(user);
            removeFromGrayList(user);
            return true;
        }
        return false;

    }

    private static synchronized boolean removeFromWhiteList(String user) {

        if (wl.contains(user)) {
            wl.remove(user);
            return true;
        }
        return false;

    }

    private static synchronized boolean addToGrayList(String user) {
        if (!gl.contains(user)) {
            gl.add(user);
            removeFromBlackList(user);
            removeFromWhiteList(user);
            return true;
        }
        return false;
    }

    private static synchronized boolean removeFromGrayList(String user) {
        if (gl.contains(user)) {
            gl.remove(user);
            return true;
        }
        return false;
    }

    private static synchronized boolean addToBlackList(String user) {
        if (!bl.contains(user)) {
            bl.add(user);
            removeFromGrayList(user);
            removeFromWhiteList(user);
            return true;
        }
        return false;
    }

    private static synchronized boolean removeFromBlackList(String user) {
        if (bl.contains(user)) {
            bl.remove(user);
            return true;
        }
        return false;
    }

    private static synchronized boolean whiteListed(String user) {
        if (wl.contains(user)) {
            return true;
        }
        return false;
    }

    private static synchronized boolean blackListed(String user) {
        if (bl.contains(user)) {
            return true;
        }
        return false;
    }

    private static synchronized boolean grayListed(String user) {
        if (gl.contains(user)) {
            return true;
        }
        return false;
    }

    private synchronized void loadProjects() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private synchronized void loadWL() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private synchronized void loadGL() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private synchronized void loadBL() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private synchronized void loadSubscr() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static ArrayList getSubscribers(String project) {
        return subscr.get(project);
    }

    public void loadProps(String propsfile) {
        try {

            props.load(new FileInputStream(propsfile));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataCommon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataCommon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
