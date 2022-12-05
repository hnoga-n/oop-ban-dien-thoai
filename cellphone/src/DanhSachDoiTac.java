import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DanhSachDoiTac {
    public ArrayList<DoiTac> arrDT = new ArrayList<DoiTac>();
    Scanner sc = new Scanner(System.in);

    public int soluongDT() {
        return arrDT.size();
    }

    public void them(DoiTac dt) {
        arrDT.add(dt);
    }

    public DoiTac tim(String Ma) {
        for (DoiTac dt : arrDT) {
            if (dt.getMADT().equals(Ma))
                return dt;
        }
        return null;
    }

    public void xoa(String Ma) {
        for (DoiTac dt : arrDT) {
            if (dt.getMADT().equals(Ma))
                arrDT.remove(dt);
            break;
        }
    }

    public void sua(String Ma) {
        int chon;
        System.out.println("1.Sua ma Doi Tac");
        System.out.println("2.Sua ten Doi Tac");
        System.out.println("3.Sua so dien thoai");
        System.out.println("4.Sua mail Doi Tac");
        System.out.println("0.Tro lai");
        for (DoiTac dt : arrDT) {

            if (dt.getMADT().equals(Ma)) {
                do {
                    System.out.print("Chon: ");
                    chon = Integer.parseInt(sc.nextLine());
                    switch (chon) {
                        case 1: {
                            System.out.print("Nhap ma Doi Tac moi: ");
                            String s = sc.nextLine();
                            for(DoiTac d : arrDT)
                            {
                                if(s.equalsIgnoreCase(d.getMADT())) System.out.println("Ma Doi tac nay da ton tai");
                                else dt.setMADT(s);
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Nhap ten Doi Tac moi: ");
                            String s = sc.nextLine();
                            for(DoiTac d : arrDT)
                            {
                                if(s.equalsIgnoreCase(d.getTenDoiTac())) System.out.println("Ten Doi tac nay da ton tai");
                                else dt.setTenDoiTac(s);
                            }
                            break;
                        }
                        case 3: {
                            System.out.print("Nhap so dien thoai moi: ");
                            String s = sc.nextLine();
                            dt.setTel(s);
                            break;
                        }
                        case 4: {
                            System.out.print("Nhap mail Doi Tac moi: ");
                            String s = sc.nextLine();
                            dt.setMail(s);
                            break;
                        }
                        case 0:
                            break;
                    }
                } while (chon != 0);
                break;
            }
        }
    }

    public void xuatDanhSach() {
        for (DoiTac dt : arrDT) {
            dt.xuatDoiTac();
            System.out.print("\n");
        }
    }

    public boolean checkDT(DoiTac dt) {
        for (DoiTac d : arrDT)
        {
            if(d.getMADT().equalsIgnoreCase(dt.getMADT()) || d.getTenDoiTac().equalsIgnoreCase(dt.getTenDoiTac())) return false;
        }
        return true;
    }

    // FILE
    public void ghiFile() {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("danhsachdoitac.txt", false);
            for (DoiTac dt : arrDT) {
                String line = dt.getFileLine();
                byte[] b = line.getBytes("utf8");
                f.write(b);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (Exception ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void docFile() throws IOException {
        this.arrDT.clear();
        FileInputStream f = null;
        InputStreamReader reader = null;
        BufferedReader bfReader = null;
        try {
            f = new FileInputStream("danhsachdoitac.txt");
            reader = new InputStreamReader(f, StandardCharsets.UTF_8);
            bfReader = new BufferedReader(reader);
            String line = null;
            while ((line = bfReader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                DoiTac dt = new DoiTac();
                dt.parseDT(line);
                arrDT.add(dt);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bfReader != null) {
                try {
                    bfReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DanhSachDoiTac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // MENU
    public void menuDoiTac() throws IOException
    {
        this.docFile();
        System.out.println("1.Them Doi Tac");
        System.out.println("2.Tim Doi Tac theo ma");
        System.out.println("3.Xoa Doi Tac theo ma");
        System.out.println("4.Chinh sua thong tin Doi Tac");
        System.out.println("5.Xuat danh sach Doi Tac");
        System.out.println("6.Xuat so luong Doi tac");
        System.out.println("0.Thoat");
        int chon;
        do
        {
            System.out.print("Chon: ");
            chon=Integer.parseInt(sc.nextLine());
            switch(chon)
            {
                case 1:
                {
                    System.out.print("Nhap ma Doi Tac: ");
                    String ma=sc.nextLine();
                    System.out.print("Nhap ten Doi Tac: ");
                    String ten=sc.nextLine();
                    System.out.print("Nhap so dien thoai: ");
                    String sdt=sc.nextLine();
                    System.out.print("Nhap mail Doi Tac: ");
                    String mail=sc.nextLine();
                    DoiTac dt=new DoiTac(ma,ten,sdt,mail);
                    if(checkDT(dt)) {
                        this.them(dt);
                    }
                    else{
                        System.out.println("Doi tac da ton tai");
                    } 
                    break;
                }
                case 2:
                {
                    System.out.print("Nhap ma cua Doi Tac can tim: ");
                    String ma=sc.nextLine();
                    this.tim(ma).xuatDoiTac();
                    break;
                }
                case 3:
                {
                    System.out.print("Nhap ma cua Doi Tac can xoa: ");
                    String ma=sc.nextLine();
                    this.xoa(ma);
                    System.out.println("Da xoa Doi Tac " + ma);
                    break;
                }
                case 4:
                {
                    System.out.print("Nhap ma cua Doi Tac can sua: ");
                    String ma=sc.nextLine();
                    this.sua(ma);
                    break;
                }
                case 5:
                {
                    this.xuatDanhSach();
                    break;
                }
                case 6:
                {
                    System.out.println("So luong Doi Tac: " + this.soluongDT());
                    break;
                }
                case 0:
                {
                    this.ghiFile();
                    break;
                }
            }         
        }
        while(chon!=0);
    }

    public static void main(String[] args) throws IOException {
        DanhSachDoiTac dsdt = new DanhSachDoiTac();
        dsdt.menuDoiTac();
        
    }
}
