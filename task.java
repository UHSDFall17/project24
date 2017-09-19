/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trollo;

import java.util.ArrayList;

/**
 *
 * @author Gc PC
 */
public class task {
    String list_name, task_name;
    ArrayList task_comments; 
    ArrayList task_members; 

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public ArrayList getTask_comments() {
        return task_comments;
    }

    public void setTask_comments(ArrayList task_comments) {
        this.task_comments = task_comments;
    }

    public ArrayList getTask_members() {
        return task_members;
    }

    public void setTask_members(ArrayList task_members) {
        this.task_members = task_members;
    }
    
    
    
}
