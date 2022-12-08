import java.util.Scanner;

public abstract class taikhoan {
  private String matk;
  private String tentk;
  private String passwd;
  Scanner sc = new Scanner(System.in);

  abstract String getMakhOrNv();

  abstract void parseAccount(String line);

  abstract void xuatThongTinTaiKhoan();
  abstract void xuatThongTinTaiKhoan_1();

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
    boolean checkDuLieu = true;
    String matktmp;
    do {
      System.out.println("Moi nhap ma tai khoan: ");
      matktmp = sc.next();
      if (matktmp.matches("[0-9]{1,}") == false) {
        checkDuLieu = false;
        System.out.println("Vui long nhap dung dinh dang ma tai khoan (VD: 12)");
        continue;
      } else {
        checkDuLieu = true;
        this.matk = matktmp;
      }
    } while (checkDuLieu == false);

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

  public String getFileLine() {
    return getMatk() + "," + getTentk() + "," + getPasswd() + "," + getMakhOrNv() + "\n";
  }
}
