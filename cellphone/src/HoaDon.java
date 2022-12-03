

public class HoaDon {

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
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Ma hoa don: " + mahd + "\n----------------------------------------------------------------------------------------------------------------------"
                + "\nMa tai khoan: " + matk + "\n----------------------------------------------------------------------------------------------------------------------" + "\nNgay: "
                + ngay);
        dssp.xuatDanhSach();
        System.out.println("\nTong gia: " + dssp.tongGia());
        System.out.println("----------------------------------------------------------------------------------------------------------------------\n");
    }

}
