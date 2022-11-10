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

  public tkKhachHang(String matk, String tentk, String passwd, String makh) {
    super(matk, tentk, passwd);
    this.makh = makh;
    this.cart = new giohang();
  }

}
