public class tkNhanvien extends taikhoan {
  private String manv;

  public tkNhanvien(String manv) {
    this.manv = manv;
  }

  public tkNhanvien() {
    super();
    manv = null;
  }

  public tkNhanvien(String matk, String tentk, String passwd, String manv) {
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

  public void xuatThongTinTaiKhoan() {
    System.out.printf("%-15s%-15s%-15s%-15s\n", getMatk(), getTentk(), getPasswd(), this.manv);
  }

  public void xuatThongTinTaiKhoan_menuchucnangnv() {
    System.out.printf("%-15s%-15s%-15s%-15s\n", "Ma tai khoan", "Ten tai khoan", "Mat khau", "Ma nhan vien");
    System.out.printf("%-15s%-15s%-15s%-15s\n", getMatk(), getTentk(), getPasswd(), this.manv);
  }

  public void xuatThongTinTaiKhoan_1() {
    System.out.printf("%-15s%-15s%-15s%-15s\n", "Ma tai khoan", "Ten tai khoan", "Mat khau", "Ma nhan vien");
    System.out.printf("%-15s%-15s%-15s%-15s\n", getMatk(), getTentk(), getPasswd(), this.manv);
  }

  public void parseAccount(String line) {
    String[] employeeAttribute = line.split(",");

    this.setMatk(employeeAttribute[0]);
    this.setTentk(employeeAttribute[1]);
    this.setPasswd(employeeAttribute[2]);
    this.setManv(employeeAttribute[3]);
  }

}
