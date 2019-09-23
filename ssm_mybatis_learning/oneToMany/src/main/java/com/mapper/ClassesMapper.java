package com.mapper;

import com.model.Classes;

public interface ClassesMapper {
    public Classes selectClassAndStudentsById(Integer id) throws Exception;

}
