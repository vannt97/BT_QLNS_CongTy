import java.util.*;

public class DSNhanSu implements NhapVaXuat,TinhLuong {


    private List<Person> dsNhanSu;
    private ReadJSONFile readJSONFile;
    private CongTy congTy;

    public CongTy getCongTy() {
        return congTy;
    }

    public void setCongTy(CongTy congTy) {
        this.congTy = congTy;
    }

    public DSNhanSu() {
        readJSONFile = new ReadJSONFile();
        dsNhanSu = readJSONFile.ReadFile();
        TinhLuong();
    }
    public List<GiamDoc> GetDsGiamDoc(){
        List<GiamDoc> dsGiamDoc = new ArrayList<>();
        for(Person person : dsNhanSu){
            if(Objects.equals(person.getChucVu(),"GiamDoc")){
                dsGiamDoc.add((GiamDoc) person);
            }
        }
        return  dsGiamDoc ;
    }

    public List<TruongPhong> GetDSTruongPhong(){
        List<TruongPhong> dsTruongPhong = new ArrayList<>();
        for(Person person : dsNhanSu){
            if(Objects.equals(person.getChucVu(),"TruongPhong")){
                dsTruongPhong.add((TruongPhong) person);
            }
        }
        return  dsTruongPhong ;
    }

    public List<NhanVien> GetDSNhanVien(){
        List<NhanVien> dsNhanVien = new ArrayList<>();
        for(Person person : dsNhanSu){
            if(Objects.equals(person.getChucVu(),"NhanVien")){
                dsNhanVien.add((NhanVien) person);
            }
        }
        return  dsNhanVien;
    }
    @Override
    public void Nhap(Scanner scanner) {
        do{
            NhapVaXuat.super.Nhap(scanner);
            InTieuDe();
            int index = scanner.nextInt();
            switch (index){
                case 1:{
                    GiamDoc giamDoc = new GiamDoc();
                    giamDoc.Nhap(scanner);
                    this.dsNhanSu.add(giamDoc);
                    break;
                }
                case 2:{
                    TruongPhong truongPhong = new TruongPhong();
                    truongPhong.Nhap(scanner);
                    truongPhong.NhapNhanVien(scanner,GetDSNhanVien());
                    this.dsNhanSu.add(truongPhong);
                    break;
                }
                case 3:{
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.Nhap(scanner);
                    nhanVien.NhapTruongPhong(GetDSTruongPhong(),scanner);
                    dsNhanSu.add(nhanVien);
                    break;
                }
                case 4: {
                    if(this.dsNhanSu == null){
                        System.out.println("Khong co nhan su nao o day ca!!!!!!");
                        break;
                    }
                    TinhLuong();
                    Xuat();
                    break;
                }
                case 5: {
                    System.out.println("Danh Sach Nhan Su: ");
                    Xuat();
                    System.out.println("Chon ma so Nhan su ban can muon xoa: ");
                    int indexMaSo = scanner.nextInt();
                    boolean isRemove = false;
                    for (Person person: this.dsNhanSu){
                        if(Objects.equals(person.getMaSo(),indexMaSo)){
                            switch (person.getChucVu()){
                                case "TruongPhong":{
                                    ((TruongPhong)person).XoaTruongPhong();
                                    break;
                                }
                                case "NhanVien":{
                                    ((NhanVien)person).XoaNhanVien();
                                    break;
                                }
                            }
                            this.dsNhanSu.remove(person);
                            isRemove = true;
                            break;
                        }
                    }
                    if(!isRemove) {
                        System.out.println("So ban nhap khong co tren danh sach nhan su ");
                    }
                    break;
                }
                case 6:{
                    TinhLuong();
                    TinhTongLuong();
                    break;
                }
                case 7:{
                    TinhLuong();
                    FindNhanVietCoLuongCaoNhat();
                    break;
                }
                case 8:{
                    FindTruongPhongCoNhieuNhanVienNhat();
                    break;
                }
                case 9: {
                    SortDSNhanSuTheoThuTuABC();
                    break;
                }
                case 10: {
                    SortDsNhanSuTheoLuongGiamDan();
                    break;
                }
                case 11:{
                    FindGiamDocCoSoCPNhieuNhat();
                    break;
                }
                case 12:{
                    this.congTy.Nhap(scanner);
                    break;
                }
                case 13:{
                    this.congTy.Xuat();
                    break;
                }
                case 14:{
                    InThuNhapCuaTungGiamDoc();
                    break;
                }
                default:{
                    System.out.println("Ban Nhap Khong dung Cac Case Tren");
                    break;
                }
            }
            System.out.println("Ban muon chon tiep khong??? - chon 1 la co , con lai la khong");
            int isNhap = scanner.nextInt();
            if(isNhap != 1){
                break;
            }

        }while (true);
    }


