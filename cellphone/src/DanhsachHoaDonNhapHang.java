
import java.util.ArrayList;
import java.util.Scanner;

public class DanhsachHoaDonNhapHang {
    private ArrayList<HoaDonNhapHang> danhSach;

    public DanhsachHoaDonNhapHang(ArrayList<HoaDonNhapHang> danhSach) {
        this.danhSach = danhSach;
    }

    public DanhsachHoaDonNhapHang() {
        this.danhSach = new ArrayList<HoaDonNhapHang>();
    }

    // thêm
    public void them(HoaDonNhapHang sp) {
        this.danhSach.add(sp);

    }

    // xóa
    public void xoa(String mahd) {
        HoaDonNhapHang hdbh = new HoaDonNhapHang();
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            if (hoaDonNhapHang.getMahd().equals(mahd)) {
                hdbh = hoaDonNhapHang;
            }
        }
        this.danhSach.remove(hdbh);
    }

    // sửa
    public void sua(String mahd) {
        for (HoaDonNhapHang hoaDon : danhSach) {
            if (hoaDon.getMahd().equals(mahd)) {
                try (Scanner sc = new Scanner(System.in)) {
                    int luaChon = 0;
                    do {
                        System.out.println("MENU ----------");
                        System.out.println("Lựa chọn: ");
                        System.out.println(
                                "1. Sửa mã hóa đơn.\n"
                                        + "2. Sửa mã tài khoản.\n"
                                        + "3. Sửa mã đối tác.\n"
                                        + "4. Sửa điểm đối tác.\n"
                                        + "5. Sửa danh sách sản phẩm.\n"
                                        + "0. Thoát.\n");
                        luaChon = sc.nextInt();
                        sc.nextLine();
                        if (luaChon == 1) {
                            System.out.println("Nhập mã hóa đơn mới: ");
                            String newMaHd = sc.nextLine();
                            hoaDon.setMahd(newMaHd);
                        }
                        if (luaChon == 2) {
                            System.out.println("Nhập mã tài khoản mới: ");
                            String newMaTk = sc.nextLine();
                            hoaDon.setmatk(newMaTk);
                        }
                        if (luaChon == 3) {
                            System.out.println("Nhập mã đối tác mới: ");
                            String newMaDt = sc.nextLine();
                            hoaDon.setMadt(newMaDt);
                        }
                        if (luaChon == 4) {
                            System.out.println("Nhập điểm đối tác mới: ");
                            int newDiem = sc.nextInt();
                            hoaDon.setDiemdt(newDiem);
                        }
                        if (luaChon == 5) {
                            System.out.println("Nhập mã sản phẩm cần sửa: ");
                            String masp = sc.nextLine();
                            hoaDon.getdssp().sua(masp);
                        }
                    } while (luaChon != 0);
                }
            }
        }
    }

    // xuất danh sách hóa đơn
    public void xuatDanhSach() {
        int i = 1;
        for (HoaDonNhapHang hoaDonNhapHang : danhSach) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.println("Hóa đơn " + i + ": ");
            i = i + 1;
            hoaDonNhapHang.xuatHoaDonNhapHang();
        }
    }
}
