
public class HoaDon {

    @Override
    public String toString() {
        return "Order [Mã hóa đơn=" + mahd + ", Mã tài khản=" + matk + ", Ngày=" + ngay;
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

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getmatk() {
        return matk;
    }

    public void setmatk(String matk) {
        this.matk = matk;
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
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Mã hóa đơn: " + mahd
                + "\n--------------------------------------------------------------------------------------------------------------------------------------------------"
                + "\nMã tài khoản: " + matk
                + "\n--------------------------------------------------------------------------------------------------------------------------------------------------"
                + "\nNgày: "
                + ngay);
        dssp.xuatDanhSach();
        System.out.println("\nTổng giá: " + dssp.tongGia());
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

}
