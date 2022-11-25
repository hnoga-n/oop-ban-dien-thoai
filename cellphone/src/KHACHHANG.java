import java.util.Scanner;

public class KHACHHANG {
    private String makh;
    private String hoten;
    private String namsinh;
    private String sdt;
    Scanner sc = new Scanner(System.in);

    // HAM KHOI TAO
    public KHACHHANG() {
        makh = null;
        hoten = null;
        namsinh = null;
        sdt = null;
    }

    public KHACHHANG(String makh, String hoten, String namsinh, String sdt) {

        this.makh = makh;
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.sdt = sdt;
    }

    public KHACHHANG(KHACHHANG obj) {
        this.makh = obj.makh;
        this.hoten = obj.hoten;
        this.namsinh = obj.namsinh;
        this.sdt = obj.sdt;
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

    // HAM NHAP XUAT
    // cua admin
    public void NhapKhachHang() {
        kiemtra kt = new kiemtra();
        System.out.print("Nhap ma khach hang: ");
        makh = kt.KiemTraNhapMa();
        System.out.print("Nhap ho ten khach hang: ");
        hoten = sc.nextLine();
        System.out.print("Nhap nam sinh khach hang: ");
        namsinh = kt.KiemTraNamSinh();
        System.out.print("Nhap so dien thoai khach hang: ");
        sdt = kt.KiemTraNhapSDT();
        System.out.println("---------------------------");
    }

    // cua user
    public void NhapKhachHang(String makh) {
        kiemtra kt = new kiemtra();
        this.makh = makh;
        System.out.print("Nhap ho ten khach hang: ");
        hoten = sc.nextLine();
        System.out.print("Nhap nam sinh khach hang: ");
        namsinh = kt.KiemTraNamSinh();
        System.out.print("Nhap so dien thoai khach hang: ");
        sdt = kt.KiemTraNhapSDT();
        System.out.println("---------------------------");
    }

    public String XuatKhachHang() {
        return String.format("%-20s%-25s%-15s%-20s", makh, hoten, namsinh, sdt);

    }

    public void XuatKhachHang_1() {
        System.out.println("==============================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s\n", "MA KHACH HANG", "HO TEN", "NAM SINH", "SO DIEN THOAI");
        System.out.println("==============================================================================");
        System.out.printf("%-20s%-25s%-15s%-20s%-20s\n", makh, hoten, namsinh, sdt);
    }

    // HAM FILE
    public String getFileLine() {
        return makh + "," + hoten + "," + namsinh + "," + sdt + "\n";
    }

    public void parseKhachHang(String line) {
        String[] params = line.split(",");
        try {
            this.makh = params[0];
            this.hoten = params[1];
            this.namsinh = params[2];
            this.sdt = params[3];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        }

    }
}