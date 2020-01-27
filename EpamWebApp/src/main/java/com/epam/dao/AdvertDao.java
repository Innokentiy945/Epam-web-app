package com.epam.dao;


import com.epam.db.ConnectionFactory;
import com.epam.model.Advert;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvertDao {

    private static final String SELECT_FROM_ADVERTS_BY_ADVERTID = "SELECT * FROM adverts WHERE advertid=?";

    public static Advert getAdvert(Long id) {

        try {
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement statement = cn.prepareStatement(SELECT_FROM_ADVERTS_BY_ADVERTID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Advert advert = new Advert();
                advert.setUserId(rs.getLong("user_id"));
                advert.setAdvertid(rs.getLong("advertid"));
                advert.setTitle(rs.getString("title"));
                advert.setAdvbody(rs.getString("advbody"));
                advert.setCategory(rs.getString("category"));
                advert.setPhonenumber(rs.getString("phonenumber"));
                advert.setDate(rs.getString("date"));
                return advert;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    private static final String SELECT_FROM_ADVERTS = "SELECT * FROM adverts";

    public static Set<Advert> getAllAdvert() {
        try {
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement statement = cn.prepareStatement(SELECT_FROM_ADVERTS);
            ResultSet rs = statement.executeQuery();

            Set<Advert> advSet = new HashSet<>();
            //List<Advert> advList = new ArrayList<>();

            while (rs.next()) {
                Advert advert = new Advert();
                advert.setUserId(rs.getLong("user_id"));
                advert.setAdvertid(rs.getLong("advertid"));
                advert.setTitle(rs.getString("title"));
                advert.setAdvbody(rs.getString("advbody"));
                advert.setCategory(rs.getString("category"));
                advert.setPhonenumber(rs.getString("phonenumber"));
                advert.setDate(rs.getString("date"));
                advSet.add(advert);
            }

            return advSet;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }



    private static final String SELECT_FROM_ADVERTS_BY_USERID = "SELECT * FROM adverts, users WHERE userid=?";


    public static List<Advert> getAdvertByUserId(Long id) {
        try {
            Connection cn = ConnectionFactory.getConnection();
            PreparedStatement statement = cn.prepareStatement(SELECT_FROM_ADVERTS_BY_USERID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();


            List<Advert> advertsByUserIdList = new ArrayList<>();

            while (rs.next()) {
                Advert advert = new Advert();
                advert.setUserId(rs.getLong("user_id"));
                advert.setAdvertid(rs.getLong("advertid"));
                advert.setTitle(rs.getString("title"));
                advert.setAdvbody(rs.getString("advbody"));
                advert.setCategory(rs.getString("category"));
                advert.setPhonenumber(rs.getString("phonenumber"));
                advert.setDate(rs.getString("date"));
                advertsByUserIdList.add(advert);

            }

            return advertsByUserIdList;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static final String INSERT_ADVERTS = "INSERT INTO adverts(user_id, advertid, title, advbody, category, phonenumber, date) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static boolean insertAdvert(Advert advert) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_ADVERTS);
            ps.setLong(1, advert.getUserId());
            ps.setLong(2, advert.getAdvertid());
            ps.setString(3, advert.getTitle());
            ps.setString(4, advert.getAdvbody());
            ps.setString(5, advert.getCategory());
            ps.setString(6, advert.getPhonenumber());
            ps.setString(7, advert.getDate());
            ps.execute();


        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private static final String DELETE_ADVERTS= "DELETE FROM adverts WHERE advertid=?";

    public static boolean deleteAdvert(Long id) {
        try (Connection cn = ConnectionFactory.getConnection()) {
            try (PreparedStatement ps = cn.prepareStatement(DELETE_ADVERTS)) {

                ps.setLong(1, id);
                ps.execute();

            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return false;
    }




}
