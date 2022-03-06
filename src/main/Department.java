package main;

import java.util.ArrayList;

public class Department {

	private String maBoPhan, tenBoPhan;
	private int soLuongNV;
	
	
	//setters and getter

	public String getMaBoPhan() {
		return maBoPhan;
	}

	public void setMaBoPhan(String maBoPhan) {
		this.maBoPhan = maBoPhan;
	}

	public String getTenBoPhan() {
		return tenBoPhan;
	}

	public void setTenBoPhan(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan;
	}

	public int getSoLuongNV() {
		return soLuongNV;
	}

	public void setSoLuongNV(int soLuongNV) {
		this.soLuongNV = soLuongNV;
	}


	//constructor
	public Department() {
		
	}
	
	public Department(String maBoPhan, String tenBoPhan, int soLuongNV) {
		super();
		this.maBoPhan = maBoPhan;
		this.tenBoPhan = tenBoPhan;
		this.soLuongNV = soLuongNV;
	}
	
	
	
	//method
	
	public String toString() {
		return ("Mã bộ phận: " + this.getMaBoPhan() + ", Tên bộ phận: " + this.getTenBoPhan() + ", Số lượng người: " + this.getSoLuongNV());
	}
	
	
	
	
	
	

	
	
	
	
	
}
