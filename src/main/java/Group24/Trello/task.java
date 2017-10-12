package Group24.Trello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.mycompany.trollo_gary;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Gc PC
 */
public class task {
	private String list_name, task_name, task_comment, task_member;
	private ArrayList task_comments; 
	private ArrayList task_members;
	private int task_id, task_member_id, list_id; 

	private static final AtomicInteger count = new AtomicInteger(0); 

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

	public String getTask_comment() {
		return task_comment;
	}

	public void setTask_comment(String task_comment) {
		this.task_comment = task_comment;
	}

	public String getTask_member() {
		return task_member;
	}

	public void setTask_member(String task_member) {
		this.task_member = task_member;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getTask_member_id() {
		return task_member_id;
	}

	public void setTask_member_id(int task_member_id) {
		this.task_member_id = task_member_id;
	}

	public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}




}
