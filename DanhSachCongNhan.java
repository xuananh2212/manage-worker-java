package QuanLyCongNhan;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DanhSachCongNhan implements Serializable {
    private ArrayList<Worker> listWorker;

    public DanhSachCongNhan() {
        this.listWorker = new ArrayList<>();
    }

    public DanhSachCongNhan(ArrayList<Worker> listWorker) {
        this.listWorker = listWorker;
    }
    public void outPut(){
        System.out.printf("\n%-10s\t%-10s\t%-12s\t%-10s\t%-12s\t%-8s\t%-12s\n","TEN",
                "ngay sinh","Dia Chi","SDT","ID","Ca","Luong");
        for(var e: listWorker){
            e.outPut();
        }
    }
    // them cong nhan vao danh sanh cong nhan
    public void addWorker(Worker w){
        this.listWorker.add(w);
    }
    // kiem tra id co ton tai khong
    public Worker checkID(String id){
        Worker w = null;
        for (var e: listWorker
             ) {
            if(e.getId().equalsIgnoreCase(id)){
                w = e;
                return w;
            }

        }
        return w;

    }
    // xoa cong nhan
    public void removeWorker(String id){
        Worker e = checkID(id);
        if(e != null){
            this.listWorker.remove(e);
            System.out.println("xoa cong nhan thanh cong");
        }else{
            System.out.println("khong ton tai id trong danh sach cong nhan");
        }
    }
    // tim kiem cong nhan theo id
    public void searchWorker(String id){
        Worker e = checkID(id);
        if(e != null){
            System.out.println(e);
            System.out.println("tim kiem thanh cong");
        }else{
            System.out.println("khong tim thay cong nhan trong danh sach");
        }
    }
    // sap xep cong nhan theo ten tu a-z
    public void softName(){
        for(int i =0 ; i< listWorker.size()-1;i++){
            for(int j = i+1; j< listWorker.size();j++){
                var name1 = this.listWorker.get(i).getFullName().getFirtName();
                var name2 = this.listWorker.get(j).getFullName().getFirtName();
                if(name1.compareToIgnoreCase(name2) > 0){
                    Collections.swap(this.listWorker,j ,i);
                }
            }
        }
        System.out.println("sap xep thanh cong nhan nut 6 den hien ds");
    }
    //sap xep theo luong tang dan;
    public void sortWage(){
        for(int i =0 ; i< listWorker.size()-1;i++){
            for(int j = i+1; j< listWorker.size();j++){
                var wage1 = this.listWorker.get(i).getWage();
                var wage2 = this.listWorker.get(j).getWage();
                if(wage1 > wage2 ){
                    Collections.swap(this.listWorker,j ,i);
                }
            }
        }
        System.out.println("sap xep thanh cong nhan nut 6 den hien ds");

    }
    // doc file
    public void writerFile(){
        var fileName ="DSCN.txt";
        try(ObjectOutputStream o1 = new ObjectOutputStream(new FileOutputStream(fileName))) {
            o1.writeObject(this.listWorker);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ghi file
    public void readFile(){
        var fileName ="DSCN.txt";
        try(ObjectInputStream o1 = new ObjectInputStream(new FileInputStream(fileName))) {
           this.listWorker.addAll((ArrayList<Worker>)o1.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