    private void InTieuDe(){
        System.out.println("Hãy Nhập Thông tin");
        System.out.println("Chọn 1: Là nhập thông tin giám đốc");
        System.out.println("Chọn 2: Là nhập thông tin trưởng phòng");
        System.out.println("Chọn 3: Là nhập thông tin nhân viên");
        System.out.println("Chọn 4: Là xuất toàn bộ các nhân sự trong công ty");
        System.out.println("Chọn 5: Là xóa thông tin nhân sự");
        System.out.println("Chọn 6: Là tính tổng lương trả cho nhân sự công ty");
        System.out.println("Chọn 7: Là tìm nhân viên thường có lương cao nhất");
        System.out.println("Chọn 8: Là tìm trưởng phòng có nhiều nhân viên nhất");
        System.out.println("Chon 9: La sắp xếp danh sách nhân sự theo tên từ ABC");
        System.out.println("Chon 10: Là sắp sếp các nhân sự của công ty có lương giảm dần");
        System.out.println("Chọn 11: Là tìm giám đốc có nhiều cổ phần nhất ");
        System.out.println("Chon 12: Là nhập thông tin công ty ");
        System.out.println("Chon 13: Là in thông tin công ty");
        System.out.println("Chon 14: là in thu nhập của từng giám đốc");

    }

    @Override
    public void Xuat() {
        NhapVaXuat.super.Xuat();
        for (Person person : this.dsNhanSu){
           person.Xuat();
        }
    }

    @Override
    public void TinhLuong() {
        TinhLuong.super.TinhLuong();
        for (Person person: this.dsNhanSu){
                person.TinhLuong();
        }
    }

    public int TinhTongLuong(){
        int totalMoney = 0;
        for (Person person: this.dsNhanSu){
            totalMoney += person.getLuongThang();
        }
        System.out.println("Tong luong tra cho toan cong ty: " + totalMoney);
        return totalMoney;
    }

    public void FindNhanVietCoLuongCaoNhat(){
        List<NhanVien> dsNhanVienLuongCaoNhat = new ArrayList<>();
        NhanVien nvMax = GetDSNhanVien().get(0);
        for(int i = 1;i<GetDSNhanVien().size();i++){
            if(nvMax.getLuongThang() < GetDSNhanVien().get(i).getLuongThang()){
                nvMax = GetDSNhanVien().get(i);
            }
        }
        for (NhanVien nhanVien : GetDSNhanVien()){
            if(nhanVien.getLuongThang() == nvMax.getLuongThang()){
                dsNhanVienLuongCaoNhat.add(nhanVien);
            }
        }

        System.out.println("Nhan vien co luong cao nhat: ");
        for (NhanVien nhanVien : dsNhanVienLuongCaoNhat){
            nhanVien.Xuat();
        }
    }

    public void FindTruongPhongCoNhieuNhanVienNhat(){
        List<TruongPhong> dsTruongPhongCoNhanVienCaoNhat = new ArrayList<>();
        TruongPhong tpMax = GetDSTruongPhong().get(0);
        for (int i = 1; i< GetDSTruongPhong().size();i++){
            if(tpMax.getDsNhanVien().size() < GetDSTruongPhong().get(i).getDsNhanVien().size()){
                tpMax = GetDSTruongPhong().get(i);
            }
        }
        for (TruongPhong truongPhong : GetDSTruongPhong()){
            if(truongPhong.getDsNhanVien().size() == tpMax.getDsNhanVien().size()){
                dsTruongPhongCoNhanVienCaoNhat.add(truongPhong);
            }
        }
        System.out.println("Truong phong co nhieu nhan vien nhat: ");
        for (TruongPhong truongPhong : dsTruongPhongCoNhanVienCaoNhat){
            truongPhong.Xuat();
        }
    }

    public void SortDSNhanSuTheoThuTuABC(){
        for(int i = 0; i < this.dsNhanSu.size() - 1; i++){
            for(int j = i+1 ;j< this.dsNhanSu.size();j++){
                if(this.dsNhanSu.get(i).getHoTen().compareTo(this.dsNhanSu.get(j).getHoTen()) > 0){
                    Person person = this.dsNhanSu.get(i);
                    this.dsNhanSu.set(i,this.dsNhanSu.get(j));
                    this.dsNhanSu.set(j, person);
                }
            }
        }
        System.out.println("Da Sort Xong");
    }

    public void SortDsNhanSuTheoLuongGiamDan(){
        Collections.sort(this.dsNhanSu, new SortByLuong());
        System.out.println("Da sort xong");
    }

    public void FindGiamDocCoSoCPNhieuNhat(){
        List<GiamDoc> dsGiamDocCoCPNhieuNhat = new ArrayList<>();
        GiamDoc gdMax = GetDsGiamDoc().get(0);
        for (int i = 1; i< GetDsGiamDoc().size();i++){
            if(gdMax.getCoPhan() < GetDsGiamDoc().get(i).getCoPhan()){
                gdMax = GetDsGiamDoc().get(i);
            }
        }
        for (GiamDoc giamDoc : GetDsGiamDoc()){
            if(giamDoc.getCoPhan() == gdMax.getCoPhan()){
                dsGiamDocCoCPNhieuNhat.add(giamDoc);
            }
        }
        System.out.println("Giam doc co nhieu co phan nhat: ");
        for (GiamDoc giamDoc : dsGiamDocCoCPNhieuNhat){
            giamDoc.Xuat();
        }
    }


    public void InThuNhapCuaTungGiamDoc(){
        int loiNhuanCty = this.congTy.TinhLoiNhuanCty();

        if(this.congTy.getDoanhThuThang() == 0) {
            System.out.println("Chua Nhap doanh thu thang cua cong ty");
            return;
        }
        for(GiamDoc giamDoc : GetDsGiamDoc()){
            giamDoc.TinhThuNhap(loiNhuanCty);
            System.out.println("Thu nhap cua giam doc " + giamDoc.getHoTen() + " la: " + giamDoc.getThuNhap());
        }
    }



}
