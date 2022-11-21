import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class tk_list {
  private ArrayList<taikhoan> listAccount = new ArrayList<taikhoan>();
  private int soLuongtk;
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    tk_list list = new tk_list();
    list.MenuDanhSachTaiKhoan();

  }

  public int dangKi() throws IOException {
    tk_list list = new tk_list();
    DANHSACHKHACHHANG kh = new DANHSACHKHACHHANG();
    kh.docfile(); // đọc file dskh
    list.readAccountListFromFile();

    // tạo tài khoản khách hàng

    KHACHHANG khtmp = new KHACHHANG();
    String makhtmp;
    makhtmp = "KH" + kh.getArray().size();
    khtmp.NhapKhachHang(makhtmp);

    taikhoan tktmp = new tkKhachHang(makhtmp);
    tktmp.nhapTaikhoan();
    tktmp.setMatk("TK" + list.listAccount.size());

    listAccount.add(tktmp);
    list.writeAccountListToFile();
    return 1;

  }

  public taikhoan dangNhap() {
    String tentktmp;
    String passwdtmp;
    taikhoan tmp = null;
    System.out.println("Nhap ten tk:");
    tentktmp = sc.nextLine();
    passwdtmp = sc.nextLine();
    for (taikhoan obj : listAccount) {
      if (obj.getTentk().equalsIgnoreCase(tentktmp) && obj.getPasswd().equalsIgnoreCase(passwdtmp)) {
        tmp = obj;
        break;
      }
    }
    return tmp;
  }

  public void xoaTaiKhoan() {
    String matktmp;
    taikhoan tktmp = null;

    System.out.println("Nhap ma tai khoan can xoa: ");
    matktmp = sc.nextLine();
    for (int i = 0; i < this.listAccount.size(); i++) {
      if (this.listAccount.get(i).getMatk() == matktmp) {
        this.listAccount.remove(listAccount.get(i));
        System.out.println("\nXoa tai khoan thanh cong!\n");
        break;
      }
    }

  }

  public void writeAccountListToFile() {
    try {
      BufferedWriter writerAdmin = new BufferedWriter(new FileWriter("adminAccount.txt"));
      BufferedWriter writerUser = new BufferedWriter(new FileWriter("userAccount.txt"));
      BufferedWriter writerEmployee = new BufferedWriter(new FileWriter("employeeAccount.txt"));

      for (taikhoan tk : this.listAccount) {
        if (tk instanceof tkAdmin) {
          writerAdmin.write(tk.getMatk() + "," + tk.getTentk() + "," + tk.getPasswd() + "," + tk.getMakhOrNv());
          writerAdmin.close();
        }
        if (tk instanceof tkNhanvien) {
          writerEmployee.write(tk.getMatk() + "," + tk.getTentk() + "," + tk.getPasswd() + "," + tk.getMakhOrNv());
          writerEmployee.close();
        }
        if (tk instanceof tkKhachHang) {
          writerUser.write(tk.getMatk() + "," + tk.getTentk() + "," + tk.getPasswd() + "," + tk.getMakhOrNv());
          writerUser.close();
        }
      }
    } catch (IOException e) {

      e.printStackTrace();
    }
  }

  public void readAccountListFromFile() {
    String line;
    try {
      BufferedReader readerAdmin = new BufferedReader(new FileReader("adminAccount.txt"));
      BufferedReader readerUser = new BufferedReader(new FileReader("userAccount.txt"));
      BufferedReader readerEmployee = new BufferedReader(new FileReader("employeeAccount.txt"));
      while ((line = readerAdmin.readLine()) != null) {
        taikhoan tmp = new tkAdmin();
        tmp.parseAccount(line);
        this.listAccount.add(tmp);
      }
      while ((line = readerUser.readLine()) != null) {
        taikhoan tmp = new tkKhachHang();
        tmp.parseAccount(line);
        this.listAccount.add(tmp);
      }
      while ((line = readerEmployee.readLine()) != null) {
        taikhoan tmp = new tkNhanvien();
        tmp.parseAccount(line);
        this.listAccount.add(tmp);
      }

      readerAdmin.close();
      readerEmployee.close();
      readerUser.close();
    } catch (IOException e) {

      e.printStackTrace();
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
  public void editAcoountForAdmin() {
    String matktmp; // mã tài khoản cần chỉnh sửa
    taikhoan tktmp; // tài khoản cần chỉnh sửa
    int mode; // lựa chọn thông số cần chỉnh sửa

    System.out.println("Moi nhap ma tai khoan can chinh sua: ");
    matktmp = sc.next();
    for (taikhoan tk : this.listAccount) {
      if (tk.getMatk().equalsIgnoreCase(matktmp)) {
        while (true) {
          System.out.println("1. Chinh sua ten tai khoan.");
          System.out.println("2. Chinh sua mat khau.");
          System.out.println("3. Chinh sua ma tai khoan.");
          System.out.println("4. Thoat");
          System.out.println("Vui long chon: ");
          mode = sc.nextInt();
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
        break;
      }

    }
  }

  public void MenuDanhSachTaiKhoan() {
    this.readAccountListFromFile();
    int mode;
    while (true) {
      System.out.println("\n");
      System.out.println("1.Hien thi danh sach tai khoan");
      System.out.println("2.Chinh sua tai khoan");
      System.out.println("3.Xoa tai khoan");
      System.out.println("4.Thoat.");
      mode = sc.nextInt();
      switch (mode) {
        case 1:
          this.show_List_Account();
          break;
        case 2:
          this.editAcoountForAdmin();
          break;
        case 3:
          this.xoaTaiKhoan();
          break;
      }

      if (mode == 4) {
        this.writeAccountListToFile();
        this.show_List_Account();
        break;
      }

    }
  }
}
