import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ListCellRenderer;

public class tk_list {
  private ArrayList<taikhoan> listAccount = new ArrayList<taikhoan>();

  Scanner sc = new Scanner(System.in);

  public ArrayList<taikhoan> getListAccountArr() {
    return this.listAccount;
  }

  public int dangKi() throws IOException {
    DANHSACHKHACHHANG dskh = new DANHSACHKHACHHANG();

    dskh.docfile(); // đọc file dskh
    // tạo khách hàng

    String makhtmp;
    int maMax = 0;
    for (KHACHHANG kh : dskh.getArray()) {
      if (Integer.parseInt(kh.getMakh().substring(2)) > maMax) {
        maMax = Integer.parseInt(kh.getMakh().substring(2));
      }
    }
    makhtmp = "KH" + (maMax + 1);
    dskh.ThemKhachHangDangKi(makhtmp);

    // tạo tài khoản khách hàng

    taikhoan tktmp = new tkKhachHang(makhtmp);
    boolean matchFlag = true;
    do {
      tktmp.nhapTaikhoan();
      matchFlag = false;
      for (taikhoan tmp : listAccount) {
        if (tmp.getTentk().equals(tktmp.getTentk()) == true) {
          matchFlag = true;
          System.out.println("Ten tai khoan bi trung !");
          break;
        }
      }

    } while (matchFlag == true);

    for (taikhoan tk : listAccount) {
      if (Integer.parseInt(tk.getMatk()) > maMax) {
        maMax = Integer.parseInt(tk.getMatk());
      }
    }
    tktmp.setMatk((maMax + 1) + "");
    listAccount.add(tktmp);
    this.writeAccountListToFile();

    return 1;

  }

  public taikhoan dangNhap() throws IOException {
    String tentktmp;
    String passwdtmp;
    taikhoan tmp = null;

    System.out.println("Nhap ten tai khoan:");
    tentktmp = sc.next();
    System.out.println("Nhap mat khau:");
    passwdtmp = sc.next();
    for (taikhoan obj : listAccount) {
      if (obj.getTentk().equals(tentktmp) && obj.getPasswd().equals(passwdtmp)) {
        tmp = obj;
        break;
      }
    }
    return tmp;
  }

  public taikhoan dangNhap(String tentktmp, String passwdtmp) {
    taikhoan tmp = null;
    for (taikhoan obj : this.listAccount) {
      if (obj.getTentk().equals(tentktmp) && obj.getPasswd().equals(passwdtmp)) {
        tmp = obj;
        break;
      }
    }
    return tmp;
  }

  public int xoaTaiKhoan() throws IOException {
    String matktmp;
    System.out.println("Nhap ma tai khoan can xoa: ");
    matktmp = sc.next();
    for (taikhoan tk : listAccount) {

      if (tk.getMatk().equalsIgnoreCase(matktmp)) {
        // trường hợp xóa tk khách hàng
        if (tk instanceof tkKhachHang) {
          DANHSACHKHACHHANG dskh = new DANHSACHKHACHHANG();
          dskh.docfile();
          for (KHACHHANG kh : dskh.getArray()) {
            if (kh.getMakh().equalsIgnoreCase(tk.getMakhOrNv())) {
              dskh.getArray().remove(kh);
              break;
            }
          }
          dskh.ghiFile();
        } else // trường hợp xóa tk nhân viên
        {
          DANHSACHNHANVIEN dsnv = new DANHSACHNHANVIEN();
          dsnv.docfile();
          for (NHANVIEN nv : dsnv.getArray()) {
            if (nv.getManv().equalsIgnoreCase(tk.getMakhOrNv())) {
              dsnv.getArray().remove(nv);
              break;
            }
          }
          dsnv.ghiFile();
        }
        this.listAccount.remove(tk);
        System.out.println("\nXoa tai khoan thanh cong!\n");
        return 1;
      }
    }
    System.out.println("\nXoa tai khoan khong thanh cong, khong tim thay tai khoan !\n");
    return -1;
  }

  public void writeAccountListToFile() {
    File newWriterAdmin1 = new File("adminAccount.txt");
    File newWriterAdmin2 = new File("userAccount.txt");
    File newWriterAdmin3 = new File("employeeAccount.txt");
    try {
      FileWriter writerAdmin = new FileWriter(newWriterAdmin1, false);
      FileWriter writerUser = new FileWriter(newWriterAdmin2, false);
      FileWriter writerEmployee = new FileWriter(newWriterAdmin3, false);
      String line = "";
      for (taikhoan tk : listAccount) {
        if (tk instanceof tkAdmin) {
          line = tk.getMatk() + "," + tk.getTentk() + "," + tk.getPasswd() + "," + tk.getMakhOrNv();
          writerAdmin.write(line);
          writerAdmin.write("\n");
        }
      }
      writerAdmin.close();

      for (taikhoan tk : listAccount) {
        if (tk instanceof tkNhanvien) {
          line = tk.getMatk() + "," + tk.getTentk() + "," + tk.getPasswd() + "," +
              tk.getMakhOrNv();
          writerEmployee.write(line);
          writerEmployee.write("\n");
        }
      }
      writerEmployee.close();
      for (taikhoan tk : listAccount) {
        if (tk instanceof tkKhachHang) {
          line = tk.getMatk() + "," + tk.getTentk() + "," + tk.getPasswd() + "," +
              tk.getMakhOrNv();
          writerUser.write(line);
          writerUser.write("\n");
        }
      }
      writerUser.close();

    } catch (IOException e) {
      System.out.println("error: " + e);
    }
  }

