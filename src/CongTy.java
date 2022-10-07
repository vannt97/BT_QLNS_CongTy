import java.util.Scanner;

public class CongTy implements NhapVaXuat{
    private String tenCongTy;
    private int maSoThue;
    private int doanhThuThang;

    private DSNhanSu dsNhanSu;

    private int loiNhuanCty;
//    Get and Set
    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public int getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(int maSoThue) {
        this.maSoThue = maSoThue;
    }

    public int getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(int doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    public int getLoiNhuanCty() {
        return loiNhuanCty;
    }

    public DSNhanSu getDsNhanSu() {
        return dsNhanSu;
    }

    public void setDsNhanSu(DSNhanSu dsNhanSu) {
        this.dsNhanSu = dsNhanSu;
    }

    //Contructor
    public CongTy() {
    }

    public CongTy(String tenCongTy, int maSoThue, int doanhThuThang) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhThuThang = doanhThuThang;
    }

    @Override
    public void Nhap(Scanner scanner) {
        NhapVaXuat.super.Nhap(scanner);
        System.out.println("Ban Phai Nhap Thong Tin Cong Ty Truoc");
        System.out.println("Nhap ten cong ty: ");
        this.tenCongTy = scanner.next();
        System.out.println("Nhap ma so thue: ");
        this.maSoThue = scanner.nextInt();
        System.out.println("Doanh thu thang: ");
        this.doanhThuThang = scanner.nextInt();
    }

    @Override
    public void Xuat() {
        NhapVaXuat.super.Xuat();
        System.out.println("Ten cong ty: " + this.tenCongTy) ;
        System.out.println("Ma so thue: " + this.maSoThue);
        System.out.println("Doanh thu thang: " +this.doanhThuThang);
    }

    public int TinhLoiNhuanCty(){
        this.loiNhuanCty = this.doanhThuThang - this.dsNhanSu.TinhTongLuong();
        return this.loiNhuanCty;
    }
}
