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
    list.readAccountListFromFile();

  }

  public int dangKi()// truyền vào 2 biến mảng nhân viên và mảng khách hàng để thao tác
  {
    tk_list list = new tk_list();
    DANHSACHKHACHHANG kh = new DANHSACHKHACHHANG();

    list.readAccountListFromFile();

    // tạo tài khoản khách hàng

    KHACHHANG khtmp = new KHACHHANG();
    String makhtmp;
    makhtmp = "KH" + b.getArray().size();
    khtmp.NhapKhachHang(makhtmp);
    khtmp.setMatk("TK" + list.listAccount.size());

    taikhoan tktmp = new tkKhachHang(makhtmp);
    tktmp.nhapTaikhoan();
    tktmp.setMatk("TK" + list.listAccount.size());

    listAccount.add(tktmp);
    writeAccountListToFile(list.listAccount);
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
    System.out.println("Nhap ma tk can xoa: ");
    matktmp = sc.nextLine();
    for (int i = 0; i < listAccount.size(); i++) {
      if (listAccount.get(i).getMatk() == matktmp) {
        listAccount.remove(listAccount.get(i));
      }
    }

  }

  public void writeAccountListToFile(ArrayList<taikhoan> accountList) {
    try {
      BufferedWriter writerAdmin = new BufferedWriter(new FileWriter("adminAccount.txt"));
      BufferedWriter writerUser = new BufferedWriter(new FileWriter("userAccount.txt"));
      BufferedWriter writerEmployee = new BufferedWriter(new FileWriter("employeeAccount.txt"));

      for (taikhoan tk : accountList) {
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
    System.out.printf("%-15s%-15s%-15s%-15s%-15s", "Ma tai khoan", "Ten tai khoan", "Mat khau", "Ma nhan vien",
        "Ma khach hang");
    for (taikhoan tk : listAccount) {
      tk.xuatThongTinTaiKhoan();
    }
  }
  // TODO: chỉnh sửa hàm xóa tài khoản
  // TODO: viết hàm chỉnh sửa tài khoản

}
