import java.util.Scanner;

public class KHACHHANG {
    private String makh;
    private String hoten;
    private String namsinh;
    private String sdt;
    private String matk;
    Scanner sc = new Scanner(System.in);

    // HAM KHOI TAO
    public KHACHHANG() {
        makh = null;
        hoten = null;
        namsinh = null;
        sdt = null;
        matk = null;
    }

    public KHACHHANG(String makh, String matk) {
        this.makh = makh;
        this.matk = matk;
    }

    public KHACHHANG(String makh, String hoten, String namsinh, String sdt, String matk) {
        this.makh = makh;
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.matk = matk;
    }

    public KHACHHANG(KHACHHANG obj) {
        this.makh = obj.makh;
        this.hoten = obj.hoten;
        this.namsinh = obj.namsinh;
        this.sdt = obj.sdt;
        this.matk = obj.matk;
    }

    // PHUONG THUC SET/GET
    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMakh() {
        return makh;
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

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getMatk() {
        return matk;
    }

    // HAM NHAP XUAT
    // cua admin
    public void NhapKhachHang() {
        System.out.print("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.print("Nhap ho ten khach hang: ");
        hoten = sc.nextLine();
        System.out.print("Nhap nam sinh khach hang: ");
        namsinh = sc.nextLine();
        System.out.print("Nhap so dien thoai khach hang: ");
        sdt = sc.nextLine();
        System.out.print("Nhap ma tai khoan khach hang: ");
        matk = sc.nextLine();
        System.out.println("---------------------------");
    }

    // cua user
    public void NhapKhachHang(String makh) {
        this.makh = makh;
        System.out.print("Nhap ho ten khach hang: ");
        hoten = sc.nextLine();
        System.out.print("Nhap nam sinh khach hang: ");
        namsinh = sc.nextLine();
        System.out.print("Nhap so dien thoai khach hang: ");
        sdt = sc.nextLine();
        System.out.println("---------------------------");
    }

    public String XuatKhachHang() {
        return String.format("%-20s%-25s%-15s%-20s%-20s", makh, hoten, namsinh, sdt, matk);
    }

    public void XuatKhachHang_1() {
        System.out.println(
                "===============================================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s%-20s\n", "MA KHACH HANG", "HO TEN", "NAM SINH", "SO DIEN THOAI",
                "MA TAI KHOAN");
        System.out.println(
                "===============================================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s%-20s\n", makh, hoten, namsinh, sdt, matk);
    }
}