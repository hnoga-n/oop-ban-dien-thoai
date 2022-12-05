import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class giohang {
  private ArrayList<SanPham> spcart;
  Scanner sc = new Scanner(System.in);

  // private ArrayList<sanpham> inventoryProduct = new ArrayList<sanpham>();
  public static void main(String[] args) throws IOException {
    giohang cart = new giohang();
    QuanLiSanPham dssp = new QuanLiSanPham();
    dssp.docDuLieuTuFile();
    cart.themSp();
    cart.themSp();
    cart.xemGiohang();
    cart.goSpKhoiGiohang();
    cart.xemGiohang();
  }

  public giohang() {
    spcart = new ArrayList<SanPham>();
  }

  // Check giỏ hàng có rỗng?
  public boolean cartIsEmpty() {
    if (spcart.size() <= 0) {
      return true;
    }
    return false;
  }

  // TODO: THÊM VÀO GIỎ HÀNG

  public int themSp() throws IOException {
    String masptmp;
    QuanLiSanPham dssp = new QuanLiSanPham();

    dssp.docDuLieuTuFile();
    System.out.println("Nhap ma san pham can them: ");
    masptmp = sc.nextLine();

    // TODO: THÊM SỐ LƯỢNG SẢN PHẨM CẦN THÊM

    for (SanPham sp : dssp.getList()) {
      if (sp.getMasp().equalsIgnoreCase(masptmp)) {
        spcart.add(sp);
        System.out.println("Them san pham thanh cong !");
        return 1;
      }
    }
    System.out.println("Khong tim thay san pham can them !");
    return 1;
  }

  // Kiểm tra xem giỏ hàng có
  // TODO: GÕ SP KHỎI GIỎ HÀNG
  public int goSpKhoiGiohang() {
    String masptmp;
    System.out.println("Nhap ma san pham can go: ");
    masptmp = sc.next();
    for (SanPham sp : spcart) {
      if (sp.getMasp().equalsIgnoreCase(masptmp)) {
        spcart.remove(sp);
        System.out.println("Go san pham thanh cong!");
        return 1;
      }
    }
    System.out.println("Khong tim thay san pham trong gio hang !");
    return 1;
  }

  // TODO: XÓA TẤT CẢ SP KHỎI GIỎ HÀNG
  public void goAllSanphamKhoiGiohang() {
    spcart.clear();
    System.out.println("Clear gio hang thanh cong !");
  }

  // TODO: XEM GIỎ HÀNG

  public int xemGiohang() {
    if (spcart.size() == 0) {
      System.out.println("Gio hang dang rong, vui long them san pham !");
      return 1;
    }
    System.out.println("Danh sach san pham trong gio hang :");
    System.out.printf("%-15s%-15s%-45s%-15s%-15s%-25s\n", "mã sản phẩm", "hãng", "tên sản phẩm", "giá",
        "số lượng", "Thời gian bảo hành");
    for (SanPham sp : spcart) {
      System.out.printf("%-15s%-15s%-45s%-15s%-25s\n", sp.getMasp(), sp.getHang(), sp.getTensp(),
          sp.getGia(), sp.getSoluong(), sp.getThoiGianBaoHanh());
    }
    System.out.println("Tong gia:" + tongGia());
    ;
    return 1;
  }

  public int tongGia() {
    int tonggia = 0;
    for (SanPham sp : spcart) {
      tonggia = tonggia + sp.getGia();
    }
    return tonggia;
  }

  // TODO: THANH TOÁN
}
