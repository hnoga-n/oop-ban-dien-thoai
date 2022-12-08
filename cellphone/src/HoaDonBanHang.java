
import java.util.Scanner;

public class HoaDonBanHang extends HoaDon {

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

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getmanv() {
        return manv;
    }

    public void setmanv(String manv) {
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void xuatHoaDonBanHang() {
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------------"
                        + "\nMã khách hàng: " + makh
                        + "\n--------------------------------------------------------------------------------------------------------------------------------------------------"
                        + "\nMã nhân viên: " + manv);
        super.xuatHoaDon();
    }

    public String dinhDangGhiVaoFile() {
        return this.getMahd() + "\n" + makh + "\n"
                + this.getmatk() + "\n" + manv + "\n" + this.getNgay()
                + "\n" + this.getdssp().tongGia() + this.getdssp().dinhDangFileHoaDon();
    }

    public void suaDanhSachSanPham() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhập mã sản phẩm cần sửa: ");
            String masp = sc.nextLine();
            this.getdssp().sua(masp);

        }
    }

}
