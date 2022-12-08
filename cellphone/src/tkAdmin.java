import java.util.Scanner;

public class tkAdmin extends taikhoan {
  private String manv;

  public static void main(String[] args) {

  }

  public tkAdmin() {
    super();
    manv = null;
  }

  public tkAdmin(String manv) {
    this.manv = manv;
  }

  public tkAdmin(String matk, String tentk, String passwd, String manv) {
    super(matk, tentk, passwd);
    this.manv = manv;
  }

  public void setManv() {
    System.out.println("Moi nhap ma nhan vien");
    this.manv = sc.nextLine();
  }

  public void setManv(String manv) {
    this.manv = manv;
  }

  public String getMakhOrNv() {
    return this.manv;
  }

  public void parseAccount(String line) {
    String[] adminAttribute = line.split(",");

    this.setMatk(adminAttribute[0]);
    this.setTentk(adminAttribute[1]);
    this.setPasswd(adminAttribute[2]);
    this.setManv(adminAttribute[3]);
  }

  public void xuatThongTinTaiKhoan() {
    System.out.printf("%-15s%-15s%-15s%-15s\n", getMatk(), getTentk(), getPasswd(), this.manv);
  }

  public void xuatThongTinTaiKhoan_1() {
    System.out.printf("%-15s%-15s%-15s%-15s\n", "Ma tai khoan", "Ten tai khoan", "Mat khau", "Ma nhan vien");
    System.out.printf("%-15s%-15s%-15s%-15s\n", getMatk(), getTentk(), getPasswd(), this.manv);
  }
}
