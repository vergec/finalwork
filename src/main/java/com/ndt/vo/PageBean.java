package com.ndt.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	
	private int totalRows; // ��¼��ѯ��ȫ���������
	private int totalPages; // �Զ������ܵķ�ҳ����
	private int currentPage; // ��ǰҳ��
	private int pageSize; // ÿҳ��ʾ�ļ�¼����
	private List data = new ArrayList();  // ÿҳ��ʾ������
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		/*
		 * 
		 * ��ҳ�㷨��
		 * if(������%ÿҳ��ʾ����==0){
		 *     ������/ÿҳ��ʾ����
		 * }else{
		 * 	   ������/ÿҳ��ʾ����+1
		 * }
		 * */ 
		return totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
	
}
