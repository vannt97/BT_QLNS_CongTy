import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TruongPhong extends Person {
    private List<NhanVien> dsNhanVien;


    public List<NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }

    public void setDsNhanVien(List<NhanVien> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
    }



    public TruongPhong() {
        this.dsNhanVien = new ArrayList<>();
        this.setChucVu("TruongPhong");
        this.setLuong1Ngay(200);
    }

    public TruongPhong(int maSo, String hoTen, int soDt, int soNgayLamViec, List<NhanVien> dsNhanVien) {
        super(maSo, hoTen, soDt, soNgayLamViec);
        this.dsNhanVien = new ArrayList<>();
        this.setChucVu("TruongPhong");
        this.setLuong1Ngay(200);
    }

    @Override
    public void Nhap(Scanner scanner) {
        super.Nhap(scanner);
    }
    public  void NhapNhanVien(Scanner scanner, List<NhanVien> dsNhanVien){
        System.out.println("Danh Sach Nhan Vien ");
        for (NhanVien nhanVien : dsNhanVien){
            nhanVien.Xuat();
        }
        System.out.println("Nhap Ma So Cua Nhan Vien - neu khong co thi nhap -1 :  ");
        do{
            int index = scanner.nextInt();
            if(index == -1) return;
            for (NhanVien nhanVien : dsNhanVien){
                if(index == nhanVien.getMaSo()){
                    this.dsNhanVien.add(nhanVien);
                    nhanVien.ThemTruongPhong(this);
                    return;
                }
            }
//            if(this.nhanVien != null) return;
            System.out.println("Nhap sai ma so roi!!!!!!");
        }while (true);
    }

    @Override
    public void Xuat() {
        super.Xuat();
        if(this.dsNhanVien == null){
            System.out.println(" - So Nhan Vien: 0");
        }else {
            System.out.println(" - So Nhan Vien: " + this.dsNhanVien.size());
        }
    }

    public void AddNhanVien(NhanVien nhanVien){
        this.dsNhanVien.add(nhanVien);
    }
    public void XoaTruongPhong(){
        for (NhanVien nhanVien : this.dsNhanVien){
            nhanVien.HuyTruongPhong();
        }
    }
    public void XoaNhanVienRaKhoiDS(NhanVien nhanVien){
        this.dsNhanVien.remove(nhanVien);
    }
}
