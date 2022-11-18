import java.util.ArrayList;
import java.util.Scanner;

public class DANHSACHNHANVIEN {
    private ArrayList<NHANVIEN> arrnv = new ArrayList<NHANVIEN>();
    private int soluongnv;
    Scanner sc = new Scanner(System.in);

    public ArrayList<NHANVIEN> getArray() {
        return arrnv;
    }

    public void NhapDanhSachNV() {
        System.out.print("So luong nhan vien: ");
        soluongnv = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------");
        NHANVIEN a;
        for (int i = 0; i < soluongnv; i++) {
            a = new NHANVIEN();
            a.NhapNhanVien();
            arrnv.add(a);
        }
    }

    public void XuatDanhSachNV() {
        if (arrnv != null) {
            System.out.println(
                    "============================================================================================");
            System.out.printf("%-20s%-25s%-15s%-20s%-20s\n", "MA NHAN VIEN", "HO TEN", "NAM SINH", "SO DIEN THOAI",
                    "CHUC VU");
            System.out.println(
                    "============================================================================================");

            for (NHANVIEN obj : arrnv) {
                System.out.println(obj.XuatNhanVien());
                System.out.println(
                        "--------------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("Danh sach rong ,vui long nhap danh sach !");
        }
    }

    public void ThemNhanVien() {
        if (arrnv == null) {
            System.out.println("Danh sach rong ,vui long nhap danh sach !");
        } else {
            NHANVIEN a = new NHANVIEN();
            a.NhapNhanVien();
            arrnv.add(a);
        }
    }

    public NHANVIEN TimKiemNhanVienTheoMaNV(String manv) {
        NHANVIEN nv = null;
        for (NHANVIEN obj : arrnv) {
            if (obj.getManv().equalsIgnoreCase(manv)) {
                nv = obj;
                return nv;
            }
        }
        return null;
    }

    public void TimKiemNhanVien() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String manv = sc.nextLine();
        NHANVIEN nv = null;
        nv = TimKiemNhanVienTheoMaNV(manv);
        if (nv != null)
            nv.XuatNhanVien_1();
        else
            System.out.println("Khong tim thay nhan vien !");
    }

    public void XoaNhanVien() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String manv = sc.nextLine();
        NHANVIEN nv = null;
        nv = TimKiemNhanVienTheoMaNV(manv);
        if (nv != null) {
            for (NHANVIEN obj : arrnv) {
                if (obj == nv) {
                    arrnv.remove(obj);
                    System.out.println("Xoa thanh cong nhan vien!");
                    break;
                }
            }
        } else
            System.out.println("Khong tim thay nhan vien !");
    }

    public void SuaNhanVien() {
        System.out.print("Nhap ma nhan vien can sua: ");
        String manv = sc.nextLine();
        NHANVIEN nv = null;
        nv = TimKiemNhanVienTheoMaNV(manv);
        if (nv != null) {
            for (NHANVIEN obj : arrnv) {
                if (obj == nv) {
                    while (true) {
                        System.out.println("\n");
                        System.out.println("--------------------------------");
                        System.out.println("======    SUA THONG TIN   ======");
                        System.out.println("--------------------------------");
                        System.out.println("1. Sua ma nhan vien");
                        System.out.println("2. Sua ho ten");
                        System.out.println("3. Sua nam sinh");
                        System.out.println("4. Sua so dien thoai");
                        System.out.println("5. Sua chuc vu");
                        System.out.println("6. Thoat");
                        System.out.println("--------------------------------");
                        ;
                        System.out.print("Chon: ");
                        String key = sc.nextLine();
                        if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 6)
                            System.out.println("Vui long chon so tu 1 den 6 !");
                        else {
                            switch (key) {
                                case "1":
                                    System.out.print("Nhap ma nhan vien moi: ");
                                    String ma = sc.nextLine();
                                    obj.setManv(ma);
                                    break;
                                case "2":
                                    System.out.print("Nhap ho ten nhan vien moi: ");
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
                                    System.out.print("Nhap chuc vu moi: ");
                                    String chucvu = sc.nextLine();
                                    obj.setChucvu(chucvu);
                                    break;
                                case "6":
                                    break;
                            }
                        }
                        if (Integer.parseInt(key) == 6)
                            break;
                    }
                }
            }
        } else
            System.out.println("Khong tim thay nhan vien !");
    }

    public void MenuDanhSachNhanVien(DANHSACHNHANVIEN list) {
        while (true) {
            System.out.println("\n");
            System.out.println("------------------------------------");
            System.out.println("==========    * MENU *    ==========");
            System.out.println("------------------------------------");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.println("3. Them nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Tim kiem nhan vien");
            System.out.println("6. Sua thong tin nhan vien");
            System.out.println("7. Thoat");
            System.out.println("------------------------------------");
            System.out.print("Chon: ");
            String key = sc.nextLine();
            if (Integer.parseInt(key) < 1 || Integer.parseInt(key) > 7)
                System.out.println("Vui long chon so tu 1 den 7 !");
            else {
                switch (key) {
                    case "1":
                        list.NhapDanhSachNV();
                        break;
                    case "2":
                        list.XuatDanhSachNV();
                        break;
                    case "3":
                        list.ThemNhanVien();
                        break;
                    case "4":
                        list.XoaNhanVien();
                        break;
                    case "5":
                        list.TimKiemNhanVien();
                        break;
                    case "6":
                        list.SuaNhanVien();
                        break;
                }
            }
            if (Integer.parseInt(key) == 7)
                break;
        }
    }

    public static void main(String[] args) {
        DANHSACHNHANVIEN list = new DANHSACHNHANVIEN();
        NHANVIEN a = new NHANVIEN("123", "hha", "1996", "096", "admin");
        NHANVIEN b = new NHANVIEN("124", "hha", "1996", "096", "admin");
        NHANVIEN c = new NHANVIEN("125", "hha", "1996", "096", "admin");
        list.arrnv.add(a);
        list.arrnv.add(b);
        list.arrnv.add(c);
        list.XuatDanhSachNV();
        list.XoaNhanVien();
        list.XuatDanhSachNV();

    }
}
