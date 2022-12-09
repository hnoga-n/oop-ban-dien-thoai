

import java.util.Scanner;

public class HoaDonBanHang extends HoaDon {
    Scanner sc = new Scanner(System.in);
    private String makh;
    private String manv;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(String makh, String manv) {
        this.makh = makh;
        this.manv = manv;
    }

    public HoaDonBanHang(String mahd, String matk, Ngay ngay, QuanLiSanPham dssp,
            String makh, String manv) {
        super(mahd, matk, ngay, dssp);
        this.makh = makh;
        this.manv = manv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh() {
        System.out.print("Nhap ma san pham moi: ");
        String newMaKh = sc.nextLine();
        do {
            if(newMaKh.matches("[0-9]{1,}")==true){
                this.makh=newMaKh;
                break;
            }
            else{
                System.out.println("Ma khanh hang la mot so!");
                System.out.print("Nhap ma khach hang moi: ");
                newMaKh = sc.nextLine();
            }
        } while (true);
    }

    public String getManv() {
        return manv;
    }


    public void setmanv() {
        System.out.print("Nhap ma nhan vien moi: ");
        String newMaNv = sc.nextLine();
        do {
            if(newMaNv.matches("[0-9]{1,}")==true){
                this.manv=newMaNv;
                break;
            }
            else{
                System.out.println("Ma nhan vien la mot so!");
                System.out.print("Nhap ma nhan vien moi: ");
                newMaNv = sc.nextLine();
            }
        } while (true);
    }

    public void xuatHoaDonBanHang() {
        System.out.println(

                "--------------------------------------------------------------------------------------------------------------------------"
                        + "\nMa khach hang: " + makh
                        + "\n--------------------------------------------------------------------------------------------------------------------------"
                        + "\nMa nhan vien: " + manv);
        super.xuatHoaDon();
    }

    public String dinhDangGhiVaoFile() {
        return this.getMahd() + "\n" + makh + "\n"
                + this.getmatk() + "\n" + manv + "\n" + this.getNgay()
                + "\n" + this.getdssp().tongGia() + this.getdssp().dinhDangFileHoaDon();
    }

}