  public void readAccountListFromFile() {
    this.listAccount.clear();
    String line;
    taikhoan tmp = null;
    BufferedReader readerAdmin = null;
    BufferedReader readerUser = null;
    BufferedReader readerEmployee = null;
    try {
      readerAdmin = new BufferedReader(new FileReader("adminAccount.txt"));
      readerUser = new BufferedReader(new FileReader("userAccount.txt"));
      readerEmployee = new BufferedReader(new FileReader("employeeAccount.txt"));
      while ((line = readerAdmin.readLine()) != null) {
        tmp = new tkAdmin();
        tmp.parseAccount(line);
        this.listAccount.add(tmp);
      }
      while ((line = readerUser.readLine()) != null) {
        tmp = new tkKhachHang();
        tmp.parseAccount(line);
        this.listAccount.add(tmp);
      }
      while ((line = readerEmployee.readLine()) != null) {
        tmp = new tkNhanvien();
        tmp.parseAccount(line);
        this.listAccount.add(tmp);
      }

    } catch (IOException ex) {
      System.out.println(ex);
    } finally {
      if (readerAdmin != null) {
        try {
          readerAdmin.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      if (readerUser != null) {
        try {
          readerUser.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      if (readerEmployee != null) {
        try {
          readerEmployee.close();
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    }
  }
  // TODO: viết hàm show tài khoản

  public void show_List_Account() {
    System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Ma tai khoan", "Ten tai khoan", "Mat khau", "Ma nhan vien",
        "Ma khach hang");
    for (taikhoan tk : this.listAccount) {
      tk.xuatThongTinTaiKhoan();
    }
  }

  // TODO: viết hàm chỉnh sửa tài khoản
  public void chinhSuaTaiKhoan() {
    String matktmp; // mã tài khoản cần chỉnh sửa
    int mode; // lựa chọn thông số cần chỉnh sửa

    System.out.println("Moi nhap ma tai khoan can chinh sua: ");
    matktmp = sc.next();
    for (taikhoan tk : this.listAccount) {
      if (tk.getMatk().equalsIgnoreCase(matktmp)) {
        while (true) {
          System.out.println("--------------------------------");
          System.out.println("======    SUA TAI KHOAN   ======");
          System.out.println("--------------------------------");
          System.out.println("1. Chinh sua ten tai khoan.");
          System.out.println("2. Chinh sua mat khau.");
          System.out.println("3. Chinh sua ma tai khoan.");
          System.out.println("4. Thoat");
          System.out.println("--------------------------------");
          System.out.println("Vui long chon: ");
          mode = sc.nextInt();
          sc.nextLine();
          switch (mode) {
            case 1:
              tk.setTentk();
              System.out.println("\nChinh sua ten tai khoan thanh cong!\n");
              break;
            case 2:
              tk.setPasswd();
              System.out.println("\nChinh sua mat khau tai khoan thanh cong!\n");
              break;
            case 3:
              tk.setMatk();
              System.out.println("\nChinh sua ma tai khoan thanh cong!\n");
              break;
          }

          if (mode == 4) {
            break;
          }
        }
      }

    }
  }

  public void chinhSuaTaiKhoan_menuchucnangnv(String matktmp) {
    int mode; // lựa chọn thông số cần chỉnh sửa
    for (taikhoan tk : this.listAccount) {
      if (tk.getMatk().equalsIgnoreCase(matktmp)) {
        while (true) {
          System.out.println("--------------------------------");
          System.out.println("======    SUA TAI KHOAN   ======");
          System.out.println("--------------------------------");
          System.out.println("1. Chinh sua ten tai khoan.");
          System.out.println("2. Chinh sua mat khau.");
          System.out.println("3. Thoat");
          System.out.println("--------------------------------");
          System.out.println("Vui long chon: ");
          mode = sc.nextInt();
          sc.nextLine();
          switch (mode) {
            case 1:
              tk.setTentk();
              System.out.println("\nChinh sua ten tai khoan thanh cong!\n");
              break;
            case 2:
              tk.setPasswd();
              System.out.println("\nChinh sua mat khau tai khoan thanh cong!\n");
              break;
          }

          if (mode == 3) {
            break;
          }
        }
        break;
      }
    }
  }

  public void MenuDanhSachTaiKhoan() throws IOException {
    // this.readAccountListFromFile();
    String mode;
    while (true) {
      System.out.println("\n");
      System.out.println("------------------------------------");
      System.out.println("==========    * MENU *    ==========");
      System.out.println("------------------------------------");
      System.out.println("1.Hien thi danh sach tai khoan");
      System.out.println("2.Chinh sua tai khoan");
      System.out.println("3.Xoa tai khoan");
      System.out.println("4.Thoat");
      System.out.println("------------------------------------");
      System.out.println("Vui long chon: ");
      mode = sc.next();
      if (mode.matches("[1-4]{1}") == false) {
        System.out.println("Vui long nhap so tu 1 den 4 !");
        continue;
      }
      switch (mode) {
        case "1":
          this.show_List_Account();
          break;
        case "2":
          this.chinhSuaTaiKhoan();
          break;
        case "3":
          this.xoaTaiKhoan();
          break;
      }
      if (mode.matches("4") == true) {
        this.writeAccountListToFile();
        break;
      }

    }
  }

  public static void main(String[] args) throws IOException {
    tk_list list = new tk_list();
    list.readAccountListFromFile();
    list.dangKi();
    list.MenuDanhSachTaiKhoan();
  }
}
