public class tkKhachHang extends taikhoan {
  private String makh;
  private giohang cart;

  public static void main(String[] args) {

  }

  public tkKhachHang() {
    super();
    makh = null;
    cart = new giohang();
  }

  public tkKhachHang(String makh) {
    this.makh = makh;
    cart = new giohang();
  }

  public tkKhachHang(String matk, String tentk, String passwd, String makh) {
    super(matk, tentk, passwd);
    this.makh = makh;
    this.cart = new giohang();
  }

  public void setMaKh() {
    System.out.println("Moi nhap ma khach hang");
    this.makh = sc.nextLine();
  }

  public void setMaKh(String makh) {
    this.makh = makh;
  }

  public String getMakhOrNv() {
    return this.makh;
  }

  public void xuatThongTinTaiKhoan() {
    System.out.printf("%-15s%-15s%-15s%-15s%-15s", getMatk(), getTentk(), getPasswd(), null, this.makh);
  }

  public void parseAccount(String line) {
    String[] userAttribute = line.split(",");

    this.setMatk(userAttribute[0]);
    this.setTentk(userAttribute[1]);
    this.setPasswd(userAttribute[2]);
    this.setMaKh(userAttribute[3]);
  }

}
