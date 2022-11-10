import java.util.Scanner;

public class NHANVIEN {
    private String manv;
    private String hoten;
    private String namsinh;
    private String sdt;
    private String chucvu;
    Scanner sc = new Scanner(System.in);

    // HAM KHOI TAO
    public NHANVIEN() {
        manv = null;
        hoten = null;
        namsinh = null;
        sdt = null;
        chucvu = null;
    }

    public NHANVIEN(String manv, String hoten, String namsinh, String sdt, String chucvu) {
        this.manv = manv;
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.chucvu = chucvu;
    }

    public NHANVIEN(NHANVIEN obj) {
        this.manv = obj.manv;
        this.hoten = obj.hoten;
        this.namsinh = obj.namsinh;
        this.sdt = obj.sdt;
        this.chucvu = obj.chucvu;
    }

    // PHUONG THUC SET/GET
    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getHoten() {
        return hoten;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getChucvu() {
        return chucvu;
    }

    // HAM NHAP XUAT
    public void NhapNhanVien() {
        System.out.print("Nhap ma nhan vien: ");
        manv = sc.nextLine();
        System.out.print("Nhap ho ten nhan vien: ");
        hoten = sc.nextLine();
        System.out.print("Nhap nam sinh nhan vien: ");
        namsinh = sc.nextLine();
        System.out.print("Nhap so dien thoai nhan vien: ");
        sdt = sc.nextLine();
        System.out.print("Nhap chuc vu nhan vien: ");
        chucvu = sc.nextLine();
        System.out.println("---------------------------");
    }

    public String XuatNhanVien() {
        return String.format("%-20s%-25s%-15s%-20s%-20s", manv, hoten, namsinh, sdt, chucvu);
    }

    public void XuatNhanVien_1() {
        System.out.println(
                "============================================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s%-20s\n", "MA NHAN VIEN", "HO TEN", "NAM SINH", "SO DIEN THOAI",
                "CHUC VU");
        System.out.println(
                "============================================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s%-20s\n", manv, hoten, namsinh, sdt, chucvu);
    }
    /*
     * public static void main(String[] args) {
     * NHANVIEN a = new NHANVIEN();
     * a.NhapNhanVien();
     * System.out.println(a.XuatNhanVien());
     * }
     */
}
