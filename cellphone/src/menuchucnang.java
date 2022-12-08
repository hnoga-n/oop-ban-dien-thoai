import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.io.IOException;

public class menuchucnang implements interface_menuchucnang {
    Scanner sc = new Scanner(System.in);
    DANHSACHKHACHHANG listkh = new DANHSACHKHACHHANG();
    DANHSACHNHANVIEN listnv = new DANHSACHNHANVIEN();
    QuanLiSanPham listsp = new QuanLiSanPham();
    tk_list listtk = new tk_list();
    DanhSachDoiTac listdt = new DanhSachDoiTac();
    DanhSachHoaDonBanHang listbh = new DanhSachHoaDonBanHang();
    DanhsachHoaDonNhapHang listnh = new DanhsachHoaDonNhapHang();
    taikhoan tk = null;

    public void Menuchinh() throws IOException {
        String key;
        while (true) {
            listtk.readAccountListFromFile();
            System.out.println("\n");
            System.out.println("------------------------------------------");
            System.out.println("==========    * MENU CHINH *    ==========");
            System.out.println("------------------------------------------");
            System.out.println("1. Dang ki");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            System.out.println("------------------------------------------");
            System.out.print("Chon: ");
            key = sc.next();
            if (key.matches("[1-3]{1}") == false) {
                System.out.println("Vui long chon so tu 1 den 3 !");
                continue;
            } else {
                switch (key) {
                    case "1":
                        listtk.dangKi();
                        break;
                    case "2":
                        tk = listtk.dangNhap();
                        if (tk instanceof tkAdmin) {
                            Menuchucnangadmin();
                        } else if (tk instanceof tkKhachHang) {
                            Menuchucnanguser((tkKhachHang) tk);
                        } else if (tk instanceof tkNhanvien) {
                            tkNhanvien tknv = (tkNhanvien) tk;
                            Menuchucnangnhanvien(tknv);
                        } else {
                            System.out.println("Tai khoan khong ton tai !");
                        }
                        break;
                }
            }
            if (Integer.parseInt(key) == 3) {
                break;
            }
        }
    }

    public void Menuchucnangadmin() throws IOException {
        String key;
        while (true) {
            System.out.println("\n");
            System.out.println("------------------------------------------");
            System.out.println("==========    * MENU ADMIN *    ==========");
            System.out.println("------------------------------------------");
            System.out.println("1. Quan li khach hang");
            System.out.println("2. Quan li nhan vien");
            System.out.println("3. Quan li san pham");
            System.out.println("4. Quan li doi tac");
            System.out.println("5. Quan li hoa don");
            System.out.println("6. Quan li tai khoan");
            System.out.println("7. Thong ke ban hang");
            System.out.println("8. Thong ke nhap hang");
            System.out.println("9. Dang xuat");
            System.out.println("------------------------------------------");
            System.out.print("Chon: ");
            key = sc.next();
            if (key.matches("[1-9]{1}") == false) {
                System.out.println("Vui long chon so tu 1 den 9 !");
                continue;
            } else {
                switch (key) {
                    case "1":
                        listkh.MenuDanhSachKhachHang();
                        break;
                    case "2":
                        listnv.MenuDanhSachNhanVien();
                        break;
                    case "3":
                        listsp.chucNang();
                        break;
                    case "4":
                        listdt.menuDoiTac();
                        break;
                    case "5":
                        while (true) {
                            System.out.println("\n");
                            System.out.println("--------------------------------------------");
                            System.out.println("==========    * MENU HOA DON *    ==========");
                            System.out.println("--------------------------------------------");
                            System.out.println("1. Hoa don ban hang");
                            System.out.println("2. Hoa don nhap hang");
                            System.out.println("3. Thoat");
                            System.out.println("--------------------------------------------");
                            System.out.print("Chon: ");
                            String key1 = sc.next();
                            if (key1.matches("[1-3]{1}") == false) {
                                System.out.println("Vui long chon so tu 1 den 3 !");
                                continue;
                            }

                            else {
                                switch (key1) {
                                    case "1":
                                        listbh.Menu();
                                        break;
                                    case "2":
                                        listnh.Menu();
                                        break;
                                }
                            }
                            if (Integer.parseInt(key1) == 3) {
                                break;
                            }
                        }
                        break;
                    case "6":
                        listtk.MenuDanhSachTaiKhoan();
                        break;
                    case "7":
                        listbh.thongKeBanHang();
                        break;
                    case "8":
                        listnh.thongKeNhapHang();
                        break;
                }
            }
            if (Integer.parseInt(key) == 9) {
                break;
            }
        }
    }

