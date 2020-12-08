package com.dbms.web.controller.entity;

public class Table {
private String tablename;
private int size;

public Table() {}

public Table(String tablename, int size) {
	super();
	this.tablename = tablename;
	this.size = size;
}

public String getTablename() {
	return tablename;
}

public void setTablename(String tablename) {
	this.tablename = tablename;
}

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
};

}
