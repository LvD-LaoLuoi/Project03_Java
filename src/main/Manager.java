package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Staff implements ICalculator {
	private String chucDanh;
	private double luong;


	
	// setter and getters

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public String getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}

	
	// method

	public void inputs(Scanner s) {
		super.inputs(s);
		super.setHeSoLuong(3.2);
		super.setSoNgayNghiPhep(12);
		this.chucDanh = "Trưởng phòng";

	}

	@Override
	public String displayInformation() {
		// TODO Auto-generated method stub
		return ("Mã nhân viên: " + this.getMa() + ", Họ và tên: " + this.getHoTen() + ", Tuổi: " + this.getTuoi()
				+ ", Hệ số lương: " + this.getHeSoLuong() + ", Bộ phận: " + this.getBoPhanLamViec() + ", Số ngày nghỉ phép: "
				+ this.getSoNgayNghiPhep() + ", Thời gian vào làm: " + this.getNgayVaoLamViec() + ", Chức vụ: " + this.getChucDanh());
	}

	@Override
	public void calculatorSalary() {
		// TODO Auto-generated method stub
		int luongTrachNhiem = 0;
		
		if (this.getBoPhanLamViec().equals("Business")) {
			luongTrachNhiem = 8000000;
		} else if (this.getBoPhanLamViec().equals("Project")) {
			luongTrachNhiem = 5000000;
		} else if(this.getBoPhanLamViec().equals("Technical")) {
			luongTrachNhiem = 6000000;
		}

		this.setLuong(this.getHeSoLuong() * 5000000 + luongTrachNhiem);
	}

}
