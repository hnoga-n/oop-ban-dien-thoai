

import java.util.Scanner;

public class HoaDon {
    Scanner sc = new Scanner(System.in);
    @Override
    public String toString() {
        return "Order [Ma hoa don=" + mahd + ", Ma tai khoan=" + matk + ", Ngay=" + ngay;
    }

    private String mahd;
    private String matk;
    private Ngay ngay;
    private QuanLiSanPham dssp;

    public HoaDon() {
    }

    public HoaDon(String mahd, String matk, Ngay ngay, QuanLiSanPham dssp) {
        this.mahd = mahd;
        this.matk = matk;
        this.ngay = ngay;
        this.dssp = dssp;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd() {
        System.out.print("Nhap ma hoa don moi: ");
        String newMaHd = sc.nextLine();
        do {
            if(newMaHd.matches("^HD[0-9]{1,}")==true){
                this.mahd=newMaHd;
                break;
            }
            else{
                System.out.println("Ma hoa don bat dau bang HD roi den so!");
                System.out.print("Nhap ma hoa don moi: ");
                newMaHd = sc.nextLine();
            }
        } while (true);
    }

    public String getmatk() {
        return matk;
    }

    public void setmatk() {
        System.out.println("Nhap ma tai khoan moi: ");
        String newMaTk = sc.nextLine();
        do {
            if(newMaTk.matches("[0-9]{1,}")==true){
                this.matk=newMaTk;
                break;
            }
            else{
                System.out.println("Ma tai khoan la mot so!");
                System.out.println("Nhap ma tai khoan moi: ");
                newMaTk = sc.nextLine();
            }
        } while (true);
    }

    public Ngay getNgay() {
        return ngay;
    }

    public void setNgay(Ngay ngay) {
        this.ngay = ngay;
    }

    public QuanLiSanPham getdssp() {
        return dssp;
    }

    public void setdssp(QuanLiSanPham dssp) {
        this.dssp = dssp;
    }

    public void xuatHoaDon() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Ma hoa don: " + mahd + "\n--------------------------------------------------------------------------------------------------------------------------"
                + "\nMa tai khoan: " + matk + "\n--------------------------------------------------------------------------------------------------------------------------" + "\nNgay: "
                + ngay);
        dssp.xuatDanhSach();
        System.out.println("\nTong gia: " + dssp.tongGia());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
    }

}
