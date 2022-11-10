import java.util.ArrayList;
import java.util.Scanner;

public class DANHSACHKHACHHANG {
    private ArrayList<KHACHHANG> arrkh = new ArrayList<KHACHHANG>();
    private int soluongkh;
    Scanner sc = new Scanner(System.in);

    public void NhapDanhSachKH() {
        System.out.print("So luong khach hang: ");
        soluongkh = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------");
        KHACHHANG a;
        for(int i=0 ; i<soluongkh ; i++){
            a = new KHACHHANG();
            a.NhapKhachHang();
            arrkh.add(a);
        }
    }
    public void XuatDanhSachKH() {
        if(arrkh != null) {
            System.out.println("===============================================================================================");
            System.out.printf("%-20s%-25s%-15s%-20s%-20s\n","MA KHACH HANG","HO TEN","NAM SINH","SO DIEN THOAI","MA TAI KHOAN");
            System.out.println("===============================================================================================");
            
            for(KHACHHANG obj : arrkh) {
                System.out.println(obj.XuatKhachHang());
                System.out.println("-----------------------------------------------------------------------------------------------");
            }      
        }
        else {
            System.out.println("Danh sach rong ,vui long nhap danh sach !");                
        }
    }
    public void ThemKhachHang() {
        if(arrkh == null) {
            System.out.println("Danh sach rong ,vui long nhap danh sach !");
        }
        else {
            KHACHHANG a = new KHACHHANG();
            a.NhapKhachHang();
            arrkh.add(a);
        }
    }
    public KHACHHANG TimKiemKhachHangTheoMaKH(String makh) {
        KHACHHANG kh = null;
        for(KHACHHANG obj : arrkh) {
            if(obj.getMakh().equalsIgnoreCase(makh)) {
                kh = obj;
                break;
            }
        }
        return kh;
    }
    public void TimKiemKhachHang() {
        System.out.print("Nhap ma khach hang can tim: ");
        String makh = sc.nextLine();
        KHACHHANG nv = null;
        nv = TimKiemKhachHangTheoMaKH(makh);
        if (nv != null)
            nv.XuatKhachHang_1();
        else  
            System.out.println("Khong tim thay khach hang !");
    }
    public void XoaKhachHang() {
        System.out.print("Nhap ma khach hang can xoa: ");
        String makh = sc.nextLine();
        KHACHHANG nv = null;
        nv = TimKiemKhachHangTheoMaKH(makh);
        if(nv != null) {
            for(KHACHHANG obj : arrkh) {
                if(obj == nv) {
                    arrkh.remove(obj);
                    System.out.println("Xoa thanh cong khach hang!");
                    break;
                }
            }
        }
        else
            System.out.println("Khong tim thay khach hang !");
    } 
    public void SuaKhachHang() {
        System.out.print("Nhap ma khach hang can sua: ");
        String manv = sc.nextLine();
        KHACHHANG nv = null;
        nv = TimKiemKhachHangTheoMaKH(manv);
        if(nv != null) {
            for(KHACHHANG obj : arrkh) {
                if(obj == nv) { 
                    while(true) {
                        System.out.println("\n");
                        System.out.println("--------------------------------");
                        System.out.println("======    SUA THONG TIN   ======");
                        System.out.println("--------------------------------");
                        System.out.println("1. Sua ma khach hang");
                        System.out.println("2. Sua ho ten");
                        System.out.println("3. Sua nam sinh");
                        System.out.println("4. Sua so dien thoai");
                        System.out.println("5. Sua ma tai khoan");
                        System.out.println("6. Thoat");
                        System.out.println("--------------------------------");;
                        System.out.print("Chon: ");
                        String key = sc.nextLine();
                        if(Integer.parseInt(key) <1 || Integer.parseInt(key) > 6)
                            System.out.println("Vui long chon so tu 1 den 6 !");
                        else {
                            switch (key) {
                                case "1":
                                    System.out.print("Nhap ma khach hang moi: ");
                                    String ma = sc.nextLine();
                                    obj.setMakh(ma);
                                    break;
                                case "2":
                                    System.out.print("Nhap ho ten khach hang moi: ");
                                    String hoten = sc.nextLine();
                                    obj.setHoten(hoten);
                                    break;
                                case "3":
                                    System.out.print("Nhap nam sinh moi: ");
                                    String namsinh = sc.nextLine();
                                    obj.setNamsinh(namsinh);
                                    break;
                                case "4":
                                    System.out.print("Nhap so dien thoai moi: ");
                                    String sdt = sc.nextLine();
                                    obj.setSdt(sdt);
                                    break;
                                case "5":
                                    System.out.print("Nhap ma tai khoan moi: ");
                                    String matk = sc.nextLine();
                                    obj.setMatk(matk);
                                    break;
                                case "6":
                                    break;
                            }
                        }
                        if(Integer.parseInt(key) == 6) break;
                    }
                }
            } 
        }
        else
            System.out.println("Khong tim thay khach hang !");
    }

    public void MenuDanhSachKhachHang(DANHSACHKHACHHANG list) {
        while(true) {
            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Nhap danh sach khach hang");
            System.out.println("2. Xuat danh sach khach hang");
            System.out.println("3. Them khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Tim kiem khach hang");
            System.out.println("6. Sua thong tin khach hang");
            System.out.println("7. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();
            if(Integer.parseInt(key) <1 || Integer.parseInt(key) > 7)
                System.out.println("Vui long chon so tu 1 den 7 !");
            else {
                switch (key) {
                case "1":
                   list.NhapDanhSachKH();
                   break;
                case "2":
                   list.XuatDanhSachKH();
                   break;
                case "3":
                   list.ThemKhachHang();
                   break;
                case "4":
                   list.XoaKhachHang();;
                   break;
                case "5":
                    list.TimKiemKhachHang();;
                    break;
                case "6":
                    list.SuaKhachHang();;
                    break;
                }
            }
            if(Integer.parseInt(key) == 7) break;
        }
    }
    
    
    public static void main(String[] args) {
        DANHSACHKHACHHANG list = new DANHSACHKHACHHANG();
        list.MenuDanhSachKhachHang(list);
    }
}
