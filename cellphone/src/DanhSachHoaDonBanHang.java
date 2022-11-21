
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHoaDonBanHang {
    private ArrayList<HoaDonBanHang> danhSach;

    public DanhSachHoaDonBanHang() {
        this.danhSach = new ArrayList<HoaDonBanHang>();
    }

    public DanhSachHoaDonBanHang(ArrayList<HoaDonBanHang> danhSach) {
        this.danhSach = danhSach;
    }

    // thêm
    public void them(HoaDonBanHang hd) {
        this.danhSach.add(hd);

    }

    // xóa
    public void xoa(String mahd) {
        HoaDonBanHang hdbh = new HoaDonBanHang();
        for (HoaDonBanHang hoaDonBanHang : danhSach) {
            if (hoaDonBanHang.getMahd().equals(mahd)) {
                hdbh = hoaDonBanHang;
            }

        }
        this.danhSach.remove(hdbh);
    }

    // sửa
    public void sua(String mahd) {
        for (HoaDonBanHang hoaDon : danhSach) {
            if (hoaDon.getMahd().equals(mahd)) {
                try (Scanner sc = new Scanner(System.in)) {
                    int luaChon = 0;
                    do {
                        System.out.println("MENU ----------");
                        System.out.println("Lựa chọn: ");
                        System.out.println(
                                "1. Sửa mã hóa đơn.\n"
                                        + "2. Sửa mã tài khoản.\n"
                                        + "3. Sửa mã khách hàng.\n"
                                        + "4. Sửa mã nhân viên.\n"
                                        + "5. Sửa điểm khách hàng.\n"
                                        + "6. Sửa danh sách sản phẩm.\n"
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
                            System.out.println("Nhập mã khách hàng mới: ");
                            String newMaKh = sc.nextLine();
                            hoaDon.setMakh(newMaKh);
                        }
                        if (luaChon == 4) {
                            System.out.println("Nhập mã nhân viên mới: ");
                            String newMaNv = sc.nextLine();
                            hoaDon.setmanv(newMaNv);
                        }
                        if (luaChon == 5) {
                            System.out.println("Nhập điểm khách hàng mới: ");
                            int newDiem = sc.nextInt();
                            hoaDon.setDiemkh(newDiem);
                        }
                        if (luaChon == 6) {
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
        for (HoaDonBanHang hoaDonBanHang : danhSach) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.println("Hóa đơn " + i + ": ");
            i = i + 1;
            hoaDonBanHang.xuatHoaDonBanHang();
        }
    }

}
