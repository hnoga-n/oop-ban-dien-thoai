import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class giohang {
  private ArrayList<SanPham> spcart;
  Scanner sc = new Scanner(System.in);

  // private ArrayList<sanpham> inventoryProduct = new ArrayList<sanpham>();
  public static void main(String[] args) throws IOException {

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
    String soLuongMua;
    QuanLiSanPham dssp = new QuanLiSanPham();
    dssp.docDuLieuTuFile();

    System.out.println("Nhap ma san pham can them: ");
    masptmp = sc.next();

    // kiểm tra xem giỏ hàng đã có sản phẩm chưa, nếu rồi thì ngắt hàm
    for (SanPham sptmp : spcart) {
      if (sptmp.getMasp().equalsIgnoreCase(masptmp)) {
        System.out
            .println("San pham da co trong gio hang, neu muon thay doi so luong vui long chon chinh sua gio hang !");
        return 1;
      }
    }

    for (SanPham sp : dssp.getList()) {
      if (sp.getMasp().equalsIgnoreCase(masptmp)) { // check xem trong kho còn sản phẩm không
        if (sp.getSoluong() == 0) {
          System.out.println("So luong san pham trong kho da het, vui long chon san pham khac !");
          return -1;
        }
        do {
          System.out.println("Nhap so luong can them: ");
          soLuongMua = sc.next();

          // check dữ liệu số
          if (soLuongMua.matches("[0-9]{1,}") == false) {
            System.out.println("Vui long khong nhap cac ki tu khac ngoai so !");
            continue;
          }
          if (soLuongMua.matches("0") == true) {
            System.out.println("So luong phai lon hon 0 !");
            continue;
          }

          // check số lượng sản phẩm còn lại trong kho có đủ không
          if (sp.getSoluong() < Integer.parseInt(soLuongMua))
            System.out.println("So luong san pham trong kho khong du ! ( con lai " + sp.getSoluong() + " san pham )");
        } while (sp.getSoluong() < Integer.parseInt(soLuongMua));

        SanPham tmp = new SanPham(sp);
        tmp.setSoluong(Integer.parseInt(soLuongMua));
        spcart.add(tmp); // add sp mới vào gio hàng

        int newQuantity = sp.getSoluong() - Integer.parseInt(soLuongMua);
        sp.setSoluong(newQuantity); // trừ đi số lượng trong kho
        dssp.ghiDuLieuVaoFile();

        System.out.println("Them san pham thanh cong !");
        return 1;
      }
    }
    System.out.println("Khong tim thay san pham can them !");
    return -1;
  }

  // Chỉnh sửa giỏ hàng
  public int chinhSuaSoLuongSanPham() throws IOException {
    String masptmp;
    String soLuongMoi;
    boolean quantityFlag = true;
    QuanLiSanPham dssp = new QuanLiSanPham();
    dssp.docDuLieuTuFile();

    System.out.println("Nhap ma san pham can chinh sua: ");
    masptmp = sc.next();
    for (SanPham sp : spcart) {
      if (sp.getMasp().equalsIgnoreCase(masptmp)) {
        do {
          // check dữ liệu số
          System.out.println("Moi nhap so luong can chinh sua: ");
          soLuongMoi = sc.next();
          if (soLuongMoi.matches("[0-9]{1,}") == false) {
            System.out.println("Vui long khong nhap cac ki tu khac ngoai so !");
            continue;
          }
          if (soLuongMoi.matches("0") == true) {
            System.out.println("So luong phai lon hon 0 !");
            continue;
          }
          // check số lượng sản phẩm trong kho

          for (SanPham spKho : dssp.getList()) {
            if ((spKho.getMasp().equalsIgnoreCase(masptmp))
                && ((spKho.getSoluong() + sp.getSoluong()) < Integer.parseInt(soLuongMoi))) {
              System.out.println("So luong san pham trong kho khong du ( con lai "
                  + (spKho.getSoluong() + sp.getSoluong()) + " san pham ) ! ");
              quantityFlag = false;
            } else {
              quantityFlag = true;
            }
          }

        } while (quantityFlag == false);
        // chỉnh sửa sản phẩm trong kho
        for (SanPham spKho : dssp.getList()) {
          if (spKho.getMasp().equalsIgnoreCase(masptmp)) {
            spKho.setSoluong(spKho.getSoluong() + sp.getSoluong() - Integer.parseInt(soLuongMoi));
          }

        }
        sp.setSoluong(Integer.parseInt(soLuongMoi));

        dssp.ghiDuLieuVaoFile();
        System.out.println("Chinh sua so luong thanh cong !");
        return 1;
      }
    }
    System.out.println("Khong tim thay san pham can them trong gio hang !");
    return -1;
  }

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
      System.out.printf("%-15s%-15s%-45s%-15s%-15s%-25s\n", sp.getMasp(), sp.getHang(), sp.getTensp(),
          sp.getGia(), sp.getSoluong(), sp.getThoiGianBaoHanh());
    }
    System.out.println("Tong gia:" + tongGia());
    ;
    return 1;
  }

  public int tongGia() {
    int tonggia = 0;
    for (SanPham sp : spcart) {
      tonggia = tonggia + sp.getGia() * sp.getSoluong();
    }
    return tonggia;
  }

  // xem các đơn hàng đã đặt
  public void xemDonhang(tkKhachHang tk) throws IOException {
    DanhSachHoaDonBanHang dsbh = new DanhSachHoaDonBanHang();
    dsbh.docDuLieuTuFile();
    for (HoaDonBanHang hdbh : dsbh.getArray()) {
      if (hdbh.getmatk().equalsIgnoreCase(tk.getMatk())) {
        hdbh.xuatHoaDonBanHang();
      }
    }
  }

  // hủy đơn hàng
  public int huyDonHang(tkKhachHang tk) throws IOException {
    String maHdCanHuy;
    DanhSachHoaDonBanHang dsbh = new DanhSachHoaDonBanHang();
    dsbh.docDuLieuTuFile();

    System.out.println(
        "Moi nhap ma don hang can huy (LUU Y: chi nhung hoa don co ma nhan vien bang NULL moi co the huy ! ): )");
    maHdCanHuy = sc.next();
    for (HoaDonBanHang hdbh : dsbh.getArray()) {
      if (hdbh.getMahd().equalsIgnoreCase(maHdCanHuy) && hdbh.getmatk().equalsIgnoreCase(tk.getMatk())) {
        if (hdbh.getManv().equals("null") == false) {
          System.out.println("Hoa don da duoc xu li, khong the huy !");
          return -1;
        } else {
          dsbh.getArray().remove(hdbh);
          System.out.println("Huy don hang thanh cong !");
          dsbh.ghiDuLieuVaoFile();
          return 1;
        }
      }
    }
    System.out.println("Khong tim thay don hang !");
    return -1;
  }

  // TODO: THANH TOÁN
  public void thanhToan(taikhoan tk) throws IOException {
    DanhSachHoaDonBanHang dsbh = new DanhSachHoaDonBanHang();
    dsbh.docDuLieuTuFile();
    int maHdGanNhat = Integer.parseInt(dsbh.getArray().get(dsbh.getArray().size() - 1).getMahd().substring(2)) + 1;
    LocalDate ld = LocalDate.now(); // lấy ngày hiện tại
    Ngay date = new Ngay(ld.getDayOfMonth(), ld.getMonthValue(), ld.getYear());
    QuanLiSanPham dssp = new QuanLiSanPham(spcart);
    HoaDonBanHang hd = new HoaDonBanHang("hd" + maHdGanNhat, tk.getMatk(), date, dssp, tk.getMakhOrNv(), "null",
        12);
    dsbh.them(hd);
    dsbh.ghiDuLieuVaoFile();
    spcart.clear();
    System.out.println("Thanh toan thanh cong");
  }

}
