import java.util.Scanner;

public abstract class taikhoan {
  private String matk;
  private String tentk;
  private String passwd;
  Scanner sc = new Scanner(System.in);

  abstract String getMakhOrNv();

  abstract void parseAccount(String line);

  abstract void xuatThongTinTaiKhoan();

  public static void main(String[] args) {

  }

  public taikhoan() {
    matk = null;
    tentk = null;
    passwd = null;
  }

  public taikhoan(String matk, String tentk, String passwd) {
    this.matk = matk;
    this.tentk = tentk;
    this.passwd = passwd;

  }

  public void setMatk() {
    System.out.println("moi nhap ma tai khoan: ");
    this.matk = sc.nextLine();
  }

  public void setMatk(String matk) {
    this.matk = matk;
  }

  public String getMatk() {
    return this.matk;
  }

  public void setPasswd() {
    System.out.println("moi nhap mat khau: ");
    this.passwd = sc.nextLine();
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getPasswd() {
    return this.passwd;
  }

  public void setTentk() {
    System.out.println("moi nhap ten tai khoan: ");
    this.tentk = sc.nextLine();
  }

  public void setTentk(String tentk) {
    this.tentk = tentk;
  }

  public String getTentk() {
    return this.tentk;
  }

  public void nhapTaikhoan() {
    this.setTentk();
    this.setPasswd();
  }

}
