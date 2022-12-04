import java.util.Scanner;
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

    public void Menuchinh() throws IOException {
        String key;
        while (true) {
            listtk.readAccountListFromFile();
            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Dang ki");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            System.out.println("------------------------------------");
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
                        taikhoan tk = listtk.dangNhap();
                        if (tk instanceof tkAdmin) {
                            Menuchucnangadmin();
                        } else if (tk instanceof tkKhachHang) {
                            Menuchucnanguser((tkKhachHang) tk);
                        } else if (tk instanceof tkNhanvien) {
                            System.out.println("Im nv");
                        } else {
                            System.out.println("I have not account");
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
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Quan li khach hang");
            System.out.println("2. Quan li nhan vien");
            System.out.println("3. Quan li san pham");
            System.out.println("4. Quan li doi tac");
            System.out.println("5. Quan li hoa don");
            System.out.println("6. Quan li tai khoan");
            System.out.println("7. Dang xuat");
            System.out.println("------------------------------------");
            System.out.print("Chon: ");
            key = sc.next();
            if (key.matches("[1-7]{1}") == false) {
                System.out.println("Vui long chon so tu 1 den 7 !");
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
                            System.out.println("------------------------------------");
                            System.out.println("==========    * MENU *    ==========");
                            System.out.println("------------------------------------");
                            System.out.println("1. Hoa don ban hang");
                            System.out.println("2. Hoa don nhap hang");
                            System.out.println("3. Thoat");
                            System.out.println("------------------------------------");
                            System.out.print("Chon: ");
                            String key1 = sc.nextLine();
                            if (Integer.parseInt(key1) < 1 || Integer.parseInt(key1) > 3)
                                System.out.println("Vui long chon so tu 1 den 3 !");
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
                }
            }
            if (Integer.parseInt(key) == 7) {
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
                System.out.println("4. Xoa san pham khoi gio hang");
                System.out.println("5. Xoa toan bo san pham khoi gio hang");
                System.out.println("6. Thanh toan");
                System.out.println("7. Dang xuat");
                System.out.println("------------------------------------");
                System.out.print("Chon: ");
                key = sc.next();
                if (key.matches("[1-7]{1}") == false) {
                    System.out.println("Vui long chon so tu 1 den 7 !");
                    continue;
                } else {
                    switch (key) {
                        case "1":
                            listsp.xuatDanhSach();
                            break;
                        case "2":
                            cart.themSp();
                            break;
                        case "3":
                            cart.xemGiohang();
                            break;
                        case "4":
                            cart.goSpKhoiGiohang();
                            break;
                        case "5":
                            cart.goAllSanphamKhoiGiohang();
                            break;
                        case "6":
                            System.out.println("thanh toan");
                            break;
                        case "7":
                            System.out.println("Gio hang van con san pham, ban co muon thoat ?");
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
                    }
                }
                if (key.matches("7") == true) {
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
