public class tkAdmin extends taikhoan {
  private String manv;

  public static void main(String[] args) {

  }

  public tkAdmin() {
    super();
    manv = null;
  }

  public tkAdmin(String matk, String tentk, String passwd, String manv) {
    super(matk, tentk, passwd);
    this.manv = manv;
  }
}
