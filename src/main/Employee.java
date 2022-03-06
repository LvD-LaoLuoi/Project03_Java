package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Staff implements ICalculator {

	private double soGioLamThem;
	private double luong;

	

	// contructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// setters and getters
	public double getSoGioLamThem() {
		return soGioLamThem;
	}

	public void setSoGioLamThem(double soGioLamThem) {
		this.soGioLamThem = soGioLamThem;
	}
	
	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	// method
	public void inputs(Scanner s) {
		super.inputs(s);
		super.setHeSoLuong(2.3);
		super.setSoNgayNghiPhep(10);
		System.out.print("Số giờ làm thêm: ");
		this.soGioLamThem = s.nextDouble();
		s.nextLine();
	}

	@Override
	public String displayInformation() {
		// TODO Auto-generated method stub
		return ("Mã nhân viên: " + this.getMa() + ", Họ và tên: " + this.getHoTen() + ", Tuổi: " + this.getTuoi()
				+ ", Hệ số lương: " + this.getHeSoLuong() + ", Bộ phận: " + this.getBoPhanLamViec()
				+ ", Số ngày nghỉ phép: " + this.getSoNgayNghiPhep() + ", Thời gian vào làm: "
				+ this.getNgayVaoLamViec());
	}

	public void calculatorSalary() {
		// TODO Auto-generated method stub
		this.setLuong((this.getHeSoLuong() * 3000000 + this.getSoGioLamThem() * 200000));
	}
}
