/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.repository.impl;

import com.ttn.pojo.Class;
import com.ttn.repository.ClassRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ClassRepositoryImpl implements ClassRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Class> getClass(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Class");
        
        return query.getResultList();
    }
    
}
