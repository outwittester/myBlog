package com.sincere.service;

import com.sincere.dao.TypeDao;
import com.sincere.dao.TypeRepository;
import com.sincere.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    @Transactional
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getTypeById(id);
    }

    @Override
    public Type updateType(String name,String id) {
        return typeDao.updateTypeByNameAndId(name,id);
    }

    @Override
    public Type addType(String name) {
        return typeDao.insertTypeByName(name);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.deleteTypeById(id);
    }


}
