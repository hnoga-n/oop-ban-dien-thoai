import java.util.Scanner;
import java.io.IOException;
public class menuchucnang implements interface_menuchucnang{
    Scanner sc = new Scanner(System.in);
    DANHSACHKHACHHANG listkh = new DANHSACHKHACHHANG();
    DANHSACHNHANVIEN listnv = new DANHSACHNHANVIEN();
    QuanLiSanPham listsp = new QuanLiSanPham();
    tk_list listtk = new tk_list();
    DanhSachDoiTac listdt = new DanhSachDoiTac();
    DanhSachHoaDonBanHang listbh = new DanhSachHoaDonBanHang();
    DanhsachHoaDonNhapHang listnh = new DanhsachHoaDonNhapHang();
    public void Menuchinh() throws IOException {
        tk_list listtk = new tk_list();
        listtk.readAccountListFromFile();
        while (true) {
            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Dang ki");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();
            if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 3)
                System.out.println("Vui long chon so tu 1 den 3 !");
            else {
                switch (key) {
                    case "1":
                        listtk.dangKi();
                        break;
                    case "2":
                        taikhoan tk = listtk.dangNhap();
                        if(tk instanceof tkAdmin) {
                            Menuchucnangadmin();
                        }
                        else if(tk instanceof tkKhachHang) {
                            System.out.println("Im kh");
                        }
                        else if(tk instanceof tkNhanvien) {
                            System.out.println("Im nv");
                        }
                        else {
                            System.out.println("I have not account");
                        }
                        break;
                    case "3":
                        break;
                }
            }
            if (Integer.parseInt(key) == 3) {
                break;
            }
        }
    }

    public void Menuchucnangadmin() throws IOException{
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
            String key = sc.nextLine();
            if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 7)
                System.out.println("Vui long chon so tu 1 den 7 !");
            else {
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
    public static void main(String[] args) throws IOException{
        menuchucnang menu = new menuchucnang();
        menu.Menuchucnangadmin();
    }
}
