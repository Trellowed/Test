/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.KhachHang;
import java.util.List;

/**
 *
 * @author fptsh
 */
public interface QuanLyKhachHangService {

    List<KhachHang> getData();
    
//    List<KhachHang> Search (List<KhachHang> list,int max, int min);

    List<KhachHang> sortBy();
    
    String add(KhachHang khachHang);
    
    String update(Long makh, KhachHang khachHang);
    
    String delete(Long makh);
    
}