    public void Menuchucnangnhanvien(tkNhanvien tknv) throws IOException {
        listnv.docfile();
        listtk.readAccountListFromFile();
        NHANVIEN nv = listnv.TimKiemNhanVienTheoMaNV(tknv.getMakhOrNv());
        while (true) {
            System.out.println("\n");
            System.out.println("----------------------------------------------");
            System.out.println("==========    * MENU NHAN VIEN *    ==========");
            System.out.println("----------------------------------------------");
            System.out.println("1. Xem thong tin ca nhan");
            System.out.println("2. Sua thong tin ca nhan");
            System.out.println("3. Xem thong tin tai khoan");
            System.out.println("4. Sua thong tin tai khoan");
            System.out.println("5. Xem don hang da ban");
            System.out.println("6. Thoat");
            System.out.println("----------------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();
            if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 6)
                System.out.println("Vui long chon so tu 1 den 6 !");
            else {
                switch (key) {
                    case "1":
                        nv.XuatNhanVien_1();
                        break;
                    case "2":
                        listnv.SuaNhanVien_menuchucnangnv(tknv.getMakhOrNv());
                        listnv.ghiFile();
                        break;
                    case "3":
                        tkNhanvien tknvtmp;
                        for (taikhoan obj : listtk.getListAccountArr()) {
                            if (obj.getMatk().equalsIgnoreCase(tknv.getMatk())) {
                                tknvtmp = (tkNhanvien) obj;
                                tknvtmp.xuatThongTinTaiKhoan_menuchucnangnv();
                                break;
                            }
                        }
                        break;

                    case "4":
                        listtk.chinhSuaTaiKhoan_menuchucnangnv(tknv.getMatk());
                        listtk.writeAccountListToFile();
                        break;

                    case "5":
                        break;

                    case "6":
                        break;
                }
            }
            if (Integer.parseInt(key) == 6) {
                break;
            }
        }
    }

    public void Menuchucnanguser(tkKhachHang tk) throws IOException {
        giohang cart = new giohang();
        String key;
        try {
            while (true) {
                // key = "";
                System.out.println("\n");
                System.out.println("------------------------------------");
                System.out.println("==========    * MENU *    ==========");
                System.out.println("------------------------------------");
                System.out.println("1. Xem danh sach san pham");
                System.out.println("2. Them san pham vao gio hang");
                System.out.println("3. Xem gio hang");
                System.out.println("4. Chinh sua so luong san pham trong gio hang");
                System.out.println("5. Xoa san pham khoi gio hang");
                System.out.println("6. Xoa toan bo san pham khoi gio hang");
                System.out.println("7. Thanh toan");
                System.out.println("8. Xem lai don hang da dat");
                System.out.println("9. Huy don hang");
                System.out.println("10. Dang xuat");
                System.out.println("------------------------------------");
                System.out.print("Chon: ");
                key = sc.next();
                if (key.matches("[0-9]{1,5}") == false) {
                    System.out.println("Vui long chon so tu 1 den 10 !");
                    continue;
                } else {
                    switch (key) {
                        case "1":
                            listsp.docDuLieuTuFile();
                            listsp.xuatDanhSach();
                            break;
                        case "2":
                            cart.themSp();
                            break;
                        case "3":
                            cart.xemGiohang();
                            break;
                        case "4":
                            cart.chinhSuaSoLuongSanPham();
                            break;
                        case "5":
                            cart.goSpKhoiGiohang();
                            break;
                        case "6":
                            cart.goAllSanphamKhoiGiohang();
                            break;
                        case "7":
                            cart.thanhToan(tk);
                            break;
                        case "8":
                            cart.xemDonhang(tk);
                            ;
                            break;
                        case "9":
                            cart.huyDonHang(tk);
                            break;
                        case "10":
                            if (cart.cartIsEmpty() == false) {
                                System.out.println("Gio hang van con san pham, ban van muon thoat ?");
                                System.out.println("1. Co");
                                System.out.println("2. Khong");
                                System.out.println("---------------");
                                System.out.println("Moi chon: ");
                                int yesno;
                                yesno = sc.nextInt();
                                switch (yesno) {
                                    case 1:
                                        cart.goAllSanphamKhoiGiohang();
                                        break;
                                    case 2:
                                        key = "69";
                                        break;
                                }
                            } else {
                                break;
                            }

                    }
                }
                if (key.matches("10") == true) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        menuchucnang menu = new menuchucnang();
        menu.Menuchucnangadmin();
    }
}
