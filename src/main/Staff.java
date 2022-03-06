package main;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Staff {
	private String ma, hoTen, boPhanLamViec, ngayVaoLamViec;
	private int tuoi, soNgayNghiPhep;
	private double heSoLuong;

	// constructor

	public Staff() {

	}

	public Staff(String ma, String hoTen, int tuoi, String ngayVaoLamViec, String boPhanLamViec, double heSoLuong,
			int soNgayNghiPhep) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.boPhanLamViec = boPhanLamViec;
		this.ngayVaoLamViec = ngayVaoLamViec;
		this.tuoi = tuoi;
		this.soNgayNghiPhep = soNgayNghiPhep;
		this.heSoLuong = heSoLuong;
	}

	// getters and setters

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getBoPhanLamViec() {
		return boPhanLamViec;
	}

	public void setBoPhanLamViec(String boPhanLamViec) {
		this.boPhanLamViec = boPhanLamViec;
	}

	public String getNgayVaoLamViec() {
		return ngayVaoLamViec;
	}

	public void setNgayVaoLamViec(String ngayVaoLamViec) {
		this.ngayVaoLamViec = ngayVaoLamViec;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public int getSoNgayNghiPhep() {
		return soNgayNghiPhep;
	}

	public void setSoNgayNghiPhep(int soNgayNghiPhep) {
		this.soNgayNghiPhep = soNgayNghiPhep;
	}
	
	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	

	// method

	public abstract String displayInformation();

	public void inputs(Scanner s) {
		System.out.print("Mã: ");
		this.ma = s.nextLine().toUpperCase();

		System.out.print("Họ và tên: ");
		this.hoTen = s.nextLine().toUpperCase();

		System.out.print("Tuổi: ");
		this.tuoi = Integer.parseInt(s.nextLine());

		System.out.print("Ngày vào làm việc <Day-Month-Year>: ");
		this.ngayVaoLamViec = s.nextLine();

		System.out.print("Hãy lựa chọn bộ phận làm việc theo danh sách gợi ý <1- Business, 2 - Project, 3 - Technical>: ");
		int kiemTra = Integer.parseInt(s.nextLine());
		if (kiemTra == 1) {
			this.boPhanLamViec = "Business";
		} else if (kiemTra == 2) {
			this.boPhanLamViec = "Project";
		} else if (kiemTra == 3) {
			this.boPhanLamViec = "Technical";
		}

	}
	
}
