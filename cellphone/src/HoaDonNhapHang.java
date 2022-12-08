

import java.util.Scanner;

public class HoaDonNhapHang extends HoaDon {
    Scanner sc = new Scanner(System.in);
    private String madt;
    private int diemdt;

    public HoaDonNhapHang(String madt, int diemdt) {
        this.madt = madt;
        this.diemdt = diemdt;
    }

    public HoaDonNhapHang(String mahd, String matk, Ngay ngay, QuanLiSanPham dssp, String madt, int diemdt) {
        super(mahd, matk, ngay, dssp);
        this.madt = madt;
        this.diemdt = diemdt;
    }

    public HoaDonNhapHang() {
    }

    public String getMadt() {
        return madt;
    }

    public void setMadt() {
        System.out.println("Nhap ma doi tac moi: ");
        String newMaDt = sc.nextLine();
        do {
            if(newMaDt.matches("^DT[0-9]{1,}")==true){
                this.madt=newMaDt;
                break;
            }
            else{
                System.out.println("Ma doi tac bat dau bang DT roi den so!");
                System.out.println("Nhap ma doi tac moi: ");
                newMaDt = sc.nextLine();
            }
        } while (true);
    }

    public int getDiemdt() {
        return diemdt;
    }

    public void setDiemdt() {
        System.out.println("Nhap diem doi tac moi: ");
        int newDiemDt=sc.nextInt();
        sc.nextLine();
        this.diemdt=newDiemDt;
    }

    public void xuatHoaDonNhapHang() {
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------"
                        + "\nMa doi tac: " + madt
                        + "\n--------------------------------------------------------------------------------------------------------------------------"
                        + "\nDiem doi tac: " + diemdt);
        super.xuatHoaDon();
    }

    public String dinhDangGhiVaoFile() {
        return this.getMahd() + "\n" + madt + "\n" + diemdt + "\n"
                + this.getmatk() + "\n" + this.getNgay()
                + "\n" + this.getdssp().tongGia() + this.getdssp().dinhDangFileHoaDon();
    }
}
