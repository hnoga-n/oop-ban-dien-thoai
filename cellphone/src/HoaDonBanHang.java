
public class HoaDonBanHang extends HoaDon {

    private String makh;
    private String manv;
    private int diemkh;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(String makh, String manv, int diemkh) {
        this.makh = makh;
        this.manv = manv;
        this.diemkh = diemkh;
    }

    public HoaDonBanHang(String mahd, String matk, Ngay ngay, QuanLiSanPham dssp,
            String makh, String manv, int diemkh) {
        super(mahd, matk, ngay, dssp);
        this.makh = makh;
        this.manv = manv;
        this.diemkh = diemkh;
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

    public int getDiemkh() {
        return diemkh;
    }

    public void setDiemkh(int diemkh) {
        this.diemkh = diemkh;
    }

    public void xuatHoaDonBanHang() {
        System.out.println("Mã khách hàng: " + makh + "\nMã nhân viên: " + manv + "\nĐiểm khách hàng: " + diemkh);
        super.xuatHoaDon();
    }

    public String dinhDangGhiVaoFile() {
        return this.getMahd() + "\n" + makh + "\n" + diemkh + "\n"
                + this.getmatk() + "\n" + manv + "\n" + this.getNgay()
                + "\n" + this.getdssp().dinhDangFileHoaDon()
                + this.getdssp().tongGia();
    }
}
