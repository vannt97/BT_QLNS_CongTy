import java.util.List;
import java.util.Scanner;

public class NhanVien extends Person implements NhapVaXuat{
    TruongPhong truongPhong;


    public TruongPhong getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(TruongPhong truongPhong) {
        this.truongPhong = truongPhong;
    }




    public NhanVien() {
        this.setChucVu("NhanVien");
        this.setLuong1Ngay(100);
    }
    public NhanVien(int maSo, String hoTen, int soDt, int soNgayLamViec, TruongPhong truongPhong) {
        super(maSo, hoTen, soDt, soNgayLamViec);
        this.truongPhong = truongPhong;
        this.setChucVu("NhanVien");
        this.setLuong1Ngay(100);
    }

    @Override
    public void Nhap(Scanner scanner) {
        super.Nhap(scanner);
    }

    public void NhapTruongPhong(List<TruongPhong> dsTruongPhong, Scanner scanner){
        System.out.println("Danh sach truong phong");
        for (TruongPhong truongPhong : dsTruongPhong){
            truongPhong.Xuat();
        }
        System.out.println("Nhap Ma So Cua Truong Phong - neu khong co thi nhap -1 :  ");
        do{
            int index = scanner.nextInt();
            if(index == -1) return;
            for (TruongPhong truongPhong : dsTruongPhong){
                if(index == truongPhong.getMaSo()){
                    this.truongPhong = truongPhong;
                    truongPhong.AddNhanVien(this);
                    return;
                }
            }
            if(this.truongPhong != null) return;
            System.out.println("Nhap sai ma so roi!!!!!!");
        }while (true);

    }

    @Override
    public void Xuat() {
        super.Xuat();
        if(this.truongPhong == null){
            System.out.println(" -Truong Phong: Khong co" );
        }else {
            System.out.println(" -Truong Phong: " + this.truongPhong.getHoTen());
        }

    }
    public void ThemTruongPhong(TruongPhong truongPhong){
            this.truongPhong = truongPhong;
    }
    public void HuyTruongPhong(){
        this.truongPhong = null;
    }

    public void XoaNhanVien(){
        if(this.truongPhong == null) return;
        this.truongPhong.XoaNhanVienRaKhoiDS(this);
    }
}
