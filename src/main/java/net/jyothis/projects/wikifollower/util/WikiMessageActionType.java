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
public enum WikiMessageActionType {

    NONE{
        @Override
        public String toString(){
            return ""+Colors.BLUE+"Edited"+Colors.NORMAL;

        }
    @Override
        public int getActionId(){
            return 0;
        }

    }, 
    UPLOAD{
        @Override
        public String toString(){
            return ""+Colors.DARK_BLUE+"Uploaded"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 1;
        }

    },
    DELETE{
        @Override
        public String toString(){
            return "Deleted";

        }
        @Override
        public int getActionId(){
            return 2;
        }

    },
    NEWPAGE{
        @Override
        public String toString(){
            return ""+Colors.BROWN+"New Page Created"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 3;
        }

    },
    PATROL{
        @Override
        public String toString(){
            return ""+Colors.DARK_GREEN+"Patrolled"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 4;
        }

    },
    MOVE{
        @Override
        public String toString(){
            return ""+Colors.GREEN+"Page Moved"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 5;
        }

    },
    APPROVE{
        @Override
        public String toString(){
            return "Approve";

        }
        @Override
        public int getActionId(){
            return 6;
        }


    },
    CREATE{
        @Override
        public String toString(){
            return ""+Colors.PURPLE+"New User Created"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 7;
        }

    },
    CREATE2
            {
        @Override
        public String toString(){
            return ""+Colors.RED+"Created another user"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 8;
        }

    },
    OVERWRITE{
        @Override
        public String toString(){
            return ""+Colors.TEAL+"Overwritten"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 9;
        }

    },
    APPROVEI{
        @Override
        public String toString(){
            return "Approve-I";

        }
        @Override
        public int getActionId(){
            return 10;
        }

    },
    PROTECT{
        @Override
        public String toString(){
            return ""+Colors.BOLD+"Page Protection"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 11;
        }

    },
    MOVEREDIR{
        @Override
        public String toString(){
            return ""+Colors.BROWN+"Redirected Page"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 12;
        }

    },
    BOT{
        @Override
        public String toString(){
            return ""+Colors.CYAN+"Bot Edit"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 13;
        }

    },
    BLOCK{
        @Override
        public String toString(){
            return ""+Colors.RED+"Blocked"+Colors.NORMAL;

        }
        @Override
        public int getActionId(){
            return 14;
        }

    };

    
    public abstract int getActionId();

    public static Enum getActionType(String action) {

        if (action.equals("upload")) {
            return WikiMessageActionType.UPLOAD;
        }
        if (action.equals("delete")) {
            return WikiMessageActionType.DELETE;
        }
        if (action.equals("patrol")) {
            return WikiMessageActionType.PATROL;
        }
        if (action.equals("N!")||action.equals("!N")||action.equals("N")) {
            return WikiMessageActionType.NEWPAGE;
        }
        if (action.equals("move")) {
            return WikiMessageActionType.MOVE;
        }
        if (action.equals("approve")) {
            return WikiMessageActionType.APPROVE;
        }
        if (action.equals("create")) {
            return WikiMessageActionType.CREATE;
        }
        if (action.equals("create2")) {
            return WikiMessageActionType.CREATE2;
        }
        if (action.equals("overwrite")) {
            return WikiMessageActionType.OVERWRITE;
        }
        if (action.equals("approve-i")) {
            return WikiMessageActionType.APPROVEI;
        }
        if (action.equals("protect")) {
            return WikiMessageActionType.PROTECT;
        }
        if (action.equals("move_redir")) {
            return WikiMessageActionType.MOVEREDIR;
        }
        if (action.equals("block")) {
            return WikiMessageActionType.BLOCK;
        }
        if (action.equals("MB")||action.equals("B")||action.equals("NMB")||action.equals("!MB")) {
            return WikiMessageActionType.BOT;
        }

        return WikiMessageActionType.NONE;

    }
}
