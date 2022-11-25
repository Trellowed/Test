/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fptsh
 */
public class KhachHangRepository {

    public static List<KhachHang> readDB() {
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public KhachHang getTuoi() {
        int tuoi = 0;
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                       WHERE tuoi >=18 and tuoi <=50
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5));
              return khachHang;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static List<KhachHang> sortByName() {
        String query = """
                       SELECT [makh]
                             ,[ten_kh]
                             ,[tuoi]
                             ,[gioiTinh]
                             ,[loai]
                         FROM [dbo].[khachHang]
                        ORDER BY ten_kh ASC
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(KhachHang khachHang){
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[khachHang]
                                  ([makh]
                                  ,[ten_kh]
                                  ,[tuoi]
                                  ,[gioiTinh]
                                  ,[loai])
                            VALUES
                                  (?,?,?,?,?)
                       """;
        try ( Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachHang.getMakh());
            ps.setObject(2, khachHang.getTenkh());
            ps.setObject(3, khachHang.getTuoi());
            ps.setObject(4, khachHang.isGioiTinh());
            ps.setObject(5, khachHang.getLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean delete(Long makh){
        int check = 0;
        String query = """
                       DELETE FROM [dbo].[khachHang]
                             WHERE makh = ?
                       """;
        try ( Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, makh);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(KhachHang khachHang, Long id){
        int check = 0;
        String query = """
                        UPDATE [dbo].[khachHang]
                           SET [makh] = ?
                              ,[ten_kh] = ?
                              ,[tuoi] = ?
                              ,[gioiTinh] = ?
                              ,[loai] = ?
                         WHERE makh = ?
                       """;
        try ( Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachHang.getMakh());
            ps.setObject(2, khachHang.getTenkh());
            ps.setObject(3, khachHang.getTuoi());
            ps.setObject(4, khachHang.isGioiTinh());
            ps.setObject(5, khachHang.getLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().readDB();
        for (KhachHang kh : list) {
            System.out.println(kh.toString());
        }
        KhachHang find = new KhachHangRepository().getTuoi();
        find.toString();
//        List<KhachHang> lists = new KhachHangRepository().sortByName();
//        for (KhachHang kh : lists) {
//            System.out.println(kh.toString());
//        }

//        Add

        KhachHang khachHang = new KhachHang("KH5", "Tran Hai Nam", 33, true, "VIP");
        boolean add = new KhachHangRepository().add(khachHang);
        System.out.println(add);

//        Delete

//        Category category = new Category(5L, "Test", "test1");
////        boolean add = new CategoryRepository().add(category);
//        boolean delete = new CategoryRepository().delete(3L);
//        System.out.println(delete);
    }
}
