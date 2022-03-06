package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResource {
	public static void main(String[] args) {

		int luaChon;
		int daTinhLuong = 0;
		ArrayList<Staff> ds = new ArrayList<>();
		Scanner s = new Scanner(System.in);

		

		do {
			System.out.println("Chương trình quản lý nguồn nhân lực Human Resources!");
			System.out.println("<Hãy lựa chọn chức năng bạn muốn thực thi>");
			System.out.println();
			System.out.println("0. Thoát khỏi chương trình.");
			System.out.println("1. Thêm nhân viên mới vào công ty.");
			System.out.println("2. Hiển thị danh sách nhân viên hiện có trong công ty.");
			System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
			System.out.println("4. Hiển thị các bộ phận trong công ty.");
			System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
			System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
			System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
			System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
			System.out.println();
			
			System.out.print("Bạn muốn làm việc với chức năng nào <Lưu ý: Cần nhập thông tin nhân viên trước khi lựa chọn các chức năng khác!>: ");
			luaChon = Integer.parseInt(s.nextLine());
			System.out.println();

			switch (luaChon) {
			case 0:
				System.out.println("Cám ơn bạn đã tin tưởng và sử dụng chương trình của chúng tôi!");
				break;
			case 1:
				int kieu;
				System.out.println();
				System.out.println("Nhập thông tin nhân viên: ");

				do {
					System.out.println();
					System.out.print("Lựa chọn kiểu nhân viên mà bạn muốn nhập <0 - Thoát, 1- Employee, 2- Manager>: ");
					kieu = Integer.parseInt(s.nextLine());
					if (kieu == 1) {
						Employee nv = new Employee();
						nv.inputs(s);
						ds.add(nv);
					} else if (kieu == 2) {
						Manager nv = new Manager();
						nv.inputs(s);
						ds.add(nv);
					} else {
						System.out.println("Bạn đã thoát khỏi chức năng nhập thông tin nhân viên!");
					}

				} while (kieu != 0);

				System.out.println();
				break;

			case 2:
				if (ds.size() == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên trước khi thực hiện chức năng này!");
					System.out.println();
					break;
				} else {
					System.out.println("Danh sách nhân viên có trong công ty: ");
					for (Staff i : ds) {
						if (i instanceof Employee) {
							System.out.println(((Employee) i).displayInformation());
						} else if (i instanceof Manager) {
							System.out.println(((Manager) i).displayInformation());
						}
					}

					System.out.println();
					break;
				}

			case 3:
				if (ds.size() == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên trước khi thực hiện chức năng này!");
					System.out.println();
					break;

				} else {
					System.out.println("Danh sách nhân viên trong công ty theo từng bộ phận: ");
					boPhan(ds, "Business");
					boPhan(ds, "Project");
					boPhan(ds, "Technical");
					break;
				}

			case 4:
				if (ds.size() == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên trước khi thực hiện chức năng này!");
					System.out.println();
					break;

				} else {
					System.out.println("Danh sách các bộ phận trong công ty:");
					Department bp1 = new Department("BP-BUS", "Business", demNhanVien(ds, "Business"));
					System.out.println(bp1.toString());
					
					
					Department bp2 = new Department("BP-PRO", "Project", demNhanVien(ds, "Project"));
					System.out.println(bp2.toString());
					
					Department bp3 = new Department("BP-TEC", "Technical", demNhanVien(ds, "Technical"));
					System.out.println(bp3.toString());
					System.out.println();
					break;
				}

			case 5:
				if (ds.size() == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên trước khi thực hiện chức năng này!");
					System.out.println();
					break;

				} else {
					System.out.println("Tìm kiếm nhân viên bằng họ và tên hoặc mã nhân viên: ");
					timKiemNV(ds);
					System.out.println();
					break;
				}

			case 6:
				if (ds.size() == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên trước khi thực hiện chức năng này!");
					System.out.println();
					break;

				} else {
					System.out.println("Tính lương cho nhân viên và in ra danh sách:");
					for (Staff i : ds) {
						if (i instanceof Employee) {
							((Employee) i).calculatorSalary();
							System.out.println( i.displayInformation() + ", Lương: " + ((Employee) i).getLuong());
						} else if (i instanceof Manager) {
							((Manager) i).calculatorSalary();
							System.out.println( i.displayInformation() + ", Lương: " + ((Manager) i).getLuong());
						}
					}
					
					daTinhLuong = 1;
					System.out.println();
					break;
				}

			case 7:
				if (ds.size() == 0 || daTinhLuong == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên và tính lương trước khi thực hiện chức năng này!");
					System.out.println();
					break;

				} else {
					System.out.println("Danh sách nhân viên sắp xếp theo thứ tự tăng dần của lương: ");
					Collections.sort(ds, new Comparator<Staff>() {
						@Override
						public int compare(Staff nv1, Staff nv2) {
								
							if (checkYourSon(nv1) < checkYourSon(nv2)) {
								return -1;
							} else {
								if (checkYourSon(nv1)  == checkYourSon(nv2)) {
									return 0;
								} else {
									return 1;
								}
							}
						}
						
						//Kiểm tra xem con của Staff thuộc lớp đối tượng nào để gọi getLuong vì trong Staff không có biến lương.
						public double checkYourSon(Staff nv) {
							if(nv instanceof Employee) {
								return ((Employee) nv).getLuong();
							} else {
								return ((Manager) nv).getLuong();
							}
						}
						
					});
					
					

					for (Staff i : ds) {
						if (i instanceof Employee) {
							System.out.println( i.displayInformation() + ", Lương: " + ((Employee) i).getLuong());
						} else if (i instanceof Manager) {
							System.out.println(i.displayInformation() + ", Lương: " + ((Manager) i).getLuong());
						}
					}
					System.out.println();
					break;
				}
			case 8:
				if (ds.size() == 0 || daTinhLuong == 0) {
					System.out.println("Bạn cần nhập danh sách nhân viên và tính lương trước khi thực hiện chức năng này!");
					System.out.println();
					break;

				} else {
					System.out.println("Danh sách nhân viên sắp xếp theo thứ tự giảm dần của lương: ");
					Collections.sort(ds, new Comparator<Staff>() {
						@Override
						public int compare(Staff nv1, Staff nv2) {
								
							if (checkYourSon(nv1) < checkYourSon(nv2)) {
								return 1;
							} else {
								if (checkYourSon(nv1)  == checkYourSon(nv2)) {
									return 0;
								} else {
									return -1;
								}
							}
						}
						
						//Kiểm tra xem con của Staff thuộc lớp đối tượng nào để gọi getLuong vì trong Staff không có biến lương.
						public double checkYourSon(Staff nv) {
							if(nv instanceof Employee) {
								return ((Employee) nv).getLuong();
							} else {
								return ((Manager) nv).getLuong();
							}
						}
						
					});

					for (Staff i : ds) {
						if (i instanceof Employee) {
							System.out.println(i.displayInformation() + ", Lương: " + ((Employee) i).getLuong());
						} else if (i instanceof Manager) {
							System.out.println(i.displayInformation() + ", Lương: " + ((Manager) i).getLuong());
						}
					}
					System.out.println();
					break;
				}

			}
		} while (luaChon != 0);

	}

	// Hàm dùng để in nhân viên theo từng bộ phận:
	public static void boPhan(ArrayList<Staff> ds, String a) {
		System.out.println("Danh sách nhân viên trong bộ phân " + a + " gồm: ");
		for (Staff i : ds) {
			if (i.getBoPhanLamViec().equals(a)) {
				if (i instanceof Employee) {
					System.out.println(((Employee) i).displayInformation());
				} else if (i instanceof Manager) {
					System.out.println(((Manager) i).displayInformation());
				}
			}
		}
		System.out.println();
	}

	// Đếm nhân số nhân viên trong mỗi bộ phận và in ra thông tin của bộ phận
	public static int demNhanVien(ArrayList<Staff> ds, String a) {
		int check = 0;

		for (Staff i : ds) {
			if (i.getBoPhanLamViec().equals(a)) {
				check += 1;
			}
		}
		return check;
	}

	// Tìm kiếm nhân viên theo mã nhân viên và tên
	public static void timKiemNV(ArrayList<Staff> ds) {
		String timKiem;
		String tuKhoa;
		Scanner s = new Scanner(System.in);
		System.out.print("Nhập vào mã nhân viên hoặc họ và tên nhân viên bạn muốn tìm kiếm: ");
		tuKhoa = s.nextLine();
		timKiem = tuKhoa.toLowerCase();
		int check = 0;
		
		for (Staff i : ds) {
			if ((i.getMa().toLowerCase().equals(timKiem)) || (i.getHoTen().toLowerCase().equals(timKiem))) {
				check ++;
				if (i instanceof Employee) {
					System.out.println(i.displayInformation());
				} else if (i instanceof Manager) {
					System.out.println(i.displayInformation());
				}
			}
		}
		if(check == 0) {
			System.out.println("Không tìm thấy kết quả phù hợp với từ khóa: " + tuKhoa);
		}
	}
	
}
