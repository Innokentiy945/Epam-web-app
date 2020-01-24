package com.epam.services;


import com.epam.model.Advert;
import com.epam.dao.AdvertDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AdvertService {

    public static Advert getAdvert(Long id) {
        return AdvertDao.getAdvert(id);
    }


    public static Set<Advert> getAllAdverts() {
        return AdvertDao.getAllAdvert();
    }

    public static List<Advert> getAdvertByUserId(Long id) {
        return AdvertDao.getAdvertByUserId(id);
    }


    public static boolean insertAdvert(Advert advert) throws SQLException, ClassNotFoundException {
        return AdvertDao.insertAdvert(advert);
    }

    public static boolean deleteAdvert(Long id) {
        return AdvertDao.deleteAdvert(id);
    }
}
