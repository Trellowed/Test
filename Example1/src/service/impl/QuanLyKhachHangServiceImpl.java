/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhachHang;
import java.util.List;
import repository.KhachHangRepository;
import service.QuanLyKhachHangService;

/**
 *
 * @author fptsh
 */
public class QuanLyKhachHangServiceImpl implements QuanLyKhachHangService{

    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    
    @Override
    public List<KhachHang> getData() {
        List<KhachHang> list = KhachHangRepository.readDB();
        return list;
    }

    @Override
    public List<KhachHang> sortBy() {
        List<KhachHang> list = KhachHangRepository.sortByName();
        return list;
    }

    @Override
    public String add(KhachHang khachHang) {
        boolean addCate = khachHangRepository.add(khachHang);
        if (addCate) {
            return "Add successfully";
        }
        return "Add failed";
    }

    @Override
    public String update(Long makh, KhachHang khachHang) {
        boolean updateCate = khachHangRepository.update(khachHang, makh);
        if (updateCate) {
            return "Update successfully";
        }
        return "Update failed";
    }

    @Override
    public String delete(Long makh) {
        boolean deleteCate = khachHangRepository.delete(makh);
        if (deleteCate) {
            return "Delete successfully";
        }
        return "Delete failed";
    }

}
